package org.genesez.example.java.cdi.bank.server.interceptor;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267463002502_764366_490) 
 */

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.genesez.example.java.cdi.bank.qualifier.Logging;

/**
 */

@Interceptor
@Logging
public class LoggingInterceptor implements Serializable {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	ctx	
	 * @return	
	 * @throws	Exception
	 */
	
	@AroundInvoke
	public Object logMethodCalls(InvocationContext ctx) throws Exception {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271599261534_369930_728) ENABLED START */
		
		//		System.out.println("Invoking method: " + ctx.getMethod());
		//		try {
		//			return ctx.proceed();
		//		} finally {
		//			System.out.println("End method: " + ctx.getMethod());
		//		}
		
		return ctx.proceed();
		
		/* PROTECTED REGION END */
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267463002502_764366_490) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PROTECTED REGION END */
	
}
