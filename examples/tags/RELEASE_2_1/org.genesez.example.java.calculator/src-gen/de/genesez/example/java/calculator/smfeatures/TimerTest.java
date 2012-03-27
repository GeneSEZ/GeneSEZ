package de.genesez.example.java.calculator.smfeatures;

import java.util.*;
import org.genesez.platform.java.umlsupport.associations.*;
import org.genesez.platform.java.umlsupport.statemachine.*;

/* PROTECTED REGION ID(java.type.import._15_5_1_6340215_1233599236768_683189_710) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class TimerTest implements EventReceiver<TimerTest.EventId> {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>TimerTest</b></em>'.
	 */
	public TimerTest() {
		/* PROTECTED REGION ID(java.constructor._15_5_1_6340215_1233604450519_45789_1311) ENABLED START */
		new _ANON_().sendImmediate();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._15_5_1_6340215_1233599236768_683189_710) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

	// -- generated state machine section -----------------------------------
	
	private Timer timerForDingdong;
	
	private void startTimerForDingdong() {
		if (SMDEBUG)
			System.out.println("dingdong " + "startet");
		timerForDingdong = new Dingdong().sendDelayed(100);
	}
	
	private void stopTimerForDingdong() {
		if (timerForDingdong != null) {
			timerForDingdong.cancel();
			if (SMDEBUG)
				System.out.println("dingdong " + "stopped");
		}
		timerForDingdong = null;
	}
	
	private Timer timerForDone;
	
	private void startTimerForDone() {
		if (SMDEBUG)
			System.out.println("done " + "startet");
		timerForDone = new Done().sendDelayed(12000);
	}
	
	private void stopTimerForDone() {
		if (timerForDone != null) {
			timerForDone.cancel();
			if (SMDEBUG)
				System.out.println("done " + "stopped");
		}
		timerForDone = null;
	}
	
	private Timer timerForTack;
	
	private void startTimerForTack() {
		if (SMDEBUG)
			System.out.println("tack " + "startet");
		timerForTack = new Tack().sendDelayed(5);
	}
	
	private void stopTimerForTack() {
		if (timerForTack != null) {
			timerForTack.cancel();
			if (SMDEBUG)
				System.out.println("tack " + "stopped");
		}
		timerForTack = null;
	}
	
	private Timer timerForTick;
	
	private void startTimerForTick() {
		if (SMDEBUG)
			System.out.println("tick " + "startet");
		timerForTick = new Tick().sendDelayed(5);
	}
	
	private void stopTimerForTick() {
		if (timerForTick != null) {
			timerForTick.cancel();
			if (SMDEBUG)
				System.out.println("tick " + "stopped");
		}
		timerForTick = null;
	}
	
	// all state machine actions are implemented as a method
	/**
	 * Action method stub for further implementation.
	 */
	private void dingdong(SmEvent event) {
		if (SMDEBUG)
			System.out.println("dingdong " + "( ... )");
		/* PROTECTED REGION ID(action.dingdong_15_5_1_6340215_1233599281128_659741_732) ENABLED START */
		// TODO: implementation of action method 'dingdong(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void done(SmEvent event) {
		if (SMDEBUG)
			System.out.println("done " + "( ... )");
		/* PROTECTED REGION ID(action.done_15_5_1_6340215_1233599281128_659741_732) ENABLED START */
		// TODO: implementation of action method 'done(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void tack(SmEvent event) {
		if (SMDEBUG)
			System.out.println("tack " + "( ... )");
		/* PROTECTED REGION ID(action.tack_15_5_1_6340215_1233599281128_659741_732) ENABLED START */
		// TODO: implementation of action method 'tack(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void tick(SmEvent event) {
		if (SMDEBUG)
			System.out.println("tick " + "( ... )");
		/* PROTECTED REGION ID(action.tick_15_5_1_6340215_1233599281128_659741_732) ENABLED START */
		// TODO: implementation of action method 'tick(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// do actions are called from a thread, controlled by start and stop methods
	
	// all state machine guards are implemented as a method
	
	/** enum for all leaf states */
	static enum StateId {
		_fTimerTest, _iTimerTest, leaf1, leaf2, leaf3
	};
	
	/** member variable holding current state */
	private StateId currentState = StateId._iTimerTest;
	
	/** package visible getter for debug purposes */
	StateId getCurrentState() {
		return currentState;
	}
	
	/** enum for all trigger events */
	static enum EventId {
		_ANON_, dingdong, done, tack, tick
	};
	
	/** inner class as local base class for all trigger events */
	private class SmEvent extends EventQueue.Event<EventId> {
		/* PROTECTED REGION ID(SmEvent._15_5_1_6340215_1233599281128_659741_732) ENABLED START */
		// Usually nothing to insert here, just in case ... 
		/* PROTECTED REGION END */
		public SmEvent(EventId id) {
			super(id);
		}
		
		public TimerTest getReceiver() {
			return TimerTest.this;
		}
	}
	
	private class _ANON_ extends SmEvent {
		public _ANON_() {
			super(EventId._ANON_);
		}
	}
	
	private class Dingdong extends SmEvent {
		public Dingdong() {
			super(EventId.dingdong);
		}
	}
	
	private class Done extends SmEvent {
		public Done() {
			super(EventId.done);
		}
	}
	
	private class Tack extends SmEvent {
		public Tack() {
			super(EventId.tack);
		}
	}
	
	private class Tick extends SmEvent {
		public Tick() {
			super(EventId.tick);
		}
	}
	
	/**
	 * process events from event queue
	 */
	@Override
	public void takeEvent(EventQueue.Event<EventId> event) {
		StateId temp = currentState;
		currentState = stateMachine.takeEvent(event, currentState, this);
		System.out.println(getClass().getSimpleName() + ": " + temp + " --(" + event + ")-> " + currentState);
	};
	
	/** class variable holding state machine of this class */
	private static StateMachine<TimerTest, EventId, StateId> stateMachine = new StateMachine<TimerTest, EventId, StateId>();
	static {
		@SuppressWarnings("unused")
		Transition<TimerTest, EventId, StateId> tempTransition;
		@SuppressWarnings("unused")
		GuardedTransition<TimerTest, EventId, StateId> tempGuardedTransition;
		@SuppressWarnings("unused")
		GuardedTransitionGroup<TimerTest, EventId, StateId> tempGroup;
		// _iTimerTest -- _ANON_([]) -> leaf1
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId.leaf1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT__iTimerTest_leaf1 " + "exec(_ANON_)");
				// no action bound to this transition
				obj.startTimerForTick(); // start time triggers in target state
				obj.startTimerForDingdong(); // start time triggers in target state
				obj.startTimerForDone(); // start time triggers in target state
				return super.exec(ev, obj);
			}
			
		};
		// _iTimerTest -- _ANON_([]) -> leaf1
		stateMachine.addTransition(EventId._ANON_, StateId._iTimerTest, tempTransition);
		
		// leaf1 -- tick([]) -> leaf2
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId.leaf2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf1_leaf2 " + "exec(tick)");
				obj.stopTimerForTick(); // stop time triggers in source state
				obj.tick((Tick) ev); // call all onTransition actions
				obj.startTimerForTack(); // start time triggers in target state
				return super.exec(ev, obj);
			}
			
		};
		// leaf1 -- tick([]) -> leaf2
		stateMachine.addTransition(EventId.tick, StateId.leaf1, tempTransition);
		
		// leaf1 -- dingdong([]) -> leaf3
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId.leaf3) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf1_leaf3 " + "exec(dingdong)");
				obj.stopTimerForTick(); // stop time triggers in source state
				obj.stopTimerForDingdong(); // stop time triggers in source state
				obj.dingdong((Dingdong) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// leaf1 -- dingdong([]) -> leaf3
		stateMachine.addTransition(EventId.dingdong, StateId.leaf1, tempTransition);
		
		// leaf1 -- done([]) -> _fTimerTest
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId._fTimerTest) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf1__fTimerTest " + "exec(done)");
				obj.stopTimerForTick(); // stop time triggers in source state
				obj.stopTimerForDingdong(); // stop time triggers in source state
				obj.stopTimerForDone(); // stop time triggers in source state
				obj.done((Done) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// leaf1 -- done([]) -> _fTimerTest
		stateMachine.addTransition(EventId.done, StateId.leaf1, tempTransition);
		
		// leaf2 -- tack([]) -> leaf1
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId.leaf1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf2_leaf1 " + "exec(tack)");
				obj.stopTimerForTack(); // stop time triggers in source state
				obj.tack((Tack) ev); // call all onTransition actions
				obj.startTimerForTick(); // start time triggers in target state
				return super.exec(ev, obj);
			}
			
		};
		// leaf2 -- tack([]) -> leaf1
		stateMachine.addTransition(EventId.tack, StateId.leaf2, tempTransition);
		
		// leaf2 -- dingdong([]) -> leaf3
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId.leaf3) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf2_leaf3 " + "exec(dingdong)");
				obj.stopTimerForTack(); // stop time triggers in source state
				obj.stopTimerForDingdong(); // stop time triggers in source state
				obj.dingdong((Dingdong) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// leaf2 -- dingdong([]) -> leaf3
		stateMachine.addTransition(EventId.dingdong, StateId.leaf2, tempTransition);
		
		// leaf2 -- done([]) -> _fTimerTest
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId._fTimerTest) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf2__fTimerTest " + "exec(done)");
				obj.stopTimerForTack(); // stop time triggers in source state
				obj.stopTimerForDingdong(); // stop time triggers in source state
				obj.stopTimerForDone(); // stop time triggers in source state
				obj.done((Done) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// leaf2 -- done([]) -> _fTimerTest
		stateMachine.addTransition(EventId.done, StateId.leaf2, tempTransition);
		
		// leaf3 -- done([]) -> _fTimerTest
		
		tempTransition = new Transition<TimerTest, EventId, StateId>(StateId._fTimerTest) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, TimerTest obj) {
				if (SMDEBUG)
					System.out.println("AT_leaf3__fTimerTest " + "exec(done)");
				obj.stopTimerForDone(); // stop time triggers in source state
				obj.done((Done) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// leaf3 -- done([]) -> _fTimerTest
		stateMachine.addTransition(EventId.done, StateId.leaf3, tempTransition);
		
	};
	/* PROTECTED REGION ID(debugflag._15_5_1_6340215_1233599281128_659741_732) ENABLED START */
	/** switch state machine tracing on / off */
	private static final boolean SMDEBUG = true;
	
	/* PROTECTED REGION END */
}
