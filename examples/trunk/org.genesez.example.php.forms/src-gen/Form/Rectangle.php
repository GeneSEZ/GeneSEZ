<?php
require_once 'Form/Point.php';
require_once 'Form/Polygon.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1249464012328_770017_760) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the geometrical form <b>rectangle</b> as a specic <i>polygon</i>
 * @see		Form_Polygon
 * @author	nicher
 * @package	de.genesez.example.java.forms
 */
class Form_Rectangle extends Form_Polygon  {
	
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a rectangle by the 2 diagonally points
	 * @param	Form_Point	$a	the lower left point of the rectangle
	 * @param	Form_Point	$c	the upper right point of the rectangle
	 */
	public function __construct(Form_Point $a, Form_Point $c) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1249464153812_196550_828) ENABLED START */
		parent::__construct(array($a, new Form_Point($c->x, $a->y), $c, new Form_Point($a->x, $c->y)));
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1249464012328_770017_760) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Rectangle' here
	/* PROTECTED REGION END */
}
?>
