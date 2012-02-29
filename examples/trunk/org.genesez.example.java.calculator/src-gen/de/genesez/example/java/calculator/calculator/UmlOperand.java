package de.genesez.example.java.calculator.calculator;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;
import de.genesez.platforms.java.umlsupport.statemachine.*;
import java.math.BigDecimal;

/* PROTECTED REGION ID(java.type.import._14_0_6340215_1225038888453_246116_139) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class UmlOperand implements EventReceiver<UmlOperand.EventId> {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final BigDecimal TEN = new BigDecimal("10");
	
	private static final Integer MAX_DIGITS = 10;
	
	private static final BigDecimal DOT1 = new BigDecimal("0.1");
	
	private BigDecimal val = new BigDecimal("0");
	
	private BigDecimal decimal;
	
	private Integer digits;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>UmlOperand</b></em>'.
	 */
	public UmlOperand() {
		/* PROTECTED REGION ID(java.constructor._15_5_1_6340215_1232985390449_353979_1097) ENABLED START */
		new _ANON_().sendImmediate();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_6340215_1225038888453_246116_139) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

	// -- generated state machine section -----------------------------------
	public void takeClear() {
		new Clear().sendImmediate();
	}
	
	public void takeDigit(Integer d) {
		new Digit(d).sendImmediate();
	}
	
	public void takeDot() {
		new Dot().sendImmediate();
	}
	
	// all state machine actions are implemented as a method
	/**
	 * Action method stub for further implementation.
	 */
	private void appendDigit(SmEvent event) {
		if (SMDEBUG)
			System.out.println("appendDigit " + "( ... )");
		/* PROTECTED REGION ID(action.appendDigit_15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of action method 'appendDigit(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void appendFractionalDigit(SmEvent event) {
		if (SMDEBUG)
			System.out.println("appendFractionalDigit " + "( ... )");
		/* PROTECTED REGION ID(action.appendFractionalDigit_15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of action method 'appendFractionalDigit(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void clear(SmEvent event) {
		if (SMDEBUG)
			System.out.println("clear " + "( ... )");
		/* PROTECTED REGION ID(action.clear_15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of action method 'clear(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// do actions are called from a thread, controlled by start and stop methods
	/**
	 * Action method stub for further implementation.
	 */
	private void blinkDisplay() {
		if (SMDEBUG)
			System.out.println("blinkDisplay " + "( ... )");
		/* PROTECTED REGION ID(action.blinkDisplay_15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of action method 'blinkDisplay(...)'
		try {
			Thread.sleep(1); // set this to reasonable value
		} catch (InterruptedException e) {
		} // set this to reasonable value
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/** field to control thread execution */
	private boolean threadControlForBlinkDisplay;
	
	/** start thread execution */
	private void startBlinkDisplay() {
		if (SMDEBUG)
			System.out.println("blinkDisplay " + " start");
		threadControlForBlinkDisplay = true;
		new Thread() {
			public void run() {
				while (threadControlForBlinkDisplay) {
					blinkDisplay();
				}
				if (SMDEBUG)
					System.out.println("blinkDisplay " + " stopped");
			}
		}.start();
	}
	
	/** notice thread execution to stop */
	private void endBlinkDisplay() {
		if (SMDEBUG)
			System.out.println("blinkDisplay " + " stop");
		threadControlForBlinkDisplay = false;
	}
	
	// all state machine guards are implemented as a method
	/** 
	 * evaluate guard condition [digit.d == 0]
	 * @param event triggering event
	 */
	private boolean evaluateGuard0(SmEvent event) {
		if (SMDEBUG)
			System.out.println("UmlOperand " + "[digit.d == 0]()" + event.getClass());
		/* PROTECTED REGION ID(guard.digit.digit.d_==_0._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of guard method
		return false;
		/* PROTECTED REGION END */
	}
	
	/** 
	 * evaluate guard condition [digits >= MAX_DIGITS]
	 * @param event triggering event
	 */
	private boolean evaluateGuard1(SmEvent event) {
		if (SMDEBUG)
			System.out.println("UmlOperand " + "[digits >= MAX_DIGITS]()" + event.getClass());
		/* PROTECTED REGION ID(guard.digit.digits_>=_MAX_DIGITS._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of guard method
		return false;
		/* PROTECTED REGION END */
	}
	
	/** 
	 * evaluate guard condition [digits < MAX_DIGITS]
	 * @param event triggering event
	 */
	private boolean evaluateGuard2(SmEvent event) {
		if (SMDEBUG)
			System.out.println("UmlOperand " + "[digits < MAX_DIGITS]()" + event.getClass());
		/* PROTECTED REGION ID(guard.digit.digits_<_MAX_DIGITS._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of guard method
		return false;
		/* PROTECTED REGION END */
	}
	
	/** 
	 * evaluate guard condition [digit.d > 0]
	 * @param event triggering event
	 */
	private boolean evaluateGuard3(SmEvent event) {
		if (SMDEBUG)
			System.out.println("UmlOperand " + "[digit.d > 0]()" + event.getClass());
		/* PROTECTED REGION ID(guard.digit.digit.d_>_0._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// TODO: implementation of guard method
		return false;
		/* PROTECTED REGION END */
	}
	
	/** enum for all leaf states */
	static enum StateId {
		Start, frac, full, integ, zero
	};
	
	/** member variable holding current state */
	private StateId currentState = StateId.Start;
	
	/** package visible getter for debug purposes */
	StateId getCurrentState() {
		return currentState;
	}
	
	/** enum for all trigger events */
	static enum EventId {
		_ANON_, clear, digit, dot
	};
	
	/** inner class as local base class for all trigger events */
	private class SmEvent extends EventQueue.Event<EventId> {
		/* PROTECTED REGION ID(SmEvent._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
		// Usually nothing to insert here, just in case ... 
		/* PROTECTED REGION END */
		public SmEvent(EventId id) {
			super(id);
		}
		
		public UmlOperand getReceiver() {
			return UmlOperand.this;
		}
	}
	
	private class _ANON_ extends SmEvent {
		public _ANON_() {
			super(EventId._ANON_);
		}
	}
	
	private class Clear extends SmEvent {
		public Clear() {
			super(EventId.clear);
		}
	}
	
	private class Digit extends SmEvent {
		private Integer d;
		
		public Integer getD() {
			return d;
		}
		
		public Digit(Integer d) {
			super(EventId.digit);
			this.d = d;
		}
	}
	
	private class Dot extends SmEvent {
		public Dot() {
			super(EventId.dot);
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
	private static StateMachine<UmlOperand, EventId, StateId> stateMachine = new StateMachine<UmlOperand, EventId, StateId>();
	static {
		@SuppressWarnings("unused")
		Transition<UmlOperand, EventId, StateId> tempTransition;
		@SuppressWarnings("unused")
		GuardedTransition<UmlOperand, EventId, StateId> tempGuardedTransition;
		@SuppressWarnings("unused")
		GuardedTransitionGroup<UmlOperand, EventId, StateId> tempGroup;
		// Start -- _ANON_([]) -> zero
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_Start_zero " + "exec(_ANON_)");
				obj.clear((_ANON_) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// Start -- _ANON_([]) -> zero
		stateMachine.addTransition(EventId._ANON_, StateId.Start, tempTransition);
		
		// frac -- dot([]) -> frac
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.frac) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_frac " + "exec(dot)");
				// ignore event
				return super.exec(ev, obj);
			}
			
		};
		// frac -- dot([]) -> frac
		stateMachine.addTransition(EventId.dot, StateId.frac, tempTransition);
		
		/*
		AT_frac_frac, AT_frac_full
		 */
		tempGroup = new GuardedTransitionGroup<UmlOperand, EventId, StateId>();
		// frac -- digit([d])[digits < MAX_DIGITS] -> frac
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.frac) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_frac_frac " + "exec(digit)");
				obj.appendFractionalDigit((Digit) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digits < MAX_DIGITS] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_frac_frac " + "eval(digit)");
				return obj.evaluateGuard2((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		// frac -- digit([d])[digits >= MAX_DIGITS] -> full
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.full) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_frac_full " + "exec(digit)");
				obj.startBlinkDisplay(); // call all startDo's
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digits >= MAX_DIGITS] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_frac_full " + "eval(digit)");
				return obj.evaluateGuard1((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		stateMachine.addTransition(EventId.digit, StateId.frac, tempGroup);
		
		// frac -- clear([]) -> zero
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_frac_zero " + "exec(clear)");
				obj.clear((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// frac -- clear([]) -> zero
		stateMachine.addTransition(EventId.clear, StateId.frac, tempTransition);
		
		// full -- digit([d]) -> full
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.full) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_full " + "exec(digit)");
				// ignore event
				return super.exec(ev, obj);
			}
			
		};
		// full -- digit([d]) -> full
		stateMachine.addTransition(EventId.digit, StateId.full, tempTransition);
		
		// full -- dot([]) -> full
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.full) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_full " + "exec(dot)");
				// ignore event
				return super.exec(ev, obj);
			}
			
		};
		// full -- dot([]) -> full
		stateMachine.addTransition(EventId.dot, StateId.full, tempTransition);
		
		// full -- clear([]) -> zero
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_full_zero " + "exec(clear)");
				obj.endBlinkDisplay(); // call all endDo's
				obj.clear((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// full -- clear([]) -> zero
		stateMachine.addTransition(EventId.clear, StateId.full, tempTransition);
		
		// integ -- dot([]) -> frac
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.frac) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_frac " + "exec(dot)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// integ -- dot([]) -> frac
		stateMachine.addTransition(EventId.dot, StateId.integ, tempTransition);
		
		/*
		AT_integ_full, AT_integ_integ
		 */
		tempGroup = new GuardedTransitionGroup<UmlOperand, EventId, StateId>();
		// integ -- digit([d])[digits >= MAX_DIGITS] -> full
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.full) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_full " + "exec(digit)");
				obj.startBlinkDisplay(); // call all startDo's
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digits >= MAX_DIGITS] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_full " + "eval(digit)");
				return obj.evaluateGuard1((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		// integ -- digit([d])[digits < MAX_DIGITS] -> integ
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.integ) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_integ " + "exec(digit)");
				obj.appendDigit((Digit) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digits < MAX_DIGITS] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_integ " + "eval(digit)");
				return obj.evaluateGuard2((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		stateMachine.addTransition(EventId.digit, StateId.integ, tempGroup);
		
		// integ -- clear([]) -> zero
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_integ_zero " + "exec(clear)");
				obj.clear((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// integ -- clear([]) -> zero
		stateMachine.addTransition(EventId.clear, StateId.integ, tempTransition);
		
		// zero -- clear([]) -> zero
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_zero " + "exec(clear)");
				// ignore event
				return super.exec(ev, obj);
			}
			
		};
		// zero -- clear([]) -> zero
		stateMachine.addTransition(EventId.clear, StateId.zero, tempTransition);
		
		/*
		ATI_zero, AT_zero_integ
		 */
		tempGroup = new GuardedTransitionGroup<UmlOperand, EventId, StateId>();
		// zero -- digit([d])[digit.d == 0] -> zero
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.zero) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_zero " + "exec(digit)");
				// ignore event
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digit.d == 0] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("ATI_zero " + "eval(digit)");
				return obj.evaluateGuard0((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		// zero -- digit([d])[digit.d > 0] -> integ
		tempGuardedTransition = new GuardedTransition<UmlOperand, EventId, StateId>(StateId.integ) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_zero_integ " + "exec(digit)");
				obj.appendDigit((Digit) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
			/** evaluate guard condition [digit.d > 0] */
			@SuppressWarnings("unused")
			public boolean eval(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_zero_integ " + "eval(digit)");
				return obj.evaluateGuard3((Digit) ev);
			}
			
		};
		tempGroup.addGuardedTransition(tempGuardedTransition);
		
		stateMachine.addTransition(EventId.digit, StateId.zero, tempGroup);
		
		// zero -- dot([]) -> frac
		
		tempTransition = new Transition<UmlOperand, EventId, StateId>(StateId.frac) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlOperand obj) {
				if (SMDEBUG)
					System.out.println("AT_zero_frac " + "exec(dot)");
				// no action bound to this transition
				return super.exec(ev, obj);
			}
			
		};
		// zero -- dot([]) -> frac
		stateMachine.addTransition(EventId.dot, StateId.zero, tempTransition);
		
	};
	/* PROTECTED REGION ID(debugflag._15_5_1_6340215_1225124944062_504229_741) ENABLED START */
	/** switch state machine tracing on / off */
	private static final boolean SMDEBUG = true;
	
	/* PROTECTED REGION END */
}
