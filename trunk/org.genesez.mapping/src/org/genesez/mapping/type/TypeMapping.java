package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324560644231_675429_5281) 
 */

/**
 * This class is the interface between the java implementation, which parses the type mapping file and the Xtend scripts. 
 * Use the methods from this class to convert model defined types in language specific types.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 * @author	Tobias Haubold <tobias.haubold@fh-zwickau.de>
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de>
 */
public class TypeMapping {
	
	/**
	 * Returns true if a mapping for the specified type in the specified context exists, otherwise false.
	 * 
	 * @param mappingType	The type to map.
	 * @param context		The context in which the type should be mapped.
	 * @return	True if a type mapping exists, otherwise false.
	 * 
	 * @see org.genesez.mapping.type.ITypeMappingManager#hasTypeMapping(java.lang.String, java.lang.String)
	 */
	public static boolean hasExternalTypeMapping(String externalType, String context) {
		return getTypeMapper().hasExternalTypeMapping(externalType, context);
	}
	
	/**
	 * Returns the name of the external type if a mapping entry exists, 
	 * otherwise the specified name of the external type will be returned.
	 * 
	 * @param	externalType	The name of the external type which shall be mapped.
	 * @return	The mapped or specified name of the external type.
	 */
	public static String mapExternalType(String externalType) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560776959_340523_5348) ENABLED START */
		return getTypeMapper().mapExternalType(externalType);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the name of the external type by means of the specified context if a mapping entry exists, 
	 * otherwise the default mapped name will be returned. If no mapping exists the specified name of the external type will be returned.
	 * 
	 * @param	externalType	The name of the external type which shall be mapped.
	 * @param	context			The name of the context in which the external type shall be mapped.
	 * @return	The mapped or specified name of the external type.
	 */
	public static String mapExternalType(String externalType, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560842862_63904_5369) ENABLED START */
		return getTypeMapper().mapExternalType(externalType, context);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns true if a mapping for the specified multi typed type with the specified context exists, otherwise false.
	 * 
	 * @param unique	True if duplicate items in the multi valued type are not allowed, otherwise false.
	 * @param ordered	True if the items in the multi valued type are ordered, otherwise false.
	 * @param context	The context in which the type should be mapped.
	 * @return	True if a type mapping exists, otherwise false.
	 */
	public static boolean hasMultiValuedTypeMapping(Boolean unique, Boolean ordered, String context) {
		return getTypeMapper().hasMultiValuedTypeMapping(unique, ordered, context);
	}
	
	/**
	 * Returns the name of the multi-valued type if a mapping entry exists, 
	 * otherwise an empty string will be returned.
	 * 
	 * @param	unique	Set to true, if the values in the multi-valued type are unique, otherwise false.
	 * @param	ordered	Set to true, if the values in the multi-valued type are ordered, otherwise false.
	 * @return	The mapped name of the multi-valued type or an empty string.
	 */
	public static String mapMultiValuedType(Boolean unique, Boolean ordered) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560993742_868184_5391) ENABLED START */
		return getTypeMapper().mapMultiValuedType(unique, ordered);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the name of the multi-valued type by means of the specified context if a mapping entry exists, 
	 * otherwise the default mapped name will be returned. If no mapping exists an empty string will be returned.
	 * 
	 * @param	unique	Set to true, if the values in the multi-valued type are unique, otherwise false.
	 * @param	ordered	Set to true, if the values in the multi-valued type are ordered, otherwise false.
	 * @param	context	The name of the context in which the multi-valued type shall be mapped.
	 * @return	The mapped or default name of the multi-valued type or an empty string.
	 */
	public static String mapMultiValuedType(Boolean unique, Boolean ordered, String contextName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561089432_12424_5402) ENABLED START */
		return getTypeMapper().mapMultiValuedType(unique, ordered, contextName);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the preconfigured type mapper.
	 * 
	 * @return	The configured type mapper instance.
	 */
	private static TypeMapper getTypeMapper() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561223022_503322_5419) ENABLED START */
		return TypeMapper.getInstance();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324560644231_675429_5281) ENABLED START */
	/* PROTECTED REGION END */
	
}
