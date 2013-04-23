package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1211871374078_396988_308) 
 */
import java.awt.Color;

/**
 * Describes the geometrical form of a <i><b>line</b></i>
 */
public class Line extends AbstractForm {
	
	/**
	 * indicates the start point of the line
	 */
	private Point start;
	
	/**
	 * indicates the end point of the line
	 */
	private Point end;
	
	/**
	 * constructs a line from the center of the coordinate system to the specified end
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
	 * @param	start	the start point of the line
	 * @param	end	the end point of the line
	 */
	public Line(Point start, Point end) {
		/* PROTECTED REGION ID(java.constructor._14_0_b6f02e1_1211871400078_573707_331) ENABLED START */
		this.start = start;
		this.end = end;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
