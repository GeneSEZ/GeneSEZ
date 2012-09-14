package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_nY_VQPRsEeGG-J2DIYyoXg) 
 */

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
public abstract class AbstractSlotWorkflowComponent extends AbstractWorkflowComponent implements WorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String slot = "coremodel";
	
	// -- generated method stubs for implementations + derived attributes ---
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
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>slot</b></em>'
	 */
	public String getSlot() {
		return slot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>slot</b></em>'
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._nY_VQPRsEeGG-J2DIYyoXg) ENABLED START */
	/* PROTECTED REGION END */
	
	// -- nested classifier -------------------------------------------------
	/**
	 * Please describe the responsibility of your class in your modeling tool.
	 * @author dreamer
	 */
	@Documented
	@Target({ TYPE })
	@Retention(RUNTIME)
	public @interface WpdSlot {
		
		// -- generated elements ------------------------------------------------
		String value() default "coremodel";
		
		// -- generated code of other cartridges --------------------------------
		
		// -- own code implementation -------------------------------------------
		/* PROTECTED REGION ID(java.annotation.own.code.declaration._5wrNUPRjEeGG-J2DIYyoXg_annotation) ENABLED START */
		/* PROTECTED REGION END */
	}
	
}
