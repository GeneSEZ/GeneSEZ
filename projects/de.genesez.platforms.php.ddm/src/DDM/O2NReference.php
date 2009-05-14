<?php

class DDM_O2NReference extends DDM_Reference
{
	private $id = array();
	private $to = array();
	private $added = array();
	private $from = null;
	
	public function __set($name, $value) {
		if ( 'from' === $name ) {
			$this->from = $value;
			$this->modified = true;
		} else {
			parent::__set($name, $value);
		}
	}

	public function __get($name) {
		if ( 'to' === $name ) {
			return new ArrayObject($this->to);
		} elseif ( 'from' === $name ) {
			return $this->from;
		} else {
			return parent::__set($name, $value);
		}
	}
	
	public function addTo($value) {
		$add = true;
		foreach ( $this->to as $to ) {
			$add = $add && $to->id != $value->id;
		}
		if ( $add ) {
			$this->to[] = $value;
			$this->added[] = $value;
			$this->modified = true;
		}
	}
	
	public function save() {
		$dbh = Doctrine_Manager::getInstance()->getCurrentConnection()->getDbh();
		foreach ( $this->added as $to ) {
			$statement = 'INSERT INTO ddm_reference_o2n(r_association, r_from, r_to)'
				. ' VALUES(' . $this->association->id
				. ', ' . $this->from->id
				. ', ' . $to->id . ')';
			$dbh->exec($statement);
			$this->id[] = $dbh->lastInsertId('ddm_reference_o2n_id_seq');
		}
		$this->added = array();
		$this->modified = false;
	}

	public function load(DDM_Object $from) {
		$dbh = Doctrine_Manager::getInstance()->getCurrentConnection()->getDbh();
		$statement = 'SELECT id,r_to FROM ddm_reference_o2n WHERE'
			. ' r_association = ' . $this->association->id . ' AND'
			. ' r_from = ' . $from->id;
		$result = $dbh->query($statement);
		if ( 0 < $result->rowCount() ) {
			foreach ( $result as $row ) {
				$this->id[] = $row['id'];
				$this->to[] = Doctrine::getTable('DDM_Object')->find($row['r_to']);
			}
			$this->from = $from;
			$this->loaded = true;
			$this->modified = false;
		}
	}
}

?>