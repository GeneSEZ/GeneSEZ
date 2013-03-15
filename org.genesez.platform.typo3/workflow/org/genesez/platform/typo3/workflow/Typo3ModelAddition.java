package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_PmjaoApAEeKxusbn3Pe47g) 
 */
import org.genesez.workflow.SimpleScript;
import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3ModelAddition extends SimpleScript {
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getScript() == null) {
			setScript(getDefaultScript());
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "script")
	public String getDefaultScript() {
		return "org::genesez::platform::typo3v4::mvc::modification::Addition::modelAdditions";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._PmjaoApAEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
