package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554216199_171079_3598) 
 */

/**
 * Manager class to manage internal naming contexts.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class InternalContextManager extends AbstractContextManager {
	
	/**
	 * Singleton of the internal naming context manager instance.
	 */
	private static InternalContextManager instance;
	
	/**
	 * Constructor of the internal naming context manager.
	 */
	private InternalContextManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324554684022_272693_3720) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Get the actual internal naming context.
	 * 
	 * @return	The actual internal naming context.
	 */
	public static String getContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554476534_12504_3683) ENABLED START */
		return getInstance().getNamingContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the new internal naming context.
	 * 
	 * @param	internalNamingContext	The new internal naming context.
	 */
	public static void setContext(String internalNamingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554523222_994240_3690) ENABLED START */
		getInstance().setNamingContext(internalNamingContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Revert to the previous internal naming context.
	 */
	public static void revertContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554608150_267705_3697) ENABLED START */
		getInstance().revertNamingContext();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the internal naming context manager instance.
	 * 
	 * @return The internal naming context manager instance.
	 */
	public static InternalContextManager getInstance() {
		if (instance == null) {
			instance = new InternalContextManager();
		}
		return instance;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554216199_171079_3598) ENABLED START */
	/* PROTECTED REGION END */
	
}
