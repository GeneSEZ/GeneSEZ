<?php

class DDM_ClassTable extends Doctrine_Table
{

	/**
	 * Fetches a class by its id
	 *
	 * @param integer $id
	 * @return DDM_Class
	 */
	public function fetch($id) {
		return $this->find($id);
	}
	
	/**
	 * Fetches a Collection of classes
	 *
	 * @param integer $max
	 * @param integer $offset
	 * @return Doctrine_Collection
	 */
	public function fetchAll($max = 0, $offset = 0) {
		if ( $max > 0 && $offset > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_class c');
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_class c');
			$query->limit($max);
			return $query->execute();
		} else {
			return $this->findAll();
		}
	}
	
	/**
	 * Fetches a Collection of Classes excluding the given id
	 *
	 * @param integer $id
	 * @param integer $max
	 * @param integer $offset
	 * @return Doctrine_Collection
	 */
	public function fetchAllExcept($id, $max = 0, $offset = 0) {
		$query = new Doctrine_Query();
		$query->from('ddm_class c');
		$query->where('c.id != ' . $id);

		if ( $max > 0 && $offset > 0 ) {
			$query->limit($max);
			$query->offset($offset);
		} elseif ( $max > 0 ) {
			$query->limit($max);
		}

		return $query->execute();
	}
	
	/**
	 * Fetches a class by its name
	 *
	 * @param string $name
	 * @return DDM_Class
	 */
	public function fetchByName($name) {
		return $this->findOneByC_Name($name);
	}
	
	/**
	 * Check the existance of a class by its name
	 *
	 * @param string $name
	 * @return bool
	 */
	public function exist($name) {
		return is_a($this->fetchByName($name) , 'DDM_Class');
	}
}

?>