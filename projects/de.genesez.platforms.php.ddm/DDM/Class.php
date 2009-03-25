<?php

require_once('DDM/BaseDDM_Class.php');

class DDM_Class extends BaseDDM_Class
{
	/**
	 * 
	 */
	function getAssociations() {
		return new ArrayObject( array_merge($this->leftSides->getData(), $this->rightSides->getData()) );
	}
	
	/**
	 * Return a specified association
	 *
	 * @param string $name
	 * @return boolean
	 */
	function getAssociation($name) {
		foreach ($this->associations as $s) {
			if ( $s->s_name == $name ) {
				return $s;
			}
		}
		return null;
	}

	/**
	 * Test if the class has a specified association
	 *
	 * @param string $name
	 * @return boolean
	 */
	function hasAssociation($name) {
		foreach ($this->associations as $s) {
			if ( $s->s_name == $name ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Test if the class has a specified attribute
	 *
	 * @param string $name
	 * @return boolean
	 */
	function hasAttribute($name) {
		foreach ($this->attributes as $a) {
			if ( $a->a_name == $name ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Overrides the magic __get method of Doctrine_Record 
	 *
	 * @param string $name
	 * @return mixed
	 */
	function __get($name) {
		if ( 'associations' == $name ) {
			return $this->getAssociations();
		}
		else {
			return parent::__get($name);
		}
	}

	function __set($name, $value) {
		if ($name === 'c_name') {
			$view = preg_replace('/[^a-zA-Z0-9]/', '', $value);
			$this->c_view = $view;
		} elseif ($name === 'c_view') {
			if ( preg_match('/[^a-zA-Z0-9]/', $value) ) {
				throw new DDM_Exception('Wrong name for view: ' . $value);
			}
		}
		parent::__set($name, $value);
	}
	
	function __toString() {
		return 'Name: ' . $this->c_name . ', View: ' . $this->c_view;
	}
	
	/**
	 * Overrides the Doctrine constructor
	 * 
	 * @return void
	 */
/*	function construct() {
		if ( $this->id <= 0 ) {
			return;
		}
	}*/
}

?>