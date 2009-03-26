<?php

class DDM_Type extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_type');

		$this->hasColumn('t_name', 'string', 1024, array('notnull' => true));
		$this->hasColumn('t_description', 'string', 1024);
		$this->hasColumn('t_basetype', 'enum', null, array('values' => array('INTEGER', 'BOOLEAN', 'STRING'), 'notnull' => true));
		$this->hasColumn('t_constraint', 'string', null);
		$this->hasColumn('t_editable', 'boolean', null, array('default' => true, 'notnull' => true));

		$this->index('name', array('fields' => array(0 => 'name'), 'type' => 'unique'));
	}

	public function setUp()
	{
		parent::setUp();
		$this->hasMany('DDM_Attribute as attributes', array('local' => 'id',
			'foreign' => 'type_id'));
	}
	
	public function __toString() {
		return 'Name: ' . $this->t_name;
	}

}

?>