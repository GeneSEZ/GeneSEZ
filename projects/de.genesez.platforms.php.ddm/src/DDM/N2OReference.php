<?php

class DDM_N2OReference extends DDM_Reference
{
	private $to = null;
	private $from = null;
	
	public function __set($name, $value) {
		if ( 'to' === $name ) {
			$this->to = $value;
			$this->modified = true;
		} elseif ( 'from' === $name ) {
			$this->from = $value;
			$this->modified = true;
		} else {
			parent::__set($name, $value);
		}
	}

	public function __get($name) {
		if ( 'to' === $name ) {
			return $this->to;
		} elseif ( 'from' === $name ) {
			return $this->from;
		} else {
			return parent::__set($name, $value);
		}
	}
	
	public function save() {
		echo "Save\n"; 
	}

	public function load(DDM_Object $from) {
	}
}

?>