package de.genesez.example.java.BankTutorial.Server.businessLogic;

/*PROTECTED REGION ID(java.type.import.BankBeanLocal) ENABLED START*/
/* TODO: put your own source code here */
import javax.ejb.Local;

import de.genesez.example.java.BankTutorial.Server.data.Bank;

/*PROTECTED REGION END*/

@Local
public interface IBankBeanLocal {
	
	/**
	 * creates a bank and returns the persisted bank
	 * If there is problem with the bank instance or the database the method returns null
	 * @param	bank	
	 * @return	creates a bank and returns the persisted bankIf there is problem with the bank instance or the database the method returns null
	 */
	public Bank createBank(Bank bank);
	
	/**
	 * This method updates the bank in the database
	 * If there is problem with the bank instance or the database the method returns null
	 * @param	changedBank	
	 * @return	This method updates the bank in the databaseIf there is problem with the bank instance or the database the method returns null
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
