<?php
require_once 'Mfw/Dto.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239096659828_207401_865) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		ArrayObject
 * @see		Mfw_Dto
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_DtoBase extends ArrayObject implements Mfw_Dto {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		string	$_view
	 */
	private $_view;

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Mfw_DtoBase}
	 * @generated	constructor stub for implementation
	 * @param	array	$container	default value is 'array()'
	 * @param	string	$view	default value is 'null'
	 */
	public function __construct($container = array(), $view = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239096659828_334898_869) ENABLED START */
		parent::__construct($container, ArrayObject::ARRAY_AS_PROPS);
		$this->_view = $view;
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239098298031_853627_1056) ENABLED START */
		return $this->_view;
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239096659828_207401_865) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_DtoBase' here
	/* PROTECTED REGION END */
}
?>
