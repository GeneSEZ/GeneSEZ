package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249463754375_944273_708) 
 */

import java.awt.Color;
/**
 * Describes the geometrical form <b>polygon</b>
 * @author	apflueger
 */
public class Polygon implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * documented here {@link getPoints()}
	 * @generated	attribute definition
	 */
	private Point[] points = null;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs a polygon with the specified points
	 * @generated	constructor for class '<em><b>Polygon</b></em>'
	 * @param	points	points describing a polygon in the given order
	 */
	public Polygon(Point[] points) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463814500_484130_734) ENABLED START */
		this.points = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			this.points[i] = points[i];
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @generated	method stub for further implementation
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Polygon.getCenterOfArea(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'Polygon.isCrossing(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'Polygon.move(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		// TODO: implementation of method 'Polygon.rotate(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'Polygon.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @generated	method stub for further implementation
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Polygon.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249463754375_944273_708) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
