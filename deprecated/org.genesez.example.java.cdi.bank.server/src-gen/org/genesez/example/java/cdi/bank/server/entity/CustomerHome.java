package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462905086_648269_462_CustomerHome) 
 */

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.enterprise.context.Conversation;
import org.genesez.example.java.cdi.bank.qualifier.BankDatabase;

/**
 */

@Named
@ConversationScoped
@Stateful(name = "CustomerHome")
public class CustomerHome extends HomeBean<Customer, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private AccountHome accountHome;
	
	@Inject
	private AddressHome addressHome;
	
	@Inject
	private BankHome bankHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Account> getAccountList() {
		/* PROTECTED REGION ID(java.implementation.CustomerHome.getAccountList) ENABLED START */
		if (getInstance() != null && getInstance().getAccounts() != null && getInstance().getAccounts().size() > 0)
			return new ArrayList<Account>(getInstance().getAccounts());
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Customer> getCustomerList() {
		/* PROTECTED REGION ID(java.implementation.Customer.getCustomerList) ENABLED START */
		// Alle Accounts auslesen
		List<Customer> customerList = getList();
		return customerList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public long getCustomerListCount() {
		/* PROTECTED REGION ID(java.implementation.Customer.getCustomerListCount) ENABLED START */
		return getCustomerList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.CustomerHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome.wire) ENABLED START */
		// Gibt es eine neue Bank?
		if (bankHome.getId() > 0) {
			Bank bank = bankHome.getInstance();
			getInstance().setBank(bank);
		}
		
		// Gibt es ein neues Konto?
		if (accountHome.getId() > 0) {
			Account account = accountHome.getInstance();
			getInstance().insertInAccounts(account);
		}
		
		// Gibt es eine neue Addresse?
		if (addressHome.getId() > 0) {
			Address address = addressHome.getInstance();
			getInstance().setAddress(address);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome.removeEjb) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
	
}
