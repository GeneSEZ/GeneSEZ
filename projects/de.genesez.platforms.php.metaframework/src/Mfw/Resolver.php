<?php
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237827400500_227958_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the resolver interface used to <b>obtain</b> the information how a 
 * request can be handled.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_Resolver  {
	
	
	
	/**
	 * Resolves the needed information to handle a request.
	 * @param	Mfw_Context	$context	the context structure of the application
	 * @return	Mfw_HandlerInfo
	 */
	public function resolve(Mfw_Context $context);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1237827400500_227958_281) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_UrlMapper' here
	/* PROTECTED REGION END */
}
?>
