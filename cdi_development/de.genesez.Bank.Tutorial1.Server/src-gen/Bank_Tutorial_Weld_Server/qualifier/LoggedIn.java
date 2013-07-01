package Bank_Tutorial_Weld_Server.qualifier;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1271580789723_586944_603.JavaAnnotationInterface) 
 */
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import javax.inject.Qualifier;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Qualifier
@Target({ FIELD, METHOD })
@Retention(RUNTIME)
public @interface LoggedIn {
	
	int timeout() default 1000;
	
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1271580789723_586944_603.JavaAnnotationInterface) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
