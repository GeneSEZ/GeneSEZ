<?php
require_once 'Core/Dto.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/BaseCompositeRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240398668828_377703_375) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseCompositeRequestHandler
 * @author	dreamer
 * @package	DDM
 */
class Editor_EditorRequestHandler extends Core_BaseCompositeRequestHandler  {

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Editor_EditorRequestHandler}
	 * @generated	constructor stub for implementation
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240402786000_724799_604) ENABLED START */
		parent::__construct(array(
			'navigation' => new Editor_NavigationHandler()
		));
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240399318375_689601_530) ENABLED START */
		$dto = parent::handle($handlerInfo);
		$dto->title = 'dynamic data model editor';
		$dto->css = array('base.css');
		$dto->scripts = array();
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240398668828_377703_375) ENABLED START */
	// TODO: put your further code implementations for class 'Editor_EditorRequestHandler' here
	/* PROTECTED REGION END */
}
?>
