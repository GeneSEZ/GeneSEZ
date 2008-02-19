package de.genesez.common.typemapping.mappingtypes;

public class ExternalMappingType extends MappingType {
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public ExternalMappingType(String map, String defaultType) {
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
