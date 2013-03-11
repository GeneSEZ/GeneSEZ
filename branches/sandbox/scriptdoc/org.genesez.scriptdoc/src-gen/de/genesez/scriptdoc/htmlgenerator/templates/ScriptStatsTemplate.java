package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;

import de.genesez.scriptdoc.parsing.ExpandScript;
import de.genesez.scriptdoc.parsing.ExtendScript;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337511696932_852900_1900) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ScriptStatsTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ScriptStatsTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public ScriptStatsTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337512036819_706844_1960) ENABLED START */
		super(templateName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337512101310_656859_1967) ENABLED START */
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				// just calculate stats for xpand and xtend scripts
				if (script instanceof ExpandScript || script instanceof ExtendScript) {
					String path = script.getFile().getPath().replace(script.getRoot().getBase().getPath() + "\\", "").replace(script.getFile().getName(), "");
					
					create(script.getFile().getName(), STATSFOLDER + "/" + path, new ScriptStatsTemplate(this.templateName, contentType), createWildCards(script, contentType));
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337511696932_852900_1900) ENABLED START */
	public final String STATSFOLDER = "stats";
	/* PROTECTED REGION END */

}
