package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (FinanceBeanLocal) 
 */

import java.math.BigDecimal;
import javax.interceptor.Interceptors;
import de.genesez.example.java.BankTutorial.Server.data.Account;
import de.genesez.example.java.BankTutorial.Server.data.Bank;
import de.genesez.example.java.BankTutorial.Server.data.Customer;
import javax.ejb.Local;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */

@Local
public interface IFinanceBeanLocal {
	
	/**
	 * checks if the bank exists and if successful the method assigns it to the attribute "selectedBank". 
	 * If a problem occurs with the bank instance, it does not exist or there is a problem with the database the method throws a BankSelectionException
	 * @param	bank	
	 * @throws	BankSelectionException
	 */
	
	public void selectBank(Bank bank) throws BankSelectionException;
	
	/**
	 * checks if the customer exists and is really a customer of the previous selected bank. If the check is successful the method assigns the customer instance to the attribute "selectedCustomer".
	 * If a problem occurs with the customer instance, it does not exist, the customer is not a customer of the selected bank or there is a problem with the database the method throws a CustomerSelectionException
	 * @param	customer	
	 * @throws	CustomerSelectionException
	 */
	
	public void selectCustomer(Customer customer) throws CustomerSelectionException;
	
	/**
	 * checks if the account exists, the previous selected customer is the owner of this account and the account contains to the previous selected bank.
	 * If a problem occurs with the account instance, it does not exist, the account is not owned by the selected customer, the account does not contain to the selected bank or there is a problem with the database the method throws a AccountSelectionException
	 * @param	account	
	 * @throws	AccountSelectionException
	 */
	
	public void selectAccount(Account account) throws AccountSelectionException;
	
	/**
	 * withdraws the amount from the selected account if possible
	 * If the withdraw is not possible the method throws a FinanceException
	 * @param	amount	
	 * @throws	FinanceException
	 */
	
	public void withdraw(BigDecimal amount) throws FinanceException;
	
	/**
	 * deposits the amount to the selected account
	 * @param	amount	
	 */
	
	public void deposit(BigDecimal amount);
	
	/**
	 * withdraws the amount from the selected account and deposits it to the target account
	 * If the target account does not exist, the withdraw from the selected account fails or a database problem occurs the method throws a FinanceException
	 * @param	target	
	 * @param	amount	
	 * @throws	FinanceException
	 */
	
	public void bankTransfer(Account target, BigDecimal amount) throws FinanceException;
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration.FinanceBeanLocal) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
