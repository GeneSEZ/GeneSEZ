package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871374078_396988_308) 
 */

import java.awt.Color;
/**
 * Describes the geometrical form of a <i><b>line</b></i>
 * @author	apflueger
 */
public class Line implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * documented here {@link getStart()}
	 * @generated	attribute definition
	 */
	private Point start;
	/**
	 * documented here {@link getEnd()}
	 * @generated	attribute definition
	 */
	private Point end;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs a line from the center of the coordinate system to the specified end
	 * @generated	constructor for class '<em><b>Line</b></em>'
	 * @param	end	the end point of the line
	 */
	public Line(Point end) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463876609_953505_745) ENABLED START */
		this.start = new Point();
		this.end = end;
		/* PROTECTED REGION END */
	}
	
	/**
	 * constructs a line from the specified start to the specified end
	 * @generated	constructor for class '<em><b>Line</b></em>'
	 * @param	start	the start point of the line
	 * @param	end	the end point of the line
	 */
	public Line(Point start, Point end) {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871400078_573707_331) ENABLED START */
		this.start = start;
		this.end = end;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @generated	method stub for further implementation
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Line.getCenterOfArea(...)'
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
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'Line.isCrossing(...)'
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
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'Line.move(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		// TODO: implementation of method 'Line.rotate(...)'
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
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'Line.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @generated	method stub for further implementation
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Line.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
