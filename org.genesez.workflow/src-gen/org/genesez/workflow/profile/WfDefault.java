package org.genesez.workflow.profile;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_GV9OQP3lEeGA35ujkRyC6w.JavaAnnotationInterface) 
 */
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Documented
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
public @interface WfDefault {
	
	String parameter();
	
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._GV9OQP3lEeGA35ujkRyC6w.JavaAnnotationInterface) ENABLED START */
	/* PROTECTED REGION END */
}
