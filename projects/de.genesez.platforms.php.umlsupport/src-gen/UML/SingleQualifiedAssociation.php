<?php
require_once 'UML/Association.php';
require_once 'UML/QualifiedAssociationBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239725977437_641495_355) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_QualifiedAssociationBase
 * @author	dreamer
 * @package	UmlSupport
 */
class UML_SingleQualifiedAssociation extends UML_QualifiedAssociationBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		UML_Association	$association
	 */
	protected $association;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link UML_SingleQualifiedAssociation}
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 * @param	boolean	$toMany	default value is 'false'
	 */
	public function __construct($owner, $variable, $opposite = null, $toMany = false) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239726038328_991078_624) ENABLED START */
		parent::__construct($owner, $variable, $opposite, $toMany);
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function insert($qualifier, $associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726163609_13805_635) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->association->insert($associated);
		} else {
			$this->variable = array($qualifier => null);
			$this->association = $this->createAssociation($qualifier);
			return $this->association->insert($associated);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function remove($qualifier, $associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726163609_972222_636) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->association->remove($associated);
		}
		return null;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @return	mixed
	 */
	public function get($qualifier) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726163609_272208_637) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->association->get();
		}
		return null;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @return	array of mixed
	 */
	public function getAll($qualifier) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726163609_831792_638) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->association->getAll();
		}
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	default value is 'null'
	 * @return	Iterator
	 */
	public function iterator($qualifier = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726163609_547169_639) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->association->iterator();
		}
		return new ArrayIterator(array());
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239725977437_641495_355) ENABLED START */
	// TODO: put your further code implementations for class 'UML_SingleQualifiedAssociation' here
	/* PROTECTED REGION END */
}
?>
