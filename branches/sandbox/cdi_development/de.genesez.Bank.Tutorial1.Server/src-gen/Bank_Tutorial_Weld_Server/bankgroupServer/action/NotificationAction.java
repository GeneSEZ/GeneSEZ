package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1294586966092_853220_914) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import java.util.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.BalanceNegativEvent;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.AccountLockedEvent;
import javax.persistence.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Model;
import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static javax.enterprise.event.TransactionPhase.AFTER_FAILURE;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.enterprise.event.TransactionPhase.BEFORE_COMPLETION;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;
import static javax.enterprise.event.Reception.ALWAYS;
import static javax.enterprise.event.Reception.IF_EXISTS;
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
public class NotificationAction {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @param	event	
	 */
	
	public void postNotification(@Observes(during = IN_PROGRESS, notifyObserver = ALWAYS)
	BalanceNegativEvent event) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1294587118521_333851_937) ENABLED START */

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your account balance is negative!"));
		System.out.println("Email has been sent! Balance is negativ: " + event.getBalance());
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @param	event	
	 */
	
	public void sendEmail(@Observes(during = IN_PROGRESS, notifyObserver = ALWAYS)
	AccountLockedEvent event) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1294587308879_75560_941) ENABLED START */

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The account is locked or closed."));
		
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1294586966092_853220_914) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
