package org.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (AccountBeanLocal) 
 */
import org.genesez.example.java.BankTutorial.Server.data.Account;
import org.genesez.example.java.BankTutorial.Server.data.Bank;
import org.genesez.example.java.BankTutorial.Server.data.Customer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Local
public interface IAccountBeanLocal {
	
	/**
	 * This method opens an account for a customer of a bank and returns the persisted account.
	 * It has to check if the customer is really a customer of the bank. If the check fails the method returns null
	 */
	
	public Account openAccount(Account account, Customer customer, Bank bank);
	
	/**
	 * This method removes an account from the database
	 */
	
	public void removeAccount(Account toBeDeleted);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration.AccountBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
