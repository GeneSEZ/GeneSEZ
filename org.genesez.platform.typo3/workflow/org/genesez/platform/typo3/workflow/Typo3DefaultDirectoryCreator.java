package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_hJRnUAo8EeKxusbn3Pe47g) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.xpand.Model2Model;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Typo3DefaultDirectoryCreator extends Model2Model {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String outputDir;
	
	// override default values of workflow parameters
	{
		addScript("org::genesez::platform::typo3v4::mvc::scripts::DefaultDirectoryCreation::createDefaultDirectories");
		setSlot("");
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._BGtNQAo9EeKxusbn3Pe47g) ENABLED START */
		if (outputDir == null || outputDir.isEmpty()) {
			issues.addError(this, "Workflow parameter 'outputDir' is missing!", outputDir);
		}
		
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("outputDir", outputDir);
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>outputDir</b></em>'
	 */
	public String getOutputDir() {
		return outputDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputDir</b></em>'
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._hJRnUAo8EeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
	
}
