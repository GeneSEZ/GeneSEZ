package org.genesez.example.java.cdi.bank.server.decorator;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1292872018692_75189_383) 
 */

import java.io.Serializable;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.genesez.example.java.cdi.bank.server.action.AccountAction;
import org.genesez.example.java.cdi.bank.server.action.IAccountAction;
import org.genesez.example.java.cdi.bank.server.entity.AccountStateEnum;
import org.genesez.example.java.cdi.bank.server.event.AccountLockedEvent;
import org.genesez.example.java.cdi.bank.server.event.BalanceNegativEvent;

/**
 */

@Decorator
public abstract class AccountChecker implements IAccountAction, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	@Any
	@Delegate
	private IAccountAction account;
	
	@Inject
	private Event<BalanceNegativEvent> balanceNegativEvent;
	
	@Inject
	private Event<AccountLockedEvent> accountLockedEvent;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	amount	
	 * @return	
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
	 * @param	amount	
	 * @return	
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
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1292872018692_75189_383) ENABLED START */
	
	/* PROTECTED REGION END */
	
}
