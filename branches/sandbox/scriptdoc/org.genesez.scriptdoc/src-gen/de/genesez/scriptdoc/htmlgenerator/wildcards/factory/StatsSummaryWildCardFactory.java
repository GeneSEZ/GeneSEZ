package de.genesez.scriptdoc.htmlgenerator.wildcards.factory;

import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.wildcards.WildCardCatalogue;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337456040469_463960_3113) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class StatsSummaryWildCardFactory extends WildCardFactoryImpl {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void create() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337544743772_893083_8435) ENABLED START */
		insertInWildcards(new WildCardCatalogue.ScanPackageCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanScriptCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanTemplateCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanFunctionCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanValidationCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanCommentedExecutableCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanPhysicalLineCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanCommentLineCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanBlankLineCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanProgramLineCountWildCard());
		insertInWildcards(new WildCardCatalogue.ScanCyclomaticComplexityWildCard());
		// halstead metrics for the whole scan
		insertInWildcards(new WildCardCatalogue.ScanProgramLengthWildCard());
		insertInWildcards(new WildCardCatalogue.ScanVocabularySizeWildCard());
		insertInWildcards(new WildCardCatalogue.ScanProgramVolumeWildCard());
		insertInWildcards(new WildCardCatalogue.ScanDifficultyLvlWildCard());
		insertInWildcards(new WildCardCatalogue.ScanProgramNiveauWildCard());
		insertInWildcards(new WildCardCatalogue.ScanEffortToImplWildCard());
		insertInWildcards(new WildCardCatalogue.ScanImplTimeWildCard());
		insertInWildcards(new WildCardCatalogue.ScanBugCountWildCard());
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337456040469_463960_3113) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
