<?php

class DDM_Reverse_Association extends Doctrine_Record
{

	public function setTableDefinition()
	{
		$this->setTableName('ddm_reverse_association');

		$this->hasColumn('s_association', 'integer', array('notnull' => true));
		$this->hasColumn('s_name', 'string', 1024, array('notnull' => true));
		
		$this->index('unique_index', array(
				'fields' => array ( 'r_association' ),
				'type' => 'unique'
			)
		);
	}

	public function setUp()
	{
		parent::setUp();

		$this->hasOne('DDM_Association as association', array('local' => 's_association',
			'foreign' => 'id',
			'onDelete' => 'CASCADE'));
	}
	
	public function __get($name) {
		$value = null;
		switch ($name) {
			case 'to':
				$value = $this->association->from;
				break;
			case 'from':
				$value = $this->association->to;
				break;
			case 's_to_cardinality':
				$value = $this->association->s_from_cardinality;
				break;
			case 's_from_cardinality':
				$value = $this->association->s_to_cardinality;
				break;
			default:
				$value = parent::__get($name);
				break;
		}
		return $value;
	}

	public function cardinality($from, $to) {
		return $this->association->cardinality($to, $from);
	}
}

?>