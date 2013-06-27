<?php
require_once 'Form/Form.php';
require_once 'Color.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes a <i><b>point</b></i> in a 2-dimensional coordinate system
 * @see		Form_Form
 * @author	nicher
 * @package	de.genesez.example.java.forms
 */
class Form_Point  implements Form_Form {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Form_Point::getX()}
	 * @generated	attribute definition
	 * @var		float	$_x
	 */
	private $_x;
	/**
	 * documented here {@link Form_Point::getY()}
	 * @generated	attribute definition
	 * @var		float	$_y
	 */
	private $_y;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a point using the optional coordinate values
	 * @param	float	$x	the optional x-coordinate value of the point, defaults to zero
	 * @param	float	$y	the optional y-coordinate value of the point, defaults to zero
	 */
	public function __construct($x = 0.0, $y = 0.0) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1249463853031_881157_741) ENABLED START */
		$this->_x = $x;
		$this->_y = $y;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea() {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		return new Form_Point($this->_x, $this->_y);
		/* PROTECTED REGION END */
	}

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'forms_Point.isCrossing(...)'
		throw new Exception('The implementation of the method forms_Point::isCrossing is missing !');
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871095796_723781_254__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'forms_Point.move(...)'
		throw new Exception('The implementation of the method forms_Point::move is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * performs a rotations around the specified point by the specified angle.
	 * 
	 * If the parameter point is obmitted, the center of area of the form is used.
	 * @param	float	$phi	the angle in degrees
	 * @param	Form_Point	$center	the optional center of the rotation, default is the center of area of the form
	 */
	public function rotate($phi, Form_Point $center = null) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871095796_723781_254__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'forms_Point.rotate(...)'
		throw new Exception('The implementation of the method forms_Point::rotate is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * changes the color by repainting using the specified color
	 * @param	Color	$color	the color to use for repainting
	 */
	public function repaint(Color $color) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871095796_723781_254__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'forms_Point.repaint(...)'
		throw new Exception('The implementation of the method forms_Point::repaint is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Point' here
	/* PROTECTED REGION END */
}
?>
