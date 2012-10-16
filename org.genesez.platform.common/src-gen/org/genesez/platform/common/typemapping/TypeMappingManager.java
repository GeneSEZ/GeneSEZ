package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324557275028_919886_4410) 
 */

import java.util.Map;

import org.genesez.platform.common.typemapping.types.Context;
import org.genesez.platform.common.typemapping.types.SingleValuedType;

import java.util.HashMap;

/**
 * @author pethu
 * @date 2009-01-24
 * @deprecated
 */
public class TypeMappingManager<T extends SingleValuedType> implements ITypeMappingManager<T> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public TypeMappingManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324557809418_393451_4513) ENABLED START */
		typeMappings = new HashMap<String, T>();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * gets the Mapping to the specified SingleValuedType (within its context) if possible
	 * @param	searchMappingType	the requested mapping
	 * @param	context	context of the mapping
	 * @return	the mapping of the type
	 */
	public String getTypeMapping(String searchMappingType, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557862963_36790_4527) ENABLED START */
		if (typeMappings.containsKey(searchMappingType)) {
			T specificType = typeMappings.get(searchMappingType);
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
		return searchMappingType;
		/* PROTECTED REGION END */
	}
	
	/**
	 * appends the SingleValued mappings of the typeMapping file to the Hashmap of the MappingManager the sourceMapping of the Type is going to be the key of itself
	 * @param	mappingContainer	a List of the SingleValuedTypes
	 */
	
	public void appendMappingMap(java.util.List<T> mappingContainer) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557833690_783743_4518) ENABLED START */
		// TODO append unbound contextes
		for (T element : mappingContainer) {
			if (!typeMappings.containsKey(element.getSourceMapping())) {
				typeMappings.put(element.getSourceMapping(), element);
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324557275028_919886_4410) ENABLED START */
	/* PROTECTED REGION END */
	
}
