<?php
require_once 'Mfw/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243243396765_950817_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the interceptor interface allowing to <b>interrupt</b> the <b>request 
 * processing</b> to decide if the request processing should continue or the 
 * request should be handled in another way.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_Interceptor  {
	
	
	
	/**
	 * Interrupts the request processing. If <i>true</i> is returned, the request 
	 * processing <b>stops</b> and the interceptor takes the responsibility to 
	 * provide a meaningful output.
	 * @param	Mfw_HandlerInfo	$handlerInfo	the handler and context information of the request
	 * @return	boolean
	 */
	public function intercept(Mfw_HandlerInfo $handlerInfo);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243243396765_950817_361) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_Interceptor' here
	/* PROTECTED REGION END */
}
?>
