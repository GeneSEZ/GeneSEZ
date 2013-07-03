package org.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (CustomerBeanLocal) 
 */
import org.genesez.example.java.BankTutorial.Server.data.Bank;
import org.genesez.example.java.BankTutorial.Server.data.Customer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Local
public interface ICustomerBeanLocal {
	
	/**
	 * adds a customer to a bank and returns the persisted customer
	 * If a problem occurs with the customer and/or bank instance, the bank already knows this customer or a database problem occurs the method returns null
	 */
	
	public Customer addCustomer(Bank bank, Customer customer);
	
	/**
	 * changes the customer of the bank and returns the customer
	 * If a problem occurs with the database the method returns null
	 */
	
	public Customer changeCustomer(Customer changedCustomer);
	
	/**
	 * removes the the customer from the database
	 */
	
	public void removeCustomer(Customer toBeDeleted);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration.CustomerBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
