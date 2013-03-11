package de.genesez.scriptdoc.htmlgenerator.wildcards.factory;

import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.wildcards.WildCardCatalogue;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337455610056_563714_2853) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class TemplateWildCardFactory extends WildCardFactoryImpl {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void create() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337544705505_251044_8427) ENABLED START */
		insertInWildcards(new WildCardCatalogue.ExecutableSummaryWildCard());
		
		insertInWildcards(new WildCardCatalogue.ExecutableDocuWildCard());
		insertInWildcards(new WildCardCatalogue.ExecutableNameWildCard());
		insertInWildcards(new WildCardCatalogue.ExecutableHtmlNameWildCard());
		insertInWildcards(new WildCardCatalogue.ExecutableMetaTypeWildCard());
		insertInWildcards(new WildCardCatalogue.ExecutableParamDefWildCard());
		insertInWildcards(new WildCardCatalogue.CodeBodyWildCard());
		insertInWildcards(new WildCardCatalogue.FunctionCallWildCard());
		insertInWildcards(new WildCardCatalogue.TemplateCallerWildCard());
		insertInWildcards(new WildCardCatalogue.ExecutableHtmlPathWildCard());
		
		insertInWildcards(new WildCardCatalogue.TemplateCallWildCard());
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337455610056_563714_2853) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
