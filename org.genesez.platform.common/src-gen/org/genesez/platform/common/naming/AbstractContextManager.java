package org.genesez.platform.common.naming;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554108463_378041_3483) 
 */

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Stack;
import java.util.EmptyStackException;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractContextManager implements ContextManager {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Stores all contexts in a Stack
	 */
	protected Stack<String> contexts = new Stack<String>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public String getActualContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555296672_317894_3847) ENABLED START */
		try {
			return contexts.peek();
		} catch (EmptyStackException ese) {
			logger.error("Could not found any context in the context list!");
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	actualContext	
	 */
	
	public void setActualContext(String actualContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555316591_776061_3862) ENABLED START */
		contexts.push(actualContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void revertActualContext() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324555329991_424007_3868) ENABLED START */
		try {
			contexts.pop();
		} catch (EmptyStackException ese) {
			logger.error("Could not revert context of an empty list!");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554108463_378041_3483) ENABLED START */
	/* PROTECTED REGION END */
	
}
