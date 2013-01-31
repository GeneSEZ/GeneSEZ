package org.genesez.metamodel.core.util;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324550889008_9017_2974) 
 */

import java.util.Map;
import java.util.List;
import org.genesez.metamodel.gcore.MLeafState;
import org.genesez.metamodel.gcore.MEvent;
import org.genesez.metamodel.gcore.MGuard;
import org.genesez.metamodel.gcore.MTransition;
import org.genesez.metamodel.gcore.MParameter;
import java.util.ArrayList;
import org.genesez.metamodel.gcore.MHistoryState;
import org.genesez.metamodel.gcore.MElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Comparator;
import org.genesez.metamodel.gcore.MExternal;
import java.util.LinkedHashSet;
import org.genesez.metamodel.gcore.MBehavior;
import java.util.LinkedList;
import java.util.HashSet;
import org.genesez.metamodel.gcore.MAtomicTransition;
import java.util.Collections;
import org.genesez.metamodel.gcore.MState;

/**
 * @author georg beier
 */
public class StateMachineHelper {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static Map<String, GuardDescriptor> guardDescriptors = new HashMap<String, GuardDescriptor>();
	
	private static int guardNo = 0;
	
	private static Comparator<String> guardKeyComparator;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	guard	
	 * @return	
	 */
	public static MGuard registerGuard(MGuard guard) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551490412_962189_3107) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public static void clearGuardInfo() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551520069_629046_3117) ENABLED START */
		guardDescriptors.clear();
		guardNo = 0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public static java.util.List<String> getGuards() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551535711_45031_3125) ENABLED START */
		List<String> result = new ArrayList<String>(guardDescriptors.keySet());
		Collections.sort(result, guardKeyComparator);
		return result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guard	
	 * @return	
	 */
	public static String getMethod(MGuard guard) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551562444_613642_3135) ENABLED START */
		return guardDescriptors.get(guardKey(guard)).guardMethod;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guardExp	
	 * @return	
	 */
	public static String getMethod(String guardExp) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551585844_837723_3143) ENABLED START */
		return guardDescriptors.get(guardExp).guardMethod;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guardMethod	
	 * @return	
	 */
	public static java.util.Set<MEvent> getGuardEvents(String guardMethod) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551607512_176690_3151) ENABLED START */
		return guardDescriptors.get(guardMethod).events;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guardExp	
	 * @return	
	 */
	public static boolean isTriggerless(String guardExp) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551639851_135838_3161) ENABLED START */
		if (guardDescriptors.containsKey(guardExp)) {
			return guardDescriptors.get(guardExp).triggerless;
		} else {
			System.out.println("		not registered " + guardExp);
			return true;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guard	
	 * @return	
	 */
	public static String guardKey(MGuard guard) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551669279_769448_3169) ENABLED START */
		return guard.getName().replaceAll("(?m)\\s+", " ").replaceAll("^\\s?\\[\\s?(.*)\\s?\\]\\s?$", "$1");
		/* PROTECTED REGION END */
	}
	
	/**
	 * find a list of parameters with same types in all trigger events
	 * @param	trigger	
	 * @return	
	 */
	public static java.util.List<MParameter> getCommonParams(java.util.List<MEvent> trigger) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551715083_500233_3178) ENABLED START */
		List<MParameter> params = new ArrayList<MParameter>();
		if (trigger.isEmpty())
			return params;
		int minParamCount = trigger.get(0).getParameter().size();
		Set<String> types = new HashSet<String>();
		for (MEvent event : trigger) {
			minParamCount = Math.min(minParamCount, event.getParameter().size());
		}
		int i;
		// find out how many parameters in parameter lists have the same type
		for (i = 0; i < minParamCount; i++) {
			types.clear();
			for (MEvent event : trigger) {
				for (int j = 0; j <= i; j++) {
					Object o = ((MParameter) event.getParameter().get(j)).getType();
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * sort a list of atomic transitions in such a way, that transitions derived from transitions starting from more inner states rank before transitions from outer states. this results in a half order, because no order is defined for states on the same level <br>
	 * if an order exists and an inner transition has no guard condition, all outer transitions can be removed from the list.
	 * @param	atl	list to be sorted
	 * @return	
	 */
	public static java.util.List<MAtomicTransition> sortInnerToOuter(java.util.List<MAtomicTransition> atl) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551761189_841258_3194) ENABLED START */
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
					for (MState sst = s2.getSuperstate(); sst != null; sst = sst.getSuperstate()) {
						if (s1 == sst)
							return -1; // s1 is a substate of s2
					}
					return 0;
				}
			}
		};
		Collections.sort(atl, atlc);
		boolean noGuard = false;
		for (Iterator<MAtomicTransition> iterator = atl.iterator(); iterator.hasNext();) {
			MAtomicTransition at = iterator.next();
			if (noGuard) {
				iterator.remove();
			} else if (at.getDefiningTransition().getGuard() == null) {
				noGuard = true;
			}
		}
		return atl;
		/* PROTECTED REGION END */
	}
	
	/**
	 * build list of all entry actions to call on a history transition
	 * @param	history	history state that was encountered
	 * @param	target	leaf state that history state delegates to
	 * @return	list of all entry actions in order outer to inner
	 */
	public static java.util.List<MBehavior> resultingEntries(MHistoryState history, MLeafState target) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551826396_210903_3215) ENABLED START */
		List<MBehavior> result = new LinkedList<MBehavior>();
		if (target.getEntry() != null)
			result.add(target.getEntry());
		for (MState state = target.getSuperstate(); state != history.getSuperstate(); state = state.getSuperstate()) {
			if (state.getEntry() != null)
				result.add(0, state.getEntry());
		}
		return result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * build list of all do activities to be started on a history transition
	 * @param	history	history state that was encountered
	 * @param	target	leaf state that history state delegates to
	 * @return	list of all do activities in order outer to inner
	 */
	public static java.util.List<MBehavior> resultingStartDo(MHistoryState history, MLeafState target) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551895839_70133_3239) ENABLED START */
		List<MBehavior> result = new LinkedList<MBehavior>();
		if (target.getDo() != null)
			result.add(target.getDo());
		for (MState state = target.getSuperstate(); state != history.getSuperstate(); state = state.getSuperstate()) {
			if (state.getDo() != null)
				result.add(0, state.getDo());
		}
		return result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * build list of all visited states on a history transition
	 * @param	history	history state that was encountered
	 * @param	target	leaf state that history state delegates to
	 * @return	list of all states in order outer to inner
	 */
	public static java.util.List<MState> visitedStates(MHistoryState history, MLeafState target) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324551952815_464954_3251) ENABLED START */
		List<MState> result = new LinkedList<MState>();
		result.add(target);
		for (MState state = target.getSuperstate(); state != history.getSuperstate(); state = state.getSuperstate()) {
			result.add(0, state);
		}
		return result;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324550889008_9017_2974) ENABLED START */
	private static class GuardDescriptor {
		public String guardMethod;
		@SuppressWarnings("unused")
		public String guardExpression;
		public Set<MEvent> events = new LinkedHashSet<MEvent>();
		public boolean triggerless = false;
	}
	
	static {
		guardKeyComparator = new Comparator<String>() {
			public int compare(String k1, String k2) {
				return guardDescriptors.get(k1).guardMethod.compareTo(guardDescriptors.get(k2).guardMethod);
			}
			
		};
	}
	/* PROTECTED REGION END */
	
}
