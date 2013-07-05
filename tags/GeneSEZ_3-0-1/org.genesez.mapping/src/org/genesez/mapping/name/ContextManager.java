package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554133792_41635_3512) 
 */

/**
 * Interface for naming context managers to naming contexts.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public interface ContextManager {
	
	/**
	 * Get the actual naming context.
	 * 
	 * @return The actual naming context. 	
	 */
	public String getNamingContext();
	
	/**
	 * Set the new naming context.
	 * 
	 * @param	namingContext	The new naming context.  
	 */
	public void setNamingContext(String namingContext);
	
	/**
	 * Revert to the previous naming context.
	 */
	public void revertNamingContext();
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_1_8e00291_1324554133792_41635_3512) ENABLED START */
	/* PROTECTED REGION END */
}
