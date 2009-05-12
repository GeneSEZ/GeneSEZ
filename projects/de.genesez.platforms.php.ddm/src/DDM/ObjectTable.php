<?php

class DDM_ObjectTable extends Doctrine_Table
{

	/**
	 * Fetches an object by its id
	 *
	 * @param integer $id
	 * @return DDM_Object
	 */
	public function fetch($id) {
		return $this->find($id);
	}
	
	/**
	 * Fetches a collection of objects
	 *
	 * @param integer $offset
	 * @param integer $max
	 * @return Doctrine_Collection
	 */
	public function fetchAll($max = 0, $offset = 0) {
		if ( $max > 0 && $offset > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_object o');
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_object o');
			$query->limit($max);
			return $query->execute();
		} else {
			return $this->findAll();
		}
	}
	
	/**
	 * Fetches a collection of objects of a specified class
	 *
	 * @param $class
	 * @param integer $max
	 * @param integer $offset
	 * @return Doctrine_Collection
	 */
	public function fetchAllByClass($class, $max = 0, $offset = 0) {
		$query = new Doctrine_Query();
		$query->from('ddm_object o');
		$query->where('o.class.c_name = \'' . $class . '\'');

		if ( $max > 0 && $offset > 0 ) {
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query->limit($max);
		}

		return $query->execute();
	}
}

?>
