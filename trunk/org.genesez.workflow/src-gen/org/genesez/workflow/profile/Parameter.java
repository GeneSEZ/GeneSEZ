package org.genesez.workflow.profile;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_SS618PXWEeGt_pQB8d500A.JavaAnnotationInterface) 
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
@Documented
@Retention(RUNTIME)
public @interface Parameter {
	
	// -- generated elements ------------------------------------------------
	boolean isRequired() default false;
	
	boolean isMultiValued() default false;
	
	WorkflowFileInclusion workflowInclusion() default WorkflowFileInclusion.WHEN_NEEDED;
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._SS618PXWEeGt_pQB8d500A.JavaAnnotationInterface) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
