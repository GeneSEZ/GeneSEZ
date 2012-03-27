<?php
require_once 'Form/Point.php';
require_once 'Form/Polygon.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1249464030468_592473_783) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the geometrical form <b>triangle</b> as a special <i>polygon</i>
 * @see		Form_Polygon
 * @author	nicher
 * @package	de.genesez.example.java.forms
 */
class Form_Triangle extends Form_Polygon  {
	
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a triangle with the points in the specified order
	 * @param	Form_Point	$a	the first point of the triangle
	 * @param	Form_Point	$b	the second point of the triangle
	 * @param	Form_Point	$c	the third point of the triangle
	 */
	public function __construct(Form_Point $a, Form_Point $b, Form_Point $c) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1249464090812_470196_811) ENABLED START */
		parent::__construct(array($a, $b, $c));
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1249464030468_592473_783) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Triangle' here
	/* PROTECTED REGION END */
}
?>
