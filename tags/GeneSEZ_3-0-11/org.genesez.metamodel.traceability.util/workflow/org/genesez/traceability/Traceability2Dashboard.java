package org.genesez.traceability;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_M7h98I8KEeKpNoiOVa6Abg) 
 */
import org.genesez.workflow.Parameter;
import org.genesez.workflow.Model2Text;

import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Traceability2Dashboard extends AbstractTraceabilityTransformable implements Model2Text {
	
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
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "template")
	public String getDefaultTemplate() {
		return "org::genesez::platform::dashboard::Root::Root";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._M7h98I8KEeKpNoiOVa6Abg) ENABLED START */
	/* PROTECTED REGION END */
}
