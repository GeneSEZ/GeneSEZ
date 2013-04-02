package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Dz4oYApBEeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleScript;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3Scaffolding extends SimpleScript {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean scaffolding = false;
	
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
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		result.add(new Parameter("scaffolding", scaffolding));
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "scaffolding")
	public boolean getDefaultScaffolding() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "script")
	public String getDefaultScript() {
		return "org::genesez::platform::typo3v4::mvc::modification::Scaffolding::modelScaffolding";
	}
	
	/**
	 * Returns the value of attribute '<em><b>scaffolding</b></em>'.
	 */
	public boolean getScaffolding() {
		return scaffolding;
	}
	
	/**
	 * Sets the value of attribute '<em><b>scaffolding</b></em>'.
	 * @param	scaffolding	the value to set.
	 */
	public void setScaffolding(boolean scaffolding) {
		this.scaffolding = scaffolding;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._Dz4oYApBEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
