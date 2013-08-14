package org.genesez.workflow.profile;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_SS618PXWEeGt_pQB8d500A.JavaAnnotationInterface) 
 */
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Documented
@Target({ FIELD })
@Retention(RUNTIME)
public @interface WfParameter {
	
	boolean isRequired() default false;
	
	boolean isMultiValued() default false;
	
	WorkflowFileInclusion workflowInclusion() default WorkflowFileInclusion.WHEN_NEEDED;
	
	boolean isTransformationParameter() default true;
	
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._SS618PXWEeGt_pQB8d500A.JavaAnnotationInterface) ENABLED START */
	/* PROTECTED REGION END */
}
