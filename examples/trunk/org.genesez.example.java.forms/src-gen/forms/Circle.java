package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871307421_631477_281) 
 */
import game.Scene;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871307421_631477_281) 
 */
import java.awt.Color;

/**
 * describes the geometrical shape of a <i><b>circle</b></i>
 */
public class Circle extends AbstractForm {
	
	/**
	 * the distance from the center to the circle line
	 */
	private double radius;
	
	/**
	 * the center of the circle
	 */
	private Point center;
	
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
	public Circle(Point center, double radius) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463891828_217474_748) ENABLED START */
		this.center = center;
		this.radius = radius;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
