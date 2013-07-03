package org.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (InterestBeanLocal) 
 */
import org.genesez.example.java.BankTutorial.Server.data.Account;
import javax.ejb.Timer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Local
public interface IInterestBeanLocal {
	
	/**
	 * calculates the inerest rate of the account which timer was up and sets a new timer
	 */
	
	public void calculateInterest(Timer timer);
	
	/**
	 * creates a timer for the inerest rate calculation of an account
	 */
	
	public void startInterestPayment(Account account);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration.InterestBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
