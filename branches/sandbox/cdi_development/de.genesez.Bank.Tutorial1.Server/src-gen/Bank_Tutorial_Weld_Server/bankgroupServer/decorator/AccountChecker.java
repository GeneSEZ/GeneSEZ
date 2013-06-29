package Bank_Tutorial_Weld_Server.bankgroupServer.decorator;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1292872018692_75189_383) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import Bank_Tutorial_Weld_Server.bankgroupServer.action.AccountAction;
import Bank_Tutorial_Weld_Server.bankgroupServer.action.IAccountAction;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.AccountStateEnum;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.AccountLockedEvent;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.BalanceNegativEvent;

/* PROTECTED REGION END */

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
	 * method stub for further implementation
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
	 * method stub for further implementation
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1292872018692_75189_383) ENABLED START */

	/* PROTECTED REGION END */

}
