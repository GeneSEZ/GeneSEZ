<?php
require_once 'Core/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237827400500_227958_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Core
 */
interface Core_Resolver  {
	
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	Core_HandlerInfo
	 */
	public function resolveHandler($path);
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	string
	 */
	public function resolveLayout($path);
	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1237827400500_227958_281) ENABLED START */
	// TODO: put your further code declarations for interface 'Core_UrlMapper' here
	/* PROTECTED REGION END */
}
?>
