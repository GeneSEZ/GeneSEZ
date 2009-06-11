<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999613687_797910_1115) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_ServiceRegistry  {
	
	
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	mixed	$component	
	 */
	public function register($name, $component);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasComponent($name);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	mixed
	 */
	public function getComponent($name);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1237999613687_797910_1115) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_ServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
