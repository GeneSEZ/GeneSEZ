<?php
require_once 'Mfw/Interceptor.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329496625_610259_886) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		IteratorAggregate
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_InterceptorRegistry extends IteratorAggregate {
	
	
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$pattern	
	 * @param	Mfw_Interceptor	$interceptor	
	 */
	public function register($pattern, $interceptor);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243329496625_610259_886) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_InterceptorRegistry' here
	/* PROTECTED REGION END */
}
?>
