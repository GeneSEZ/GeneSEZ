package de.genesez.platforms.common.typemapping.mappingtypes;

public class PrimitiveMappingType extends MappingType {

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public PrimitiveMappingType(String map, String defaultType) {
		super(map, defaultType);
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * implemented abstract methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
		
	@Override
	public String getKey() {
		return getMap();
	}

}
