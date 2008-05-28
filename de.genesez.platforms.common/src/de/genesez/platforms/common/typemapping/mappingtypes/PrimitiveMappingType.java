package de.genesez.platforms.common.typemapping.mappingtypes;

/**
 * This class based on the implementation of the MappingType class and supports
 * the mapping of primitive types.
 * 
 * @author nihe
 * @date 2008-02-18
 */
public class PrimitiveMappingType extends MappingType {
	
	/**
	 * Sole constructor which set the default mapping settings of a primitive
	 * type.
	 * 
	 * @param map the type which shall be transformed (model type)
	 * @param defaultType the default type which is returned when no context is
	 *            given
	 */
	public PrimitiveMappingType(String map, String defaultType) {
		super(map, defaultType);
	}
	
	/**
	 * Getter method which returns the unique identifier of the mapping.
	 * 
	 * @see de.genesez.platforms.common.typemapping.mappingtypes.MappingType#getKey()
	 */
	public String getKey() {
		return getMap();
	}
	
}
