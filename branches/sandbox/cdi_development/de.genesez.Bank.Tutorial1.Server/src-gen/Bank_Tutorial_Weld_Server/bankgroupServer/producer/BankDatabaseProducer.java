package Bank_Tutorial_Weld_Server.bankgroupServer.producer;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1284052807095_444093_816) ENABLED START */
/* TODO: put your own source code here */
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Bank_Tutorial_Weld_Server.qualifier.BankDatabase;

/* PROTECTED REGION END */

/**
 */

public class BankDatabaseProducer {
	
	// -- generated attribute, constant + association declarations ----------
	
	@PersistenceContext
	@Produces
	@BankDatabase
	public EntityManager userDatabase;
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1284052807095_444093_816) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
