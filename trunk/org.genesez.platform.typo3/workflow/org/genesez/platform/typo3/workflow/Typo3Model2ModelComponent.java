package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_esLdUAo9EeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import org.genesez.workflow.xpand.Model2ModelComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3Model2ModelComponent extends Model2ModelComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean isT3MVCCompliant = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String extensionName;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String extensionVendor;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String extensionKey;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zhoXUAo_EeKxusbn3Pe47g) ENABLED START */
		// check extension name
		if (extensionName == null || extensionName.isEmpty()) {
			issues.addError(this, "Workflow parameter 'extensionName' must be present.", extensionName);
		} else {
			// add workflow parameter for transformation variables as global variables
			addGlobalVarDef("extensionName", extensionName);
		}
		
		// check extension vendor
		if (extensionVendor == null || extensionVendor.isEmpty()) {
			issues.addError(this, "Workflow parameter 'extensionVendor' must be present.", extensionVendor);
		} else {
			// add workflow parameter for transformation variables as global variables
			addGlobalVarDef("extensionVendor", extensionVendor);
		}
		
		// check extension key
		if (extensionKey == null || extensionKey.isEmpty()) {
			issues.addError(this, "Workflow parameter 'extensionKey' must be present.", extensionKey);
		} else {
			// add workflow parameter for transformation variables as global variables
			addGlobalVarDef("extensionKey", extensionKey);
		}
		
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("isT3MVCCompliant", isT3MVCCompliant);
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zhoXVAo_EeKxusbn3Pe47g) ENABLED START */
		// start execution
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "isT3MVCCompliant")
	public boolean getDefaultIsT3MVCCompliant() {
		return true;
	}
	
	/**
	 * Returns the value of attribute '<em><b>isT3MVCCompliant</b></em>'.
	 */
	public boolean getIsT3MVCCompliant() {
		return this.isT3MVCCompliant;
	}
	
	/**
	 * Sets the value of attribute '<em><b>isT3MVCCompliant</b></em>'.
	 * @param	isT3MVCCompliant	the value to set.
	 */
	public void setIsT3MVCCompliant(boolean isT3MVCCompliant) {
		this.isT3MVCCompliant = isT3MVCCompliant;
	}
	
	/**
	 * Returns the value of attribute '<em><b>extensionName</b></em>'.
	 */
	public String getExtensionName() {
		return this.extensionName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>extensionName</b></em>'.
	 * @param	extensionName	the value to set.
	 */
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>extensionVendor</b></em>'.
	 */
	public String getExtensionVendor() {
		return this.extensionVendor;
	}
	
	/**
	 * Sets the value of attribute '<em><b>extensionVendor</b></em>'.
	 * @param	extensionVendor	the value to set.
	 */
	public void setExtensionVendor(String extensionVendor) {
		this.extensionVendor = extensionVendor;
	}
	
	/**
	 * Returns the value of attribute '<em><b>extensionKey</b></em>'.
	 */
	public String getExtensionKey() {
		return this.extensionKey;
	}
	
	/**
	 * Sets the value of attribute '<em><b>extensionKey</b></em>'.
	 * @param	extensionKey	the value to set.
	 */
	public void setExtensionKey(String extensionKey) {
		this.extensionKey = extensionKey;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._esLdUAo9EeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
