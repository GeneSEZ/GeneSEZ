package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_IInokPLKEeGYwYEQM4LYvw) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Model2Model extends AbstractXpandWorkflowComponent {
	
	@Parameter(isRequired = true, isMultiValued = true, workflowInclusion = ALWAYS)
	private java.util.Set<String> script = new java.util.LinkedHashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String outputSlot;
	
	private CompositeComponent compositeXtend;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._QITJ0Pn6EeG2esQ-bp2d2A) ENABLED START */
		compositeXtend.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._M-BmMPn6EeG2esQ-bp2d2A) ENABLED START */
		if (script.isEmpty()) {
			issues.addError(this, "Workflow parameter 'script' is missing!", script);
		}
		if (outputSlot == null || outputSlot.isEmpty()) {
			outputSlot = WorkflowContext.DEFAULT_SLOT;
			issues.addInfo(this, "Using default model slot for workflow parameter 'outputSlot'.", outputSlot);
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		compositeXtend.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public String getLogMessage() {
		return compositeXtend.getLogMessage();
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
	
	/**
	 * Returns the value of attribute '<em><b>outputSlot</b></em>'.
	 */
	public String getOutputSlot() {
		return outputSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputSlot</b></em>'.
	 * @param	outputSlot	the value to set.
	 */
	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._IInokPLKEeGYwYEQM4LYvw) ENABLED START */
	private void prepareDelegate() {
		compositeXtend = new CompositeComponent(getClass().getName());
		for (String s : script) {
			XtendComponent xc = new XtendComponent();
			xc.setSkipOnErrors(getAbortOnError());
			for (MetaModel mm : getMetaModel()) {
				xc.addMetaModel(mm);
			}
			for (String a : getAopScript()) {
				xc.addExtensionAdvice(a);
			}
			for (GlobalVarDef def : getGlobalVarDef()) {
				xc.addGlobalVarDef(def);
			}
			xc.setOutputSlot(outputSlot);
			xc.setInvoke(s + "(" + getSlot() + ")");
			compositeXtend.addComponent(xc);
		}
	}
	
	/* PROTECTED REGION END */
	
}
