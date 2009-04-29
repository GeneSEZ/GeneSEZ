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
		spl_autoload_register(array('UtilitiesModuleLoader', 'autoload'));
		return array(
			Adapter_SeasarPhpBuilder::newComponent('Msg_FlashNotifier', 'notifier')
		);
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240324483359_514108_877) ENABLED START */
	public static function autoload($classname) {
		$path = str_replace('_', '/', $classname);
		$file = dirname(__FILE__) . '/' . $path . '.php';
		if (file_exists($file) && is_readable($file)) {
			require_once $file;
			return true;
		}
		return false;
	}
	/* PROTECTED REGION END */
}
?>
