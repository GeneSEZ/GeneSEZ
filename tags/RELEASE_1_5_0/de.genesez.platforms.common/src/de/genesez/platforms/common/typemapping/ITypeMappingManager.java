package de.genesez.platforms.common.typemapping;

/**
 * This interface define some methods that allows to manage and store all
 * mappings from a specified mapping type, e.g. primitiveTypes, externalTypes
 * and so on.
 * 
 * @author nihe
 * @param <T> the specific mapping type
 * @date 2008-02-18
 */
public interface ITypeMappingManager<T> {
	
	/**
	 * This method is used to return the language specific type, if any entry
	 * exists.
	 * 
	 * @param searchMappingType the specific mapping type
	 * @return
	 */
	public String getTypeMapping(T searchMappingType);
	
	/**
	 * This method is used to return the language specific type by means of the
	 * context, if any entry exists.
	 * 
	 * @param searchMappingType the specific mapping type
	 * @param context the implementation context
	 * @return
	 */
	public String getTypeMapping(T searchMappingType, String context);
	
	/**
	 * This method is used to add a specific mapping type to the type mapping
	 * map.
	 * 
	 * @param mappingType the specific mapping type
	 */
	public void addMappingType(T mappingType);
	
	/**
	 * This method is used to add a specific mapping type based on a context to
	 * the type mapping map.
	 * 
	 * @param searchMappingType the specific mapping type
	 * @param context the implementation context
	 * @param contextType the language specific type
	 */
	public void addContextTypeToMappingType(T searchMappingType, String context, String contextType);
	
}
