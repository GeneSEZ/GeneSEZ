<?php
require_once 'Mfw/Context.php';
require_once 'Mfw/PlugIn.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982393703_618181_979) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a <b>default implementation</b> of the plug-in interface plug-ins 
 * can use to just implement the methods they need.
 * @see		Mfw_PlugIn
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Mfw_PlugInBase  implements Mfw_PlugIn {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * 
	 * @return	array of string
	 */
	public function getDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243425055984_625936_998) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243425055984_834606_999) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Context
	 */
	public function getContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243425055984_110478_1001) ENABLED START */
		return null;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getExtensions() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243425056000_45550_1003) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getInterceptors() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243425056000_918987_1005) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982393703_618181_979) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_InvisibleModuleLoader' here
	/* PROTECTED REGION END */
}
?>
