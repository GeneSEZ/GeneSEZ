<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240383889812_628548_635) ENABLED START */
// TODO: put your further include + require statements here
require_once 'DDM.php';
/* PROTECTED REGION END */

/**
 * @see		Loader_InvisibleModuleLoader
 * @author	dreamer
 * @package	DDM
 */
class DdmModuleLoader extends Loader_InvisibleModuleLoader  {




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240383951921_51160_678) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240383960218_4573_682) ENABLED START */
		return array(
			'de.genesez.metaframework.core',
			'de.genesez.metaframework.util'
		);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240384049984_368807_718) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240383889812_628548_635) ENABLED START */
	// TODO: put your further code implementations for class 'DdmModuleLoader' here
	/* PROTECTED REGION END */
}
?>
