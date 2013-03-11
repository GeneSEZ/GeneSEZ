package de.genesez.scriptdoc.htmlgenerator.wildcards.factory;

import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.wildcards.WildCardCatalogue;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337455712354_366693_2953) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class OAWScriptHeadWildCardFactory extends WildCardFactoryImpl {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void create() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337544762430_165290_8441) ENABLED START */
		insertInWildcards(new WildCardCatalogue.DirectoryPathWildCard());
		insertInWildcards(new WildCardCatalogue.EclipseProjectPathWildCard());
		insertInWildcards(new WildCardCatalogue.NameSpaceWildCard());
		insertInWildcards(new WildCardCatalogue.ScriptNameWildCard());
		insertInWildcards(new WildCardCatalogue.HeadCommentWildCard());
		insertInWildcards(new WildCardCatalogue.HeadImportWildCard());
		insertInWildcards(new WildCardCatalogue.HeadExtensionsWildCard());
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337455712354_366693_2953) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
