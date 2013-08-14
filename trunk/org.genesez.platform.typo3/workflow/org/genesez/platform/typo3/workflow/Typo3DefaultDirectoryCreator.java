package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_hJRnUAo8EeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleScript;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3DefaultDirectoryCreator extends SimpleScript {
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String outputDir;
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getScript() == null) {
			setScript(getDefaultScript());
		}
		if (outputDir == null && logger.isErrorEnabled()) {
			logger.error("Mandatory parameter 'outputDir' not set!");
			result = false;
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		result.add(new Parameter("outputDir", outputDir));
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "script")
	public String getDefaultScript() {
		return "org::genesez::platform::typo3v4::mvc::scripts::DefaultDirectoryCreation::createDefaultDirectories";
	}
	
	/**
	 * Returns the value of attribute '<em><b>outputDir</b></em>'.
	 */
	public String getOutputDir() {
		return this.outputDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputDir</b></em>'.
	 * @param	outputDir	the value to set.
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._hJRnUAo8EeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
