package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (AccountBeanLocal) 
 */

import de.genesez.example.java.BankTutorial.Server.data.Bank;
import de.genesez.example.java.BankTutorial.Server.data.AbstractAccount;
import de.genesez.example.java.BankTutorial.Server.data.Customer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author domwet
 */

@Local
public interface IAccountBeanLocal {
	
	/**
	 * This method opens an account for a customer of a bank and returns the persisted account.
	 * It has to check if the customer is really a customer of the bank. If the check fails the method returns null
	 * @param	account	
	 * @param	customer	
	 * @param	bank	
	 * @return	
	 */
	
	public AbstractAccount openAccount(AbstractAccount account, Customer customer, Bank bank);
	
	/**
	 * This method removes an account from the database
	 * @param	toBeDeleted	
	 */
	
	public void removeAccount(AbstractAccount toBeDeleted);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.AccountBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
