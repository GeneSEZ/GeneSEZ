/**
 * 
 */
package de.genesez.platforms.common.typemapping;

import de.genesez.metamodel.gcore.MType;

/**
 * This class is the interface between the java implementation, which parses the
 * type mapping file, and the Xtend scripts. Use the methods from this class to
 * convert model defined types in language specific types.
 * 
 * @author nihe
 * @author pethu
 * @date 2008-01-24
 */
public class TypeMapping {
	
	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value for this type.
	 * 
	 * @param type
	 *            the type which shall be transformed
	 * @return the transformed or standard type as String representation
	 */
	public static String mappingName(MType type) {
		return getTypeMapper().getMappingName(type);
	}

	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value for this type.
	 * 
	 * @param type
	 *            the type which shall be transformed
	 * @param contextType
	 *            the implementation context
	 * @return the transformed or standard type as String representation
	 */
	public static String mappingName(MType type, String contextType) {
		return getTypeMapper().getMappingName(type, contextType);
	}

	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value. This method is used for collections.
	 * 
	 * @param unique
	 *            true if the collection shall be unique otherwise false
	 * @param ordered
	 *            true if the collection shall be ordered otherwise false
	 * @return the transformed or standard type as String representation
	 */
	public static String mappingType(Boolean unique, Boolean ordered) {
		return getTypeMapper().getMappingType(unique, ordered);
	}

	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value. This method is used for collections.
	 * 
	 * @param unique
	 *            true if the collection shall be unique otherwise false
	 * @param ordered
	 *            true if the collection shall be ordered otherwise false
	 * @param contextType
	 *            the implementation context
	 * @return the transformed or standard type as String representation
	 */
	public static String mappingType(Boolean unique, Boolean ordered,
			String contextType) {
		return getTypeMapper().getMappingType(unique, ordered, contextType);
	}

	/**
	 * Sole method to get the preconfigured type mapper.
	 * 
	 * @return preconfigured type mapper
	 */
	private static TypeMapper getTypeMapper() {
		return TypeMapper.getInstance();
	}
}
