/**
 * 
 */
package de.genesez.platforms.common.m2t;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.genesez.metamodel.gcore.MAction;
import de.genesez.metamodel.gcore.MActivity;
import de.genesez.metamodel.gcore.MAtomicTransition;
import de.genesez.metamodel.gcore.MBehavior;
import de.genesez.metamodel.gcore.MElement;
import de.genesez.metamodel.gcore.MEvent;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGuard;
import de.genesez.metamodel.gcore.MHistoryState;
import de.genesez.metamodel.gcore.MLeafState;
import de.genesez.metamodel.gcore.MParameter;
import de.genesez.metamodel.gcore.MState;
import de.genesez.metamodel.gcore.MTimeEvent;
import de.genesez.metamodel.gcore.MTransition;

/**
 * @author georg beier
 * 
 */
public class StateMachineHelper {

	private static Map<String, GuardDescriptor> guardDescriptors = new HashMap<String, GuardDescriptor>();
	private static int guardNo = 0;

	private static class GuardDescriptor {
		public String guardMethod;
		public String guardExpression;
		public Set<MEvent> events = new LinkedHashSet<MEvent>();
		public boolean triggerless = false;
	}

	private static Comparator<String> guardKeyComparator = new Comparator<String>() {

		public int compare(String k1, String k2) {
			return guardDescriptors.get(k1).guardMethod
					.compareTo(guardDescriptors.get(k2).guardMethod);
		}

	};

	public static MGuard registerGuard(MGuard guard) {
		String key = guardKey(guard);
		GuardDescriptor descriptor;
		Set<MEvent> ev = new LinkedHashSet<MEvent>();
		if (!guardDescriptors.containsKey(key)) {
			descriptor = new GuardDescriptor();
			descriptor.guardMethod = "evaluateGuard" + guardNo++;
			descriptor.guardExpression = key;
			guardDescriptors.put(key, descriptor);
		} else {
			descriptor = guardDescriptors.get(key);
		}
		for (Object transition : guard.getTransition()) {
			for (Object event : ((MTransition) transition).getTrigger()) {
				ev.add((MEvent) event);
			}
		}
		if (ev.isEmpty()) {
			descriptor.triggerless = true;
		} else {
			descriptor.events.addAll(ev);
		}
		return guard;
	}

	public static void clearGuardInfo() {
		guardDescriptors.clear();
		guardNo = 0;
	}

	public static List<String> getGuards() {
		List<String> result = new ArrayList<String>(guardDescriptors.keySet());
		Collections.sort(result, guardKeyComparator);
		return result;
	}

	public static String getMethod(MGuard guard) {
		return guardDescriptors.get(guardKey(guard)).guardMethod;
	}

	public static String getMethod(String guardExp) {
		return guardDescriptors.get(guardExp).guardMethod;
	}

	public static Set<MEvent> getGuardEvents(String guardMethod) {
		return guardDescriptors.get(guardMethod).events;
	}

	public static boolean isTriggerless(String guardExp) {
		if (guardDescriptors.containsKey(guardExp)) {
			return guardDescriptors.get(guardExp).triggerless;
		} else {
			System.out.println("		not registered " + guardExp);
			return true;
		}
	}

	public static String guardKey(MGuard guard) {
		return guard.getName().replaceAll("(?m)\\s+", " ").replaceAll(
				"^\\s?\\[\\s?(.*)\\s?\\]\\s?$", "$1");
	}

	/**
	 * find a list of parameters with same types in all trigger events
	 */
	public static List<MParameter> getCommonParams(List<MEvent> trigger) {
		List<MParameter> params = new ArrayList<MParameter>();
		if (trigger.isEmpty())
			return params;
		int minParamCount = trigger.get(0).getParameter().size();
		Set<String> types = new HashSet<String>();
		for (MEvent event : trigger) {
			minParamCount = Math
					.min(minParamCount, event.getParameter().size());
		}
		int i;
		// find out how many parameters in parameter lists have the same type
		for (i = 0; i < minParamCount; i++) {
			types.clear();
			for (MEvent event : trigger) {
				for (int j = 0; j <= i; j++) {
					Object o = ((MParameter) event.getParameter().get(j))
							.getType();
					if (o instanceof MElement) {
						types.add(((MElement) o).getName());
					} else if (o instanceof MExternal) {
						types.add(((MExternal) o).getSpecification());
					}
				}
			}
			if (types.size() != i)
				break; // types differ
		}
		for (int j = 0; j < i; j++) {
			params.add((MParameter) trigger.get(0).getParameter().get(0));
		}
		return params;
	}

	/**
	 * sort a list of atomic transitions in such a way, that transitions derived
	 * from transitions starting from more inner states rank before transitions
	 * from outer states. this results in a half order, because no order is
	 * defined for states on the same level <br>
	 * if an order exists and an inner transition has no guard condition, all
	 * outer transitions can be removed from the list.
	 * 
	 * @param atl
	 *            list to be sorted
	 */
	public static List<MAtomicTransition> sortInnerToOuter(
			List<MAtomicTransition> atl) {
		if (atl.size() == 1) {
			return atl;
		}
		Comparator<MAtomicTransition> atlc = new Comparator<MAtomicTransition>() {

			public int compare(MAtomicTransition o1, MAtomicTransition o2) {
				MState s1 = o1.getDefiningTransition().getSource();
				MState s2 = o2.getDefiningTransition().getSource();
				if (s1 == s2) {
					return 0;
				} else if (s1.getSuperstate() == null) {
					return 0; // s1 cannot be contained
				} else {
					for (MState sst = s2.getSuperstate(); sst != null; sst = sst
							.getSuperstate()) {
						if (s1 == sst)
							return -1; // s1 is a substate of s2
					}
					return 0;
				}
			}
		};
		Collections.sort(atl, atlc);
		boolean noGuard = false;
		for (Iterator<MAtomicTransition> iterator = atl.iterator(); iterator
				.hasNext();) {
			MAtomicTransition at = iterator.next();
			if (noGuard) {
				iterator.remove();
			} else if (at.getDefiningTransition().getGuard() == null) {
				noGuard = true;
			}
		}
		return atl;
	}

	/**
	 * build list of all entry actions to call on a history transition
	 * 
	 * @param history
	 *            history state that was encountered
	 * @param target
	 *            leaf state that history state delegates to
	 * @return list of all entry actions in order outer to inner
	 */
	public static List<MBehavior> resultingEntries(MHistoryState history,
			MLeafState target) {
		List<MBehavior> result = new LinkedList<MBehavior>();
		if (target.getEntry() != null)
			result.add(target.getEntry());
		for (MState state = target.getSuperstate(); state != history
				.getSuperstate(); state = state.getSuperstate()) {
			if (state.getEntry() != null)
				result.add(0, state.getEntry());
		}
		return result;
	}

	/**
	 * build list of all do activities to be started on a history transition
	 * 
	 * @param history
	 *            history state that was encountered
	 * @param target
	 *            leaf state that history state delegates to
	 * @return list of all do activities in order outer to inner
	 */
	public static List<MBehavior> resultingStartDo(MHistoryState history,
			MLeafState target) {
		List<MBehavior> result = new LinkedList<MBehavior>();
		if (target.getDo() != null)
			result.add(target.getDo());
		for (MState state = target.getSuperstate(); state != history
				.getSuperstate(); state = state.getSuperstate()) {
			if (state.getDo() != null)
				result.add(0, state.getDo());
		}
		return result;
	}

	/**
	 * build list of all visited states on a history transition
	 * 
	 * @param history
	 *            history state that was encountered
	 * @param target
	 *            leaf state that history state delegates to
	 * @return list of all states in order outer to inner
	 */
	public static List<MState> visitedStates(MHistoryState history,
			MLeafState target) {
		List<MState> result = new LinkedList<MState>();
			result.add(target);
		for (MState state = target.getSuperstate(); state != history
				.getSuperstate(); state = state.getSuperstate()) {
				result.add(0, state);
		}
		return result;
	}

}
