<?php

class DDM_TypeTable extends Doctrine_Table
{

	/**
	 * Fetches a type by its id
	 *
	 * @param integer $id
	 * @return DDM_Type
	 */
	public function fetch($id) {
		return $this->find($id);
	}
	
	/**
	 * Fetches a Collection of types
	 *
	 * @param integer $max
	 * @param integer $offset
	 * @return Doctrine_Collection
	 */
	public function fetchAll($max = 0, $offset = 0) {
		if ( $max > 0 && $offset > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_type t');
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_type t');
			$query->limit($max);
			return $query->execute();
		} else {
			return $this->findAll();
		}
	}
}

?>
