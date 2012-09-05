package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462950358_713082_482_AddressHome) 
 */

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
@Stateful(name = "AddressHome")
public class AddressHome extends HomeBean<Address, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private BankgroupHome bankgroupHome;
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private CustomerHome customerHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Address> getAddressList() {
		/* PROTECTED REGION ID(java.implementation.Address.getAddressList) ENABLED START */
		// Alle Addressen auslesen
		List<Address> addressList = getList();
		return addressList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public long getAddressListCount() {
		/* PROTECTED REGION ID(java.implementation.Address.getAddressListCount) ENABLED START */
		return getAddressList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
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
		// Nothing to do
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome.removeEjb) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
	
}
