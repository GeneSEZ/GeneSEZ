<?php
require_once 'Loader/InvisibleModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240324483359_514108_877) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_InvisibleModuleLoader
 * @author	dreamer
 * @package	Utilities
 */
class UtilitiesModuleLoader extends Loader_InvisibleModuleLoader  {




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324545343_620417_920) ENABLED START */
		return array(
			Adapter_SeasarPhpBuilder::newComponent('FlashNotifier', 'notifier')
		);
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240324483359_514108_877) ENABLED START */
	// TODO: put your further code implementations for class 'UtilitiesModuleLoader' here
	/* PROTECTED REGION END */
}
?>
