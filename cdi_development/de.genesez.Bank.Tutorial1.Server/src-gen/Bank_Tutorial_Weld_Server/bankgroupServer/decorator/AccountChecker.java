package Bank_Tutorial_Weld_Server.bankgroupServer.decorator;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1292872018692_75189_383) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.action.AccountAction;

import javax.inject.Inject;

import javax.enterprise.inject.Any;

import javax.decorator.Delegate;

import javax.decorator.Decorator;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Decorator
public abstract class AccountChecker implements AccountAction, Serializable {
	
	@Inject
	@Any
	@Delegate
	private AccountAction account;
	
	@Inject
	private Event<BalanceNegativEvent> balanceNegativEvent;
	
	@Inject
	private Event<AccountLockedEvent> accountLockedEvent;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String withdraw(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292924693772_225204_767) ENABLED START */
		
		System.out.println("Decorator: withdraw(" + amount + ")");
		
		if (account instanceof AccountAction) {
			if (((AccountAction) account).getAccountHome().getInstance().getState() != AccountStateEnum.VALID) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Withdraw not possible!"));
				accountLockedEvent.fire(new AccountLockedEvent());
				return "Administration";
			}
			
			if (((AccountAction) account).getAccountHome().getInstance().getAmount() < amount) {
				balanceNegativEvent.fire(new BalanceNegativEvent(((AccountAction) account).getAccountHome().getInstance().getAmount() - amount));
			}
		}
		return account.withdraw(amount);
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String deposit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292924739558_567223_771) ENABLED START */
		
		if (account instanceof AccountAction) {
			if (((AccountAction) account).getAccountHome().getInstance().getState() != AccountStateEnum.VALID) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deposit not possible!"));
				accountLockedEvent.fire(new AccountLockedEvent());
				return "";
			}
		}
		
		return account.deposit(amount);
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1292872018692_75189_383) ENABLED START */
	
	/* PROTECTED REGION END */
}
