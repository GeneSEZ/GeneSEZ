package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462924637_558573_474_AccountHome) 
 */

import javax.inject.Named;

import javax.inject.Inject;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;

import javax.ejb.Stateful;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named
@ConversationScoped
@Stateful(name = "AccountHome")
public class AccountHome extends HomeBean<Account, EntityManager> {
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private CustomerHome customerHome;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getCustomerList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474_AccountHome.getCustomerList) ENABLED START */
		// TODO: implementation of method 'AccountHome.getCustomerList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getAccountList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474.getAccountList) ENABLED START */
		// TODO: implementation of method 'AccountHome.getAccountList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getAccountListCount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474.getAccountListCount) ENABLED START */
		// TODO: implementation of method 'AccountHome.getAccountListCount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
		// TODO: implementation of method 'AccountHome.wire(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474_AccountHome.removeEjb) ENABLED START */
		// TODO: implementation of method 'AccountHome.removeEjb(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
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
