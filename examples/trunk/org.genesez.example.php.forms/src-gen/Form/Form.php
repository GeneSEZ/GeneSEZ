<?php
require_once 'Form/Point.php';
require_once 'Form/Moveable.php';
require_once 'Form/Rotateable.php';
require_once 'Form/Paintable.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the common behavior of a geometrical forms
 * @see		Form_Moveable
 * @see		Form_Rotateable
 * @see		Form_Paintable
 * @author	dreamer
 * @package	de.genesez.example.java.forms
 */
interface Form_Form extends Form_Moveable, Form_Rotateable, Form_Paintable {
	
	
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea();

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
	// TODO: put your further code declarations for interface 'forms_Form' here
	/* PROTECTED REGION END */
}
?>
