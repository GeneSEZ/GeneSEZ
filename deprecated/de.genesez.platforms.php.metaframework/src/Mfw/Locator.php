<?php
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1238000869500_873239_1272) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the locator inferface used to <b>obtain</b> the <b>request handler</b> 
 * which is able to handle the request.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_Locator  {
	
	
	
	/**
	 * Locates the request handler using the specified information.
	 * @param	Mfw_HandlerInfo	$handlerInfo	the information needed to find the request handler
	 * @return	Mfw_RequestHandler
	 */
	public function locate(Mfw_HandlerInfo $handlerInfo);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1238000869500_873239_1272) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_Locator' here
	/* PROTECTED REGION END */
}
?>
