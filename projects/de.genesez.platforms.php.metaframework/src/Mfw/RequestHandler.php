<?php
require_once 'Mfw/Dto.php';
require_once 'Mfw/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_RequestHandler  {
	
	
	
	/**
	 * Processes the current request. It returns either a <b>DTO</b> which 
	 * contains all data to be rendered or it returns <b>true</b> to indicate 
	 * that rendering was already done.
	 * @param	Mfw_HandlerInfo	$handlerInfo	provides additional information
	 * @return	Mfw_Dto
	 */
	public function handle($handlerInfo);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$view	
	 */
	public function setView($view);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_RequestHandler' here
	/* PROTECTED REGION END */
}
?>
