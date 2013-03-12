package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;

import org.genesez.scriptdoc.parsing.*;

import de.genesez.scriptdoc.htmlgenerator.wildcards.factory.*;
import de.genesez.scriptdoc.parsing.CheckScript;
import de.genesez.scriptdoc.parsing.ExpandScript;
import de.genesez.scriptdoc.parsing.ExtendScript;
import de.genesez.scriptdoc.parsing.IContent;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337511558116_590677_1829) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class OawScriptTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>OawScriptTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public OawScriptTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337511571126_360621_1847) ENABLED START */
		super(templateName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337511620858_162777_1852) ENABLED START */
		Script currentType = null;
		if (this.contentType.equals(ContentType.EXPAND)) {
			currentType = new ExpandScript();
		} else if (this.contentType.equals(ContentType.EXTEND)) {
			currentType = new ExtendScript();
		} else if (this.contentType.equals(ContentType.CHECK)) {
			currentType = new CheckScript();
		} else
			return;
		
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				if (script.getClass().getName().equals(currentType.getClass().getName())) {
					String scriptName = script.getFile().getName();
					String path = script.getLink().replace(scriptName + ".html", "");
					Set<WildCardFactory> wildcards = createWildCards(script, contentType);
					HtmlTemplate template = new OawScriptTemplate(this.templateName, contentType);
					
					create(scriptName, path, template, wildcards);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337511558116_590677_1829) ENABLED START */

	@Override
	public Set<WildCardFactory> createWildCards(IContent content, ContentType contentType) {
		Script script = (Script) content;
		Set<WildCardFactory> factories = new LinkedHashSet<WildCardFactory>();
		
		WildCardFactory naviWildCards = WildCardFactory.getWildCardFactory(ContentType.NAVI);
		WildCardFactory scriptHeadWildCards = WildCardFactory.getWildCardFactory(ContentType.OAWSCRIPTHEAD);
		WildCardFactory wildcards = WildCardFactory.getWildCardFactory(contentType);
		
		factories.add(naviWildCards);
		factories.add(scriptHeadWildCards);
		factories.add(wildcards);
		
		for (WildCardFactory factory : factories) {
			factory.setupReplacement(script);
		}
		
		return factories;
	}
	/* PROTECTED REGION END */

}
