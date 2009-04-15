<?php
require_once 'UML/AssociationBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239223376703_89982_525) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		UML_AssociationBase
 * @author	dreamer
 * @package	UmlSupport
 */
class UML_OneAssociation extends UML_AssociationBase  {

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link UML_OneAssociation}
	 * @generated	constructor stub for implementation
	 * @param	mixed	$owner	
	 * @param	mixed	$variable	
	 * @param	mixed	$opposite	default value is 'null'
	 */
	public function __construct($owner, $variable, $opposite = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1239223439078_306373_553) ENABLED START */
		parent::__construct($owner, $variable, $opposite);
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function insert($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223542125_225880_560) ENABLED START */
		if ($this->getReference() !== $associated) {
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$to = $this->getReference();
				if ($to !== null) {
					$to->$opposite->unlink($this->owner);
				}
				$this->setReference($associated);
				$associated->$opposite->link($this->owner);
			} else {
				$this->setReference($associated);
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223557609_549691_564) ENABLED START */
		if ($this->getReference() === $associated) {
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$to = $this->getReference();
				if ($to !== null) {
					$to->$opposite->unlink($this->owner);
				}
				$this->setReference(null);
			} else {
				$this->setReference(null);
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223557609_889752_565) ENABLED START */
		return $this->getReference();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getAll() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223557609_740040_566) ENABLED START */
		if ($this->getReference() === null) {
			return array();
		} else {
			return array($this->getReference());
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Iterator
	 */
	public function iterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223557625_384024_567) ENABLED START */
		if ($this->getReference() === null) {
			return new ArrayIterator(array());
		} else {
			return new ArrayIterator(array($this->getReference()));
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected function link($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223581453_354740_578) ENABLED START */
		if ($this->isSymmetric()) {
			$to = $this->getReference();
			if ($to !== null) {
				$opposite = &$this->opposite;
				$to->$opposite->unlink($this->owner);
			}
		}
		$this->setReference($associated);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 */
	protected function unlink($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239223581453_963115_579) ENABLED START */
		$this->setReference(null);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	mixed
	 */
	protected function getReference() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239353543546_744868_622) ENABLED START */
		return $this->variable;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	protected function setReference($associated) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239353543546_554252_623) ENABLED START */
		$this->variable = $associated;
		return $this->variable;
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239223376703_89982_525) ENABLED START */
	// TODO: put your further code implementations for class 'UML_OneAssociation' here
	/* PROTECTED REGION END */
}
?>
