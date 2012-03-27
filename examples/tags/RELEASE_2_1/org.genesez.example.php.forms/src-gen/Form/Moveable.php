<?php

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1214478843156_556754_163) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * describes things which can be <i><b>moved</b></i>
 * @author	nicher
 * @package	de.genesez.example.java.forms
 */
interface Form_Moveable  {
	
	
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._14_0_b6f02e1_1214478843156_556754_163) ENABLED START */
	// TODO: put your further code declarations for interface 'forms_Moveable' here
	/* PROTECTED REGION END */
}
?>
