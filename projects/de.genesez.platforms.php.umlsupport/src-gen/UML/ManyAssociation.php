<?php
require_once 'UML/AssociationBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239223716375_693657_589) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_AssociationBase
 * @author	dreamer
 * @package	UmlSupport
 */
class UML_ManyAssociation extends UML_AssociationBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		Iterator	$iterator
	 */
	protected $iterator;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link UML_ManyAssociation}
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 */
	public function __construct($owner, &$variable, $opposite = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239223810921_908628_619) ENABLED START */
		parent::__construct($owner, $variable, $opposite);
		if (!is_array($this->variable)) {
			$this->variable = array();
		}
		$this->renewIterator();
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function insert($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223884906_322162_631) ENABLED START */
		if (!in_array($associated, $this->variable, true)) {
			$this->variable[] = $associated;
			$this->renewIterator();
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$associated->$opposite->link($this->owner);
			}
		}
		return $associated;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function remove($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223884906_453925_632) ENABLED START */
		if (in_array($associated, $this->variable, true)) {
			$offset = array_search($associated, $this->variable, true);
			if ($offset !== false) {
				$removed = array_splice($this->variable, $offset, 1);
			} else {
				// can not happen
			}
			$this->renewIterator();
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$associated->$opposite->unlink($this->owner);
			}
			return $associated;
		}
		return null;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	mixed
	 */
	public function get() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223884906_816831_633) ENABLED START */
		$return = null;
		if ($this->iterator->valid()) {
			$return = &$this->iterator->current();
		}
		$this->iterator->next();
		if (!$this->iterator->valid()) {
			$this->iterator->rewind();
		}
		return $return;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getAll() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223884906_959308_634) ENABLED START */
		return array_values($this->variable);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Iterator
	 */
	public function iterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223884906_999753_635) ENABLED START */
		return new ArrayIterator($this->variable);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected function link($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223888812_243604_649) ENABLED START */
		$this->variable[] = $associated;
		$this->renewIterator();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected function unlink($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223888812_325355_650) ENABLED START */
		$offset = array_search($associated, $this->variable, true);
		if ($offset !== false) {
			$removed = array_splice($this->variable, $offset, 1);
		} else {
			// should not happen
		}
		$this->renewIterator();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function renewIterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223854125_806699_627) ENABLED START */
		$this->iterator = new ArrayIterator($this->variable);
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239223716375_693657_589) ENABLED START */
	// TODO: put your further code implementations for class 'UML_ManyAssociation' here
	/* PROTECTED REGION END */
}
?>
