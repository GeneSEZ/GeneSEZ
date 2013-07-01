package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462918311_582104_470_BankHome) 
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
@Stateful(name = "BankHome")
public class BankHome extends HomeBean<Bank, EntityManager> {
	
	@Inject
	private BankgroupHome bankgroupHome;
	
	@Inject
	private AccountHome accountHome;
	
	@Inject
	private AddressHome addressHome;
	
	@Inject
	private CustomerHome customerHome;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getAccountList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome.getAccountList) ENABLED START */
		// TODO: implementation of method 'BankHome.getAccountList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getCustomerList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome.getCustomerList) ENABLED START */
		// TODO: implementation of method 'BankHome.getCustomerList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getBankList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470.getBankList) ENABLED START */
		// TODO: implementation of method 'BankHome.getBankList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getBankListCount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470.getBankListCount) ENABLED START */
		// TODO: implementation of method 'BankHome.getBankListCount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome.wire) ENABLED START */
		// TODO: implementation of method 'BankHome.wire(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome.removeEjb) ENABLED START */
		// TODO: implementation of method 'BankHome.removeEjb(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	/*
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/* PROTECTED REGION END */
}
