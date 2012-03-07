package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271100384359_869290_741) 
 */

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.genesez.example.java.BankTutorial.Server.data.Account;

/**
 * This bean is responsible for the calculation of the interests of the bank accounts using the timer of the Enterprise JavaBeans
 * @author apflueger
 */

@Stateless(name = "InterestBean")
public class InterestBean implements IInterestBeanLocal {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Resource
	private TimerService timerService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>InterestBean</b></em>'.
	 */
	
	public InterestBean() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * calculates the inerest rate of the account which timer was up and sets a new timer
	 * @param	timer	
	 */
	
	@Timeout
	@Interceptors(value = {
		StatementInterceptor.class
	})
	public void calculateInterest(Timer timer) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271100430203_54009_770) ENABLED START */
		// TODO: implementation of method 'InterestRateBean.calculateInterestRate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * creates a timer for the inerest rate calculation of an account
	 * @param	account	
	 */
	
	public void startInterestPayment(Account account) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271100501687_533547_784) ENABLED START */
		// TODO: implementation of method 'InterestRateBean.startInterestPayment(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271100384359_869290_741) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
