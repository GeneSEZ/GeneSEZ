package de.genesez.scriptdoc.htmlgenerator.wildcards;

import java.util.*;

import de.genesez.scriptdoc.helper.StringHelper;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337448232929_345291_2590) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class DupeMultiValueWildCard extends MultiValueWildCard {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @return	
	 */
	public String replaceContent(String content) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337448297030_110733_2611) ENABLED START */
		int c = 0;
		for (Object repl : this.replacement) {
			c++;
			for (String value : this.values) {
				if (c < this.replacement.size()) {
					content = StringHelper.duplicateLine(content, value, "\n");
				}
				content = StringHelper.replaceFirstLine(content, "\n", value, (String) repl);
			}
		}
		return content;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337448232929_345291_2590) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
