package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_AU05APRzEeGG-J2DIYyoXg) 
 */
import org.eclipse.emf.mwe.core.WorkflowComponentWithID;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public interface WorkflowComponent extends WorkflowComponentWithID, IWorkflowComponent {
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._AU05APRzEeGG-J2DIYyoXg) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
