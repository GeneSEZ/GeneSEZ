<?php

class DDM_Class extends Doctrine_Record
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

	/**
	 * 
	 */
	public function getAssociations() {
		return new ArrayObject( array_merge($this->leftSides->getData(), $this->rightSides->getData()) );
	}
	
	/**
	 * Return a specified association
	 *
	 * @param string $name
	 * @return boolean
	 */
	public function getAssociation($name) {
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
	public function hasAssociation($name) {
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
	public function hasAttribute($name) {
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
	public function __get($name) {
		if ( 'associations' === $name ) {
			return $this->getAssociations();
		}
		else {
			return parent::__get($name);
		}
	}

	public function __set($name, $value) {
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

	public function __toString() {
		return 'Name: ' . $this->c_name . ', View: ' . $this->c_view;
	}
}

?>