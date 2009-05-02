<?php
require_once 'UML/Association.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239223190765_606602_489) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_Association
 * @author	dreamer
 * @package	UmlSupport
 */
abstract class UML_AssociationBase  implements UML_Association {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$owner
	 */
	protected $owner;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$variable
	 */
	protected $variable;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$opposite
	 */
	protected $opposite;

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link UML_AssociationBase}
	 * @generated	constructor stub for implementation
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 */
	public function __construct($owner, &$variable, $opposite = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239224069812_771902_665) ENABLED START */
		$this->owner = $owner;
		$this->variable = &$variable;
		$this->opposite = $opposite;
		/* PROTECTED REGION END */
	}


	// -- method declarations -----------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected abstract function link($associated);

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected abstract function unlink($associated);

	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function isSymmetric() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223205781_569263_508) ENABLED START */
		return $this->opposite !== null;
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239223190765_606602_489) ENABLED START */
	// TODO: put your further code implementations for class 'UML_AssociationBase' here
	/* PROTECTED REGION END */
}
?>
