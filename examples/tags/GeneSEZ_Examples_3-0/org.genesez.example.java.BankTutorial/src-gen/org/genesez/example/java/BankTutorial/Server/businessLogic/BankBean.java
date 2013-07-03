package org.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271072706937_469823_827) 
 */
import org.genesez.example.java.BankTutorial.Server.data.Bank;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

/**
 * The bank bean administrates the bank entities
 */

@Stateless(name = "BankBean")
public class BankBean implements IBankBeanLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>BankBean</b></em>'.
	 */
	
	public BankBean() {
	}
	
	/**
	 * creates a bank and returns the persisted bank
	 * If there is problem with the bank instance or the database the method returns null
	 */
	
	public Bank createBank(Bank bank) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271072724171_604562_850) ENABLED START */
		// TODO: implementation of method 'BankBean.createBank(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method updates the bank in the database
	 * If there is problem with the bank instance or the database the method returns null
	 */
	
	public Bank changeBank(Bank changedBank) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271072738984_497759_853) ENABLED START */
		// TODO: implementation of method 'BankBean.changeBank(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method removes a bank from the database
	 */
	
	public void removeBank(Bank toBeDeleted) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271072780687_381411_859) ENABLED START */
		// TODO: implementation of method 'BankBean.removeBank(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271072706937_469823_827) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
