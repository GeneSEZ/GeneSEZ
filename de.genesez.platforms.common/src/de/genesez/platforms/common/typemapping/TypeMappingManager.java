package de.genesez.platforms.common.typemapping;

import java.util.HashMap;
import java.util.Map;

import de.genesez.platforms.common.typemapping.mappingtypes.MappingType;

public class TypeMappingManager<T extends MappingType> implements ITypeMappingManager<T> {

	private Map<String, T> typeMappings = null;
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public TypeMappingManager() {
		typeMappings = new HashMap<String, T>();
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * accessor methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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
		
	public void addMappingType(T mappingType) {
		if (!typeMappings.containsKey(mappingType.getKey()))
			typeMappings.put(mappingType.getKey(), mappingType);
	}
		
	public void addContextTypeToMappingType(T searchMappingType, String context, String contextType) {
		T mappingType = null;
		
		mappingType = typeMappings.get(searchMappingType.getKey());
		if (mappingType != null) {
			if (!mappingType.hasContextType(context))
				mappingType.addContextType(context, contextType);
		}
	}

}
