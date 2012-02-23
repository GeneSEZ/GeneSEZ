<?php
require_once 'Form/Form.php';
require_once 'Form/Point.php';
require_once 'Color.php';
require_once 'UML/ManyAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1249543362015_69354_283) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * <p>
 *   describes a complex <b>figure</b> by a composition of forms
 * </p>
 * @see		Form_Form
 * @author	dreamer
 * @package	de.genesez.example.java.forms
 */
class Form_Figure  implements Form_Form {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @var	array of Form_Form	stores the linked objects of the  unidirectional to many association to {@link Form_Form} (symmetry ensured) ({@link __get() documented here})
	 */
	private $_forms = array();
	/**
	 * holds the association management object for the unidirectional to many association to {@link Form_Form} (symmetry ensured)
	 * @var UML_ManyAssociation
	 */
	private $associations;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * determines the center of area of the form
	 * @return	Form_Point
	 */
	public function getCenterOfArea() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		// TODO: implementation of method 'forms_Figure.getCenterOfArea(...)'
		throw new Exception('The implementation of the method forms_Figure::getCenterOfArea is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * determines if the form is crossing another form
	 * @param	Form_Form	$form	the form to check for crossing
	 * @return	boolean
	 */
	public function isCrossing(Form_Form $form) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		// TODO: implementation of method 'forms_Figure.isCrossing(...)'
		throw new Exception('The implementation of the method forms_Figure::isCrossing is missing !');
		/* PROTECTED REGION END */
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	float	$dx	delta value to move in <i><b>x</b></i> direction
	 * @param	float	$dy	delta value to move in <i><b>y</b></i> direction
	 */
	public function move($dx, $dy) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		// TODO: implementation of method 'forms_Figure.move(...)'
		throw new Exception('The implementation of the method forms_Figure::move is missing !');
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		// TODO: implementation of method 'forms_Figure.rotate(...)'
		throw new Exception('The implementation of the method forms_Figure::rotate is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * changes the color by repainting using the specified color
	 * @param	Color	$color	the color to use for repainting
	 */
	public function repaint(Color $color) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		// TODO: implementation of method 'forms_Figure.repaint(...)'
		throw new Exception('The implementation of the method forms_Figure::repaint is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>forms</var>: [the form objects this figure consists of
]</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'forms' :
				if ($this->associations === null) {
					$this->associations = new UML_ManyAssociation($this, $this->_forms);
				}
				return $this->associations;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1249543362015_69354_283) ENABLED START */
	// TODO: put your further code implementations for class 'forms_Figure' here
	/* PROTECTED REGION END */
}
?>
