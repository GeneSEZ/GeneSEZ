<?php

require_once('DDM/BaseDDM_Attribute.php');

class DDM_Attribute extends BaseDDM_Attribute
{

	function __set($name, $value) {
		if ($name === 'a_name') {
			$column = preg_replace('/[^a-zA-Z0-9]/', '', $value);
			$this->a_column = $column;
		} elseif ($name === 'a_column') {
			if ( preg_match('/[^a-zA-Z0-9]/', $value) ) {
				throw new DDM_Exception('Wrong name for column: ' . $value);
			}
		}
		parent::__set($name, $value);
	}

	function __toString() {
		return 'Name: ' . $this->a_name . ', Column: ' . $this->a_column;
	}

}

?>