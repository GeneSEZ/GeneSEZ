package de.genesez.platforms.common.typemapping;

import java.util.List;

/**
 * Interface for the TypeMappingManagers to handle the ValuedTypes
 * 
 * @author pethu
 * @date 2009-01-24
 */
public interface ITypeMappingManager<T> {

	/**
	 * This method is used to return the language specific type by means of the
	 * context, if any entry exists.
	 * 
	 * @param searchMappingType
	 *            the specific mapping type
	 * @param context
	 *            the implementation context
	 * @return the Mapping of the Type
	 */
	public String getTypeMapping(String searchMappingType, String context);

	/**
	 * this method puts each mapping of the mappingContainer in its own Mapping
	 * HashMap
	 * 
	 * @param mappingContainer
	 *            contains possible new typeMaps
	 */
	void appendMappingMap(List<T> mappingContainer);
}
