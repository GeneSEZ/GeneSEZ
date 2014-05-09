package de.genesez.scriptdoc.htmlgenerator;

import java.io.File;
import java.util.*;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337440419977_249207_1641) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	protected String root;
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public abstract boolean generate();
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>root</b></em>'
	 */
	public String getRoot() {
		return root;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>root</b></em>'
	 */
	public void setRoot(String root) {
		this.root = root;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337440419977_249207_1641) ENABLED START */

	private ArrayList<File> bases;

	public void setBases(ArrayList<File> bases) {
		this.bases = bases;
	}

	public ArrayList<File> getBases() {
		return bases;
	}
	
	/* PROTECTED REGION END */

}
