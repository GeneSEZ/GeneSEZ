package de.genesez.scriptdoc.htmlgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337520122007_85684_3032) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class BuiltInLoader extends Loader {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static BuiltInLoader instance = new BuiltInLoader();
	
	private java.util.Set<String> integratedFunctions = new java.util.HashSet<String>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>BuiltInLoader</b></em>'.
	 */
	private BuiltInLoader() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337520232939_753129_3058) ENABLED START */
		this.dir = "built-in";
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337520305417_545881_3064) ENABLED START */
		boolean failed = true;
		String separator = ";";
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(root + "/" + dir + "/" + "functions.csv")));
			String readString;
			while ((readString = in.readLine()) != null) {
				String s = readString.split(separator)[0];
				integratedFunctions.add(s);
			}
			in.close();
			return failed;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	funName	
	 * @return	
	 */
	public boolean isBuiltInFunction(String funName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337520331126_3582_3067) ENABLED START */
		for (String s : integratedFunctions) {
			if (s.equals(funName)) {
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public static BuiltInLoader getInstance() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337520269194_248784_3061) ENABLED START */
		return instance;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337520122007_85684_3032) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
