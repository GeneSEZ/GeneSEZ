package de.genesez.platforms.common.typemapping;

import genesezMM.MType;

public class TypeMapping {
	
	public static String mappingName(MType type) {
		return getTypeMapper().getMappingName(type);
	}
	
	public static String mappingName(MType type, String contextType) {
		return getTypeMapper().getMappingName(type, contextType);
	}
	
	
	public static String mappingType(Boolean unique, Boolean ordered) {
		return getTypeMapper().getMappingType(unique, ordered);
	}
	
	public static String mappingType(Boolean unique, Boolean ordered, String contextType) {
		return getTypeMapper().getMappingType(unique, ordered, contextType);
	}

	///////////////////////////////////////////////////////////////////////////
		
	private static TypeMapper getTypeMapper() {
		return TypeMapper.getInstance();
	}

}
