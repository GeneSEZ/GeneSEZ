package org.genesez.example.java.cdi.bank.server.decorator;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1295617750758_301949_805) 
 */

import java.io.Serializable;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.genesez.example.java.cdi.bank.server.action.CustomerAction;
import org.genesez.example.java.cdi.bank.server.action.ICustomerAction;

/**
 */

@Decorator
public abstract class SchufaChecker implements ICustomerAction, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	@Any
	@Delegate
	private ICustomerAction customerAction;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	amount	
	 * @return	
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
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1295617750758_301949_805) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
