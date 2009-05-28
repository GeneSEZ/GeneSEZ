<?php
require_once 'Core/Context.php';
require_once 'Loader/PlugInLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982393703_618181_979) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_PlugInLoader
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Loader_InvisibleModuleLoader  implements Loader_PlugInLoader {




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982767343_461764_1020) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982767343_685586_1021) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982413781_969884_999) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Context
	 */
	public function getModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982413781_734867_998) ENABLED START */
		return null;
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982393703_618181_979) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_InvisibleModuleLoader' here
	/* PROTECTED REGION END */
}
?>
