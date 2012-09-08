package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_NEnv4PLHEeGYwYEQM4LYvw) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.workflow.AbstractSlotWorkflowComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Validator extends AbstractSlotWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = true, isMultiValued = true, workflowInclusion = ALWAYS)
	private String script;
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS)
	private String aopScript;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Q-Z5MPk7EeG9kdm-OL78lQ) ENABLED START */
		// TODO: implementation of method 'Validator.checkConfiguration(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._U869MPk7EeG9kdm-OL78lQ) ENABLED START */
		// TODO: implementation of method 'Validator.invokeInternal(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>script</b></em>'
	 */
	public String getScript() {
		return script;
	}
	
	/**
	 * Sets the value of attribute '<em><b>script</b></em>'
	 */
	public void setScript(String script) {
		this.script = script;
	}
	
	/**
	 * Returns the value of attribute '<em><b>aopScript</b></em>'
	 */
	public String getAopScript() {
		return aopScript;
	}
	
	/**
	 * Sets the value of attribute '<em><b>aopScript</b></em>'
	 */
	public void setAopScript(String aopScript) {
		this.aopScript = aopScript;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._NEnv4PLHEeGYwYEQM4LYvw) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
