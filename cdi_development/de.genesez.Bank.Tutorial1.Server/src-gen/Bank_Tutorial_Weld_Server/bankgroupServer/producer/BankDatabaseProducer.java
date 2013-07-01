package Bank_Tutorial_Weld_Server.bankgroupServer.producer;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1284052807095_444093_816) 
 */

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import javax.enterprise.inject.Produces;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class BankDatabaseProducer {
	
	@PersistenceContext
	@Produces
	@BankDatabase
	public EntityManager userDatabase;
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052807095_444093_816) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
