package Bank_Tutorial_Weld_Server.bankgroupServer.interceptor;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267463002502_764366_490) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import Bank_Tutorial_Weld_Server.qualifier.Logging;

/* PROTECTED REGION END */

/**
 */

@Interceptor
@Logging
public class LoggingInterceptor implements Serializable {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267463002502_764366_490) ENABLED START */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PROTECTED REGION END */

}
