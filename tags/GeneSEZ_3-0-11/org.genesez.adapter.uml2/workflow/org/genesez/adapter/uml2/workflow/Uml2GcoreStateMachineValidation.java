package org.genesez.adapter.uml2.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_rh-c0If5EeKynYimrwgSoA) 
 */
import org.genesez.workflow.SimpleValidator;
import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Uml2GcoreStateMachineValidation extends SimpleValidator {
	
	/**
	 * Validates the configuration of the component before invocation.
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
		return "org::genesez::adapter::uml2::gcore::validation::GcoreStatemachineConstraints";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._rh-c0If5EeKynYimrwgSoA) ENABLED START */
	/* PROTECTED REGION END */
}
