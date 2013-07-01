package Bank_Tutorial_Weld_Server.bankgroupServer.producer;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1284052911274_5891_850) 
 */

import javax.enterprise.inject.Produces;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class RandomAccountNumberProducer {
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Produces
	@RandomAccountNumber
	public long getAccountNumber() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1284053176151_723319_875) ENABLED START */
		
		return random.nextInt(100000000);
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052911274_5891_850) ENABLED START */
	
	private Random random = new Random(System.currentTimeMillis());
	
	/* PROTECTED REGION END */
}
