<?php
require_once 'UML/Association.php';
require_once 'UML/QualifiedAssociationBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239725989468_606530_378) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_QualifiedAssociationBase
 * @author	dreamer
 * @package	UmlSupport
 */
class UML_MultiQualifiedAssociation extends UML_QualifiedAssociationBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		UML_Association	$associations
	 */
	protected $associations = array();
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link UML_MultiQualifiedAssociation}
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 * @param	boolean	$toMany	default value is 'false'
	 */
	public function __construct($owner, $variable, $opposite = null, $toMany = false) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239726216359_644894_659) ENABLED START */
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726330859_73254_674) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->associations[$qualifier]->insert($associated);
		} else {
			$this->variable[$qualifier] = null;
			$this->associations[$qualifier] = $this->createAssociation($qualifier);
			return $this->associations[$qualifier]->insert($associated);
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726330859_515689_675) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->associations[$qualifier]->remove($associated);
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726330859_2291_676) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->associations[$qualifier]->get();
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726330875_836506_677) ENABLED START */
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->associations[$qualifier]->getAll();
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239726330875_218919_678) ENABLED START */
		if ($qualifier === null) {
			if ($this->toMany === true) {
				// TODO: much work to do...
				throw new Exception('not yet implemented');
			} else {
				return new ArrayIterator($this->variable);
			}
		}
		if (array_key_exists($qualifier, $this->variable)) {
			return $this->associations[$qualifier]->iterator();
		}
		return new ArrayIterator(array());
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239725989468_606530_378) ENABLED START */
	// TODO: put your further code implementations for class 'UML_MultiQualifiedAssociation' here
	/* PROTECTED REGION END */
}
?>
