package org.genesez.platform.common.naming;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554022530_872105_3376) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class TypeMappingContextManager extends AbstractContextManager {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Singleton type maping context manager instance.
	 */
	private static TypeMappingContextManager instance = new TypeMappingContextManager();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for the Singleton
	 */
	private TypeMappingContextManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324555652557_327631_3957) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Get the actual type mapping context.
	 * @return	The actual type mapping context
	 */
	public static String getContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555491460_805001_3927) ENABLED START */
		return getInstance().getActualContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the new type mapping context.
	 * @param	actualContext	The new type mapping context
	 */
	
	public static void setContext(String actualContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555472342_922675_3920) ENABLED START */
		getInstance().setActualContext(actualContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Revert the to the previous type mapping context.
	 */
	
	public static void revertContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555501366_930635_3935) ENABLED START */
		getInstance().revertActualContext();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Singleton type maping context manager instance.
	 */
	public static TypeMappingContextManager getInstance() {
		return instance;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554022530_872105_3376) ENABLED START */
	/* PROTECTED REGION END */
	
}
