package de.genesez.platforms.common.typemapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.genesez.platforms.common.typemapping.types.Context;
import de.genesez.platforms.common.typemapping.types.MultiValuedType;

/**
 * Manager class to manage the MultiValued typeMappings
 * 
 * @author pethu
 * @date 2009-01-24
 */
public class CollectionMappingManager<T extends MultiValuedType> implements
		ITypeMappingManager<T> {

	/**
	 * This type mapping map stores all type mappings.
	 */
	private Map<String, T> typeMappings = null;

	/**
	 * Sole constructor which initializes the type mapping map.
	 */
	public CollectionMappingManager() {
		typeMappings = new HashMap<String, T>();
	}

	/**
	 * appends the Multivalued mappings of the typeMapping file to the HashMap
	 * of the MappingManager a multivalue mapping uses the "ordered: default:
	 * false" and the "unique: default: true" booleans as sourceMap the
	 * combination of the booleans are going to be the key
	 * 
	 * @param mappingList
	 *            a List of the MultiValuedTypes
	 */
	public void appendMappingMap(List<T> mappingContainer) {
		for (T element : mappingContainer) {
			Boolean ordered = element.isOrdered();
			Boolean unique = element.isUnique();
			typeMappings.put(unique.toString() + ordered.toString(), element);
		}

	}

	/**
	 * gets the MultiValued mapping out of the HashMap of the MappingManager
	 * 
	 * @param searchMappingString
	 *            composed of the two Booleans to identify a MultiValuedType
	 * @param context
	 *            context of the MultiValuedType
	 * @return the Mapping of the type
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
			}
		}
		return "";
	}
}
