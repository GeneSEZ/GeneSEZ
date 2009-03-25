<?php
/**
 * @author	dreamer
 * @package	Loader
 */

require_once 'Loader/InvisibleModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237975932171_599452_831) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_InvisibleModuleLoader
 * @author	dreamer
 * @package	Loader
 */
class Loader_CoreModuleLoader extends Loader_InvisibleModuleLoader  {
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237975998187_888171_855) ENABLED START */
		return array(
			Seasar_PhpSeasarBuilder::newComponent('Seasar_ServiceRegistry', 'serviceRegistry', array(), array(
				Seasar_PhpSeasarBuilder::newProperty('container', 'container')
			)),
			Seasar_PhpSeasarBuilder::newComponent('ServiceRegistryDispatcher', 'dispatcher', array(), array(
				Seasar_PhpSeasarBuilder::newProperty('serviceRegistry', 'serviceRegistry')
			)),
			Seasar_PhpSeasarBuilder::newComponent('Smarty', 'smarty'),
			Seasar_PhpSeasarBuilder::newComponent('SmartyRenderer', 'renderer', array(), array(
				Seasar_PhpSeasarBuilder::newProperty('smarty', 'smarty')
			))
		);
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237975932171_599452_831) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_CoreModuleLoader' here
	/* PROTECTED REGION END */
}
?>
