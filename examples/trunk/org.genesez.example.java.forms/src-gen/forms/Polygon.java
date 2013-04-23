package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249463754375_944273_708) 
 */
import game.Scene;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249463754375_944273_708) 
 */
import java.awt.Color;

/**
 * Describes the geometrical form <b>polygon</b>
 */
public class Polygon extends AbstractForm {
	
	/**
	 * the points a polygon consists of
	 */
	private Point[] points = null;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249463754375_944273_708) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
