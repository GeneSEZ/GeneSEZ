<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329496625_610259_886) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the inteface for the <b>interceptor registry</b>. An interceptor 
 * registry is used to register {@link Mfw_Interceptor interceptors} with 
 * particular url patterns.
 * @see		IteratorAggregate
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_InterceptorRegistry extends IteratorAggregate {
	
	
	
	/**
	 * Registers an interceptor for the specified url pattern.
	 * @param	string	$pattern	the url pattern, i.e. a regular expression a url must match
	 * @param	string	$interceptor	the identifier of the interceptor
	 */
	public function register($pattern, $interceptor);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243329496625_610259_886) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_InterceptorRegistry' here
	/* PROTECTED REGION END */
}
?>
