<?php
require_once 'uml/Association.php';
require_once 'uml/AssociationBase.php';

class UML_OneAssociation extends UML_AssociationBase implements UML_Association {
	private $owner;
	private $variable;
	private $opposite;
	
	public function __construct(&$owner, &$variable, $opposite = null) {
		$this->owner = $owner;
		$this->variable = $variable;
		$this->opposite = $opposite;
	}
	
	public function insert(&$associated) {
		if ($this->variable !== $associated) {
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$to = $this->variable;
				if ($to !== null) {
					$to->$opposite->unlink($this->owner);
				}
				$this->variable = $associated;
				$associated->$opposite->link($this->owner);
			} else {
				$this->variable = $associated;
			}
			$this->variable = $associated;
		}
		return $associated;
	}
	public function remove(&$associated) {
		if ($this->variable === $associated) {
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$to = $this->variable;
				if ($to !== null) {
					$to->$opposite->unlink($this->owner);
				}
				$this->variable = null;
			} else {
				$this->variable = null;
			}
			return $associated;
		}
		return null;
	}
	public function get() {
		return $this->variable;
	}
	public function getAll() {
		if ($this->variable === null) {
			return array();
		} else {
			return array($this->variable);
		}
	}
	
	protected function isSymmetric() {
		return $this->opposite !== null;
	}
	protected function link(&$associated) {
		if ($this->isSymmetric()) {
			$to = $this->variable;
			if ($to !== null) {
				$opposite = &$this->opposite;
				$to->$opposite->unlink($this->owner);
			}
		}
		$this->variable = $associated;
	}
	protected function unlink(&$associated) {
		$this->variable = null;
	}
}
?>