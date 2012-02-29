package forms;

import java.awt.Color;
import java.util.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1249543362015_69354_283) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * <p>
 *   describes a complex <b>figure</b> by a composition of forms
 * </p>
 * @author	dreamer
 */
public class Figure implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * variable for association to Form
	 */
	private java.util.Set forms = new java.util.HashSet();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @generated	method stub for further implementation
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Figure.getCenterOfArea(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'Figure.isCrossing(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'Figure.move(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		// TODO: implementation of method 'Figure.rotate(...)'
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
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'Figure.rotate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @generated	method stub for further implementation
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Figure.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * accessor for association to forms
	 * <html>;   <head>;     ;   </head>;   <body>;     the form objects this figure consists of;   </body>; </html>; 
	 */
	public java.util.Set getForms() {
		return java.util.Collections.unmodifiableSet(forms);
	}
	
	/**
	 * accessor for association to forms
	 * @see {@link getForms}
	 */
	public void insertInForms(Form forms) {
		if (this.forms.contains(forms)) {
			return;
		}
		this.forms.add(forms);
	}
	
	/**
	 * accessor for association to forms
	 * @see {@link getForms}
	 */
	public void removeFromForms(Form forms) {
		if (!this.forms.contains(forms)) {
			return;
		}
		this.forms.remove(forms);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249543362015_69354_283) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
