package de.genesez.platforms.java.BankTutorial.Server.businessLogic;

/*PROTECTED REGION ID(java.type.import._16_0_129203bc_1271100384359_869290_741) ENABLED START*/
/* TODO: put your own source code here */
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.genesez.platforms.java.BankTutorial.Server.data.AbstractAccount;

/*PROTECTED REGION END*/

/**
 * This bean is responsible for the calculation of the interest rate of the bank accounts using the timer of the Enterprise JavaBeans
 * @author	apflueger
 */

@Stateless(name = "InterestRateBean")
public class InterestRateBean implements IInterestRateBeanLocal {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Resource
	private TimerService timerService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>InterestRateBean</b></em>'
	 */
	public InterestRateBean() {
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
	public void calculateInterestRate(Timer timer) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271100430203_54009_770) ENABLED START */
		// TODO: implementation of method 'InterestRateBean.calculateInterestRate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * creates a timer for the inerest rate calculation of an account
	 * @param	account	
	 */
	
	public void startInterestPayment(AbstractAccount account) {
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
