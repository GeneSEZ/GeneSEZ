<?php
require_once 'Mfw/PlugIn.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329329406_140543_862) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_PlugInRegistry  {
	
	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_PlugIn	$plugin	
	 */
	public function register($plugin);

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasMissingDependencies();

	/**
	 * @generated	method stub for implementation
	 * @return	array
	 */
	public function getMissingDependencies();

	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243329329406_140543_862) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_PlugInRegistry' here
	/* PROTECTED REGION END */
}
?>
