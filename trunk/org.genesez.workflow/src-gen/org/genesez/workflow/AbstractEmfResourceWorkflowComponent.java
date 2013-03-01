package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_y0pgQPRsEeGG-J2DIYyoXg) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractEmfResourceWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean useSingleGlobalResourceSet = false;
	
	private ResourceSet resourceSet;
	
	private String uri;
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String file;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._ng9WMPjlEeGhK_C0J8Xzwg) ENABLED START */
		super.checkConfiguration(issues);
		if (file == null || file.isEmpty()) {
			if (uri == null || uri.isEmpty()) {
				issues.addError(this, "Workflow parameter 'file' is missing!", file);
			} else {
				issues.addInfo(this, "Use workflow parameter 'uri' instead of 'file'", uri);
			}
		} else {
			uri = URI.createFileURI(new File(file).getAbsolutePath()).toString();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'
	 * @return	
	 */
	public boolean getUseSingleGlobalResourceSet() {
		return useSingleGlobalResourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'
	 * @param	useSingleGlobalResourceSet	
	 */
	public void setUseSingleGlobalResourceSet(boolean useSingleGlobalResourceSet) {
		this.useSingleGlobalResourceSet = useSingleGlobalResourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>resourceSet</b></em>'
	 * @return	
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>resourceSet</b></em>'
	 * @param	resourceSet	
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>uri</b></em>'
	 * @return	
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * Sets the value of attribute '<em><b>uri</b></em>'
	 * @param	uri	
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	/**
	 * Returns the value of attribute '<em><b>file</b></em>'
	 * @return	
	 */
	public String getFile() {
		return file;
	}
	
	/**
	 * Sets the value of attribute '<em><b>file</b></em>'
	 * @param	file	
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._y0pgQPRsEeGG-J2DIYyoXg) ENABLED START */
	/* PROTECTED REGION END */
	
}
