package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324557275028_919886_4410) 
 */

import java.util.Map;

import java.util.HashMap;

import org.genesez.mapping.type.types.Context;
import org.genesez.mapping.type.types.SingleValuedType;

/**
 * Manager class to manage single-valued type mappings.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public class TypeMappingManager<T extends SingleValuedType> implements ITypeMappingManager<T> {
	
	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings;
	
	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public TypeMappingManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324557809418_393451_4513) ENABLED START */
		typeMappings = new HashMap<String, T>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the mapping of the specified single-valued type by means of the specified context.
	 * If no mapping for the specified context exists in the type mapping map then the default mapping will be returned.
	 * Otherwise if no mapping exists the specified parameter will be returned.
	 * 
	 * @param	mappingType	The mapping type which shall be mapped.
	 * @param	context		The name of the context in which the single-valued type shall be mapped.
	 * @return	The mapped single-valued type.
	 */
	public String getTypeMapping(String mappingType, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557862963_36790_4527) ENABLED START */
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
			} else {
				return specificType.getSourceMapping();
			}
		}
		return mappingType;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Appends the type mappings specified by the parameter {@code typeMappingContainer} to the type mapping map of the type mapping manager.
	 * The source information {@code from} of the XML type mapping file will be used as key of the type mapping map.
	 * 
	 * @param	typeMappingContainer	List of possible new type mappings.
	 */
	public void appendTypeMappingMap(java.util.List<T> typeMappingContainer) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557833690_783743_4518) ENABLED START */
		for (T element : typeMappingContainer) {
			if (!typeMappings.containsKey(element.getSourceMapping())) {
				typeMappings.put(element.getSourceMapping(), element);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324557275028_919886_4410) ENABLED START */
	/* PROTECTED REGION END */
	
}
