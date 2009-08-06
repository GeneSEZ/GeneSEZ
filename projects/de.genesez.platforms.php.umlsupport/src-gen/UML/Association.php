<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239222572640_136215_385) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * principal type for all associations, defines a universal interface to deal 
 * with all kinds of associations.
 * @author	dreamer
 * @package	UmlSupport
 */
interface UML_Association  {
	
	
	
	/**
	 * inserts an associated object into the association, if not already present.
	 * @param	mixed	$associated	the object to create a link with
	 * @return	mixed
	 */
	public function insert($associated);

	/**
	 * removes an associated object from the association, if present
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function remove($associated);

	/**
	 * in case of a to-one-association, return the associated object,<br>otherwise 
	 * return the first associated object and subsequent calls iterate over the 
	 * associated objects
	 * @return	mixed
	 */
	public function get();

	/**
	 * returns all associated objects as an associated array as a copy of the 
	 * internal data structure
	 * @return	array of mixed
	 */
	public function getAll();

	/**
	 * returns an
	 * @return	Iterator
	 */
	public function iterator();

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239222572640_136215_385) ENABLED START */
	// TODO: put your further code declarations for interface 'UML_Association' here
	/* PROTECTED REGION END */
}
?>
