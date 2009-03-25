<?php

abstract class BaseDDM_Class extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_class');

		$this->hasColumn('c_parent', 'integer', null);
		$this->hasColumn('c_name', 'string', 1024, array('notnull' => true));
		$this->hasColumn('c_view', 'string', 1024, array('notnull' => true));
		$this->hasColumn('c_description', 'string', 1024);
		$this->hasColumn('c_editable', 'boolean', null, array('default' => true, 'notnull' => true));

		$this->index('name', array('fields' => array(0 => 'name'), 'type' => 'unique'));
	}

	public function setUp()
	{
		parent::setUp();
		$this->hasOne('DDM_Class as parent', array('local' => 'c_parent',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));

		$this->hasMany('DDM_Object as objects', array('local' => 'id',
			'foreign' => 'o_class'));

		$this->hasMany('DDM_Class as children', array('local' => 'id',
			'foreign' => 'c_parent'));

		$this->hasMany('DDM_Attribute as attributes', array('local' => 'id',
			'foreign' => 'a_class'));

		$this->hasMany('DDM_Association as leftSides', array('local' => 'id',
			'foreign' => 's_left'));

		$this->hasMany('DDM_Association as rightSides', array('local' => 'id',
			'foreign' => 's_right'));
	}

}
