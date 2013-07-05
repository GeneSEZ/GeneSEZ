package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1295616816697_516191_766) ENABLED START */
/* TODO: put your own source code here */
import java.util.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.CustomerHome;
import javax.persistence.*;
import javax.inject.Inject;
import javax.enterprise.context.Conversation;
import javax.enterprise.inject.Model;
import javax.annotation.*;
import javax.ejb.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Bank_Tutorial_Weld_Server.qualifier.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.*;

/* PROTECTED REGION END */

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
	 * method stub for further implementation
	 * @return	
	 */
	
	public String selectCustomer() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1295799817600_41848_551) ENABLED START */

		customerHome.initConversation();
		return "CustomerList";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
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
	 * method stub for further implementation
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
	 * getter for the attribute '<em><b>customerHome</b></em>'
	 */
	public CustomerHome getCustomerHome() {
		return customerHome;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1295616816697_516191_766) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
