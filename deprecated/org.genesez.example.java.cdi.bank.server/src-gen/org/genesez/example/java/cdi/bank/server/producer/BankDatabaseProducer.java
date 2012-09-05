package org.genesez.example.java.cdi.bank.server.producer;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1284052807095_444093_816) 
 */

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.enterprise.inject.Produces;
import org.genesez.example.java.cdi.bank.qualifier.BankDatabase;

/**
 */

public class BankDatabaseProducer {
	
	// -- generated attribute, constant + association declarations ----------
	
	@PersistenceContext
	@Produces
	@BankDatabase
	public EntityManager userDatabase;
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052807095_444093_816) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
