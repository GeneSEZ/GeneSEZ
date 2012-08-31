<?php

class DDM_AttributeTable extends Doctrine_Table
{
	/**
	 * Fetches an attribute by its id
	 *
	 * @param integer $id
	 * @return The DDM_Attribute
	 */
	public function fetch($id) {
		return $this->find($id);
	}

	/**
	 * Fetches a Collection of attributes
	 *
	 * @param integer $max
	 * @param integer $offset
	 * @return Doctrine_Collection
	 */
	public function fetchAll($max = 0, $offset = 0) {
		if ( $max > 0 && $offset > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_attribute a');
			$query->limit($max);
			$query->offset($offset);
			return $query->execute();
		} elseif ( $max > 0 ) {
			$query = new Doctrine_Query();
			$query->from('ddm_attribute a');
			$query->limit($max);
			return $query->execute();
		} else {
			return $this->findAll();
		}
	}
}

?>
