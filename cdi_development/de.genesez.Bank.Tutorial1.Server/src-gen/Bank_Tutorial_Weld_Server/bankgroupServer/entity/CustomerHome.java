package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462905086_648269_462_CustomerHome) 
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
@Stateful(name = "CustomerHome")
public class CustomerHome extends HomeBean<Customer, EntityManager> {
	
	@Inject
	private AccountHome accountHome;
	
	@Inject
	private AddressHome addressHome;
	
	@Inject
	private BankHome bankHome;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getAccountList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome.getAccountList) ENABLED START */
		// TODO: implementation of method 'CustomerHome.getAccountList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getCustomerList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462.getCustomerList) ENABLED START */
		// TODO: implementation of method 'CustomerHome.getCustomerList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getCustomerListCount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462.getCustomerListCount) ENABLED START */
		// TODO: implementation of method 'CustomerHome.getCustomerListCount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
		// TODO: implementation of method 'CustomerHome.wire(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome.removeEjb) ENABLED START */
		// TODO: implementation of method 'CustomerHome.removeEjb(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462905086_648269_462_CustomerHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
}
