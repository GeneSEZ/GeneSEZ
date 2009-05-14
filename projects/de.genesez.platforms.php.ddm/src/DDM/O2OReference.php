<?php

class DDM_O2OReference extends DDM_Reference
{
	private $id = null;
	private $to = null;
	private $from = null;
	
	public function __set($name, $value) {
		if ( 'to' === $name ) {
			$this->to = $value;
			$this->modified = true;
		} elseif ( 'from' === $name ) {
			$this->from = $value;
			$this->modified = true;
		} else {
			parent::__set($name, $value);
		}
	}

	public function __get($name) {
		if ( 'to' === $name ) {
			return $this->to;
		} elseif ( 'from' === $name ) {
			return $this->from;
		} else {
			return parent::__set($name, $value);
		}
	}
	
	public function save() {
		$dbh = Doctrine_Manager::getInstance()->getCurrentConnection()->getDbh();
		if ( null !== $this->id ) {
			$statement = 'UPDATE ddm_reference_o2o'
				. ' SET r_association = ' . $this->association->id
				. ' r_from = ' . $this->from->id
				. ' r_to = ' . $this->to->id;
			$dbh->exec($statement);
		} else {
			$statement = 'INSERT INTO ddm_reference_o2o(r_association, r_from, r_to)'
				. ' VALUES(' . $this->association->id
				. ', ' . $this->from->id
				. ', ' . $this->to->id . ')';
			$dbh->exec($statement);
			$this->id = $dbh->lastInsertId('ddm_reference_o2o_id_seq');
		}
		$this->modified = false;
	}
	
	public function load(DDM_Object $from) {
		$dbh = Doctrine_Manager::getInstance()->getCurrentConnection()->getDbh();
		$statement = 'SELECT id,r_to FROM ddm_reference_o2o WHERE'
			. ' r_association = ' . $this->association->id . ' AND'
			. ' r_from = ' . $from->id;
		$result = $dbh->query($statement);
		if ( 0 < $result->rowCount() ) {
			$row = $result->fetch(PDO::FETCH_ASSOC);
			$this->id = $row['id'];
			$this->to = Doctrine::getTable('DDM_Object')->find($row['r_to']);
			$this->from = $from;
			$this->loaded = true;
			$this->modified = false;
		}
	}
}

?>