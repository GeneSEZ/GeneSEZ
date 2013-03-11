package de.genesez.scriptdoc.htmlgenerator;

import java.util.*;

import de.genesez.scriptdoc.htmlgenerator.templates.HtmlTemplate;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;
import de.genesez.scriptdoc.parsing.SymbolTable;
import java.io.File;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337440710824_281138_1767) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class HtmlGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association LINKGEN to LinkGenerator */
	private LinkGenerator linkGen = new LinkGenerator();
	
	/** stores the associated object of association DIRGEN to DirectoryGenerator */
	private DirectoryGenerator dirGen = new DirectoryGenerator();
	
	private SymbolTable table;
	
	private File base;
	
	private boolean withStats;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518410024_944741_2880) ENABLED START */
		boolean failed = false;
		String statsFolder = "stats";
		
		/* generating links */
		linkGen.setBase(base);
		linkGen.setRoot(root);
		linkGen.setTable(table);
		linkGen.generate();
		
		/* generating directory structure */
		dirGen.setBase(base);
		dirGen.setRoot(root);
		dirGen.generate();
		
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				dirGen.generate(script.getFile(), true);
				if (withStats)
					dirGen.generate(new File(statsFolder + "/" + script.getFile()), true);
			}
		}
		/* generating html documents out of the loaded templates */
		TemplateInitiator loader = new TemplateInitiator(withStats);
		loader.generate();
		System.out.println("generating html docs...");
		for (HtmlTemplate template : loader.getTemplates()) {
			template.setTable(table);
			template.setRoot(root);
			template.read();
			template.make();
		}
		
		/* THATS IT! */
		return failed;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>table</b></em>'
	 */
	public SymbolTable getTable() {
		return table;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>table</b></em>'
	 */
	public void setTable(SymbolTable table) {
		this.table = table;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>base</b></em>'
	 */
	public File getBase() {
		return base;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>base</b></em>'
	 */
	public void setBase(File base) {
		this.base = base;
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
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337440710824_281138_1767) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
