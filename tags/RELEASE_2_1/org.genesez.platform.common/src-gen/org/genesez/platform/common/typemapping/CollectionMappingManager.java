package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324556915532_759601_4257) 
 */

import java.util.Map;

import org.genesez.platform.common.typemapping.types.Context;
import org.genesez.platform.common.typemapping.types.MultiValuedType;

import java.util.HashMap;

/**
 * Manager class to manage the MultiValued typeMappings
 * 
 * @author pethu
 * @date 2009-01-24
 */
public class CollectionMappingManager<T extends MultiValuedType> implements ITypeMappingManager<T> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public CollectionMappingManager() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324557421098_649321_4460) ENABLED START */
		typeMappings = new HashMap<String, T>();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * gets the MultiValued mapping out of the HashMap of the MappingManager
	 * @param	searchMappingString	composed of the two Booleans to identify a MultiValuedType
	 * @param	context	context of the MultiValuedType
	 * @return	 the Mapping of the type
	 */
	public String getTypeMapping(String searchMappingString, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557584458_775311_4474) ENABLED START */
		if (typeMappings.containsKey(searchMappingString)) {
			T specificType = typeMappings.get(searchMappingString);
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
	 * appends the Multivalued mappings of the typeMapping file to the HashMap of the MappingManager a multivalue mapping uses the "ordered: default: false" and the "unique: default: true" booleans as sourceMap the combination of the booleans are going to be the key
	 * @param	mappingContainer	a List of the MultiValuedTypes
	 */
	
	public void appendMappingMap(java.util.List<T> mappingContainer) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324557451739_196817_4465) ENABLED START */
		for (T element : mappingContainer) {
			Boolean ordered = element.getOrdered();
			Boolean unique = element.getUnique();
			typeMappings.put(unique.toString() + ordered.toString(), element);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324556915532_759601_4257) ENABLED START */
	/* PROTECTED REGION END */
	
}
