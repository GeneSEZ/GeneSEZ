package org.genesez.platform.common.naming;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554216199_171079_3598) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class NamingContextManager extends AbstractContextManager {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static NamingContextManager instance = new NamingContextManager();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for the Singleton
	 */
	private NamingContextManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324554684022_272693_3720) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Get the actual naming context.
	 * @return	The actual naming context
	 */
	public static String getContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554476534_12504_3683) ENABLED START */
		return getInstance().getActualContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the new naming context.
	 * @param	actualContext	The new naming context
	 */
	
	public static void setContext(String actualContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554523222_994240_3690) ENABLED START */
		getInstance().setActualContext(actualContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Revert the to the previous naming context.
	 */
	
	public static void revertContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554608150_267705_3697) ENABLED START */
		getInstance().revertActualContext();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>instance</b></em>'
	 */
	public static NamingContextManager getInstance() {
		return instance;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554216199_171079_3598) ENABLED START */
	/* PROTECTED REGION END */
	
}
