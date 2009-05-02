<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239725542718_817217_267) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	UmlSupport
 */
interface UML_QualifiedAssociation  {
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function insert($qualifier, $associated);

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @param	mixed	$associated	
	 * @return	mixed
	 */
	public function remove($qualifier, $associated);

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @return	mixed
	 */
	public function get($qualifier);

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	
	 * @return	array of mixed
	 */
	public function getAll($qualifier);

	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$qualifier	default value is 'null'
	 * @return	Iterator
	 */
	public function iterator($qualifier = null);

	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239725542718_817217_267) ENABLED START */
	// TODO: put your further code declarations for interface 'UML_QualifiedAssociation' here
	/* PROTECTED REGION END */
}
?>
