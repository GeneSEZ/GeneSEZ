package de.genesez.scriptdoc.htmlgenerator.wildcards.factory;

import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.templates.HtmlTemplate.ContentType;
import de.genesez.scriptdoc.htmlgenerator.wildcards.WildCard;
import de.genesez.scriptdoc.parsing.IContent;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337452261655_222870_2617) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class WildCardFactory {
	
	// -- generated attribute, constant + association declarations ----------
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 */
	public abstract void create();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	c	
	 */
	public void setupReplacement(IContent c) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337452554522_454934_2662) ENABLED START */
		for (WildCard wildcard : this.wildcards) {
			wildcard.setupReplacement(c);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	type	
	 * @return	
	 */
	public static WildCardFactory getWildCardFactory(ContentType type) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337452311560_24321_2637) ENABLED START */
		switch (type) {
			case NAVI:
				return new NaviWildCardFactory();
			case OAWSCRIPTHEAD:
				return new OAWScriptHeadWildCardFactory();
			case PACKAGE:
				return new PackageWildCardFactory();
			case EXPAND:
				return new TemplateWildCardFactory();
			case EXTEND:
				return new FunctionWildCardFactory();
			case CHECK:
				return new ValidationWildCardFactory();
			case SCRIPTSUMMARY:
				return new ScriptSummaryWildCardFactory();
			case SCRIPTSUMMARYFRAME:
				return new ScriptSummaryFrameWildCardFactory();
			case PACKAGESUMMARY:
				return new PackageSummaryWildCardFactory();
			case METATYPESUMMARY:
				return new MetaTypeSummaryWildCardFactory();
			case METATYPE:
				return new MetaTypeWildCardFactory();
			case STATSSUMMARY:
				return new StatsSummaryWildCardFactory();
			case STATSSCRIPTSUMMARY:
				return new StatsScriptSummaryWildCardFactory();
			case STATSSCRIPT:
				return new StatsScriptWildCardFactory();
			case EXPANDBUNDLE:
				return new BundleExpandWildCardFactory();
			case EXTENDBUNDLE:
				return new BundleExtendWildCardFactory();
			case CHECKBUNDLE:
				return new BundleCheckWildCardFactory();
			case EXTERNALFUNCTION:
				return new ExternalFunctionWildCardFactory();
			case EXECUTABLEINDEX:
				return new ExecutableIndexWildCardFactory();
			case EXECUTABLEINDEXNAVI:
				return new ExecutableIndexNaviWildCardFactory();
			case NONE:
				return new EmptyWildCardFactory();
			default:
				return null;
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	/**
	 * accessor for association to wildcards
	 */
	public java.util.List<WildCard> getWildcards() {
		return java.util.Collections.unmodifiableList(wildcards);
	}
	
	/**
	 * accessor for association to wildcards
	 */
	public void insertInWildcards(WildCard wildcards) {
		if (this.wildcards.contains(wildcards)) {
			return;
		}
		this.wildcards.add(wildcards);
	}
	
	/**
	 * accessor for association to wildcards
	 */
	public void removeFromWildcards(WildCard wildcards) {
		if (!this.wildcards.contains(wildcards)) {
			return;
		}
		this.wildcards.remove(wildcards);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337452261655_222870_2617) ENABLED START */
	protected java.util.List<WildCard> wildcards = new java.util.ArrayList<WildCard>();
	/* PROTECTED REGION END */

}
