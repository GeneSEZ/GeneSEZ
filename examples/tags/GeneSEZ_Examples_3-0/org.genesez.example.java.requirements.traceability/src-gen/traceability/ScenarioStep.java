package traceability;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks the annotated type as needed to realize the specified scenario steps.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface ScenarioStep {
	
	/**
	 * Defines all scenario steps which need to be satisfied.
	 */
	public enum Value {
		
		/**
		 * draw a line from (0;0) to (2;0)
		 */
		ST1_1,
		/**
		 * draw a line from (2;0) to (2;2)
		 */
		ST1_2,
		/**
		 * draw a line from (2;2) to (0;2)
		 */
		ST1_3,
		/**
		 * draw a line from (0;2) to (1;3)
		 */
		ST1_4,
		/**
		 * draw a line from (1;3) to (2;2)
		 */
		ST1_5,
		/**
		 * draw a line from (2;2) to (0;0)
		 */
		ST1_6,
		/**
		 * draw a line from (0;0) to (0;2)
		 */
		ST1_7,
		/**
		 * draw a line from (0;2) to (2;0)
		 */
		ST1_8,
		/**
		 * depict the center as a point
		 */
		ST2_1,
		/**
		 * depict a circle by using the center point and a radius
		 */
		ST2_2
		
	}
	
	/**
	 * @return all scenario steps fulfilled by a type
	 */
	Value[] value();
}
