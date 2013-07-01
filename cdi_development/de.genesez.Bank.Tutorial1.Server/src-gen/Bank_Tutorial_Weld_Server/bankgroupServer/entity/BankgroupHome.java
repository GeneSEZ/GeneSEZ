package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462981134_570566_486_BankgroupHome) 
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
@Stateful(name = "BankgroupHome")
public class BankgroupHome extends HomeBean<Bankgroup, EntityManager> {
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private AddressHome addressHome;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getBankList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome.getBankList) ENABLED START */
		// TODO: implementation of method 'BankgroupHome.getBankList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getBankgroupList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486.getBankgroupList) ENABLED START */
		// TODO: implementation of method 'BankgroupHome.getBankgroupList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getBankgroupListCount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486.getBankgroupListCount) ENABLED START */
		// TODO: implementation of method 'BankgroupHome.getBankgroupListCount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.BankgroupHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome.wire) ENABLED START */
		// TODO: implementation of method 'BankgroupHome.wire(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome.removeEjb) ENABLED START */
		// TODO: implementation of method 'BankgroupHome.removeEjb(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
}
