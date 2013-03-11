package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;
import de.genesez.scriptdoc.htmlgenerator.wildcards.factory.*;
import de.genesez.scriptdoc.parsing.IContent;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337457681305_334350_3302) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class WildCardTemplate extends HtmlTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>WildCardTemplate</b></em>'.
	 * @param	templateName	
	 * @param	fileName	
	 * @param	type	
	 */
	public WildCardTemplate(String templateName, String fileName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337549214658_118192_9353) ENABLED START */
		super(templateName, fileName, type);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>WildCardTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public WildCardTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337549327306_993953_9357) ENABLED START */
		super(templateName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	contentType	
	 * @return	
	 */
	public java.util.Set<WildCardFactory> createWildCards(IContent content, ContentType contentType) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457825948_982348_3330) ENABLED START */
		WildCardFactory wildcards = WildCardFactory.getWildCardFactory(contentType);
		wildcards.setupReplacement(content);
		
		Set<WildCardFactory> factories = new LinkedHashSet<WildCardFactory>();
		factories.add(wildcards);
		
		return factories;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	factories	
	 */
	public void setupWildCardReplacement(IContent content, java.util.Set<WildCardFactory> factories) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337510877626_143265_1720) ENABLED START */
		// TODO: implementation of method 'WildCardTemplate.setupWildCardReplacement(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337457681305_334350_3302) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
