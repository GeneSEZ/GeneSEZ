package de.genesez.scriptdoc.htmlgenerator;

import java.util.*;
import java.io.File;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337440752897_678399_1807) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class DirectoryGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	private java.util.Set<String> folders = new java.util.HashSet<String>();
	
	private File base;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>DirectoryGenerator</b></em>'.
	 */
	public DirectoryGenerator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337518520519_465531_2894) ENABLED START */
		folders.add("stats");
		folders.add("css");
		folders.add("metatypes");
		folders.add("packages");
		folders.add("built-in");
		folders.add("index");
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	dir	
	 * @param	replaceFileName	
	 * @return	
	 */
	public boolean generate(File dir, boolean replaceFileName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518537867_53786_2897) ENABLED START */
		String modPath = root + "/" + dir.getPath().replace(base.getPath(), "");
		
		if (replaceFileName)
			modPath = modPath.replace(dir.getName(), "");
		
		return (new File(modPath)).mkdirs();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518595384_322084_2903) ENABLED START */
		boolean failed = true;
		for (String folder : folders) {
			String modPath = root + "/" + folder;
			failed = (new File(modPath)).mkdirs();
			//			if(failed) return true;
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337440752897_678399_1807) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
