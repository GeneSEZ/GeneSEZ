<?php
require_once 'uml/Association.php';
require_once 'uml/AssociationBase.php';

class UML_ManyAssociation extends UML_AssociationBase implements UML_Association {
	private $owner;
	private $variable;
	private $opposite;
	private $iterator;
	
	function __construct(&$owner, &$variable, $opposite = null) {
		$this->owner = $owner;
		$this->variable = $variable;
		if (!is_array($this->variable)) {
			$this->variable = array();
		}
		$this->renewIterator();
		$this->opposite = $opposite;
	}
	
	public function insert(&$associated) {
		if (!in_array($associated, $this->variable, true)) {
			$this->variable[] = $associated;
			$this->renewIterator();
			if ($this->isSymmetric()) {
				$opposite = &$this->opposite;
				$associated->$opposite->link($this->owner);
			}
		}
		return $associated;
	}
	// TODO: check parameter, if object or array (remove more than one value at ones?)
	public function remove(&$associated) {
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
	}
	public function get() {
		$return = null;
		if ($this->iterator->valid()) {
			$return = &$this->iterator->current();
		}
		$this->iterator->next();
		if (!$this->iterator->valid()) {
			$this->iterator->rewind();
		}
		return $return;
	}
	public function getAll() {
		return array_values($this->variable);
	}
	
	protected function isSymmetric() {
		return $this->opposite !== null;
	}
	protected function link(&$associated) {
		$this->variable[] = $associated;
		$this->renewIterator();
	}
	protected function unlink(&$associated) {
		$offset = array_search($associated, $this->variable, true);
		if ($offset !== false) {
			$removed = array_splice($this->variable, $offset, 1);
		} else {
			// should not happen
		}
		$this->renewIterator();
	}
	protected function renewIterator() {
		$this->iterator = new ArrayIterator($this->variable);
	}
}
?>