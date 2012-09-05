package org.genesez.example.java.cdi.bank.qualifier;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267536958936_443501_1534.JavaAnnotationInterface) 
 */

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Inherited;
import javax.inject.Qualifier;
import javax.interceptor.InterceptorBinding;

/**
 */
@Qualifier
@InterceptorBinding
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@Inherited
public @interface Logging {
	
	// -- generated elements ------------------------------------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1267536958936_443501_1534.JavaAnnotationInterface) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
