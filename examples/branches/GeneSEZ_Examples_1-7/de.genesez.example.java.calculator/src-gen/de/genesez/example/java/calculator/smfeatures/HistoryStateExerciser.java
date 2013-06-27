package de.genesez.example.java.calculator.smfeatures;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;
import de.genesez.platforms.java.umlsupport.statemachine.*;

/* PROTECTED REGION ID(java.type.import._15_5_1_6340215_1233754261619_362762_1178) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

public class HistoryStateExerciser implements EventReceiver<HistoryStateExerciser.EventId> {
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>HistoryStateExerciser</b></em>'
	 */
	public HistoryStateExerciser() {
		/* PROTECTED REGION ID(java.constructor._15_5_1_6340215_1233754282541_809591_1198) ENABLED START */
		new _ANON_().sendImmediate();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._15_5_1_6340215_1233754261619_362762_1178) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

	// -- generated state machine section -----------------------------------
	public void takeH0() {
		new H0().send();
	}
	
	public void takeH2() {
		new H2().send();
	}
	
	public void takeH4() {
		new H4().send();
	}
	
	public void takeT1() {
		new T1().send();
	}
	
	public void takeT10() {
		new T10().send();
	}
	
	public void takeT11() {
		new T11().send();
	}
	
	public void takeT2() {
		new T2().send();
	}
	
	public void takeT3() {
		new T3().send();
	}
	
	public void takeT5() {
		new T5().send();
	}
	
	public void takeT6() {
		new T6().send();
	}
	
	public void takeT7() {
		new T7().send();
	}
	
	public void takeT8() {
		new T8().send();
	}
	
	public void takeT9() {
		new T9().send();
	}
	
	// all state machine actions are implemented as a method
	
	// do actions are called from a thread, controlled by start and stop methods
	
	// all state machine guards are implemented as a method
	
	/** enum for all leaf states */
	static enum StateId {
		_hLevel1b,
		_iHistoryStateExerciser,
		_iLevel0,
		_iLevel2a,
		_iLevel2b,
		level1a1,
		level1a2,
		level1a3,
		level1b1,
		level1b2,
		level2b1,
		level2b2,
		shallow
	};
	
	/** member variable holding current state */
	private StateId currentState = StateId._iHistoryStateExerciser;
	
	/** package visible getter for debug purposes */
	StateId getCurrentState() {
		return currentState;
	}
	
	/** enum for all trigger events */
	static enum EventId {
		_ANON_, h0, h2, h4, t1, t10, t11, t2, t3, t5, t6, t7, t8, t9
	};
	
	/** remember shallow history for shallow */
	private StateId historyOfShallow = StateId.level1a1;
	/** remember deep history for _hLevel1b */
	private StateId historyOfHLevel1b = StateId.level1b1;
	
	/** inner class as local base class for all trigger events */
	private class SmEvent extends EventQueue.Event<EventId> {
		/* PROTECTED REGION ID(SmEvent._15_5_1_6340215_1233754307714_240408_1202) ENABLED START */
		// Usually nothing to insert here, just in case ... 
		/* PROTECTED REGION END */
		public SmEvent(EventId id) {
			super(id);
		}
		
		public HistoryStateExerciser getReceiver() {
			return HistoryStateExerciser.this;
		}
	}
	
	private class _ANON_ extends SmEvent {
		public _ANON_() {
			super(EventId._ANON_);
		}
	}
	
	private class H0 extends SmEvent {
		public H0() {
			super(EventId.h0);
		}
	}
	
	private class H2 extends SmEvent {
		public H2() {
			super(EventId.h2);
		}
	}
	
	private class H4 extends SmEvent {
		public H4() {
			super(EventId.h4);
		}
	}
	
	private class T1 extends SmEvent {
		public T1() {
			super(EventId.t1);
		}
	}
	
	private class T10 extends SmEvent {
		public T10() {
			super(EventId.t10);
		}
	}
	
	private class T11 extends SmEvent {
		public T11() {
			super(EventId.t11);
		}
	}
	
	private class T2 extends SmEvent {
		public T2() {
			super(EventId.t2);
		}
	}
	
	private class T3 extends SmEvent {
		public T3() {
			super(EventId.t3);
		}
	}
	
	private class T5 extends SmEvent {
		public T5() {
			super(EventId.t5);
		}
	}
	
	private class T6 extends SmEvent {
		public T6() {
			super(EventId.t6);
		}
	}
	
	private class T7 extends SmEvent {
		public T7() {
			super(EventId.t7);
		}
	}
	
	private class T8 extends SmEvent {
		public T8() {
			super(EventId.t8);
		}
	}
	
	private class T9 extends SmEvent {
		public T9() {
			super(EventId.t9);
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
	private static StateMachine<HistoryStateExerciser, EventId, StateId> stateMachine = new StateMachine<HistoryStateExerciser, EventId, StateId>();
	static {
		@SuppressWarnings("unused")
		Transition<HistoryStateExerciser, EventId, StateId> tempTransition;
		@SuppressWarnings("unused")
		GuardedTransition<HistoryStateExerciser, EventId, StateId> tempGuardedTransition;
		@SuppressWarnings("unused")
		GuardedTransitionGroup<HistoryStateExerciser, EventId, StateId> tempGroup;
		// _iHistoryStateExerciser -- _ANON_([]) -> shallow
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.shallow) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT__iHistoryStateExerciser_shallow " + "exec(_ANON_)");
				// no action bound to this transition
				switch (obj.historyOfShallow) {
					case level1a1:
						super.exec(ev, obj);
						return StateId.level1a1;
				}
				return super.exec(ev, obj);
			}
			
		};
		// _iHistoryStateExerciser -- _ANON_([]) -> shallow
		stateMachine.addTransition(EventId._ANON_, StateId._iHistoryStateExerciser, tempTransition);
		
		// level1a1 -- t1([]) -> level1a2
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a1_level1a2 " + "exec(t1)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1a1 -- t1([]) -> level1a2
		stateMachine.addTransition(EventId.t1, StateId.level1a1, tempTransition);
		
		// level1a1 -- h4([]) -> _hLevel1b
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId._hLevel1b) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a1__hLevel1b " + "exec(h4)");
				obj.historyOfShallow = StateId.level1a1;
				// no action bound to this transition
				switch (obj.historyOfHLevel1b) {
					case level1b1:
						super.exec(ev, obj);
						return StateId.level1b1;
					case level1b2:
						super.exec(ev, obj);
						return StateId.level1b2;
					case level2b1:
						super.exec(ev, obj);
						return StateId.level2b1;
					case level2b2:
						super.exec(ev, obj);
						return StateId.level2b2;
				}
				return super.exec(ev, obj);
			}
			
		};
		// level1a1 -- h4([]) -> _hLevel1b
		stateMachine.addTransition(EventId.h4, StateId.level1a1, tempTransition);
		
		// level1a1 -- t10([]) -> level1b1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1b1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a1_level1b1 " + "exec(t10)");
				obj.historyOfShallow = StateId.level1a1;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1a1 -- t10([]) -> level1b1
		stateMachine.addTransition(EventId.t10, StateId.level1a1, tempTransition);
		
		// level1a2 -- t2([]) -> level1a3
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a3) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a2_level1a3 " + "exec(t2)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1a2 -- t2([]) -> level1a3
		stateMachine.addTransition(EventId.t2, StateId.level1a2, tempTransition);
		
		// level1a2 -- h2([]) -> _hLevel1b
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId._hLevel1b) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a2__hLevel1b " + "exec(h2)");
				obj.historyOfShallow = StateId.level1a2;
				// no action bound to this transition
				switch (obj.historyOfHLevel1b) {
					case level1b1:
						super.exec(ev, obj);
						return StateId.level1b1;
					case level1b2:
						super.exec(ev, obj);
						return StateId.level1b2;
					case level2b1:
						super.exec(ev, obj);
						return StateId.level2b1;
					case level2b2:
						super.exec(ev, obj);
						return StateId.level2b2;
				}
				return super.exec(ev, obj);
			}
			
		};
		// level1a2 -- h2([]) -> _hLevel1b
		stateMachine.addTransition(EventId.h2, StateId.level1a2, tempTransition);
		
		// level1a3 -- t3([]) -> level1a1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a3_level1a1 " + "exec(t3)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1a3 -- t3([]) -> level1a1
		stateMachine.addTransition(EventId.t3, StateId.level1a3, tempTransition);
		
		// level1a3 -- t9([]) -> level2b2
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level2b2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a3_level2b2 " + "exec(t9)");
				obj.historyOfShallow = StateId.level1a2;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1a3 -- t9([]) -> level2b2
		stateMachine.addTransition(EventId.t9, StateId.level1a3, tempTransition);
		
		// level1a3 -- h2([]) -> _hLevel1b
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId._hLevel1b) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1a3__hLevel1b " + "exec(h2)");
				obj.historyOfShallow = StateId.level1a2;
				// no action bound to this transition
				switch (obj.historyOfHLevel1b) {
					case level1b1:
						super.exec(ev, obj);
						return StateId.level1b1;
					case level1b2:
						super.exec(ev, obj);
						return StateId.level1b2;
					case level2b1:
						super.exec(ev, obj);
						return StateId.level2b1;
					case level2b2:
						super.exec(ev, obj);
						return StateId.level2b2;
				}
				return super.exec(ev, obj);
			}
			
		};
		// level1a3 -- h2([]) -> _hLevel1b
		stateMachine.addTransition(EventId.h2, StateId.level1a3, tempTransition);
		
		// level1b1 -- t5([]) -> level1b2
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1b2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1b1_level1b2 " + "exec(t5)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1b1 -- t5([]) -> level1b2
		stateMachine.addTransition(EventId.t5, StateId.level1b1, tempTransition);
		
		// level1b1 -- t11([]) -> level1a1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1b1_level1a1 " + "exec(t11)");
				obj.historyOfHLevel1b = StateId.level1b1;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1b1 -- t11([]) -> level1a1
		stateMachine.addTransition(EventId.t11, StateId.level1b1, tempTransition);
		
		// level1b2 -- t6([]) -> level2b1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level2b1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1b2_level2b1 " + "exec(t6)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1b2 -- t6([]) -> level2b1
		stateMachine.addTransition(EventId.t6, StateId.level1b2, tempTransition);
		
		// level1b2 -- t8([]) -> level1a2
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1b2_level1a2 " + "exec(t8)");
				obj.historyOfHLevel1b = StateId.level1b2;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1b2 -- t8([]) -> level1a2
		stateMachine.addTransition(EventId.t8, StateId.level1b2, tempTransition);
		
		// level1b2 -- t11([]) -> level1a1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level1b2_level1a1 " + "exec(t11)");
				obj.historyOfHLevel1b = StateId.level1b2;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level1b2 -- t11([]) -> level1a1
		stateMachine.addTransition(EventId.t11, StateId.level1b2, tempTransition);
		
		// level2b1 -- t7([]) -> level2b2
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level2b2) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level2b1_level2b2 " + "exec(t7)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level2b1 -- t7([]) -> level2b2
		stateMachine.addTransition(EventId.t7, StateId.level2b1, tempTransition);
		
		// level2b1 -- h0([]) -> shallow
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.shallow) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level2b1_shallow " + "exec(h0)");
				obj.historyOfHLevel1b = StateId.level2b1;
				// no action bound to this transition
				switch (obj.historyOfShallow) {
					case level1a1:
						super.exec(ev, obj);
						return StateId.level1a1;
					case level1a2:
						super.exec(ev, obj);
						return StateId.level1a2;
				}
				return super.exec(ev, obj);
			}
			
		};
		// level2b1 -- h0([]) -> shallow
		stateMachine.addTransition(EventId.h0, StateId.level2b1, tempTransition);
		
		// level2b1 -- t11([]) -> level1a1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level2b1_level1a1 " + "exec(t11)");
				obj.historyOfHLevel1b = StateId.level2b1;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level2b1 -- t11([]) -> level1a1
		stateMachine.addTransition(EventId.t11, StateId.level2b1, tempTransition);
		
		// level2b2 -- h0([]) -> shallow
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.shallow) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level2b2_shallow " + "exec(h0)");
				obj.historyOfHLevel1b = StateId.level2b2;
				// no action bound to this transition
				switch (obj.historyOfShallow) {
					case level1a1:
						super.exec(ev, obj);
						return StateId.level1a1;
					case level1a2:
						super.exec(ev, obj);
						return StateId.level1a2;
				}
				return super.exec(ev, obj);
			}
			
		};
		// level2b2 -- h0([]) -> shallow
		stateMachine.addTransition(EventId.h0, StateId.level2b2, tempTransition);
		
		// level2b2 -- t11([]) -> level1a1
		
		tempTransition = new Transition<HistoryStateExerciser, EventId, StateId>(StateId.level1a1) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, HistoryStateExerciser obj) {
				if (SMDEBUG)
					System.out.println("AT_level2b2_level1a1 " + "exec(t11)");
				obj.historyOfHLevel1b = StateId.level2b2;
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// level2b2 -- t11([]) -> level1a1
		stateMachine.addTransition(EventId.t11, StateId.level2b2, tempTransition);
		
	};
	/* PROTECTED REGION ID(debugflag._15_5_1_6340215_1233754307714_240408_1202) ENABLED START */
	/** switch state machine tracing on / off */
	private static final boolean SMDEBUG = true;
	
	/* PROTECTED REGION END */
}
