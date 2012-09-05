package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462924637_558573_474_AccountHome) 
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
import org.genesez.example.java.cdi.bank.qualifier.RandomAccountNumber;

/**
 */

@Named
@ConversationScoped
@Stateful(name = "AccountHome")
public class AccountHome extends HomeBean<Account, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private CustomerHome customerHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Customer> getCustomerList() {
		/* PROTECTED REGION ID(java.implementation.AccountHome.getCustomerList) ENABLED START */
		if (getInstance() != null && getInstance().getCustomers() != null && getInstance().getCustomers().size() > 0)
			return (new ArrayList<Customer>(getInstance().getCustomers()));
		else
			return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Account> getAccountList() {
		/* PROTECTED REGION ID(java.implementation.Account.getAccountList) ENABLED START */
		// Alle Accounts auslesen
		List<Account> accountList = getList();
		return accountList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public long getAccountListCount() {
		/* PROTECTED REGION ID(java.implementation.Account.getAccountListCount) ENABLED START */
		return getAccountList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.AccountHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474_AccountHome.wire) ENABLED START */
		// Wurde schon eine Bank Id zugeordnet?
		if (bankHome.getId() > 0) {
			Bank bank = bankHome.getInstance();
			getInstance().setBank(bank);
		}
		
		// Gibt es einen neuen Kunden?
		if (customerHome.getId() > 0) {
			Customer customer = customerHome.getInstance();
			getInstance().insertInCustomers(customer);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474_AccountHome.removeEjb) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462924637_558573_474_AccountHome) ENABLED START */
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	
	@Inject
	@RandomAccountNumber
	private long accountNumber;
	
	/* (non-Javadoc)
	 * @see Bank_Tutorial_Weld_Server.bankgroupServer.entity.HomeBean#save()
	 */
	@Override
	public String save() {
		// Wenn wir das erste mal speichern, dann setzen wir die Account Id
		if (getInstance().getId() == 0)
			getInstance().setAccountNumber(accountNumber);
		
		return super.save();
	}
	/* PROTECTED REGION END */
	
}
