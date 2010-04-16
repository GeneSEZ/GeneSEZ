package de.genesez.platforms.java.BankTutorial.Server.businessLogic;

/*PROTECTED REGION ID(java.type.import.CustomerBeanLocal) ENABLED START*/
/* TODO: put your own source code here */
import javax.ejb.Local;
import de.genesez.platforms.java.BankTutorial.Server.data.Bank;
import de.genesez.platforms.java.BankTutorial.Server.data.Customer;

/*PROTECTED REGION END*/

@Local
public interface ICustomerBeanLocal {
	
	/**
	 * adds a customer to a bank and returns the persisted customer
	 * If a problem occurs with the customer and/or bank instance, the bank already knows this customer or a database problem occurs the method returns null
	 * @param	bank	
	 * @param	customer	
	 * @return	adds a customer to a bank and returns the persisted customerIf a problem occurs with the customer and/or bank instance, the bank already knows this customer or a database problem occurs the method returns null
	 */
	public Customer addCustomer(Bank bank, Customer customer);
	
	/**
	 * changes the customer of the bank and returns the customer
	 * If a problem occurs with the database the method returns null
	 * @param	changedCustomer	
	 * @return	changes the customer of the bank and returns the customerIf a problem occurs with the database the method returns null
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
