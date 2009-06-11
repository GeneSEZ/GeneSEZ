<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243324717437_372929_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_ExtensionRegistry  {
	
	
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @param	mixed	$contribution	
	 */
	public function register($extension, $contribution);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @return	boolean
	 */
	public function hasContributions($extension);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @return	array of mixed
	 */
	public function getContributions($extension);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243324717437_372929_361) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_ExtensionRegistry' here
	/* PROTECTED REGION END */
}
?>
