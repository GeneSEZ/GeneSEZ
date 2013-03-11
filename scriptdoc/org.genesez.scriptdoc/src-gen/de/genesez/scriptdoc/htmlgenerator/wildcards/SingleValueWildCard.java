package de.genesez.scriptdoc.htmlgenerator.wildcards;

import java.util.*;

import de.genesez.scriptdoc.parsing.IContent;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337447346868_43676_2526) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class SingleValueWildCard extends WildCard {
	
	// -- generated attribute, constant + association declarations ----------
	
	protected String replacement;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @return	
	 */
	public String replaceContent(String content) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337447495593_299610_2549) ENABLED START */
		if(this.replacement != null) {
			for (String value : this.values) {
				content = content.replace(value, this.replacement);
			}
		}
		return content;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>replacement</b></em>'
	 */
	public String getReplacement() {
		return replacement;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>replacement</b></em>'
	 */
	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337447346868_43676_2526) ENABLED START */
	public SingleValueWildCard(String replacement, String placeHolder) {
		this.replacement = replacement;
		this.values.add(placeHolder);
	}
	
	public SingleValueWildCard() {
	}
	/* PROTECTED REGION END */

}
