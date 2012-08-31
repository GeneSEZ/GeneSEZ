<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243886078750_274309_265) ENABLED START */
// TODO: put your further include + require statements here
require_once 'DDM.php';
/* PROTECTED REGION END */

/**
 * @see		Mfw_PlugInBase
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class DdmPlugIn extends Mfw_PlugInBase  {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getId() {
		return 'de.genesez.metaframework.ddm';
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243886078750_560538_268) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243886078750_605616_269) ENABLED START */
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243886078750_400460_272) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243886078750_274309_265) ENABLED START */
	// TODO: put your further code implementations for class 'DdmPlugIn' here
	/* PROTECTED REGION END */
}
?>
