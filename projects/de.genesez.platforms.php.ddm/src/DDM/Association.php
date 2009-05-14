<?php

class DDM_Association extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_association');

		$this->hasColumn('s_from', 'integer', array('notnull' => true));
		$this->hasColumn('s_from_cardinality', 'enum', 4 ,array(
			'notnull' => true,
			'values' => array ( '0..1', '1' )
			)
		);
		$this->hasColumn('s_to', 'integer', array('notnull' => true));
		$this->hasColumn('s_to_cardinality', 'enum', 4 ,array(
			'notnull' => true,
			'values' => array ( '0..1', '1', 'N', '1..N')
			)
		);
		$this->hasColumn('s_name', 'string', 1024, array('notnull' => true));
		$this->hasColumn('s_description', 'string', 1024, array('notnull' => true, 'default' => ''));
	}

	public function setUp()
	{
		parent::setUp();

		$this->hasOne('DDM_Class as from', array('local' => 's_from',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));

		$this->hasOne('DDM_Class as to', array('local' => 's_to',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));
	}

	public function cardinality($from, $to) {
		$cardinality = false;

		if ( 1 == $from && '0..1' == $this->s_from_cardinality ) {
			$cardinality = true;
		} elseif ( 'N' == $from && '1..N' == $this->s_from_cardinality ) {
			$cardinality = true;
		} else {
			$cardinality = $this->s_from_cardinality == $from;
		}
		
		if ( 1 == $to && '0..1' == $this->s_to_cardinality ) {
			$cardinality = $cardinality && true;
		} elseif ( 'N' == $to && '1..N' == $this->s_to_cardinality ) {
			$cardinality = $cardinality && true;
		} else {
			$cardinality = $cardinality && $this->s_to_cardinality == $to;
		}
		
		return $cardinality; 
	}
	
	public function toOne() {
		return $this->s_to_cardinality == 1 || $this->s_to_cardinality == '0..1'; 
	}
	
	public function createLink() {
		$reference = null;
		if ( $this->cardinality(1, 1)) {
			$reference = new DDM_O2OReference();
		} elseif ( $this->cardinality(1, 'N')) {
			$reference = new DDM_O2NReference();
		} elseif ( $this->cardinality('N', 1)) {
			$reference = new DDM_N2OReference();
		} else {
			$reference = new DDM_N2NReference();
		}
		$reference->association = $this;
		return $reference;
	}
	
	public function __toString() {
		return 'Name: ' . $this->s_name;
	}

}

?>