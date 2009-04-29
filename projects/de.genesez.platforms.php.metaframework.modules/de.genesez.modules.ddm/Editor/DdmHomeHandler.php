<?php
require_once 'Core/Dto.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/BaseRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240412964281_715800_630) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseRequestHandler
 * @author	dreamer
 * @package	DDM
 */
class Editor_DdmHomeHandler extends Core_BaseRequestHandler  {




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240412984828_697646_652) ENABLED START */
		return new Core_BaseDto(array(
			'title' => 'dynamic data model editor',
			'css' => array($this->baseServerUri() . 'base.css'),
			'scripts' => array()
		));
//		$dto = new Core_BaseDto('ddm/editor.html');
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240412964281_715800_630) ENABLED START */
	// TODO: put your further code implementations for class 'DdmHomeHandler' here
	/* PROTECTED REGION END */
}
?>
