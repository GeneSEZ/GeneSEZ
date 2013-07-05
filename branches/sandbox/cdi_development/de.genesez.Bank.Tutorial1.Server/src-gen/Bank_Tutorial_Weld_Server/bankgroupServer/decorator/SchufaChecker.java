package Bank_Tutorial_Weld_Server.bankgroupServer.decorator;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1295617750758_301949_805) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import java.util.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.action.AccountAction;
import Bank_Tutorial_Weld_Server.bankgroupServer.action.CustomerAction;
import Bank_Tutorial_Weld_Server.bankgroupServer.action.ICustomerAction;
import javax.persistence.*;
import javax.inject.Inject;
import javax.enterprise.inject.Any;
import javax.decorator.Delegate;
import javax.decorator.Decorator;
import javax.annotation.*;
import javax.ejb.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Bank_Tutorial_Weld_Server.qualifier.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.*;

/* PROTECTED REGION END */

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
	 * method stub for further implementation
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1295617750758_301949_805) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
