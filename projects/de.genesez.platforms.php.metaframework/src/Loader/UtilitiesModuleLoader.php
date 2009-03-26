<?php
require_once 'Loader/InvisibleModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982205234_346906_901) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_InvisibleModuleLoader
 * @author	dreamer
 * @package	Loader
 */
class Loader_UtilitiesModuleLoader extends Loader_InvisibleModuleLoader  {
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982234093_59205_924) ENABLED START */
		return array(
			Adapter_SeasarPhpBuilder::newComponent('FlashNotifier', 'notifier')
		);
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982205234_346906_901) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_UtilitiesModuleLoader' here
	/* PROTECTED REGION END */
}
?>
