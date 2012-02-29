package de.genesez.example.java.BankTutorial.Server.businessLogic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271099412921_623828_661) 
 */

import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The statement interceptor is responsible for logging every access to an account
 * @author domwet
 */

public class StatementInterceptor {
	
	// -- generated attribute, constant + association declarations ----------
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	ctx	
	 * @return	
	 * @throws	Exception
	 */
	
	public Object onAccountChange(InvocationContext ctx) throws Exception {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271099421812_119306_683) ENABLED START */
		// TODO: implementation of method 'StatementInterceptor.onAccountChange(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271099412921_623828_661) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
