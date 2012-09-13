package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_y0pgQPRsEeGG-J2DIYyoXg) 
 */

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import org.eclipse.emf.mwe.core.issues.Issues;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public abstract class AbstractEmfResourceWorkflowComponent extends AbstractSlotWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean useSingleGlobalResourceSet = false;
	
	private ResourceSet resourceSet;
	
	private String uri;
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String file;
	
	// -- generated method stubs for implementations + derived attributes ---
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
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'
	 */
	public boolean getUseSingleGlobalResourceSet() {
		return useSingleGlobalResourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useSingleGlobalResourceSet</b></em>'
	 */
	public void setUseSingleGlobalResourceSet(boolean useSingleGlobalResourceSet) {
		this.useSingleGlobalResourceSet = useSingleGlobalResourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>resourceSet</b></em>'
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	/**
	 * Sets the value of attribute '<em><b>resourceSet</b></em>'
	 */
	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	/**
	 * Returns the value of attribute '<em><b>uri</b></em>'
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * Sets the value of attribute '<em><b>uri</b></em>'
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	/**
	 * Returns the value of attribute '<em><b>file</b></em>'
	 */
	public String getFile() {
		return file;
	}
	
	/**
	 * Sets the value of attribute '<em><b>file</b></em>'
	 */
	public void setFile(String file) {
		this.file = file;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._y0pgQPRsEeGG-J2DIYyoXg) ENABLED START */
	/* PROTECTED REGION END */
	
	// -- nested classifier -------------------------------------------------
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdUseSingleGlobalResourceSet {
		
		// -- generated elements ------------------------------------------------
		boolean value() default false;
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._yAPW4PRjEeGG-J2DIYyoXg_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdFile {
		
		// -- generated elements ------------------------------------------------
		String value();
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._XSUiwPRjEeGG-J2DIYyoXg_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
}
