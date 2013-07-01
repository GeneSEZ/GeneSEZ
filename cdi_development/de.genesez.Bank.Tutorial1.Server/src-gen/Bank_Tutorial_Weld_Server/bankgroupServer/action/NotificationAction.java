package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1294586966092_853220_914) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.event.BalanceNegativEvent;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.AccountLockedEvent;

import javax.enterprise.inject.Model;

import javax.enterprise.event.Observes;
import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static javax.enterprise.event.TransactionPhase.AFTER_FAILURE;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.enterprise.event.TransactionPhase.BEFORE_COMPLETION;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;
import static javax.enterprise.event.Reception.ALWAYS;
import static javax.enterprise.event.Reception.IF_EXISTS;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Model
@Logging
public class NotificationAction {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void postNotification(@Observes(during = IN_PROGRESS, notifyObserver = ALWAYS)
	BalanceNegativEvent event) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1294587118521_333851_937) ENABLED START */
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Your account balance is negative!"));
		System.out.println("Email has been sent! Balance is negativ: " + event.getBalance());
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void sendEmail(@Observes(during = IN_PROGRESS, notifyObserver = ALWAYS)
	AccountLockedEvent event) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1294587308879_75560_941) ENABLED START */
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The account is locked or closed."));
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1294586966092_853220_914) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
