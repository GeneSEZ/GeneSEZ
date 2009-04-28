<?php

class DDM_Association extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_association');

//		$this->hasColumn('s_left', 'integer', array('notnull' => true));
//		$this->hasColumn('s_left_cardinality', 'enum', 4 ,array(
//			'notnull' => true,
//			'values' => array ( '0..1', '1', 'N', '1..N')
//			)
//		);
//		$this->hasColumn('s_right', 'integer', array('notnull' => true));
//		$this->hasColumn('s_right_cardinality', 'enum', 4 ,array(
//			'notnull' => true,
//			'values' => array ( '0..1', '1', 'N', '1..N')
//			)
//		);
		$this->hasColumn('s_from', 'integer', array('notnull' => true));
		$this->hasColumn('s_from_cardinality', 'enum', 4 ,array(
			'notnull' => true,
			'values' => array ( '0..1', '1', 'N', '1..N')
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
//		$this->hasOne('DDM_Class as left', array('local' => 's_left',
//			'foreign' => 'id',
//			'onDelete' => 'CASCADE'));
//
//		$this->hasOne('DDM_Class as right', array('local' => 's_right',
//			'foreign' => 'id',
//			'onDelete' => 'CASCADE'));
		$this->hasOne('DDM_Class as from', array('local' => 's_from',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));

		$this->hasOne('DDM_Class as to', array('local' => 's_to',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));
	}

	public function __toString() {
		return 'Name: ' . $this->s_name;
	}

}

?>