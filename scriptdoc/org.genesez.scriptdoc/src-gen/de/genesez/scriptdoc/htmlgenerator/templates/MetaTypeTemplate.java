package de.genesez.scriptdoc.htmlgenerator.templates;

import java.io.File;
import java.util.*;

import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.ExpandScript;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337511417951_912556_1800) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class MetaTypeTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>MetaTypeTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public MetaTypeTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337511453550_78514_1818) ENABLED START */
		super(templateName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337511613214_252782_1850) ENABLED START */
		List<String> allMetaTypes = new ArrayList<String>();
		Set<Script> metaTypes = new TreeSet<Script>();
		// 1. search all metatypes
		for (ScriptPackage pack : table.getPackages()) {
			for (Script s : pack.getScripts()) {
				for (Executable ex : s.getSymbols()) {
					allMetaTypes.add(ex.getMetaType().trim());
				}
			}
		}
		// 2. build a script according to the metatype name
		for (String mt : allMetaTypes) {
			if (!exists(metaTypes, mt)) {
				ExpandScript s = new ExpandScript();
				s.setFile(new File(mt));
				metaTypes.add(s);
			}
		}
		// 3. add the corresponding executables
		for (Script mt : metaTypes) {
			for (ScriptPackage pack : table.getPackages()) {
				for (Script s : pack.getScripts()) {
					for (Executable ex : s.getSymbols()) {
						if (ex.getMetaType().trim().equals(mt.getFile().getName())) {
							Executable e = ex;
							ExpandScript es = new ExpandScript();
							es.setFile(new File(s.getFile().getName()));
							es.setLink(s.getLink());
							
							mt.insertInSymbols(e);
							e.setScript(es);
						}
					}
				}
			}
		}
		
		for (Script script : metaTypes) {
			create(script.getFile().getName(), "metatypes", new MetaTypeTemplate(this.templateName, contentType), createWildCards(script, contentType));
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337511417951_912556_1800) ENABLED START */
	private boolean exists(Set<Script> metatypes, String mt) {
		for (Script script : metatypes) {
			if (script.getFile().getName().equals(mt)) {
				return true;
			}
		}
		return false;
	}
	/* PROTECTED REGION END */

}
