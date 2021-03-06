package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_lFzPUP9cEeGCP-nN45yJrw) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class CompositeComponent<T extends WorkflowComponent> extends AbstractWorkflowComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.List<WorkflowComponent> component = new java.util.ArrayList<WorkflowComponent>();
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._G2T8cP9dEeGCP-nN45yJrw) ENABLED START */
		for (WorkflowComponent c : component) {
			c.checkConfiguration(issues);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._YGvEgI_uEeKpSZF4h81flQ) ENABLED START */
		super.invokeInternal(context, monitor, issues);
		for (WorkflowComponent c : component) {
			// check for abort
			if (monitor != null && monitor.isCanceled()) {
				return;
			}
			// invoke
			c.invoke(context, monitor, issues);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>component</b></em>'.
	 */
	public java.util.List<WorkflowComponent> getComponent() {
		return component;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>component</b></em>'.
	 * @param	component	the value to add.
	 */
	public void addComponent(WorkflowComponent component) {
		this.component.add(component);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>component</b></em>'.
	 * @param	component	the value to remove.
	 */
	public void removeComponent(WorkflowComponent component) {
		this.component.remove(component);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._lFzPUP9cEeGCP-nN45yJrw) ENABLED START */
	/* PROTECTED REGION END */
}
