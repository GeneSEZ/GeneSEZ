package de.genesez.scriptdoc.htmlgenerator.wildcards;

import java.util.*;

import de.genesez.scriptdoc.helper.StringHelper;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337447750361_668479_2558) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class MultiValueWildCard extends WildCard {
	
	// -- generated attribute, constant + association declarations ----------
	
	protected java.util.List<String> replacement = new java.util.ArrayList<String>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @return	
	 */
	public String replaceContent(String content) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337447850962_820662_2580) ENABLED START */
		for (String repl : this.replacement) {
			for (String value : this.values) {
				content = StringHelper.replaceFirstLine(content, "\n", value, repl);
			}
			
		}
		return content;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337447750361_668479_2558) ENABLED START */
	/**
	 * accessor for association to params
	 */
	public void insertInReplacement(String repl) {
		if (this.replacement.contains(repl)) {
			return;
		}
		this.replacement.add(repl);
	}
	
	/**
	 * Gets the value of the attribute '<em><b>replacement</b></em>'
	 */
	public java.util.List<String> getReplacement() {
		return replacement;
	}
	/* PROTECTED REGION END */

}
