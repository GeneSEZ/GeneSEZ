package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_VjuJsIzDEeKLl_w7vhifuQ) 
 */
import org.genesez.workflow.SimpleModel2Text;

import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Statistic2Html extends SimpleModel2Text {
	
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
		return "org::genesez::statistic::m2t::Evaluation::Root";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._VjuJsIzDEeKLl_w7vhifuQ) ENABLED START */
	/* PROTECTED REGION END */
}
