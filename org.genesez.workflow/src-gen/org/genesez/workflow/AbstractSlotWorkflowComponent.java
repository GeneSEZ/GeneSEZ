package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_nY_VQPRsEeGG-J2DIYyoXg) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractSlotWorkflowComponent extends AbstractWorkflowComponent implements WorkflowComponent {
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String slot = "coremodel";
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._llkAgPjlEeGhK_C0J8Xzwg) ENABLED START */
		if (slot == null || slot.isEmpty()) {
			issues.addError(this, "Workflow parameter 'slot' is missing!", slot);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>slot</b></em>'
	 * @return	
	 */
	public String getSlot() {
		return slot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>slot</b></em>'
	 * @param	slot	
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._nY_VQPRsEeGG-J2DIYyoXg) ENABLED START */
	/* PROTECTED REGION END */
	
}
