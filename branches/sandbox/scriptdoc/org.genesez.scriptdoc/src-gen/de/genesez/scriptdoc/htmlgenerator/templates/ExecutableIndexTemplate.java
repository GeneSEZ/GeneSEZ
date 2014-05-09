package de.genesez.scriptdoc.htmlgenerator.templates;

import java.io.File;
import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.wildcards.factory.WildCardFactory;
import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.ExpandScript;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1340247578188_64_2339) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ExecutableIndexTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ExecutableIndexTemplate</b></em>'.
	 * @param	templateName	
	 * @param	fileName	
	 * @param	type	
	 */
	public ExecutableIndexTemplate(String templateName, String fileName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1340247619668_792358_2360) ENABLED START */
		super(templateName, fileName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1340247708828_735553_2365) ENABLED START */
		for (ScriptPackage pack : table.getPackages()) {
			for (Script s : pack.getScripts()) {
				for (Executable ex : s.getSymbols()) {
					insertInPackList(ex);
				}
			}
		}
		
		// holds wildcards to insert the content of the index page except for the indexnavi 
		
		java.util.Set<WildCardFactory> indexContentFactories;
		
		// holds wildcards to create the index navi
		java.util.Set<WildCardFactory> indexNaviFactories = createWildCards(indices, ContentType.EXECUTABLEINDEXNAVI);
		;
		
		for (Script script : indices.getScripts()) {
			indexContentFactories = createWildCards(script, ContentType.EXECUTABLEINDEX);
			indexContentFactories.addAll(indexNaviFactories);
			
			int num = ExecutableIndexTemplate.alphabet.indexOf(script.getFile().getName());
			
			create("index-" + num, "index", new ExecutableIndexTemplate(this.templateName, "", contentType), indexContentFactories);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1340247578188_64_2339) ENABLED START */
	public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
	
	private ScriptPackage indices = new ScriptPackage("indices");
	
	public void insertInPackList(Executable e) {
		String pack = "";
		String firstLetter = "";
		// determine first letter of this executable
		try {
		firstLetter = (e.getName().charAt(0) + "").toUpperCase();
		} catch(RuntimeException r) {
			System.err.println("parse error in " + e.getLink().replace(".html", "") + " for " + e.getCode());
			return;
		}
		// watch if a script with the current letter is available
		Script s = indices.getScript(firstLetter);
		// if not, create a new once
		if (s == null) {
			
			s = new ExpandScript();
			s.setFile(new File(firstLetter));
//			s.setRoot(e.getScript().getRoot());
			s.setRootPath(e.getScript().getRootPath());
			s.insert(e);
			
			// sometimes the packages are not set up.. 
			// TODO
			if (e.getScript().getPack() != null) {
				pack = e.getScript().getPack().getName();
			} else {
				System.out.println(e.getName());
			}
			
			ScriptPackage p = new ScriptPackage(pack);
			s.setPack(p);
			indices.insertInScripts(s);
		} else { // otherwise, just insert the current executable..
			s.insert(e);
		}
	}
	/* PROTECTED REGION END */

}
