<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243324717437_372929_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the inteface for the <b>extension registry</b>. An extension 
 * registry is used to manage contributions for particular extensions.<br><br>Note: 
 * the data type and structure of the contributions must be known by the 
 * accessing object.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_ExtensionRegistry  {
	
	
	
	/**
	 * Registers a contribution for the specified extension.
	 * @param	string	$extension	the extension on which a contribution is done
	 * @param	mixed	$contribution	the contribution for the specified extension
	 */
	public function register($extension, $contribution);

	/**
	 * Checks for <b>contributions</b> to the specified extension.
	 * @param	string	$extension	the identifier of the extension
	 * @return	boolean
	 */
	public function hasContributions($extension);

	/**
	 * Returns an array with the <b>contributions</b> of the specified extensions.
	 * @param	string	$extension	the identifier of the extension
	 * @return	array of mixed
	 */
	public function getContributions($extension);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243324717437_372929_361) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_ExtensionRegistry' here
	/* PROTECTED REGION END */
}
?>
