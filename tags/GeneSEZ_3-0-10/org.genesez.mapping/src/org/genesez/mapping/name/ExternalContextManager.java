package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554022530_872105_3376) 
 */

/**
 * Manager class to manage external naming contexts.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class ExternalContextManager extends AbstractContextManager {
	
	/**
	 * Singleton of the external naming context manager instance.
	 */
	private static ExternalContextManager instance;
	
	/**
	 * Constructor of the external naming context manager.
	 */
	private ExternalContextManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324555652557_327631_3957) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Get the actual external naming context.
	 * 
	 * @return	The actual external naming context.
	 */
	public static String getContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555491460_805001_3927) ENABLED START */
		return getInstance().getNamingContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the new external naming context.
	 * 
	 * @param	externalNamingContext	The new external naming context.
	 */
	public static void setContext(String externalNamingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555472342_922675_3920) ENABLED START */
		getInstance().setNamingContext(externalNamingContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Revert to the previous external naming context.
	 */
	public static void revertContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555501366_930635_3935) ENABLED START */
		getInstance().revertNamingContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the external naming context manager instance.
	 * 
	 * @return The external naming context manager instance.
	 */
	public static ExternalContextManager getInstance() {
		if (instance == null) {
			instance = new ExternalContextManager();
		}
		return instance;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554022530_872105_3376) ENABLED START */
	/* PROTECTED REGION END */
	
}
