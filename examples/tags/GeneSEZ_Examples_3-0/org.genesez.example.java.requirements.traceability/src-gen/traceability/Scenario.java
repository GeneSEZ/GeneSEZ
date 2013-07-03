package traceability;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the annotated type as needed to realize the specified scenarios.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Scenario {
	
	/**
	 * Defines all scenarios which need to be realized.
	 */
	public enum Value {
		
		/**
		 * drawing the nicolas house
		 * 
		 * <h3>Steps:</h3>
		 * <ol>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * 	<li>drawing the nicolas house</li>
		 * </ol>
		 * 

		 */
		S1,
		/**
		 * depicting a circle
		 * 
		 * <h3>Steps:</h3>
		 * <ol>
		 * 	<li>depicting a circle</li>
		 * 	<li>depicting a circle</li>
		 * </ol>
		 * 
		 * @see <a href="http://genesez.de/examples/java/forms/requiremens/scenario/2">http://genesez.de/examples/java/forms/requiremens/scenario/2</a>

		 */
		S2
		
	}
	
	/**
	 * @return all scenarios fulfilled by a type
	 */
	Value[] value();
}
