package org.genesez.documentation.xpand.service.markdown;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_6_8a7027a_1363990575660_337525_1695) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author nicher
 */
public class MarkdownService {
	
	/**
	 * Method stub for further implementation.
	 * @param	input	
	 * @return	
	 */
	public static String convertToHtml(String input) {
		/* PROTECTED REGION ID(java.implementation._17_0_6_8a7027a_1363990616651_336886_2091) ENABLED START */
		return GenesezMarkdownProcessor.getInstance().process(input);
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_6_8a7027a_1363990575660_337525_1695) ENABLED START */
	/* PROTECTED REGION END */
	
}
