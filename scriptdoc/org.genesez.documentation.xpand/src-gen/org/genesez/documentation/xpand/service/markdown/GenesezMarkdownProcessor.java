package org.genesez.documentation.xpand.service.markdown;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_6_8a7027a_1363990363536_845617_1584) 
 */

import java.io.IOException;
import org.markdown4j.Markdown4jProcessor;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author nicher
 */
public class GenesezMarkdownProcessor {
	
	private static GenesezMarkdownProcessor instance = null;
	
	private Markdown4jProcessor processor;
	
	/**
	 * Constructor for class '<em><b>GenesezMarkdownProcessor</b></em>'.
	 */
	private GenesezMarkdownProcessor() {
		/* PROTECTED REGION ID(java.constructor._17_0_6_8a7027a_1363990498533_558663_1644) ENABLED START */
		processor = new Markdown4jProcessor();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	input	
	 * @return	
	 */
	public String process(String input) {
		/* PROTECTED REGION ID(java.implementation._17_0_6_8a7027a_1363990517182_684395_1664) ENABLED START */
		String htmlOutput = input;
		
		try {
			htmlOutput = processor.process(input);
		} catch (IOException e) {
		}
		return htmlOutput;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public static GenesezMarkdownProcessor getInstance() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_8a7027a_1363990538444_360454_1678) ENABLED START */
		if (null == instance) {
			instance = new GenesezMarkdownProcessor();
		}
		return instance;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_6_8a7027a_1363990363536_845617_1584) ENABLED START */
	/* PROTECTED REGION END */
	
}
