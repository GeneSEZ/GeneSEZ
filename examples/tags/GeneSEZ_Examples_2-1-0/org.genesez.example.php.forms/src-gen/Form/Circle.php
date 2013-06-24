<?php
require_once 'Form/Point.php';
require_once 'Form/Form.php';
require_once 'Color.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * describes the geometrical shape of a <i><b>circle</b></i>
 * @see		Form_Form
 * @author	nicher
 * @package	de.genesez.example.java.forms
 */
class Form_Circle  implements Form_Form {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Form_Circle::getCenter()}
	 * @generated	attribute definition
	 * @var		Form_Point	$_center
	 */
	private $_center;
	/**
	 * documented here {@link Form_Circle::getRadius()}
	 * @generated	attribute definition
	 * @var		float	$_radius
	 */
	private $_radius;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a circle at the optional point with the optional radius.
	 * 
	 * If no parameter is specified an unit circle is created.
	 * @param	Form_Point	$center	the optional center of the circle, defaults to the center of the coordinate system
	 * @param	float	$radius	the optional distance from the center to the circle line, defaults to one unit (1.0)
	 */
	public function __construct(Form_Point $center = null, $radius = 1.0) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1249463891828_217474_748) ENABLED START */
		if ($center === null) {
			$this->_center = new Form_Point();
		} else {
			$this->_center = $center;
		}
		$this->_radius = $radius;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea() {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		return new Form_Point($this->_center->x, $this->_center->y);
		/* PROTECTED REGION END */
	}

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'forms_Circle.isCrossing(...)'
		throw new Exception('The implementation of the method forms_Circle::isCrossing is missing !');
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871307421_631477_281__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'forms_Circle.move(...)'
		throw new Exception('The implementation of the method forms_Circle::move is missing !');
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
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871307421_631477_281__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'forms_Circle.rotate(...)'
		throw new Exception('The implementation of the method forms_Circle::rotate is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * changes the color by repainting using the specified color
	 * @param	Color	$color	the color to use for repainting
	 */
	public function repaint(Color $color) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871307421_631477_281__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'forms_Circle.repaint(...)'
		throw new Exception('The implementation of the method forms_Circle::repaint is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Circle' here
	/* PROTECTED REGION END */
}
?>
