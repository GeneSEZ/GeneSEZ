package de.genesez.scriptdoc.parsing;

import java.util.*;

import de.genesez.scriptdoc.helper.StringHelper;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337446362181_226341_2342) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class SymbolTable implements IContent {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores associated objects of association PACKAGES to ScriptPackage */
	private Set<ScriptPackage> packages = new TreeSet<ScriptPackage>();
	
	/** stores the associated object of association ROOTS to Roots */
	private Roots roots;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 */
	public void insertInSymbols(Script s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337446762631_928707_2452) ENABLED START */
//		String packageName = StringHelper.separateNamespaceOutOfFile(s.getFile(), s.getRoot().getBase().getPath(), true);
		String packageName = StringHelper.separateNamespaceOutOfFile(s.getFile(), s.getRootPath(), true);
		
		for (ScriptPackage pack : packages) {
			if(pack.getName().equals(packageName)) {
				pack.insertInScripts(s);
				s.setPack(pack);
				return;
			}
		}
		
		ScriptPackage pack = new ScriptPackage(packageName);
		s.setPack(pack);
		pack.insertInScripts(s);
		packages.add(pack);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	p	
	 */
	public void insertInSymbols(ScriptPackage p) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337446804444_540116_2456) ENABLED START */
		if (this.packages.contains(p)) {
			return;
		}
		this.packages.add(p);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	name	
	 * @return	
	 */
	public ScriptPackage getPackage(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337446842278_92293_2459) ENABLED START */
		boolean exist = false;
		for (ScriptPackage p : this.packages) {
			if(p.getName().equals(name)) {
				return p;
			}else {
				exist = false;
			}
		}
		
		if(!exist) {
			ScriptPackage pack = new ScriptPackage(name);
			packages.add(pack);
			return pack;
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	headExtension	
	 * @return	
	 */
	public Script getScript(String headExtension) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337446881517_64893_2463) ENABLED START */
		String packName, scriptName;
		String[] arHeadExt = headExtension.split("::");
		scriptName = arHeadExt[arHeadExt.length - 1];
		packName = headExtension.replace("::" + scriptName, "");

		for (ScriptPackage pack : packages) {
			if(pack.getName().equals(packName)) {
				for (Script s : pack.getScripts()) {
					if(s.getFile().getName().contains(scriptName)) {
						return s;
					}
				}
			}
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	/**
	 * accessor for association to packages
	 */
	public java.util.Set<ScriptPackage> getPackages() {
//		return java.util.Collections.unmodifiableSet(packages);
		return packages;
	}
	
	/**
	 * accessor for association to roots
	 */
	public Roots getRoots() {
		return roots;
	}
	
	/**
	 * accessor for association to roots
	 */
	public void setRoots(Roots roots) {
		this.roots = roots;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337446362181_226341_2342) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
