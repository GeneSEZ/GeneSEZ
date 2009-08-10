<?php
require_once 'Form/Point.php';
require_once 'Form/Form.php';
require_once 'Color.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1249463754375_944273_708) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Describes the geometrical form <b>polygon</b>
 * @see		Form_Form
 * @author	dreamer
 * @package	de.genesez.example.java.forms
 */
class Form_Polygon  implements Form_Form {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Form_Polygon::getPoints()}
	 * @generated	attribute definition
	 * @var		Form_Point	$_points
	 */
	private $_points = array();
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a polygon with the specified points
	 * @param	array	$points	points describing a polygon in the given order
	 */
	public function __construct(array $points) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1249463814500_484130_734) ENABLED START */
		foreach ($points as $point) {
			if ($point !== null && $point instanceof Form_Point) {
				$this->_points[] = $point;
			}
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'forms_Polygon.getCenterOfArea(...)'
		throw new Exception('The implementation of the method forms_Polygon::getCenterOfArea is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'forms_Polygon.isCrossing(...)'
		throw new Exception('The implementation of the method forms_Polygon::isCrossing is missing !');
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249463754375_944273_708__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'forms_Polygon.move(...)'
		throw new Exception('The implementation of the method forms_Polygon::move is missing !');
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249463754375_944273_708__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'forms_Polygon.rotate(...)'
		throw new Exception('The implementation of the method forms_Polygon::rotate is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * changes the color by repainting using the specified color
	 * @param	Color	$color	the color to use for repainting
	 */
	public function repaint(Color $color) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249463754375_944273_708__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'forms_Polygon.repaint(...)'
		throw new Exception('The implementation of the method forms_Polygon::repaint is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1249463754375_944273_708) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Polygon' here
	/* PROTECTED REGION END */
}
?>
