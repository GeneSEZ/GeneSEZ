<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1245605920593_483120_768) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_RequestHandlerBase
 * @author	dreamer
 * @package	de.genesez.metaframework.phpinfo
 */
class PhpInfoHandler extends Mfw_RequestHandlerBase  {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_HandlerInfo	$handlerInfo	
	 * @return	Mfw_Dto
	 */
	public function handle(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1245605931015_826023_790) ENABLED START */
		phpinfo();
		return true;
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1245605920593_483120_768) ENABLED START */
	// TODO: put your further code implementations for class 'PhpInfoHandler' here
	/* PROTECTED REGION END */
}
?>
