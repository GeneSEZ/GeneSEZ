package de.genesez.scriptdoc.htmlgenerator;

import java.util.*;
import de.genesez.scriptdoc.htmlgenerator.templates.HtmlTemplate;
import de.genesez.scriptdoc.htmlgenerator.templates.HtmlTemplate.ContentType;
import de.genesez.scriptdoc.htmlgenerator.templates.*;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337440940261_383174_1831) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class TemplateInitiator extends Loader {
	
	// -- generated attribute, constant + association declarations ----------
	
	private java.util.Set<HtmlTemplate> templates = new java.util.HashSet<HtmlTemplate>();
	
	private boolean withStats;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>TemplateInitiator</b></em>'.
	 * @param	generateStats	
	 */
	public TemplateInitiator(boolean generateStats) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337517880684_930906_2778) ENABLED START */
		this.withStats = generateStats;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337517847066_459916_2775) ENABLED START */
		// produces the index pages of the executables 
		templates.add(new ExecutableIndexTemplate("executable_index_template.html", "index", ContentType.EXECUTABLEINDEX));
		// produces the main index page
		templates.add(new NonWildCardTemplate("index_template.html", "index"));
		// produces the help doc
		templates.add(new NonWildCardTemplate("help_template.html", "help-doc"));
		// prduces the not-referenced.html
		templates.add(new NonWildCardTemplate("not_referenced_template.html", "not-referenced"));
		// produces the page which lists the 
		templates.add(new NonWildCardTemplate("integrated_function_template.html", "integrated-function"));
		// produces the page which lists the automatically generated functions
		templates.add(new NonWildCardTemplate("generated_function_template.html", "generated-function"));
		// produces the frame in the left upper coner of the docu
		templates.add(new NonWildCardTemplate("bundle_summary_frame_template.html", "bundle-summary-frame"));
		// produces the pages that shows the xtend script contents
		templates.add(new OawScriptTemplate("extend_template.html", ContentType.EXTEND));
		// produces the pages that shows the check script contents
		templates.add(new OawScriptTemplate("check_template.html", ContentType.CHECK));
		// produces the pages that shows the xpand script contents
		templates.add(new OawScriptTemplate("expand_template.html", ContentType.EXPAND));
		// produces the xpand bundle frame
		templates.add(new SummaryTemplate("bundle_expand_frame_template.html", "bundle-expand-frame", ContentType.EXPANDBUNDLE));
		// produces the xtend bundle frame
		templates.add(new SummaryTemplate("bundle_extend_frame_template.html", "bundle-extend-frame", ContentType.EXTENDBUNDLE));
		// produces the check bundle frame
		templates.add(new SummaryTemplate("bundle_check_frame_template.html", "bundle-check-frame", ContentType.CHECKBUNDLE));
		// produces the metatype summary page
		templates.add(new SummaryTemplate("metatype_summary_template.html", "metatype-summary", ContentType.METATYPESUMMARY));
		// produces the external function reference page
		templates.add(new SummaryTemplate("external_function_reference_template.html", "external-function", ContentType.EXTERNALFUNCTION));
		// produces the the namespace overview page
		templates.add(new SummaryTemplate("package_summary_template.html", "package-summary", ContentType.PACKAGESUMMARY));
		// produces the frame that shows all scripts
		templates.add(new SummaryTemplate("script_summary_frame_template.html", "allscripts-frame", ContentType.SCRIPTSUMMARYFRAME));
		// produces the page that shows all scripts
		templates.add(new SummaryTemplate("script_summary_template.html", "allscripts", ContentType.SCRIPTSUMMARY));
		// produces the page for each metatype
		templates.add(new MetaTypeTemplate("metatype_template.html", ContentType.METATYPE));
		// produces the page for each namespace
		templates.add(new PackageTemplate("package_template.html", ContentType.PACKAGE));
		
		// the stats templates..
		if (withStats) {
			templates.add(new ScriptStatsTemplate("stats_script_template.html", ContentType.STATSSCRIPT));
			templates.add(new SummaryTemplate("stats_script_summary_template.html", "stats-script-summary", ContentType.STATSSCRIPTSUMMARY));
			templates.add(new SummaryTemplate("stats_summary_template.html", "stats-summary", ContentType.STATSSUMMARY));
		} else {
			templates.add(new NonWildCardTemplate("no_stats_template.html", "stats-summary"));
		}
		
		return true;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>templates</b></em>'
	 */
	public java.util.Set<HtmlTemplate> getTemplates() {
		return templates;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>templates</b></em>'
	 */
	public void setTemplates(java.util.Set<HtmlTemplate> templates) {
		this.templates = templates;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>withStats</b></em>'
	 */
	public boolean getWithStats() {
		return withStats;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>withStats</b></em>'
	 */
	public void setWithStats(boolean withStats) {
		this.withStats = withStats;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337440940261_383174_1831) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
