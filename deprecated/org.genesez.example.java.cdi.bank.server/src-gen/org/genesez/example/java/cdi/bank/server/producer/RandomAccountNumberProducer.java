package org.genesez.example.java.cdi.bank.server.producer;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1284052911274_5891_850) 
 */

import java.util.Random;
import javax.enterprise.inject.Produces;
import org.genesez.example.java.cdi.bank.qualifier.RandomAccountNumber;

/**
 */

public class RandomAccountNumberProducer {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	@Produces
	@RandomAccountNumber
	public long getAccountNumber() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1284053176151_723319_875) ENABLED START */
		
		return random.nextInt(100000000);
		
		/* PROTECTED REGION END */
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052911274_5891_850) ENABLED START */
	
	private Random random = new Random(System.currentTimeMillis());
	
	/* PROTECTED REGION END */
	
}
