package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249463754375_944273_708) 
 */

import traceability.ScenarioStep;
import org.genesez.platform.java.umlsupport.associations.*;
import traceability.Requirement;
import java.awt.Color;
import traceability.Scenario;

/**
 * Describes the geometrical form <b>polygon</b>
 * @author domwet
 */
public class Polygon implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * the points a polygon consists of
	 */
	
	private Point[] points = null;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs a polygon with the specified points
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
	 * @return	the location of the center of area
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Polygon.getCenterOfArea(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines if the form is crossing another form
	 * @param	form	the form to check for crossing
	 * @return	true, if the specified form crosses this form, otherwise false
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
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Polygon.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249463754375_944273_708) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
