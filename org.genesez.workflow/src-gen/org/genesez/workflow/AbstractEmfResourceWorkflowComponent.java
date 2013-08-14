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
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractEmfResourceWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean useSingleGlobalResourceSet = false;
	
	private ResourceSet resourceSet;
	
	private String uri;
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
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
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "useSingleGlobalResourceSet")
	public boolean getDefaultUseSingleGlobalResourceSet() {
		return false;
	}
	
	/**
	 * Returns the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'.
	 */
	public boolean getUseSingleGlobalResourceSet() {
		return this.useSingleGlobalResourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'.
	 * @param	useSingleGlobalResourceSet	the value to set.
	 */
	public void setUseSingleGlobalResourceSet(boolean useSingleGlobalResourceSet) {
		this.useSingleGlobalResourceSet = useSingleGlobalResourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>resourceSet</b></em>'.
	 */
	public ResourceSet getResourceSet() {
		return this.resourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>resourceSet</b></em>'.
	 * @param	resourceSet	the value to set.
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>uri</b></em>'.
	 */
	public String getUri() {
		return this.uri;
	}
	
	/**
	 * Sets the value of attribute '<em><b>uri</b></em>'.
	 * @param	uri	the value to set.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	/**
	 * Returns the value of attribute '<em><b>file</b></em>'.
	 */
	public String getFile() {
		return this.file;
	}
	
	/**
	 * Sets the value of attribute '<em><b>file</b></em>'.
	 * @param	file	the value to set.
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._y0pgQPRsEeGG-J2DIYyoXg) ENABLED START */
	/* PROTECTED REGION END */
}
