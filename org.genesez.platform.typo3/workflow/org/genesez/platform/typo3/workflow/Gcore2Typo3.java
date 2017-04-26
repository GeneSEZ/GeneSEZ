package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_mFxjwIpzEeKeCsuOoxdEcQ) 
 */
import org.genesez.workflow.SimpleModel2Text;
import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2Typo3 extends SimpleModel2Text {
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getTemplate() == null) {
			setTemplate(getDefaultTemplate());
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "template")
	public String getDefaultTemplate() {
		return "org::genesez::platform::typo3::cms::m2t::Root::Root";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._mFxjwIpzEeKeCsuOoxdEcQ) ENABLED START */
	/* PROTECTED REGION END */
}
