<?php
require_once 'Core/Dto.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/BaseRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239126599921_834943_1226) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseRequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Core_Controller extends Core_BaseRequestHandler  {
	
	
	
	// -- method declarations -----------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function create();
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function delete();
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function edit();
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function show();
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function listing();
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239126840906_396271_1264) ENABLED START */
		// TODO: implementation of method 'Core_Controller.handle(...)'
		throw new Exception('The implementation of the method Core_Controller::handle is missing !');
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239126599921_834943_1226) ENABLED START */
	// TODO: put your further code implementations for class 'Core_Controller' here
	/* PROTECTED REGION END */
}
?>
