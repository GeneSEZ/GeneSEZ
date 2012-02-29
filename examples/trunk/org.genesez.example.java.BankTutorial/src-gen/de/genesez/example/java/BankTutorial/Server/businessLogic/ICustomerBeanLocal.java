package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (CustomerBeanLocal) 
 */

import de.genesez.example.java.BankTutorial.Server.data.Bank;
import de.genesez.example.java.BankTutorial.Server.data.Customer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author domwet
 */

@Local
public interface ICustomerBeanLocal {
	
	/**
	 * adds a customer to a bank and returns the persisted customer
	 * If a problem occurs with the customer and/or bank instance, the bank already knows this customer or a database problem occurs the method returns null
	 * @param	bank	
	 * @param	customer	
	 * @return	
	 */
	
	public Customer addCustomer(Bank bank, Customer customer);
	
	/**
	 * changes the customer of the bank and returns the customer
	 * If a problem occurs with the database the method returns null
	 * @param	changedCustomer	
	 * @return	
	 */
	
	public Customer changeCustomer(Customer changedCustomer);
	
	/**
	 * removes the the customer from the database
	 * @param	toBeDeleted	
	 */
	
	public void removeCustomer(Customer toBeDeleted);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.CustomerBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
