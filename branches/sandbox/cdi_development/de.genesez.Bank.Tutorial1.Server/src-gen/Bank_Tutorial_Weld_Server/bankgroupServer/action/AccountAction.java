package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1290437148659_98473_381) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.ejb.Remove;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.AccountHome;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.AccountStateEnum;
import Bank_Tutorial_Weld_Server.qualifier.Logging;

/* PROTECTED REGION END */

/**
 */

@Model
@Logging
public class AccountAction implements IAccountAction {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private AccountHome accountHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String selectAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290607643743_626720_563) ENABLED START */

		accountHome.initConversation();
		return "AccountList";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @param	amount	
	 * @return	
	 */
	
	public String withdraw(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290437233884_123442_404) ENABLED START */

		accountHome.getInstance().withdraw(Float.valueOf(amount));
		return "Administration";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @param	amount	
	 * @return	
	 */
	
	public String deposit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290437276055_220574_408) ENABLED START */

		accountHome.getInstance().deposit(Float.valueOf(amount));
		return "Administration";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String saveAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290607608752_242752_560) ENABLED START */

		accountHome.save();
		return "home";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String cancel() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292944095037_464062_934) ENABLED START */

		accountHome.cancel();
		return "home";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String lockAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292927511955_659940_922) ENABLED START */

		accountHome.getInstance().setState(AccountStateEnum.LOCKED);
		return "";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String closeAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292927518915_89685_924) ENABLED START */

		accountHome.getInstance().setState(AccountStateEnum.CLOSED);
		return "";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public String unlockAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292927524555_478504_926) ENABLED START */

		accountHome.getInstance().setState(AccountStateEnum.VALID);
		return "";
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>accountHome</b></em>'
	 */
	public AccountHome getAccountHome() {
		return accountHome;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1290437148659_98473_381) ENABLED START */
	private static final long serialVersionUID = 1L;
	/* PROTECTED REGION END */

}
