package de.genesez.platforms.common.naming;

public class TypeMappingContextManager extends AbstractContextManager {
	
	/**
	 * Singleton naming context manager instance.
	 */
	private static TypeMappingContextManager typeMappingContextManager = null;
	
	/**
	 * Get the actual type mapping context.
	 * 
	 * @return The actual type mapping context
	 */
	public static String getContext() {
		return getInstance().getActualContext();
	}
	
	/**
	 * Set the new type mapping context.
	 * 
	 * @param actualContext The new type mapping context
	 */
	public static void setContext(String actualContext) {
		getInstance().setActualContext(actualContext);
	}
	
	/**
	 * Revert the to the previous type mapping context.
	 */
	public static void revertContext() {
		getInstance().revertActualContext();
	}
	
	/**
	 * Sole method to get the type mapping context manager.
	 * 
	 * @return singleton type mapping context manager instance
	 */
	public static TypeMappingContextManager getInstance() {
		if (typeMappingContextManager == null) {
			typeMappingContextManager = new TypeMappingContextManager();
		}
		return typeMappingContextManager;
	}
}
