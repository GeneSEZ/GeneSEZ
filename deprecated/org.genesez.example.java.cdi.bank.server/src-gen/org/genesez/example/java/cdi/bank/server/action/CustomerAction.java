package org.genesez.example.java.cdi.bank.server.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1295616816697_516191_766) 
 */

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.genesez.example.java.cdi.bank.qualifier.Logging;
import org.genesez.example.java.cdi.bank.server.entity.CustomerHome;

/**
 */

@Model
@Logging
public class CustomerAction implements ICustomerAction {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private CustomerHome customerHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String selectCustomer() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1295799817600_41848_551) ENABLED START */
		
		customerHome.initConversation();
		return "CustomerList";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	amount	
	 * @return	
	 */
	
	public String createCredit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1295616928080_833880_776) ENABLED START */
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your credit is committed!"));
		System.out.println("Your credit is committed!");
		
		customerHome.cancel();
		return "Home";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String cancel() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1295798964926_684332_535) ENABLED START */
		
		customerHome.cancel();
		return "home";
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>customerHome</b></em>'
	 */
	public CustomerHome getCustomerHome() {
		return customerHome;
		
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1295616816697_516191_766) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
