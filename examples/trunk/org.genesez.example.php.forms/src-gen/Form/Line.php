<?php
require_once 'Form/Point.php';
require_once 'Form/Form.php';
require_once 'Color.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the geometrical form of a <i><b>line</b></i>
 * @see		Form_Form
 * @author	dreamer
 * @package	de.genesez.example.java.forms
 */
class Form_Line  implements Form_Form {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Form_Line::getStart()}
	 * @generated	attribute definition
	 * @var		Form_Point	$_start
	 */
	private $_start;
	/**
	 * documented here {@link Form_Line::getEnd()}
	 * @generated	attribute definition
	 * @var		Form_Point	$_end
	 */
	private $_end;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a line from the start, if specified to the specified end.
	 * 
	 * If the start is not specified the center of the coordinate system is used.
	 * @param	Form_Point	$end	the end point of the line
	 * @param	Form_Point	$start	the optional start point of the line, defaults to the center of the coordinate system
	 */
	public function __construct(Form_Point $end, Form_Point $start = null) {
		/* PROTECTED REGION ID(php.constructor._14_0_b6f02e1_1211871400078_573707_331) ENABLED START */
		$this->_end = $end;
		if ($start === null) {
			$this->_start = new Form_Point();
		} else {
			$this->_start = $start;
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea() {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'forms_Line.getCenterOfArea(...)'
		throw new Exception('The implementation of the method forms_Line::getCenterOfArea is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'forms_Line.isCrossing(...)'
		throw new Exception('The implementation of the method forms_Line::isCrossing is missing !');
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871374078_396988_308__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'forms_Line.move(...)'
		throw new Exception('The implementation of the method forms_Line::move is missing !');
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
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871374078_396988_308__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'forms_Line.rotate(...)'
		throw new Exception('The implementation of the method forms_Line::rotate is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * changes the color by repainting using the specified color
	 * @param	Color	$color	the color to use for repainting
	 */
	public function repaint(Color $color) {
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1211871374078_396988_308__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'forms_Line.repaint(...)'
		throw new Exception('The implementation of the method forms_Line::repaint is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Line' here
	/* PROTECTED REGION END */
}
?>
