package de.genesez.scriptdoc.parsing;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383916302_155642_1966) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ScriptPackage implements IContent, Comparable<ScriptPackage> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores associated objects of association SCRIPTS to Script */
	protected java.util.List<Script> scripts = new java.util.ArrayList<Script>();
	
	/** stores the associated object of association SYMBOLS to SymbolTable */
	private SymbolTable symbols;
	
	private String name;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ScriptPackage</b></em>'.
	 * @param	name	
	 */
	public ScriptPackage(String name) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337384932969_613035_2604) ENABLED START */
		this.name = name;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	toCompare	
	 * @return	
	 */
	public int compareTo(ScriptPackage toCompare) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337546689709_990383_9300) ENABLED START */
		int lstComp = name.compareTo(toCompare.getName());
		return lstComp;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * accessor for association to scripts
	 */
	public java.util.List<Script> getScripts() {
		return java.util.Collections.unmodifiableList(scripts);
	}
	
	/**
	 * accessor for association to scripts
	 */
	public void insertInScripts(Script scripts) {
		if (this.scripts.contains(scripts)) {
			return;
		}
		this.scripts.add(scripts);
	}
	
	/**
	 * accessor for association to scripts
	 */
	public void removeFromScripts(Script scripts) {
		if (!this.scripts.contains(scripts)) {
			return;
		}
		this.scripts.remove(scripts);
	}
	
	/**
	 * accessor for association to symbols
	 */
	public SymbolTable getSymbols() {
		return symbols;
	}
	
	/**
	 * accessor for association to symbols
	 */
	public void setSymbols(SymbolTable symbols) {
		this.symbols = symbols;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383916302_155642_1966) ENABLED START */
	public Script getScript(String name) {
		for (Script s : scripts) {
			if(s.getFile().getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	/* PROTECTED REGION END */

}
