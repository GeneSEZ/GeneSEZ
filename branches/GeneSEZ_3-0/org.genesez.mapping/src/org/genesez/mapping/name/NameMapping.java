package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554198617_832176_3544) 
 */

/**
 * This class is the interface between the java implementation, which handles the naming contexts and the Xtend scripts.
 * Use the methods from this class to map names of model elements.
 *
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class NameMapping {
	
	/**
	 * Returns the mapped name of the model element by means of the specified naming context.
	 * If no Xtend script for the specified model element and naming context exists, 
	 * the string representation of the specified model element will be returned.
	 * 
	 * @param	element			The model element which shall be mapped.
	 * @param	namingContext	The naming context in which the model element shall be mapped.
	 * @return	The mapped name of the model element or its string representation.
	 */
	public static String mapElementName(Object element, String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324554844430_961618_3744) ENABLED START */
		return NameMapper.getInstance().mapElementName(element, namingContext);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554198617_832176_3544) ENABLED START */
	/* PROTECTED REGION END */
	
}
