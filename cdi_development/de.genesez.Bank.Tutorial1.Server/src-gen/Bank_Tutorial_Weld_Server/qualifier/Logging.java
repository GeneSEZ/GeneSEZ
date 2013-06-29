
package Bank_Tutorial_Weld_Server.qualifier;
	/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267536958936_443501_1534) ENABLED START */ 
	import java.util.*;
            import java.lang.annotation.Retention;               
            import static java.lang.annotation.RetentionPolicy.RUNTIME;                       
            import java.lang.annotation.Target;           
                import static java.lang.annotation.ElementType.TYPE;                       
                import static java.lang.annotation.ElementType.METHOD;                       
        import java.lang.annotation.Inherited;
	import javax.persistence.*;
        import javax.inject.Qualifier;
        import javax.interceptor.InterceptorBinding;
	import javax.annotation.*;
	import javax.ejb.*;
			import Bank_Tutorial_Weld_Server.qualifier.*;
			import Bank_Tutorial_Weld_Server.bankgroupServer.*;
		
	
	/* PROTECTED REGION END */

/**
 */
    @Qualifier
         
         
		
        @InterceptorBinding   

            @Target({ TYPE , METHOD })
            @Retention(RUNTIME)
                 
    
       @Inherited
    
public @interface Logging {
	
	// -- generated attribute, constant + association declarations ----------
	
	
	// -- generated association accessors -----------------------------------
		
		
		
		


	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.annotation.own.code.declaration._16_0_1_41601a3_1267536958936_443501_1534) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}

	    
