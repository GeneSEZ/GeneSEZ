package forms;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1249464012328_770017_760) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the geometrical form <b>rectangle</b> as a specic <i>polygon</i>
 * @author	dreamer
 */
public class Rectangle extends Polygon {
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs a rectangle by the 2 diagonally points
	 * @generated	constructor for class '<em><b>Rectangle</b></em>'
	 * @param	a	the lower left point of the rectangle
	 * @param	c	the upper right point of the rectangle
	 */
	public Rectangle(Point a, Point c) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249464153812_196550_828) ENABLED START */
		super(new Point[] {
		a, new Point(c.getX(), a.getY()), c, new Point(a.getX(), c.getY())
		});
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249464012328_770017_760) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
