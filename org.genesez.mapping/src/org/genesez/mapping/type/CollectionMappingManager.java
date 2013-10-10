package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324556915532_759601_4257) 
 */

import java.util.Map;


import java.util.HashMap;

import org.genesez.mapping.type.types.Context;
import org.genesez.mapping.type.types.MultiValuedType;

/**
 * Manager class to manage multi-valued type mappings.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public class CollectionMappingManager<T extends MultiValuedType> implements ITypeMappingManager<T> {
	
	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings;
	
	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public CollectionMappingManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324557421098_649321_4460) ENABLED START */
		typeMappings = new HashMap<String, T>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns true if a mapping for the specified type in the specified context exists, otherwise false.
	 * @see org.genesez.mapping.type.ITypeMappingManager#hasTypeMapping(java.lang.String, java.lang.String)
	 */
	public boolean hasTypeMapping(String mappingType, String context) {
		if (context == null) {
			return typeMappings.containsKey(mappingType);
		}
		if (typeMappings.containsKey(mappingType)) {
			T specificType = typeMappings.get(mappingType);
			for (Context c : specificType.getContextMap()) {
				if (c.getKey().equalsIgnoreCase(context)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns the mapping of the specified multi-valued type by means of the specified context.
	 * If no mapping for the specified context exists in the type mapping map then the default mapping will be returned.
	 * Otherwise if no mapping exists the specified parameter will be returned.
	 * 
	 * @param	mappingType	The mapping type which shall be mapped.
	 * @param	context		The name of the context in which the multi-valued type shall be mapped.
	 * @return	The mapped multi-valued type.
	 */
	public String getTypeMapping(String mappingType, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557584458_775311_4474) ENABLED START */
		if (typeMappings.containsKey(mappingType)) {
			T specificType = typeMappings.get(mappingType);
			if (context != null) {
				for (Context c : specificType.getContextMap()) {
					if (c.getKey().equalsIgnoreCase(context)) {
						return c.getValue();
					}
				}
			}
			if (specificType.isSetDestinationMapping()) {
				return specificType.getDestinationMapping();
			}
		}
		return "";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Appends the type mappings specified by the parameter {@code typeMappingContainer} to the type mapping map of the type mapping manager.
	 * The source information {@code unique} and {@code ordered} of the XML type mapping file will be used as key of the type mapping map.
	 * 
	 * @param	typeMappingContainer	List of possible new type mappings.
	 */
	public void appendTypeMappingMap(java.util.List<T> typeMappingContainer) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557451739_196817_4465) ENABLED START */
		for (T element : typeMappingContainer) {
			Boolean ordered = element.getOrdered();
			Boolean unique = element.getUnique();
			typeMappings.put(String.valueOf(unique) + String.valueOf(ordered), element);
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324556915532_759601_4257) ENABLED START */
	/* PROTECTED REGION END */
	
}
