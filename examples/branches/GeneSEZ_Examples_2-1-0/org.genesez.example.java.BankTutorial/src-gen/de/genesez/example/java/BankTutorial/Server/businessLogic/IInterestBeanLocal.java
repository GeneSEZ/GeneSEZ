package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (InterestBeanLocal) 
 */

import javax.ejb.Timer;
import javax.interceptor.Interceptors;
import de.genesez.example.java.BankTutorial.Server.data.Account;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */

@Local
public interface IInterestBeanLocal {
	
	/**
	 * calculates the inerest rate of the account which timer was up and sets a new timer
	 * @param	timer	
	 */
	
	public void calculateInterest(Timer timer);
	
	/**
	 * creates a timer for the inerest rate calculation of an account
	 * @param	account	
	 */
	
	public void startInterestPayment(Account account);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.InterestBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
