package forms;

import java.awt.Color;
import java.util.*;

/* PROTECTED REGION ID(java.type.import._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * describes the geometrical shape of a <i><b>circle</b></i>
 * @author	dreamer
 */
public class Circle implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * documented here {@link getCenter()}
	 * @generated	attribute definition
	 */
	private Point center;
	/**
	 * documented here {@link getRadius()}
	 * @generated	attribute definition
	 */
	private double radius;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs an unit circle in the center of the coordinate system
	 * @generated	constructor for class '<em><b>Circle</b></em>'
	 */
	public Circle() {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871354437_848983_304) ENABLED START */
		this.center = new Point();
		this.radius = 1.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * constructs a circle at the specified point with the specified radius
	 * @generated	constructor for class '<em><b>Circle</b></em>'
	 * @param	center	the center of the circle
	 * @param	radius	the distance from the center to the circle line
	 */
	public Circle(Point center, double radius) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463891828_217474_748) ENABLED START */
		this.center = center;
		this.radius = radius;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @generated	method stub for further implementation
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Circle.getCenterOfArea(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines if the form is crossing another form
	 * @generated	method stub for further implementation
	 * @param	form	the form to check for crossing
	 * @return	determines if the form is crossing another form
	 */
	public boolean isCrossing(Form form) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'Circle.isCrossing(...)'
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
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'Circle.move(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		// TODO: implementation of method 'Circle.rotate(...)'
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
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'Circle.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @generated	method stub for further implementation
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Circle.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
