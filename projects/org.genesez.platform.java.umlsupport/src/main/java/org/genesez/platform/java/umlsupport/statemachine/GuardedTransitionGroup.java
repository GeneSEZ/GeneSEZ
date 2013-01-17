package org.genesez.platform.java.umlsupport.statemachine;


/**
 * @author: georg beier
 * @version: $Revision: 1.1 $
 */
public class GuardedTransitionGroup<RCV, EV, ST> implements
		AbstractTransition<RCV, EV, ST> {

	private java.util.List<GuardedTransition<RCV, EV, ST>> guardedTransition = new java.util.ArrayList<GuardedTransition<RCV, EV, ST>>();

	/**
	 */
	public ST exec(EventQueue.Event<EV> ev, RCV onObj) {
		for (GuardedTransition<RCV, EV, ST> gtr : guardedTransition) {
			if (gtr.eval(ev, onObj)) {
				return gtr.exec(ev, onObj);
			}
		}
		return null;
	}

	public void addGuardedTransition(GuardedTransition<RCV, EV, ST> _in) {
		if (guardedTransition.contains(_in))
			return;
		guardedTransition.add(_in);
	}

	public void removeGuardedTransition(GuardedTransition<RCV, EV, ST> _ex) {
		if (!guardedTransition.contains(_ex))
			return;
		guardedTransition.remove(_ex);
	}
}
