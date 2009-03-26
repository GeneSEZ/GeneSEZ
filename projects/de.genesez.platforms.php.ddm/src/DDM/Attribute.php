<?php

class DDM_Attribute extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_attribute');

		$this->hasColumn('a_class', 'integer', null);
		$this->hasColumn('a_type', 'integer', null);
		$this->hasColumn('a_name', 'string', 1024, array('notnull' => true));
		$this->hasColumn('a_column', 'string', 1024, array('notnull' => true));
		$this->hasColumn('a_description', 'string', 255, array('notnull' => true));
	}

	public function setUp()
	{
		parent::setUp();
		$this->hasOne('DDM_Class as class', array('local' => 'a_class',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));

		$this->hasOne('DDM_Type as type', array('local' => 'a_type',
			'foreign' => 'id',
			'onDelete' => 'RESTRICT'));
	}

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