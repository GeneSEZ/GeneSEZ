package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871307421_631477_281) 
 */

import traceability.ScenarioStep;
import static traceability.Requirement.Value.R1;
import org.genesez.platform.java.umlsupport.associations.*;
import traceability.Requirement;
import java.awt.Color;
import static traceability.Scenario.Value.S2;
import static traceability.ScenarioStep.Value.ST2_2;
import traceability.Scenario;

/**
 * describes the geometrical shape of a <i><b>circle</b></i>
 * @author domwet
 */
@Scenario({
	S2
})
@Requirement({
	R1
})
public class Circle implements Form {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * the center of the circle
	 */
	private Point center;
	
	/**
	 * the distance from the center to the circle line
	 */
	private double radius;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructs an unit circle in the center of the coordinate system
	 */
	public Circle() {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871354437_848983_304) ENABLED START */
		this.center = new Point();
		this.radius = 1.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * constructs a circle at the specified point with the specified radius
	 * @param	center	the center of the circle
	 * @param	radius	the distance from the center to the circle line
	 */
	@ScenarioStep({
		ST2_2
	})
	public Circle(Point center, double radius) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463891828_217474_748) ENABLED START */
		this.center = center;
		this.radius = radius;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * determines the center of area of the form
	 * @return	the location of the center of area
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'Circle.getCenterOfArea(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines if the form is crossing another form
	 * @param	form	the form to check for crossing
	 * @return	true, if the specified form crosses this form, otherwise false
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
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'Circle.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
