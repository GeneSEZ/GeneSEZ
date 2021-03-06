package org.genesez.platform.dotnet.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_4vH5QAomEeKxusbn3Pe47g) 
 */
import org.genesez.workflow.SimpleModel2Text;
import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2Csharp extends SimpleModel2Text {
	
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
		return "org::genesez::platform::dotnet::csharp::templates::Root::Root";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._4vH5QAomEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
