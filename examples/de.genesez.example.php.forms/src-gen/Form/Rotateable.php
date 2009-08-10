<?php
require_once 'Form/Point.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1214478880187_510458_215) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * describes things which can be <i><b>rotated</b></i>
 * @author	dreamer
 * @package	de.genesez.example.java.forms
 */
interface Form_Rotateable  {
	
	
	
	/**
	 * performs a rotations around the specified point by the specified angle.
	 * 
	 * If the parameter point is obmitted, the center of area of the form is used.
	 * @param	float	$phi	the angle in degrees
	 * @param	Form_Point	$center	the optional center of the rotation, default is the center of area of the form
	 */
	public function rotate($phi, Form_Point $center = null);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._14_0_b6f02e1_1214478880187_510458_215) ENABLED START */
	// TODO: put your further code declarations for interface 'forms_Rotateable' here
	/* PROTECTED REGION END */
}
?>
