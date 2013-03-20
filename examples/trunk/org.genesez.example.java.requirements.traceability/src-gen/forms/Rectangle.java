package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249464012328_770017_760) 
 */

import static traceability.Requirement.Value.R1;
import traceability.Requirement;
import traceability.Scenario;
import traceability.ScenarioStep;

/**
 * Describes the geometrical form <b>rectangle</b> as a specic <i>polygon</i>
 */
@Requirement({ R1 })
public class Rectangle extends Polygon {
	
	/**
	 * constructs a rectangle by the 2 diagonally points
	 * @param	a	the lower left point of the rectangle
	 * @param	c	the upper right point of the rectangle
	 */
	public Rectangle(Point a, Point c) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249464153812_196550_828) ENABLED START */
		super(new Point[] { a, new Point(c.getX(), a.getY()), c, new Point(a.getX(), c.getY()) });
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249464012328_770017_760) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
