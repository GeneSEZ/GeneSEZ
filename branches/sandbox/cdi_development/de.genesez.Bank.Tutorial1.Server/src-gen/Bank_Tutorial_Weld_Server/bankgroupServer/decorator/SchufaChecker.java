package Bank_Tutorial_Weld_Server.bankgroupServer.decorator;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1295617750758_301949_805) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.action.CustomerAction;

import javax.inject.Inject;

import javax.enterprise.inject.Any;

import javax.decorator.Delegate;

import javax.decorator.Decorator;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Decorator
public abstract class SchufaChecker implements CustomerAction, Serializable {
	
	@Inject
	@Any
	@Delegate
	private CustomerAction customerAction;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String createCredit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1295797697416_453258_531) ENABLED START */
		
		if (customerAction instanceof CustomerAction) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Negative Schufa entry for customer " + ((CustomerAction) customerAction).getCustomerHome().getInstance().getFullName()));
		}
		//customerAction.createCredit(amount)
		return "";
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1295617750758_301949_805) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
