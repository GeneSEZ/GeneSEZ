package traceability;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marks the annotated target as needed to realize the specified requirement.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Requirement {
	/**
	 * Defines all requirements which need to be satisfied.
	 */
	public enum Value {
		
		/**
		 * the depiction of simple, 2-dimensional geometrical forms must be possible
		 */
		R1,
		/**
		 * a point should be definable
		 */
		R2,
		/**
		 * the connection between two points should be possible
		 */
		R3,
		/**
		 * the depiction of complex geometrical forms should be possible
		 */
		R4,
		/**
		 * geometrical forms must be moveable
		 * @see <a href="http://genesez.de/examples/java/forms/requiremens/requirement/5">http://genesez.de/examples/java/forms/requiremens/requirement/5</a>
		 */
		R5,
		/**
		 * geometrical forms must be rotatable
		 * @see <a href="http://genesez.de/examples/java/forms/requiremens/requirement/6">http://genesez.de/examples/java/forms/requiremens/requirement/6</a>
		 */
		R6,
		/**
		 * rotate geometrical forms around theier own
		 */
		R7,
		/**
		 * rotate geometrical forms around a specified point
		 */
		R8,
		/**
		 * rotate geometrical forms around the center of the coordinate system
		 */
		R9,
		/**
		 * definition of polylines should be possible
		 */
		R10
		
	}
	
	/**
	 * @return all requirements fulfilled by a type
	 */
	Value[] value();
}
