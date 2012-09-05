package org.genesez.example.java.cdi.bank.server.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1290437148659_98473_381) 
 */

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.genesez.example.java.cdi.bank.qualifier.Logging;
import org.genesez.example.java.cdi.bank.server.entity.AccountHome;
import org.genesez.example.java.cdi.bank.server.entity.AccountStateEnum;

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
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String selectAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290607643743_626720_563) ENABLED START */
		
		accountHome.initConversation();
		return "AccountList";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
	 * Method stub for further implementation.
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
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String saveAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290607608752_242752_560) ENABLED START */
		
		accountHome.save();
		return "home";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String cancel() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292944095037_464062_934) ENABLED START */
		
		accountHome.cancel();
		return "home";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String lockAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292927511955_659940_922) ENABLED START */
		
		accountHome.getInstance().setState(AccountStateEnum.LOCKED);
		return "";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String closeAccount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1292927518915_89685_924) ENABLED START */
		
		accountHome.getInstance().setState(AccountStateEnum.CLOSED);
		return "";
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
	 * Returns the value of attribute '<em><b>accountHome</b></em>'
	 */
	public AccountHome getAccountHome() {
		return accountHome;
		
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1290437148659_98473_381) ENABLED START */
	private static final long serialVersionUID = 1L;
	/* PROTECTED REGION END */
	
}
