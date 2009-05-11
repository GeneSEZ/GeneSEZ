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
	function __set($name, $value) {
		// An object attribute in Doctrine
		if ( $this->hasRelation($name) ) {
			return parent::set($name, $value);
		}
		elseif ( $this->class->hasAttribute($name) ) {
			$this->setAttribute($name, $value);
		}
		elseif ( $this->class->hasAssociation($name) ) {
			$this->setAssociation($name, $value);
		}
	}

	/**
	 * Set the value of an attribute
	 *
	 * @param string $name
	 * @param mixed $value
	 */
	function setAttribute($name, $value) {
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
	function setAssociation($name, $value) {
		if ( $this->class->hasAssociation($name) ) {
			$this->setAssociationValue($name, $value);
		}
		$association = $this->class->getAssociation($name);
		if ( $association->to->hasAssociation($name) ) {
			$value->setAssociationValue($name, $this);
		}
	}

	/**
	 * Overrides the magic __get method of Doctrine_Record 
	 *
	 * @param string $name
	 * @return mixed
	 */
	function __get($name) {
		// An object attribute in Doctrine
		if ( $this->hasRelation($name) ) {
			return parent::get($name);
		}
		elseif ( $this->class->hasAttribute($name) ) {
			return $this->getAttribute($name);
		}
		elseif ( $this->class->hasAssociation($name) ) {
			return $this->getAssociation($name);
		}
	}

	/**
	 * Return the value of an attribute
	 *
	 * @param string $name
	 * @return mixed
	 */
	function getAttribute($name) {
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
	function getAssociation($name) {
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
	function construct() {
		if ( $this->id <= 0 ) {
			return;
		}
		
		if ( 0 < count($this->class->attributes) ) {
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
	function save() {
		parent::save();
		
		if ( 0 < count($this->class->attributes) ) {
			$this->saveAttributes();
		}
		
		if ( 0 < count($this->class->associations) ) {
			$this->saveAssociations();
		}
	}

	/**
	 * Load the attribute values of an object
	 *
	 * @return void
	 */
	function loadAttributes() {
		$conn = $this->_table->getConnection();
		$statement = 'SELECT * FROM ' . strtolower($this->class->c_view) . ' WHERE id=' . $this->id;
		$row = $conn->getDbh()->query($statement)->fetch(PDO::FETCH_ASSOC);
		
		foreach ( $this->class->attributes as $a) {
			$a_name = strtolower($a->a_name);
			if ( isset($row[$a_name]) ) {
				$this->attributes[$a->a_name] = $row[$a_name];
			}
		}
	}

	/**
	 * Load the associations of an object
	 *
	 * @return void
	 */
	function loadAssociations() {
		$conn = $this->_table->getConnection();
		
		foreach ( $this->class->associations as $s) {
			if ( $s->cardinality(1, 1) ) {
				$statement = 'SELECT r_right FROM ddm_reference_o2o WHERE r_association=' . $s->id . ' AND r_left=' . $this->id;
				$row = $conn->getDbh()->query($statement)->fetch(PDO::FETCH_ASSOC);
				$objectTable = Doctrine::getTable('DDM_Object');
				$this->associations[$s->s_name] = $objectTable->find($row['r_right']);
			}
			elseif  ( $s->cardinality(1, 'N') ) {
				$q = new Doctrine_RawSql();
				$q->select('{o.*}')
					->from('ddm_object o')
					->where('o.id IN (SELECT r_right FROM ddm_reference_o2n WHERE r_association=' . $s->id . ' AND r_left=' . $this->id . ')')
					->addComponent('o', 'DDM_Object');
				$this->associations[$s->s_name] = new ArrayObject( $q->execute()->getData() );
			}
		}
	}

	/**
	 * Save the attribute values of an object
	 *
	 * @return void
	 */
	function saveAttributes() {
		$update = array();
		
		foreach ($this->class->attributes as $a) {
			if ( isset($this->attributes[$a->a_name]) ) {
				array_push( $update, $a->a_name ." = '" . $this->attributes[$a->a_name] . "'" );
			} else {
				array_push( $update, $a->a_name ." = NULL" );
			}
		}
	
		$statement = 'UPDATE ' . strtolower( $this->class->c_view ) . ' SET '
			. join( ',', $update )
			. ' WHERE id=' . $this->id;
	
		$conn = $this->_table->getConnection();
		$conn->execute($statement);
	}

	/**
	 * Save the association of an object
	 *
	 * @return void
	 */
	function saveAssociations() {
		$conn = $this->_table->getConnection();
		
		foreach ( $this->class->associations as $s) {
			if ( $s->cardinality(1, 1) ) {
				$statement = 'INSERT INTO ddm_reference_o2o (r_association, r_left, r_right) '
					. ' VALUES(' . $s->id . ',' . $this->id . ','. $this->associations[$s->s_name]->id . ')';
				$conn->execute($statement);
			}
			elseif  ( $s->cardinality(1, 'N') ) {
					$iterator = $this->associations[$s->s_name]->getIterator();
					while($iterator->valid()) {
						$statement = 'INSERT INTO ddm_reference_o2n (r_association, r_left, r_right) '
							. ' VALUES(' . $s->id . ',' . $this->id . ','. $iterator->current()->id . ')';
						$conn->execute($statement);
						$iterator->next();
					}
			}
		}
	}

	private function setAssociationValue($name, $value) {
		$association = $this->class->getAssociation($name);

		if ( $association->cardinality(1, 1) ) {
			$this->associations[$name] = $value;
		}
		elseif  ( $association->cardinality(1, 'N') || $association->cardinality('N', 'N') ) {
				if ( ! array_key_exists( $name, $this->associations ) || is_null( $this->associations[$name] ) ) {
					$this->associations[$name] = new ArrayObject();
				}
				$this->associations[$name]->append( $value );
		}
	}
}

?>