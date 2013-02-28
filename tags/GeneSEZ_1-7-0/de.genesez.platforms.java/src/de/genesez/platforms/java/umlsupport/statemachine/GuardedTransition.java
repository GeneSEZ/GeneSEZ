package de.genesez.platforms.java.umlsupport.statemachine;

/**
 * @author: georg beier
 * @version: $Revision: 1.1 $
 */
public abstract class GuardedTransition<RCV, EV, ST> extends
		Transition<RCV, EV, ST> {

	/**
	 * new guarded transition
	 * 
	 * @param tgt
	 *            target state
	 */
	public GuardedTransition(ST tgt) {
		super(tgt);
	}

	/**
	 * does nothing. should be overwritten by subclass, evaluate guard condition
	 * 
	 * @param ev
	 *            incoming event
	 * @param onObj
	 *            event receiver
	 * @return result of guard evaluation
	 */
	public boolean eval(EventQueue.Event<EV> ev, RCV onObj) {
		throw new RuntimeException("unexpected event " + ev.eventId);
	}
}
