package de.genesez.scriptdoc.parsing;

import java.util.*;

import de.genesez.scriptdoc.helper.StringHelper;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383894291_461877_1964) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class Validation extends Executable {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Validation</b></em>'.
	 * @param	n	
	 */
	public Validation(String n) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337387723765_738484_2913) ENABLED START */
		super(n);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337387739428_71666_2916) ENABLED START */
		// split the validation definition at a colon AND the line terminator
		// not save! (i think ^^)
		// TODO find the correct validation pattern
		String[] arbody = codeBody.split(":\\s*\\r");
		// just override the part that we dont need :)
		arbody[arbody.length - 1] = "";
		paramDef = StringHelper.arrayToString(arbody, "");
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383894291_461877_1964) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
