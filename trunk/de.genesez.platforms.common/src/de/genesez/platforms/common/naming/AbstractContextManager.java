package de.genesez.platforms.common.naming;

import java.util.EmptyStackException;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractContextManager implements ContextManager {
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Stores all contexts in a Stack
	 */
	protected Stack<String> contexts = new Stack<String>();
	
	/**
	 * 
	 */
	public AbstractContextManager() {
	}
	
	/**
	 * @return
	 */
	public String getActualContext() {
		try {
			return contexts.peek();
		} catch (EmptyStackException ese) {
			logger.error("Could not found any context in the context list!");
		}
		return null;
	}
	
	/**
	 * @param context
	 */
	public void setActualContext(String actualContext) {
		contexts.push(actualContext);
	}
	
	/**
	 * 
	 */
	public void revertActualContext() {
		try {
			contexts.pop();
		} catch (EmptyStackException ese) {
			logger.error("Could not revert context of an empty list!");
		}
	}
	
}
