package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337511768904_749349_1920) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class SummaryTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>SummaryTemplate</b></em>'.
	 * @param	templateName	
	 * @param	fileName	
	 * @param	type	
	 */
	public SummaryTemplate(String templateName, String fileName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337511941909_555283_1950) ENABLED START */
		super(templateName, fileName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337511991205_284910_1955) ENABLED START */
		String folder = "";
		HtmlTemplate template = new SummaryTemplate(this.templateName, this.name, contentType);
		
		if (contentType.equals(ContentType.STATSSCRIPTSUMMARY)) {
			folder = "stats";
		}
		
		create(this.name, folder, template, createWildCards(table, contentType));
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337511768904_749349_1920) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
