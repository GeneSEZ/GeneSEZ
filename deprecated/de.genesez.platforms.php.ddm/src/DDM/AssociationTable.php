<?php

class DDM_AssociationTable extends Doctrine_Table
{

	/**
	 * Fetches an association by its id
	 *
	 * @param integer $id
	 * @return DDM_Association
	 */
	public function fetch($id) {
		return $this->find($id);
	}
	
	/**
	 * Fetches a Collection of Associations
	 *
	 * @param integer $offset
	 * @param integer $max
	 * @return Doctrine_Collection
	 */
	public function fetchAll($max = 0, $offset = 0) {
		if ( $max > 0 && $offset > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_association a');
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_association a');
			$query->limit($max);
			return $query->execute();
		} else {
			return $this->findAll();
		}
	}
	
}

?>