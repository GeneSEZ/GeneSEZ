
package Bank_Tutorial_Weld_Server.qualifier;
	/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1271580789723_586944_603) ENABLED START */ 
	import java.util.*;
            import java.lang.annotation.Retention;               
            import static java.lang.annotation.RetentionPolicy.RUNTIME;                       
            import java.lang.annotation.Target;           
                import static java.lang.annotation.ElementType.METHOD;                       
                import static java.lang.annotation.ElementType.FIELD;                       
                import static java.lang.annotation.ElementType.PARAMETER;                       
	import javax.persistence.*;
        import javax.inject.Qualifier;
	import javax.annotation.*;
	import javax.ejb.*;
			import Bank_Tutorial_Weld_Server.qualifier.*;
			import Bank_Tutorial_Weld_Server.bankgroupServer.*;
		
	
	/* PROTECTED REGION END */

/**
 */
    @Qualifier
         
         
		

            @Target({ METHOD , FIELD , PARAMETER })
            @Retention(RUNTIME)
                 
    
    
public @interface LoggedIn {
	
	// -- generated attribute, constant + association declarations ----------
        int timeout()          default 1000    ;
    
	
	
	// -- generated association accessors -----------------------------------
		
		
		
		
		
		


	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1271580789723_586944_603) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}

	    
