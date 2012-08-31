<?php

class DDM_Object extends Doctrine_Record
{

	private $attributes = array();
	private $associations = array();

	public function setTableDefinition()
	{
		$this->setTableName('ddm_object');

		$this->hasColumn('o_class', 'integer', null);
	}

	public function setUp()
	{
		parent::setUp();
		$this->hasOne('DDM_Class as class', array('local' => 'o_class',
			'foreign' => 'id',
			'onDelete' => 'RESTRICT'));
	}

	/**
	 * Overrides the magic __set method of Doctrine_Record 
	 *
	 * @param string $name
	 * @param mixed $value
	 * @return void
	 */
	public function __set($name, $value) {
		// An object attribute in Doctrine
		if ( $this->hasRelation($name) ) {
			return parent::set($name, $value);
		}
		elseif ( $this->class->hasAttribute($name) ) {
			$this->setAttribute($name, $value);
		}
		elseif ( $this->class->hasAssociation($name) ) {
			$this->setLinkValue($name, $value);
		}
	}
	
	public function __toString() {
		return 'Object: ' . $this->id;
	}

	/**
	 * Set the value of an attribute
	 *
	 * @param string $name
	 * @param mixed $value
	 */
	public function setAttribute($name, $value) {
		if ( $this->class->hasAttribute($name) ) {
			$this->attributes[$name] = $value;
		}
	}

	/**
	 * Set the opposite of an association
	 *
	 * @param string $name
	 * @param DDM_Object $value
	 */
	public function setLink($name, $value) {
		if ( $this->class->hasAssociation($name) ) {
			$this->setLinkValue($name, $value);
		}
	}

	/**
	 * Overrides the magic __get method of Doctrine_Record 
	 *
	 * @param string $name
	 * @return mixed
	 */
	public function __get($name) {
		// An object attribute in Doctrine
		if ( $this->hasRelation($name) ) {
			return parent::get($name);
		}
		elseif ( $this->class->hasAttribute($name) ) {
			return $this->getAttribute($name);
		}
		elseif ( $this->class->hasAssociation($name) ) {
			return $this->getLinkValue($name);
		}
	}

	/**
	 * Return the value of an attribute
	 *
	 * @param string $name
	 * @return mixed
	 */
	public function getAttribute($name) {
		if ( $this->class->hasAttribute($name) && isset($this->attributes[$name]) ) {
			return $this->attributes[$name];
		}
		return null;
	}

	/**
	 * Return the value(s) of an association
	 *
	 * @param string $name
	 * @return mixed
	 */
	public function getLink($name) {
		if ( $this->class->hasAssociation($name) && isset($this->associations[$name]) ) {
			return $this->associations[$name];
		}
		return null;
	}

	/**
	 * Overrides the Doctrine constructor
	 * 
	 * @return void
	 */
	public function construct() {
		if ( $this->id <= 0 ) {
			return;
		}
		
		// ugly hack
#		if ( 0 < count($this->class->attributes) ) {
		if ( 0 < count($this->class->attributes) || 0 < count($this->class->parent->attributes) ) {
			$this->loadAttributes();
		}
		if ( 0 < count($this->class->associations) ) {
			$this->loadAssociations();
		}		
	}

	/**
	 * Overrides the save method of Doctrine_Record
	 *
	 * @return void
	 */
	public function save() {
		parent::save();
		
		// ugly hack
#		if ( 0 < count($this->class->attributes) ) {
		if ( 0 < count($this->class->attributes) || 0 < count($this->class->parent->attributes) ) {
			$this->saveAttributes();
		}
		// ugly hack
#		if ( 0 < count($this->class->associations) ) {
		if ( 0 < count($this->class->associations) || 0 < count($this->class->parent->associations) ) {
			$this->saveAssociations();
		}
	}

	/**
	 * Load the attribute values of an object
	 *
	 * @return void
	 */
	private function loadAttributes() {
		$conn = $this->_table->getConnection();
		$statement = 'SELECT * FROM ' . strtolower($this->class->c_view) . ' WHERE id=' . $this->id;
		$row = $conn->getDbh()->query($statement)->fetch(PDO::FETCH_ASSOC);
		
		foreach ( $this->class->attributes as $a) {
			$a_name = strtolower($a->a_name);
			if ( isset($row[$a_name]) ) {
				$this->attributes[$a->a_name] = $row[$a_name];
			}
		}
// ugly hack
		if ( 0 < count($this->class->parent->attributes) ) {
		foreach ( $this->class->parent->attributes as $a) {
			$a_name = strtolower($a->a_name);
			if ( isset($row[$a_name]) ) {
				$this->attributes[$a->a_name] = $row[$a_name];
			}
		}
		}
	}

	/**
	 * Load the associations of an object
	 *
	 * @return void
	 */
	private function loadAssociations() {
		$conn = $this->_table->getConnection();
		
		foreach ( $this->class->associations as $s) {
			$this->loadLinkValue($s);
		}
	}
	
	private function loadLinkValue(DDM_Association $association) {
		$link = $association->createLink();
		$link->load($this);
		if ( $link->isLoaded() ) {
			$this->associations[$association->s_name] = $link;
		}
	}

	/**
	 * Save the attribute values of an object
	 *
	 * @return void
	 */
	private function saveAttributes() {
		$update = array();
		
		foreach ($this->class->attributes as $a) {
			if ( isset($this->attributes[$a->a_name]) ) {
				array_push( $update, $a->a_name ." = '" . $this->attributes[$a->a_name] . "'" );
			} else {
				array_push( $update, $a->a_name ." = NULL" );
			}
		}
		
		// second part of ugly hack
#		if ( isset ($this->class->parent) ) {
		foreach ($this->class->parent->attributes as $a) {
			if ( isset($this->attributes[$a->a_name]) ) {
				array_push( $update, $a->a_name ." = '" . $this->attributes[$a->a_name] . "'" );
			} else {
				array_push( $update, $a->a_name ." = NULL" );
			}
		}
#		}
		
		$statement = 'UPDATE ' . strtolower( $this->class->c_view ) . ' SET '
			. join( ', ', $update )
			. ' WHERE id=' . $this->id;
	
		$conn = $this->getTable()->getConnection()->getDbh();
		$conn->exec($statement);
	}

	/**
	 * Save the association of an object
	 *
	 * @return void
	 */
	private function saveAssociations() {
		$conn = $this->_table->getConnection();
		
		foreach ( $this->class->associations as $s) {
			$name = $s->s_name;
			if ( isset( $this->associations[$name] ) && $this->associations[$name]->isModified() ) {
				$this->associations[$name]->save();
			}
		}

		// third part of ugly hack
#		if ( isset ($this->class->parent) ) {
		foreach ( $this->class->parent->associations as $s) {
			$name = $s->s_name;
			if ( isset( $this->associations[$name] ) && $this->associations[$name]->isModified() ) {
				$this->associations[$name]->save();
			}
		}
#		}
	}

	private function setLinkValue($name, DDM_Object $object) {
		$association = $this->class->getAssociation($name);
		
		if ( ! isset( $this->associations[$name] ) ) {
			$this->associations[$name] = $association->createLink();
			$this->associations[$name]->from = $this;
		}
		$link = $this->associations[$name];
		
		if ( $association->toOne() ) {
			$link->to = $object;
		} else {
			$link->addTo( $object );
		}
	}
	
	private function getLinkValue($name) {
		if ( isset($this->associations[$name]) ) {
			return $this->associations[$name]->to;
		}
		return null;
	}
}

?>