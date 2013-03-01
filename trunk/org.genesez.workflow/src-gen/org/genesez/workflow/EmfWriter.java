package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_UMGTcPLIEeGYwYEQM4LYvw) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Writer;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class EmfWriter extends AbstractEmfResourceWorkflowComponent {
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean schemaLocation = true;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean schemaLocationImplementation = true;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean ignoreEmptySlot = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean cloneSlotContents = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean multipleResourcesInCaseOfList = false;
	
	private Writer writer;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._r4HjsPjlEeGhK_C0J8Xzwg) ENABLED START */
		writer.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._yDDUkPjoEeGhK_C0J8Xzwg) ENABLED START */
		super.checkConfiguration(issues);
		prepareDelegate();
		writer.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public String getLogMessage() {
		return writer.getLogMessage();
	}
	
	/**
	 * Returns the value of attribute '<em><b>schemaLocation</b></em>'
	 */
	public boolean getSchemaLocation() {
		return schemaLocation;
	}
	
	/**
	 * Sets the value of attribute '<em><b>schemaLocation</b></em>'
	 */
	public void setSchemaLocation(boolean schemaLocation) {
		this.schemaLocation = schemaLocation;
	}
	
	/**
	 * Returns the value of attribute '<em><b>schemaLocationImplementation</b></em>'
	 */
	public boolean getSchemaLocationImplementation() {
		return schemaLocationImplementation;
	}
	
	/**
	 * Sets the value of attribute '<em><b>schemaLocationImplementation</b></em>'
	 */
	public void setSchemaLocationImplementation(boolean schemaLocationImplementation) {
		this.schemaLocationImplementation = schemaLocationImplementation;
	}
	
	/**
	 * Returns the value of attribute '<em><b>ignoreEmptySlot</b></em>'
	 */
	public boolean getIgnoreEmptySlot() {
		return ignoreEmptySlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>ignoreEmptySlot</b></em>'
	 */
	public void setIgnoreEmptySlot(boolean ignoreEmptySlot) {
		this.ignoreEmptySlot = ignoreEmptySlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>cloneSlotContents</b></em>'
	 */
	public boolean getCloneSlotContents() {
		return cloneSlotContents;
	}
	
	/**
	 * Sets the value of attribute '<em><b>cloneSlotContents</b></em>'
	 */
	public void setCloneSlotContents(boolean cloneSlotContents) {
		this.cloneSlotContents = cloneSlotContents;
	}
	
	/**
	 * Returns the value of attribute '<em><b>multipleResourcesInCaseOfList</b></em>'
	 */
	public boolean getMultipleResourcesInCaseOfList() {
		return multipleResourcesInCaseOfList;
	}
	
	/**
	 * Sets the value of attribute '<em><b>multipleResourcesInCaseOfList</b></em>'
	 */
	public void setMultipleResourcesInCaseOfList(boolean multipleResourcesInCaseOfList) {
		this.multipleResourcesInCaseOfList = multipleResourcesInCaseOfList;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._UMGTcPLIEeGYwYEQM4LYvw) ENABLED START */
	private void prepareDelegate() {
		writer = new Writer();
		writer.setUri(getUri());
		writer.setModelSlot(getSlot());
		writer.setCloneSlotContents(cloneSlotContents);
		writer.setIgnoreEmptySlot(ignoreEmptySlot);
		writer.setMultipleResourcesInCaseOfList(multipleResourcesInCaseOfList);
		writer.setOPTION_SCHEMA_LOCATION(schemaLocation);
		writer.setOPTION_SCHEMA_LOCATION_IMPLEMENTATION(schemaLocationImplementation);
		//writer.setResourceSet( getResourceSet() );
		writer.setSkipOnErrors(getAbortOnError());
		writer.setUseSingleGlobalResourceSet(getUseSingleGlobalResourceSet());
	}
	
	/* PROTECTED REGION END */
	
}
