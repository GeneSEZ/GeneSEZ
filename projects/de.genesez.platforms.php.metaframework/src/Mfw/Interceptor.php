<?php
require_once 'Mfw/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243243396765_950817_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Allows to interrupt the request processing to decide if the request 
 * processing should continue or the request should be handled in another way.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_Interceptor  {
	
	
	
	/**
	 * interrupts the request processing
	 * @param	Mfw_HandlerInfo	$handlerInfo	the handler information of the request
	 * @return	boolean
	 */
	public function intercept($handlerInfo);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243243396765_950817_361) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_Interceptor' here
	/* PROTECTED REGION END */
}
?>
