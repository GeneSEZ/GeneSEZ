package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* PROTECTED REGION ID(java.type.import.InterestBeanLocal) ENABLED START */
/* TODO: put your own source code here */
import javax.ejb.Local;
import javax.ejb.Timer;

import de.genesez.example.java.BankTutorial.Server.data.AbstractAccount;

/* PROTECTED REGION END */

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
	public void startInterestPayment(AbstractAccount account);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.InterestBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
