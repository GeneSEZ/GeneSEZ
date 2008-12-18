package de.genesez.platforms.common.typemapping;

import java.util.HashMap;
import java.util.Map;

import de.genesez.platforms.common.typemapping.mappingtypes.MappingType;

/**
 * This class implements the ITypeMappingManager interface to manage and store
 * all mappings from a specified mapping type, e.g. primitiveTypes,
 * externalTypes and so on.
 * 
 * @author nihe
 * @param <T> the specific mapping type
 * @date 2008-02-18
 */
public class TypeMappingManager<T extends MappingType> implements ITypeMappingManager<T> {
	
	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings = null;
	
	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public TypeMappingManager() {
		typeMappings = new HashMap<String, T>();
	}
	
	/**
	 * This method is used to return the language specific type, if any entry
	 * exists.
	 * 
	 * @see de.genesez.platforms.common.typemapping.ITypeMappingManager#getTypeMapping(java.lang.Object)
	 */
	public String getTypeMapping(T searchMappingType) {
		String returnValue = null;
		T mappingType = null;
		
		mappingType = typeMappings.get(searchMappingType.getKey());
		if (mappingType != null) {
			returnValue = mappingType.getDefaultType();
		}
		return returnValue;
	}
	
	/**
	 * This method is used to return the language specific type by means of the
	 * context, if any entry exists.
	 * 
	 * @see de.genesez.platforms.common.typemapping.ITypeMappingManager#getTypeMapping(java.lang.Object,
	 *      java.lang.String)
	 */
	public String getTypeMapping(T searchMappingType, String context) {
		String returnValue = null;
		T mappingType = null;
		
		mappingType = typeMappings.get(searchMappingType.getKey());
		if (mappingType != null) {
			if (mappingType.hasContextType(context))
				returnValue = mappingType.getContextType(context);
			else
				returnValue = mappingType.getDefaultType();
		}
		return returnValue;
	}
	
	/**
	 * This method is used to add a specific mapping type to the type mapping
	 * map.
	 * 
	 * @see de.genesez.platforms.common.typemapping.ITypeMappingManager#addMappingType(java.lang.Object)
	 */
	public void addMappingType(T mappingType) {
		if (!typeMappings.containsKey(mappingType.getKey()))
			typeMappings.put(mappingType.getKey(), mappingType);
	}
	
	/**
	 * This method is used to add a specific mapping type based on a context to
	 * the type mapping map.
	 * 
	 * @see de.genesez.platforms.common.typemapping.ITypeMappingManager#addContextTypeToMappingType(java.lang.Object,
	 *      java.lang.String, java.lang.String)
	 */
	public void addContextTypeToMappingType(T searchMappingType, String context, String contextType) {
		T mappingType = null;
		
		mappingType = typeMappings.get(searchMappingType.getKey());
		if (mappingType != null) {
			if (!mappingType.hasContextType(context))
				mappingType.addContextType(context, contextType);
		}
	}
	
}
