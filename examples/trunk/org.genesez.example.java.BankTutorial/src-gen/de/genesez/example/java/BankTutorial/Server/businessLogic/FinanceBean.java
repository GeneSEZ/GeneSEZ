package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271101053859_90038_924) 
 */

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import javax.math.BigDecimal;
import de.genesez.example.java.BankTutorial.Server.data.Bank;
import de.genesez.example.java.BankTutorial.Server.data.AbstractAccount;
import de.genesez.example.java.BankTutorial.Server.data.Customer;

/**
 * The finance bean provides the possible account operations. Before an account operation can be called a bank, customer and account have to be selected
 * @author domwet
 */

@Stateful(name = "FinanceBean")
public class FinanceBean implements IFinanceBeanLocal {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Bank selectedBank;
	
	private Customer selectedCustomer;
	
	private AbstractAccount selectedAccount;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>FinanceBean</b></em>'.
	 */
	
	public FinanceBean() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * checks if the bank exists and if successful the method assigns it to the attribute "selectedBank". 
	 * If a problem occurs with the bank instance, it does not exist or there is a problem with the database the method throws a BankSelectionException
	 * @param	bank	
	 * @throws	BankSelectionException
	 */
	
	public void selectBank(Bank bank) throws BankSelectionException {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271098589734_78035_335) ENABLED START */
		// TODO: implementation of method 'FinanceBean.selectBank(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * checks if the customer exists and is really a customer of the previous selected bank. If the check is successful the method assigns the customer instance to the attribute "selectedCustomer".
	 * If a problem occurs with the customer instance, it does not exist, the customer is not a customer of the selected bank or there is a problem with the database the method throws a CustomerSelectionException
	 * @param	customer	
	 * @throws	CustomerSelectionException
	 */
	
	public void selectCustomer(Customer customer) throws CustomerSelectionException {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271098603859_239354_338) ENABLED START */
		// TODO: implementation of method 'FinanceBean.selectCustomer(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * checks if the account exists, the previous selected customer is the owner of this account and the account contains to the previous selected bank.
	 * If a problem occurs with the account instance, it does not exist, the account is not owned by the selected customer, the account does not contain to the selected bank or there is a problem with the database the method throws a AccountSelectionException
	 * @param	account	
	 * @throws	AccountSelectionException
	 */
	
	public void selectAccount(AbstractAccount account) throws AccountSelectionException {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271100052515_829366_713) ENABLED START */
		// TODO: implementation of method 'FinanceBean.selectAccount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * withdraws the amount from the selected account if possible
	 * If the withdraw is not possible the method throws a FinanceException
	 * @param	amount	
	 * @throws	FinanceException
	 */
	
	@Interceptors(value = {
		StatementInterceptor.class
	})
	public void withdraw(BigDecimal amount) throws FinanceException {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271099162031_166263_647) ENABLED START */
		// TODO: implementation of method 'FinanceBean.withdraw(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * deposits the amount to the selected account
	 * @param	amount	
	 */
	
	@Interceptors(value = {
		StatementInterceptor.class
	})
	public void deposit(BigDecimal amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271099191796_436869_651) ENABLED START */
		// TODO: implementation of method 'FinanceBean.deposit(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * withdraws the amount from the selected account and deposits it to the target account
	 * If the target account does not exist, the withdraw from the selected account fails or a database problem occurs the method throws a FinanceException
	 * @param	target	
	 * @param	amount	
	 * @throws	FinanceException
	 */
	
	@Interceptors(value = {
		StatementInterceptor.class
	})
	public void bankTransfer(AbstractAccount target, BigDecimal amount) throws FinanceException {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271099207406_509649_655) ENABLED START */
		// TODO: implementation of method 'FinanceBean.bankTransfer(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271101053859_90038_924) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
