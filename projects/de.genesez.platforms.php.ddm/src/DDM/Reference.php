<?php

abstract class DDM_Reference {	
	
	protected $association = null;
	protected $modified = false;
	
	public function __set($name, $value) {
		$this->{$name} = $value;
	}

	public function __get($name) {
		return $this->{$name};
	}
	
	public function isModified() {
		return $this->modified;
	}
	
	public abstract function save();

	public abstract function load(DDM_Object $from);
}

?>