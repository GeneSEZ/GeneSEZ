<?php
require_once 'Core/Dto.php';
require_once 'Core/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Core_RequestHandler  {
	
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo);
	/**
	 * @generated	method stub for implementation
	 * @param	string	$view	
	 */
	public function setView($view);
	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
	// TODO: put your further code declarations for interface 'Core_RequestHandler' here
	/* PROTECTED REGION END */
}
?>
