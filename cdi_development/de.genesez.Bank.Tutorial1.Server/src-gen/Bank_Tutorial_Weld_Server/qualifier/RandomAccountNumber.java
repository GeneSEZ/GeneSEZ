package Bank_Tutorial_Weld_Server.qualifier;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267537230263_119058_1592) ENABLED START */
/* TODO: put your own source code here */
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/* PROTECTED REGION END */

/**
 */
@Qualifier
@Target( {
METHOD, FIELD, PARAMETER
})
@Retention(RUNTIME)
public @interface RandomAccountNumber {
	
	// -- generated attribute, constant + association declarations ----------
	
	// -- generated association accessors -----------------------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1267537230263_119058_1592) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
