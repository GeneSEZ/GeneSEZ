package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324560644231_675429_5281) 
 */

import org.genesez.metamodel.gcore.MType;

/**
 * This class is the interface between the java implementation, which parses the type mapping file, and the Xtend scripts. Use the methods from this class to convert model defined types in language specific types.
 * 
 * @author nihe
 * @author pethu
 * @date 2008-01-24
 * @deprecated
 */
public class TypeMapping {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * This method returns if any entry exists the transformed value else the basic value for this type.
	 * @param	type	the type which shall be transformed
	 * @return	the transformed or standard type as String representation
	 */
	public static String mappingName(MType type) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560776959_340523_5348) ENABLED START */
		return getTypeMapper().getMappingName(type);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the basic value for this type.
	 * @param	type	the type which shall be transformed
	 * @param	contextType	the implementation context
	 * @return	the transformed or standard type as String representation
	 */
	public static String mappingName(MType type, String contextType) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560842862_63904_5369) ENABLED START */
		return getTypeMapper().getMappingName(type, contextType);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the basic value. This method is used for collections.
	 * @param	unique	true if the collection shall be unique otherwise false
	 * @param	ordered	true if the collection shall be ordered otherwise false
	 * @return	
	 */
	public static String mappingType(Boolean unique, Boolean ordered) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560993742_868184_5391) ENABLED START */
		return getTypeMapper().getMappingType(unique, ordered);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the basic value. This method is used for collections.
	 * @param	unique	true if the collection shall be unique otherwise false
	 * @param	ordered	true if the collection shall be ordered otherwise false
	 * @param	contextType	the implementation context
	 * @return	
	 */
	public static String mappingType(Boolean unique, Boolean ordered, String contextType) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561089432_12424_5402) ENABLED START */
		return getTypeMapper().getMappingType(unique, ordered, contextType);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the preconfigured type mapper.
	 * @return	preconfigured type mapper
	 */
	private static TypeMapper getTypeMapper() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561223022_503322_5419) ENABLED START */
		return TypeMapper.getInstance();
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324560644231_675429_5281) ENABLED START */
	/* PROTECTED REGION END */
	
}
