package org.genesez.example.java.cdi.bank.qualifier;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267537230263_119058_1592.JavaAnnotationInterface) 
 */

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import javax.inject.Qualifier;

/**
 */
@Qualifier
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface RandomAccountNumber {
	
	// -- generated elements ------------------------------------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1267537230263_119058_1592.JavaAnnotationInterface) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
