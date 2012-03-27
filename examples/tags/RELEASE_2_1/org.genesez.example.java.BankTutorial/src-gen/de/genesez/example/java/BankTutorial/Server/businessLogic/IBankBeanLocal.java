package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (BankBeanLocal) 
 */

import de.genesez.example.java.BankTutorial.Server.data.Bank;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */

@Local
public interface IBankBeanLocal {
	
	/**
	 * creates a bank and returns the persisted bank
	 * If there is problem with the bank instance or the database the method returns null
	 * @param	bank	
	 * @return	
	 */
	
	public Bank createBank(Bank bank);
	
	/**
	 * This method updates the bank in the database
	 * If there is problem with the bank instance or the database the method returns null
	 * @param	changedBank	
	 * @return	
	 */
	
	public Bank changeBank(Bank changedBank);
	
	/**
	 * This method removes a bank from the database
	 * @param	toBeDeleted	
	 */
	
	public void removeBank(Bank toBeDeleted);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.BankBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
