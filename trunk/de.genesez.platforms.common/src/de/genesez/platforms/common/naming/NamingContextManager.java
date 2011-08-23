package de.genesez.platforms.common.naming;

public class NamingContextManager extends AbstractContextManager {
	
	/**
	 * Singleton naming context manager instance.
	 */
	private static NamingContextManager namingContextManager = null;
	
	/**
	 * Get the actual naming context.
	 * 
	 * @return The actual naming context
	 */
	public static String getContext() {
		return getInstance().getActualContext();
	}
	
	/**
	 * Set the new naming context.
	 * 
	 * @param actualContext The new naming context
	 */
	public static void setContext(String actualContext) {
		getInstance().setActualContext(actualContext);
	}
	
	/**
	 * Revert the to the previous naming context.
	 */
	public static void revertContext() {
		getInstance().revertActualContext();
	}
	
	/**
	 * Sole method to get the naming context manager.
	 * 
	 * @return singleton naming context manager instance
	 */
	public static NamingContextManager getInstance() {
		if (namingContextManager == null) {
			namingContextManager = new NamingContextManager();
		}
		return namingContextManager;
	}
}
