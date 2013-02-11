package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324556963941_767545_4318) 
 */

/**
 * Interface for type mapping managers to handle type mappings.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public interface ITypeMappingManager<T> {
	
	/**
	 * Returns the mapping of the specified type by means of the specified context.
	 * If no mapping for the specified context exists in the type mapping map then the default mapping will be returned.
	 * Otherwise if no mapping exists the specified parameter will be returned.
	 * 
	 * @param	mappingType	The mapping type which shall be mapped.
	 * @param	context		The name of the context in which the type shall be mapped.
	 * @return	The mapped type.
	 */
	public String getTypeMapping(String mappingType, String context);
	
	/**
	 * Returns true if a mapping for the specified type in the specified context exists, otherwise false.
	 * @param mappingType	The type to map.
	 * @param context		The context in which the type should be mapped.
	 * @return	True if a type mapping exists, otherwise false.
	 */
	public boolean hasTypeMapping(String mappingType, String context);
	
	/**
	 * Appends the type mappings specified by the parameter {@code typeMappingContainer} to the type mapping map of the type mapping manager.
	 * 
	 * @param	typeMappingContainer	List of possible new type mappings.
	 */
	public void appendTypeMappingMap(java.util.List<T> typeMappingContainer);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_1_8e00291_1324556963941_767545_4318) ENABLED START */
	/* PROTECTED REGION END */
}
