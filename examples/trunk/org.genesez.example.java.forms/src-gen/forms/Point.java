package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871095796_723781_254) 
 */
import java.awt.Color;
import java.math.*;

/**
 * Describes a <i><b>point</b></i> in a 2-dimensional coordinate system
 */
public class Point extends AbstractForm {
	
	/**
	 * the x coordinate value
	 */
	private double x;
	
	/**
	 * the y coordinate value
	 */
	private double y;
	
	/**
	 * constructs a point in the center of the coordinate system
	 */
	public Point() {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871240109_473577_277) ENABLED START */
		this.x = 0.0;
		this.y = 0.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * constructs a point using the specified coordinate values
	 * @param	x	the x-coordinate value of the point
	 * @param	y	the y-coordinate value of the point
	 */
	public Point(double x, double y) {
		/* PROTECTED REGION ID(java.constructor._16_0_b6f02e1_1249463853031_881157_741) ENABLED START */
		this.x = x;
		this.y = y;
		/* PROTECTED REGION END */
	}
	
	/**
	 * the x coordinate value
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * the y coordinate value
	 */
	public double getY() {
		return y;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
