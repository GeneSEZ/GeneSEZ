package forms;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._14_0_b6f02e1_1214478880187_510458_215) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * describes things which can be <i><b>rotated</b></i>
 * @author	dreamer
 */
public interface Rotateable {
	
	/**
	 * performs a rotation by the specified angle
	 * @generated	method stub for further implementation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi);
	
	/**
	 * performs a rotations around the specified point by the specified angle
	 * @generated	method stub for further implementation
	 * @param	center	the center of the rotation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(Point center, double phi);
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._14_0_b6f02e1_1214478880187_510458_215) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
