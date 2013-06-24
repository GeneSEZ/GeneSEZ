package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871095796_723781_254) 
 */

import java.awt.Color;
/**
 * Describes a <i><b>point</b></i> in a 2-dimensional coordinate system
 * @author	apflueger
 */
public class Point implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * documented here {@link getX()}
	 * @generated	attribute definition
	 */
	private double x;
	/**
	 * documented here {@link getY()}
	 * @generated	attribute definition
	 */
	private double y;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs a point in the center of the coordinate system
	 * @generated	constructor for class '<em><b>Point</b></em>'
	 */
	public Point() {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871240109_473577_277) ENABLED START */
		this.x = 0.0;
		this.y = 0.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * constructs a point using the specified coordinate values
	 * @generated	constructor for class '<em><b>Point</b></em>'
	 * @param	x	the x-coordinate value of the point
	 * @param	y	the y-coordinate value of the point
	 */
	public Point(double x, double y) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463853031_881157_741) ENABLED START */
		this.x = x;
		this.y = y;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @generated	method stub for further implementation
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		return new Point(this.x, this.y);
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines if the form is crossing another form
	 * @generated	method stub for further implementation
	 * @param	form	the form to check for crossing
	 * @return	determines if the form is crossing another form
	 */
	public boolean isCrossing(Form form) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'Point.isCrossing(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @generated	method stub for further implementation
	 * @param	dx	delta value to move in <i><b>x</b></i> direction
	 * @param	dy	delta value to move in <i><b>y</b></i> direction
	 */
	public void move(double dx, double dy) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'Point.move(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		// TODO: implementation of method 'Point.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotations around the specified point by the specified angle
	 * @generated	method stub for further implementation
	 * @param	center	the center of the rotation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(Point center, double phi) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'Point.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @generated	method stub for further implementation
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Point.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * the x coordinate value
	 * @generated	getter for the attribute '<em><b>x</b></em>'
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * the y coordinate value
	 * @generated	getter for the attribute '<em><b>y</b></em>'
	 */
	public double getY() {
		return y;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
