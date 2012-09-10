package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Aes3IPqcEeGS1KtqERYUjQ) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.AbstractSlotWorkflowComponent;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public abstract class AbstractXpandWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS)
	private java.util.Set<String> advice = new java.util.HashSet<String>();
	
	@Parameter(isRequired = true, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<MetaModel> metaModel = new java.util.HashSet<MetaModel>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<GlobalVarDef> globalVarDef = new java.util.HashSet<GlobalVarDef>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._jVgogPqdEeGS1KtqERYUjQ) ENABLED START */
		if (metaModel.isEmpty()) {
			issues.addError(this, "Workflow parameter 'metaModel' is missing!", metaModel);
		}
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>advice</b></em>'
	 */
	public java.util.Set<String> getAdvice() {
		return advice;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>advice</b></em>'.
	 * @param	advice	the value to add
	 */
	public void addAdvice(String advice) {
		this.advice.add(advice);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>advice</b></em>'.
	 * @param	advice	the value to remove
	 */
	public void removeAdvice(String advice) {
		this.advice.remove(advice);
	}
	
	/**
	 * Returns the value of attribute '<em><b>metaModel</b></em>'
	 */
	public java.util.Set<MetaModel> getMetaModel() {
		return metaModel;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to add
	 */
	public void addMetaModel(MetaModel metaModel) {
		this.metaModel.add(metaModel);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>metaModel</b></em>'.
	 * @param	metaModel	the value to remove
	 */
	public void removeMetaModel(MetaModel metaModel) {
		this.metaModel.remove(metaModel);
	}
	
	/**
	 * Returns the value of attribute '<em><b>globalVarDef</b></em>'
	 */
	public java.util.Set<GlobalVarDef> getGlobalVarDef() {
		return globalVarDef;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>globalVarDef</b></em>'.
	 * @param	globalVarDef	the value to add
	 */
	public void addGlobalVarDef(GlobalVarDef globalVarDef) {
		this.globalVarDef.add(globalVarDef);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>globalVarDef</b></em>'.
	 * @param	globalVarDef	the value to remove
	 */
	public void removeGlobalVarDef(GlobalVarDef globalVarDef) {
		this.globalVarDef.remove(globalVarDef);
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._Aes3IPqcEeGS1KtqERYUjQ) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
