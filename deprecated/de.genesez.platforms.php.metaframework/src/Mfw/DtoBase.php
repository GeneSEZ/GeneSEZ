<?php
require_once 'Mfw/Dto.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239096659828_207401_865) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a <b>default implementation</b> based on the object wrapper of 
 * arrays for data transfer objects.
 * @see		ArrayObject
 * @see		Mfw_Dto
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_DtoBase extends ArrayObject implements Mfw_Dto {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_DtoBase::getView()}
	 * @generated	attribute definition
	 * @var		string	$_view
	 */
	private $_view;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs a data transfer object. An optional container can be specified 
	 * used to store the content, see {@link ArrayObject}.
	 * @param	array	$container	an optional container which is used to store the content
	 * @param	string	$view	the optional identifier of the view
	 */
	public function __construct(array $container = array(), $view = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239096659828_334898_869) ENABLED START */
		parent::__construct($container, ArrayObject::ARRAY_AS_PROPS);
		$this->_view = $view;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Obtains the <b>identifier</b> of the <b>view</b> or template by which the 
	 * dto is used to <i>render</i> an output.
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239096659828_207401_865__16_0_b6f02e1_1239095244843_429695_734) ENABLED START */
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
