package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462981134_570566_486_BankgroupHome) 
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
@Stateful(name = "BankgroupHome")
public class BankgroupHome extends HomeBean<Bankgroup, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private AddressHome addressHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Bank> getBankList() {
		/* PROTECTED REGION ID(java.implementation.BankgroupHome.getBankList) ENABLED START */
		return getInstance() == null ? null : new ArrayList<Bank>(getInstance().getBanks());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public List<Bankgroup> getBankgroupList() {
		/* PROTECTED REGION ID(java.implementation.Bankgroup.getBankgroupList) ENABLED START */
		// Alle Bankgroups auslesen
		entityManager.flush();
		List<Bankgroup> bankgroupList = getList();
		return bankgroupList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public long getBankgroupListCount() {
		/* PROTECTED REGION ID(java.implementation.Bankgroup.getBankgroupListCount) ENABLED START */
		return getBankgroupList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
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
		// Gibt es eine Addresse?
		if (addressHome.getId() > 0) {
			Address address = addressHome.getInstance();
			getInstance().setAddress(address);
		}
		
		// Gibt es eine neue Bank?
		if (bankHome.getId() > 0) {
			Bank bank = bankHome.getInstance();
			getInstance().insertInBanks(bank);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome.removeEjb) ENABLED START */
		
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462981134_570566_486_BankgroupHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */
	
}
