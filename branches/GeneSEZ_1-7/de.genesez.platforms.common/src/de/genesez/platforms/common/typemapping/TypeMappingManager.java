/**
 * 
 */
package de.genesez.platforms.common.typemapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.genesez.platforms.common.typemapping.types.Context;
import de.genesez.platforms.common.typemapping.types.SingleValuedType;

/**
 * @author pethu
 * @date 2009-01-24
 */
public class TypeMappingManager<T extends SingleValuedType> implements ITypeMappingManager<T> {

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
	 * gets the Mapping to the specified SingleValuedType (within its context)
	 * if possible
	 * 
	 * @param map
	 *            the requested mapping
	 * @param context
	 *            context of the mapping
	 * @return the mapping of the type
	 */
	public String getTypeMapping(String searchMappingType, String context) {
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
	}

	/**
	 * appends the SingleValued mappings of the typeMapping file to the Hashmap
	 * of the MappingManager the sourceMapping of the Type is going to be the
	 * key of itself
	 * 
	 * @param mappingList
	 *            a List of the SingleValuedTypes
	 */
	public void appendMappingMap(List<T> mappingContainer) {
		// TODO append unbound contextes
		for (T element : mappingContainer) {
			if (!typeMappings.containsKey(element.getSourceMapping())) {
				typeMappings.put(element.getSourceMapping(), element);
			}
		}
	}
}
