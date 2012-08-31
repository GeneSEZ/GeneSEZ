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
	
	/**
	 * Returns the inheritance hierarchie (array of superclasses) of a class by its name.
	 * The last entry is specified class itself.
	 * 
	 * @param $name
	 * @return array of ddm_class
	 */
	public function fetchSuperclasses($name) {
		$classes = array();
		if (!$this->exist($name)) {
			return $classes;
		}
		$class = $this->fetchByName($name);
		$end = false;
		while (!$end) {
			$classes[] = $class;
			// i need a very strange check here...
			if (is_int($class->c_parent)) {
				$class = $class->parent;
			} else {
				$end = true;
			}
		}
//		return array_reverse($classes);
		return $classes;
	}
}

?>