<?php
require_once 'Mfw/Dto.php';
require_once 'Mfw/HandlerInfo.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the request handler interface used to <b>handle</b> requests.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_RequestHandler  {
	
	
	
	/**
	 * Processes the current request. It returns either a <b>DTO</b> which 
	 * contains all data to be rendered or it returns <b>true</b> to indicate 
	 * that rendering was already done.
	 * @param	Mfw_HandlerInfo	$handlerInfo	additional information about the request and handler
	 * @return	Mfw_Dto
	 */
	public function handle(Mfw_HandlerInfo $handlerInfo);

	/**
	 * Setter for the view used to render the content
	 * @param	string	$view	the identifier of the view
	 */
	public function setView($view);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239095178265_502885_711) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_RequestHandler' here
	/* PROTECTED REGION END */
}
?>
