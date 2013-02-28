package org.genesez.platform.common.naming;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554198617_832176_3544) 
 */

import org.genesez.metamodel.gcore.MElement;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Naming {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	xtendNamingFile	
	 */
	
	public static void setXtendNamingFile(String xtendNamingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554789398_807748_3731) ENABLED START */
		getNamingMapper().setXtendNamingFile(xtendNamingFile);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	namingContext	
	 * @return	
	 */
	public static String naming(MElement element, String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554844430_961618_3744) ENABLED START */
		return getNamingMapper().getMappingName(element, namingContext);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the preconfigured naming mapper.
	 * @return	preconfigured naming mapper
	 */
	private static NamingMapper getNamingMapper() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554899079_137165_3757) ENABLED START */
		return NamingMapper.getInstance();
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554198617_832176_3544) ENABLED START */
	/* PROTECTED REGION END */
	
}
