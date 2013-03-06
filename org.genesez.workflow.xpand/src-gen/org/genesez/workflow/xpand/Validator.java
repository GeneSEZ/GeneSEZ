package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_NEnv4PLHEeGYwYEQM4LYvw) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Validator extends AbstractXpandWorkflowComponent {
	
	@Parameter(isRequired = true, isMultiValued = true, workflowInclusion = ALWAYS)
	private java.util.Set<String> script = new java.util.LinkedHashSet<String>();
	
	private CheckComponent checkComponent;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._U869MPk7EeG9kdm-OL78lQ) ENABLED START */
		checkComponent.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Q-Z5MPk7EeG9kdm-OL78lQ) ENABLED START */
		if (script.isEmpty()) {
			issues.addError(this, "Workflow parameter 'script' is missing!", script);
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		checkComponent.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public String getLogMessage() {
		return checkComponent.getLogMessage();
	}
	
	/**
	 * Returns the value of attribute '<em><b>script</b></em>'.
	 */
	public java.util.Set<String> getScript() {
		return script;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>script</b></em>'.
	 * @param	script	the value to add.
	 */
	public void addScript(String script) {
		this.script.add(script);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>script</b></em>'.
	 * @param	script	the value to remove.
	 */
	public void removeScript(String script) {
		this.script.remove(script);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._NEnv4PLHEeGYwYEQM4LYvw) ENABLED START */
	private void prepareDelegate() {
		checkComponent = new CheckComponent();
		checkComponent.setAbortOnError(getAbortOnError());
		checkComponent.setEmfAllChildrenSlot(getSlot());
		for (String s : script) {
			checkComponent.addCheckFile(s);
		}
		for (MetaModel mm : getMetaModel()) {
			checkComponent.addMetaModel(mm);
		}
		for (String s : getAopScript()) {
			checkComponent.addExtensionAdvice(s);
		}
		for (GlobalVarDef def : getGlobalVarDef()) {
			checkComponent.addGlobalVarDef(def);
		}
	}
	
	/* PROTECTED REGION END */
	
}
