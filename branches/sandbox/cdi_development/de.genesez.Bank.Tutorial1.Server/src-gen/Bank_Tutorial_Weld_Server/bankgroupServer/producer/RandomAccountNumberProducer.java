package Bank_Tutorial_Weld_Server.bankgroupServer.producer;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1284052911274_5891_850) ENABLED START */
/* TODO: put your own source code here */
import java.util.Random;
import javax.enterprise.inject.Produces;
import Bank_Tutorial_Weld_Server.qualifier.RandomAccountNumber;

/* PROTECTED REGION END */

/**
 */

public class RandomAccountNumberProducer {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	@Produces
	@RandomAccountNumber
	public long getAccountNumber() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1284053176151_723319_875) ENABLED START */

		return random.nextInt(100000000);
		
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052911274_5891_850) ENABLED START */

	private Random random = new Random(System.currentTimeMillis());
	
	/* PROTECTED REGION END */

}
