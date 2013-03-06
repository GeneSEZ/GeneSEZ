package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Dz4oYApBEeKxusbn3Pe47g) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3Scaffolding extends Typo3Model2Model {
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean scaffolding = false;
	
	// override default values of workflow parameters
	{
		addScript("org::genesez::platform::typo3v4::mvc::modification::Scaffolding::modelScaffolding");
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._unugwApNEeKxusbn3Pe47g) ENABLED START */
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("scaffolding", scaffolding);
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
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
