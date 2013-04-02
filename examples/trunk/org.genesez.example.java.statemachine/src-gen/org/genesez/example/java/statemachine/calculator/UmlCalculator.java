package org.genesez.example.java.statemachine.calculator;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_6340215_1225038875421_848650_119) 
 */
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;
import org.genesez.platform.java.umlsupport.statemachine.EventQueue;
import org.genesez.platform.java.umlsupport.statemachine.EventReceiver;
import org.genesez.platform.java.umlsupport.statemachine.GuardedTransition;
import org.genesez.platform.java.umlsupport.statemachine.GuardedTransitionGroup;
import org.genesez.platform.java.umlsupport.statemachine.StateMachine;
import org.genesez.platform.java.umlsupport.statemachine.Transition;
import org.genesez.platform.java.umlsupport.statemachine.*;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class UmlCalculator implements AssociationRole, EventReceiver<UmlCalculator.EventId> {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		OPERAND
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the linked object of association '<em><b>operand</b></em>' */
	private UmlOperand operand;
	
	private BigDecimal x;
	
	private BigDecimal y;
	
	private BigDecimal result;
	
	private String display;
	
	private Operation operator;
	
	/**
	 * Constructor for class '<em><b>UmlCalculator</b></em>'.
	 */
	public UmlCalculator() {
		/* PROTECTED REGION ID(java.constructor._15_5_1_6340215_1232983409888_396871_1086) ENABLED START */
		operand().insert(new UmlOperand());
		new _ANON_().sendImmediate();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>result</b></em>'.
	 */
	public BigDecimal getResult() {
		return result;
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.OPERAND, new OneAssociation<UmlCalculator, UmlOperand>(this, new Accessor<UmlOperand>() {
			public UmlOperand get() {
				return operand;
			}
			
			public void set(UmlOperand referenced) {
				operand = referenced;
			}
		}));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * Provides access to the association '<em><b>operand</b></em>' to {@link UmlOperand}.
	 */
	@SuppressWarnings("unchecked")
	public Association<UmlCalculator, UmlOperand> operand() {
		return (Association<UmlCalculator, UmlOperand>) association.get(Associations.OPERAND);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_6340215_1225038875421_848650_119) ENABLED START */
	private void eval() {
		switch (operator) {
			case ADD:
				result = y.add(x);
				break;
			case SUB:
				result = y.subtract(x);
				break;
			case MUL:
				result = y.multiply(x);
				break;
			case DIV:
				result = y.divide(x);
				break;
			case POW:
				result = y.pow(x.intValue());
				break;
		}
		System.out.println("eval: " + result + " = " + y + " " + operator + " " + x);
	}
	
	/* PROTECTED REGION END */
	
	public void takeClear() {
		new Clear().send();
	}
	
	public void takeClearEntry() {
		new ClearEntry().send();
	}
	
	public void takeDigit(int value) {
		new Digit(value).send();
	}
	
	public void takeDot() {
		new Dot().send();
	}
	
	public void takeEquals() {
		new Equals().send();
	}
	
	public void takeOperator(Operation o) {
		new Operator(o).send();
	}
	
	private Timer timerForTimeout;
	
	private void startTimerForTimeout() {
		if (SMDEBUG)
			System.out.println("timeout " + "startet");
		timerForTimeout = new Timeout().sendDelayed(10000);
	}
	
	private void stopTimerForTimeout() {
		if (timerForTimeout != null) {
			timerForTimeout.cancel();
			if (SMDEBUG)
				System.out.println("timeout " + "stopped");
		}
		timerForTimeout = null;
	}
	
	// all state machine actions are implemented as a method
	/**
	 * Action method stub for further implementation.
	 */
	private void clearAll(SmEvent event) {
		if (SMDEBUG)
			System.out.println("clearAll " + "( ... )");
		/* PROTECTED REGION ID(action.clearAll_14_0_6340215_1225039245609_959527_370) ENABLED START */
		operand().get().takeClear();
		x = new BigDecimal(0.0);
		y = new BigDecimal(0.0);
		result = new BigDecimal(0.0);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void clearOperand(SmEvent event) {
		if (SMDEBUG)
			System.out.println("clearOperand " + "( ... )");
		/* PROTECTED REGION ID(action.clearOperand_14_0_6340215_1225039245609_959527_370) ENABLED START */
		operand().get().takeClear();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void clearX(SmEvent event) {
		if (SMDEBUG)
			System.out.println("clearX " + "( ... )");
		/* PROTECTED REGION ID(action.clearX_14_0_6340215_1225039245609_959527_370) ENABLED START */
		x = new BigDecimal(0.0);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void clearY(SmEvent event) {
		if (SMDEBUG)
			System.out.println("clearY " + "( ... )");
		/* PROTECTED REGION ID(action.clearY_14_0_6340215_1225039245609_959527_370) ENABLED START */
		y = new BigDecimal(0.0);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void evaluate(SmEvent event) {
		if (SMDEBUG)
			System.out.println("evaluate " + "( ... )");
		/* PROTECTED REGION ID(action.evaluate_14_0_6340215_1225039245609_959527_370) ENABLED START */
		eval();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void evaluateAndSetY(SmEvent event) {
		if (SMDEBUG)
			System.out.println("evaluateAndSetY " + "( ... )");
		/* PROTECTED REGION ID(action.evaluateAndSetY_14_0_6340215_1225039245609_959527_370) ENABLED START */
		eval();
		y = result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void sendDigitToOperand(SmEvent event) {
		if (SMDEBUG)
			System.out.println("sendDigitToOperand " + "( ... )");
		/* PROTECTED REGION ID(action.sendDigitToOperand_14_0_6340215_1225039245609_959527_370) ENABLED START */
		operand().get().takeDigit(((Digit) event).value);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void sendDotToOperand(SmEvent event) {
		if (SMDEBUG)
			System.out.println("sendDotToOperand " + "( ... )");
		/* PROTECTED REGION ID(action.sendDotToOperand_14_0_6340215_1225039245609_959527_370) ENABLED START */
		operand().get().takeDot();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void setOperator(SmEvent event) {
		if (SMDEBUG)
			System.out.println("setOperator " + "( ... )");
		/* PROTECTED REGION ID(action.setOperator_14_0_6340215_1225039245609_959527_370) ENABLED START */
		operator = ((Operator) event).o;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void setXfromOperand(SmEvent event) {
		if (SMDEBUG)
			System.out.println("setXfromOperand " + "( ... )");
		/* PROTECTED REGION ID(action.setXfromOperand_14_0_6340215_1225039245609_959527_370) ENABLED START */
		x = operand().get().getVal();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void setYFromResult(SmEvent event) {
		if (SMDEBUG)
			System.out.println("setYFromResult " + "( ... )");
		/* PROTECTED REGION ID(action.setYFromResult_14_0_6340215_1225039245609_959527_370) ENABLED START */
		y = result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void setYfromOperand(SmEvent event) {
		if (SMDEBUG)
			System.out.println("setYfromOperand " + "( ... )");
		/* PROTECTED REGION ID(action.setYfromOperand_14_0_6340215_1225039245609_959527_370) ENABLED START */
		y = operand().get().getVal();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void show(SmEvent event) {
		if (SMDEBUG)
			System.out.println("show " + "( ... )");
		/* PROTECTED REGION ID(action.show_14_0_6340215_1225039245609_959527_370) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Action method stub for further implementation.
	 */
	private void shutdown(SmEvent event) {
		if (SMDEBUG)
			System.out.println("shutdown " + "( ... )");
		/* PROTECTED REGION ID(action.shutdown_14_0_6340215_1225039245609_959527_370) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	// do actions are called from a thread, controlled by start and stop methods
	
	// all state machine guards are implemented as a method
	
	/** enum for all leaf states */
	static enum StateId {
		End,
		Start,
		StartInput,
		eval,
		operatorEntered,
		xOperandInput,
		yOperandInput
	};
	
	/** member variable holding current state */
	private StateId currentState = StateId.Start;
	
	/** package visible getter for debug purposes */
	StateId getCurrentState() {
		return currentState;
	}
	
	/** enum for all trigger events */
	static enum EventId {
		_ANON_, clear, clearEntry, digit, dot, equals, operator, timeout
	};
	
	/** inner class as local base class for all trigger events */
	private class SmEvent extends EventQueue.Event<EventId> {
		/* PROTECTED REGION ID(SmEvent._14_0_6340215_1225039245609_959527_370) ENABLED START */
		// Usually nothing to insert here, just in case ... 
		/* PROTECTED REGION END */
		public SmEvent(EventId id) {
			super(id);
		}
		
		public UmlCalculator getReceiver() {
			return UmlCalculator.this;
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
	
	private class ClearEntry extends SmEvent {
		public ClearEntry() {
			super(EventId.clearEntry);
		}
	}
	
	private class Digit extends SmEvent {
		private int value;
		
		public int getValue() {
			return value;
		}
		
		public Digit(int value) {
			super(EventId.digit);
			this.value = value;
		}
	}
	
	private class Dot extends SmEvent {
		public Dot() {
			super(EventId.dot);
		}
	}
	
	private class Equals extends SmEvent {
		public Equals() {
			super(EventId.equals);
		}
	}
	
	private class Operator extends SmEvent {
		private Operation o;
		
		public Operation getO() {
			return o;
		}
		
		public Operator(Operation o) {
			super(EventId.operator);
			this.o = o;
		}
	}
	
	private class Timeout extends SmEvent {
		public Timeout() {
			super(EventId.timeout);
		}
	}
	
	/**
	 * process events from event queue
	 */
	public void takeEvent(EventQueue.Event<EventId> event) {
		StateId temp = currentState;
		currentState = stateMachine.takeEvent(event, currentState, this);
		System.out.println(getClass().getSimpleName() + ": " + temp + " --(" + event + ")-> " + currentState);
	};
	
	/** class variable holding state machine of this class */
	private static StateMachine<UmlCalculator, EventId, StateId> stateMachine = new StateMachine<UmlCalculator, EventId, StateId>();
	static {
		@SuppressWarnings("unused")
		Transition<UmlCalculator, EventId, StateId> tempTransition;
		@SuppressWarnings("unused")
		GuardedTransition<UmlCalculator, EventId, StateId> tempGuardedTransition;
		@SuppressWarnings("unused")
		GuardedTransitionGroup<UmlCalculator, EventId, StateId> tempGroup;
		// Start -- _ANON_([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_Start_yOperandInput " + "exec(_ANON_)");
				obj.show((_ANON_) ev); // call all onTransition actions
				obj.clearOperand((_ANON_) ev); // call all onTransition actions
				obj.clearY((_ANON_) ev); // call all entry actions
				obj.startTimerForTimeout(); // start time triggers in target state
				return super.exec(ev, obj);
			}
			
		};
		// Start -- _ANON_([]) -> yOperandInput
		stateMachine.addTransition(EventId._ANON_, StateId.Start, tempTransition);
		
		// eval -- operator([o]) -> operatorEntered
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.operatorEntered) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_operatorEntered " + "exec(operator)");
				obj.setYFromResult((Operator) ev); // call all onTransition actions
				obj.setOperator((Operator) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- operator([o]) -> operatorEntered
		stateMachine.addTransition(EventId.operator, StateId.eval, tempTransition);
		
		// eval -- equals([]) -> eval
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.eval) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_eval " + "exec(equals)");
				obj.evaluate((Equals) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- equals([]) -> eval
		stateMachine.addTransition(EventId.equals, StateId.eval, tempTransition);
		
		// eval -- digit([value]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_yOperandInput " + "exec(digit)");
				obj.sendDigitToOperand((Digit) ev); // call all onTransition actions
				obj.clearY((Digit) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- digit([value]) -> yOperandInput
		stateMachine.addTransition(EventId.digit, StateId.eval, tempTransition);
		
		// eval -- dot([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_yOperandInput " + "exec(dot)");
				obj.sendDotToOperand((Dot) ev); // call all onTransition actions
				obj.clearY((Dot) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- dot([]) -> yOperandInput
		stateMachine.addTransition(EventId.dot, StateId.eval, tempTransition);
		
		// eval -- timeout([]) -> End
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.End) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_End " + "exec(timeout)");
				obj.stopTimerForTimeout(); // stop time triggers in source state
				obj.shutdown((Timeout) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- timeout([]) -> End
		stateMachine.addTransition(EventId.timeout, StateId.eval, tempTransition);
		
		// eval -- clear([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_yOperandInput " + "exec(clear)");
				obj.clearAll((Clear) ev); // call all onTransition actions
				obj.clearY((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- clear([]) -> yOperandInput
		stateMachine.addTransition(EventId.clear, StateId.eval, tempTransition);
		
		// eval -- clearEntry([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_eval_yOperandInput " + "exec(clearEntry)");
				obj.clearOperand((ClearEntry) ev); // call all onTransition actions
				obj.clearY((ClearEntry) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// eval -- clearEntry([]) -> yOperandInput
		stateMachine.addTransition(EventId.clearEntry, StateId.eval, tempTransition);
		
		// operatorEntered -- operator([o]) -> operatorEntered
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.operatorEntered) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_operatorEntered " + "exec(operator)");
				obj.setOperator((Operator) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- operator([o]) -> operatorEntered
		stateMachine.addTransition(EventId.operator, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- equals([]) -> eval
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.eval) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_eval " + "exec(equals)");
				obj.evaluate((Equals) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- equals([]) -> eval
		stateMachine.addTransition(EventId.equals, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- dot([]) -> xOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.xOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_xOperandInput " + "exec(dot)");
				obj.sendDotToOperand((Dot) ev); // call all onTransition actions
				obj.clearX((Dot) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- dot([]) -> xOperandInput
		stateMachine.addTransition(EventId.dot, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- digit([value]) -> xOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.xOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_xOperandInput " + "exec(digit)");
				obj.sendDigitToOperand((Digit) ev); // call all onTransition actions
				obj.clearX((Digit) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- digit([value]) -> xOperandInput
		stateMachine.addTransition(EventId.digit, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- timeout([]) -> End
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.End) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_End " + "exec(timeout)");
				obj.stopTimerForTimeout(); // stop time triggers in source state
				obj.shutdown((Timeout) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- timeout([]) -> End
		stateMachine.addTransition(EventId.timeout, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- clear([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_yOperandInput " + "exec(clear)");
				obj.clearAll((Clear) ev); // call all onTransition actions
				obj.clearY((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- clear([]) -> yOperandInput
		stateMachine.addTransition(EventId.clear, StateId.operatorEntered, tempTransition);
		
		// operatorEntered -- clearEntry([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_operatorEntered_yOperandInput " + "exec(clearEntry)");
				obj.clearOperand((ClearEntry) ev); // call all onTransition actions
				obj.clearY((ClearEntry) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// operatorEntered -- clearEntry([]) -> yOperandInput
		stateMachine.addTransition(EventId.clearEntry, StateId.operatorEntered, tempTransition);
		
		// xOperandInput -- digit([value]) -> xOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.xOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("ATI_xOperandInput " + "exec(digit)");
				obj.sendDigitToOperand((Digit) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- digit([value]) -> xOperandInput
		stateMachine.addTransition(EventId.digit, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- dot([]) -> xOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.xOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("ATI_xOperandInput " + "exec(dot)");
				obj.sendDotToOperand((Dot) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- dot([]) -> xOperandInput
		stateMachine.addTransition(EventId.dot, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- equals([]) -> eval
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.eval) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_xOperandInput_eval " + "exec(equals)");
				obj.setXfromOperand((Equals) ev); // call all exit actions
				obj.clearOperand((Equals) ev); // call all entry actions
				obj.evaluate((Equals) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- equals([]) -> eval
		stateMachine.addTransition(EventId.equals, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- operator([o]) -> operatorEntered
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.operatorEntered) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_xOperandInput_operatorEntered " + "exec(operator)");
				obj.setXfromOperand((Operator) ev); // call all exit actions
				obj.evaluateAndSetY((Operator) ev); // call all onTransition actions
				obj.clearOperand((Operator) ev); // call all entry actions
				obj.setOperator((Operator) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- operator([o]) -> operatorEntered
		stateMachine.addTransition(EventId.operator, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- clearEntry([]) -> xOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.xOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_xOperandInput_xOperandInput " + "exec(clearEntry)");
				obj.setXfromOperand((ClearEntry) ev); // call all exit actions
				obj.clearOperand((ClearEntry) ev); // call all onTransition actions
				obj.clearX((ClearEntry) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- clearEntry([]) -> xOperandInput
		stateMachine.addTransition(EventId.clearEntry, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- timeout([]) -> End
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.End) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_xOperandInput_End " + "exec(timeout)");
				obj.stopTimerForTimeout(); // stop time triggers in source state
				obj.setXfromOperand((Timeout) ev); // call all exit actions
				obj.shutdown((Timeout) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- timeout([]) -> End
		stateMachine.addTransition(EventId.timeout, StateId.xOperandInput, tempTransition);
		
		// xOperandInput -- clear([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_xOperandInput_yOperandInput " + "exec(clear)");
				obj.setXfromOperand((Clear) ev); // call all exit actions
				obj.clearAll((Clear) ev); // call all onTransition actions
				obj.clearY((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// xOperandInput -- clear([]) -> yOperandInput
		stateMachine.addTransition(EventId.clear, StateId.xOperandInput, tempTransition);
		
		// yOperandInput -- operator([o]) -> operatorEntered
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.operatorEntered) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_yOperandInput_operatorEntered " + "exec(operator)");
				obj.setYfromOperand((Operator) ev); // call all exit actions
				obj.clearOperand((Operator) ev); // call all entry actions
				obj.setOperator((Operator) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- operator([o]) -> operatorEntered
		stateMachine.addTransition(EventId.operator, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- digit([value]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("ATI_yOperandInput " + "exec(digit)");
				obj.sendDigitToOperand((Digit) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- digit([value]) -> yOperandInput
		stateMachine.addTransition(EventId.digit, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- dot([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("ATI_yOperandInput " + "exec(dot)");
				obj.sendDotToOperand((Dot) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- dot([]) -> yOperandInput
		stateMachine.addTransition(EventId.dot, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- equals([]) -> eval
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.eval) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_yOperandInput_eval " + "exec(equals)");
				obj.setYfromOperand((Equals) ev); // call all exit actions
				obj.clearOperand((Equals) ev); // call all entry actions
				obj.evaluate((Equals) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- equals([]) -> eval
		stateMachine.addTransition(EventId.equals, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- timeout([]) -> End
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.End) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_yOperandInput_End " + "exec(timeout)");
				obj.stopTimerForTimeout(); // stop time triggers in source state
				obj.setYfromOperand((Timeout) ev); // call all exit actions
				obj.shutdown((Timeout) ev); // call all onTransition actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- timeout([]) -> End
		stateMachine.addTransition(EventId.timeout, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- clear([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_yOperandInput_yOperandInput " + "exec(clear)");
				obj.setYfromOperand((Clear) ev); // call all exit actions
				obj.clearAll((Clear) ev); // call all onTransition actions
				obj.clearY((Clear) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- clear([]) -> yOperandInput
		stateMachine.addTransition(EventId.clear, StateId.yOperandInput, tempTransition);
		
		// yOperandInput -- clearEntry([]) -> yOperandInput
		
		tempTransition = new Transition<UmlCalculator, EventId, StateId>(StateId.yOperandInput) {
			@SuppressWarnings("unused")
			public StateId exec(EventQueue.Event<EventId> ev, UmlCalculator obj) {
				if (SMDEBUG)
					System.out.println("AT_yOperandInput_yOperandInput " + "exec(clearEntry)");
				obj.setYfromOperand((ClearEntry) ev); // call all exit actions
				obj.clearOperand((ClearEntry) ev); // call all onTransition actions
				obj.clearY((ClearEntry) ev); // call all entry actions
				return super.exec(ev, obj);
			}
			
		};
		// yOperandInput -- clearEntry([]) -> yOperandInput
		stateMachine.addTransition(EventId.clearEntry, StateId.yOperandInput, tempTransition);
		
	};
	/* PROTECTED REGION ID(debugflag._14_0_6340215_1225039245609_959527_370) ENABLED START */
	/** switch state machine tracing on / off */
	private static final boolean SMDEBUG = false;
	
	/* PROTECTED REGION END */
}
