package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462950358_713082_482_AddressHome) 
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
@Stateful(name = "AddressHome")
public class AddressHome extends HomeBean<Address, EntityManager> {
	
	@Inject
	private BankgroupHome bankgroupHome;
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private CustomerHome customerHome;
	
	/**
	 * Method stub for further implementation.
	 */
	
	public List getAddressList() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462950358_713082_482.getAddressList) ENABLED START */
		// TODO: implementation of method 'AddressHome.getAddressList(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getAddressListCount() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462950358_713082_482.getAddressListCount) ENABLED START */
		// TODO: implementation of method 'AddressHome.getAddressListCount(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome.wire) ENABLED START */
		// TODO: implementation of method 'AddressHome.wire(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome.removeEjb) ENABLED START */
		// TODO: implementation of method 'AddressHome.removeEjb(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
}
