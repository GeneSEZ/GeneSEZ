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

		$this->hasMany('DDM_Association as associations', array('local' => 'id',
			'foreign' => 's_from'));
		
	}

	public function createObject() {
		$o = new DDM_Object();
		$o->class = $this;
		return $o;
	}
	
	public function addAssociation($name, DDM_Class $class, $foreignCardinality = 1, $myCardinality = 1, $description = null ) {
		$association = $this->addAssociationTo($name, $class, $foreignCardinality, $myCardinality);
		$class->addAssociationFrom($this->c_name, $association);
	}
	
	public function addAssociationTo($name, DDM_Class $class, $foreignCardinality = 1, $myCardinality = 1, $description = null) {
		$association = new DDM_Association();
		$association->s_name = $name;
		$association->from = $this;
		$association->to = $class;
		$association->s_from_cardinality = $myCardinality;
		$association->s_to_cardinality = $foreignCardinality;
		if ( null !== $description ) {
			$association->s_description = $description;
		}
		$association->save();
		return $association;
	}
	
	public function addAssociationFrom($name, $association) {
		$reverseAssociation = new DDM_Reverse_Association();
		$reverseAssociation->s_name = $name;
		$reverseAssociation->association = $association;
		$reverseAssociation->save();
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
		return $this->getReverseAssociation($name);
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
		return $this->hasReverseAssociation($name);
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
		if (null !== $this->c_parent) {
			return $this->parent->hasAttribute($name);
		}
		return false;
	}

	public function __get($name) {
/*		if ('attributes' === $name ) {
			if ( isset($this->parent) ) {
				return array_merge(parent::__get('attributes')->toArray(), $this->parent->attributes);
			} else {
				return parent::__get('attributes')->toArray();
			}
		}
		if ('associations' === $name ) {
			if ( isset($this->parent) ) {
				return array_merge(parent::__get('associations')->toArray(), $this->parent->associations);
			} else {
				return parent::__get('associations')->toArray();
			}
		}*/
		return parent::__get($name);
	}
	
	/**
	 * Overrides the magic __set method of Doctrine_Record 
	 *
	 * @param string $name
	 * @param string $value
	 * @return mixed
	 */
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

	/**
	 * Returns string representaion of the class object 
	 *
	 * @return string
	 */
	public function __toString() {
		return 'Name: ' . $this->c_name . ', View: ' . $this->c_view;
	}
	
	public function getReverseAssociations() {
		$query = Doctrine_Query::create()
			->from('ddm_reverse_association r')
			->leftJoin('r.association a')
			->addWhere('a.s_to = ?', $this->id);
		return $query->execute();
	}
	
	private function getReverseAssociation($name) {
		if ( $this->hasReverseAssociation($name) ) {
			$query = Doctrine_Query::create()
				->from('ddm_reverse_association r')
				->leftJoin('r.association a')
				->addWhere('a.s_to = ?', $this->id)
				->addWhere('r.s_name LIKE ?', $name);
			return $query->fetchOne();
		}
		return null;
	}
	
	private function hasReverseAssociation($name) {
		$query = Doctrine_Query::create()
			->from('ddm_reverse_association r')
			->leftJoin('r.association a')
			->addWhere('a.s_to = ?', $this->id)
			->addWhere('r.s_name LIKE ?', $name);
		$result = $query->execute();
		return 0 < $result->count();
	}
}

?>