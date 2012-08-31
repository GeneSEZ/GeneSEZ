<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1245605549734_18637_652) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_PlugInBase
 * @author	dreamer
 * @package	de.genesez.metaframework.phpinfo
 */
class PhpInfoPlugIn extends Mfw_PlugInBase  {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getId() {
		return 'de.genesez.metaframework.phpinfo';
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Context
	 */
	public function getContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1245605581609_541946_674) ENABLED START */
		return new Mfw_Context('phpinfo', 'phpinfo.handler');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1245605602328_933381_683) ENABLED START */
		return array(
			Mfw_SeasarPhpBuilder::newComponent('PhpInfoHandler', 'phpinfo.handler')
		);
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1245605549734_18637_652) ENABLED START */
	// TODO: put your further code implementations for class 'PhpInfoPlugIn' here
	/* PROTECTED REGION END */
}
?>
