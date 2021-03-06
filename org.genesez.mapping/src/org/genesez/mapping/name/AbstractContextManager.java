package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554108463_378041_3483) 
 */

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Manager class to manage naming contexts.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public abstract class AbstractContextManager implements ContextManager {
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Stores all contexts in a Stack.
	 */
	protected Stack<String> contexts = new Stack<String>();
	
	/**
	 * Get the actual naming context.
	 * 
	 * @return The actual naming context. 	
	 */
	public String getNamingContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555296672_317894_3847) ENABLED START */
		try {
			return contexts.peek();
		} catch (EmptyStackException ese) {
			logger.error("Could not found any context in the context stack!");
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the new naming context.
	 * 
	 * @param	namingContext	The new naming context.  
	 */
	public void setNamingContext(String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555316591_776061_3862) ENABLED START */
		contexts.push(namingContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Revert to the previous naming context.
	 */
	public void revertNamingContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555329991_424007_3868) ENABLED START */
		try {
			contexts.pop();
		} catch (EmptyStackException ese) {
			logger.error("Could not revert context of an empty stack!");
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554108463_378041_3483) ENABLED START */
	/* PROTECTED REGION END */
	
}
