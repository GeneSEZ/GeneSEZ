<?php
require_once 'UML/Association.php';
require_once 'UML/QualifiedAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239725727578_8381_310) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_QualifiedAssociation
 * @author	dreamer
 * @package	UmlSupport
 */
abstract class UML_QualifiedAssociationBase  implements UML_QualifiedAssociation {
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
	/**
	 * @generated	attribute definition
	 * @var		boolean	$toMany
	 */
	protected $toMany;

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link UML_QualifiedAssociationBase}
	 * @generated	constructor stub for implementation
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 * @param	boolean	$toMany	default value is 'false'
	 */
	public function __construct($owner, $variable, $opposite = null, $toMany = false) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239725839750_17244_341) ENABLED START */
		$this->owner = $owner;
		$this->variable = $variable;
		$this->opposite = $opposite;
		$this->toMany = $toMany;
		if (!is_array($this->variable)) {
			$this->variable = array();
		}
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @return	UML_Association
	 */
	protected function createAssociation($qualifier) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239725945640_40248_350) ENABLED START */
		if ($this->toMany === true) {
			return new UML_ManyAssociation($this->owner, $this->variable[$qualifier], $this->opposite);
		} else {
			return new UML_OneAssociation($this->owner, $this->variable[$qualifier], $this->opposite);
		}
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239725727578_8381_310) ENABLED START */
	// TODO: put your further code implementations for class 'UML_QualifiedAssociationBase' here
	/* PROTECTED REGION END */
}
?>
