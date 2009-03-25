<?php
/**
 * @author	dreamer
 * @package	Loader
 */

require_once 'Core/Context.php';
require_once 'Loader/InvisibleModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_InvisibleModuleLoader
 * @author	dreamer
 * @package	Loader
 */
class Loader_DdmModuleLoader extends Loader_InvisibleModuleLoader  {
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982820437_568347_1028) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313375_834057_962) ENABLED START */
		return array(
			'de.genesez.platforms.php.metaframework.core'
		);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313390_339484_965) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Context
	 */
	public function getModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313390_105015_964) ENABLED START */
		return new Core_Context('ddm', 'web.ddm.handler', array(
			new Core_Context('class', 'web.ddm.class.handler'),
			new Core_Context('type', 'web.ddm.type.handler'),
			new Core_Context('attribute', 'web.ddm.attribute.handler'),
			new Core_Context('association', 'web.ddm.association.handler'),
		));
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313390_149783_963) ENABLED START */
		return array(
			// data access objects
			Seasar_PhpSeasarBuilder::newComponent('DoctrineTypeDao', 'typeDao'),
			Seasar_PhpSeasarBuilder::newComponent('DoctrineAttributeDao', 'attributeDao'),
			Seasar_PhpSeasarBuilder::newComponent('DoctrineClassDao', 'classDao'),
			Seasar_PhpSeasarBuilder::newComponent('DoctrineAssociationDao', 'associationDao'),
			Seasar_PhpSeasarBuilder::newComponent('DoctrineObjectDao', 'objectDao'),
			// quickform adapter
			Seasar_PhpSeasarBuilder::newComponent('TypeFormAdapter', 'typeFormAdapter'),
			Seasar_PhpSeasarBuilder::newComponent('AttributeFormAdapter', 'attributeFormAdapter'),
			Seasar_PhpSeasarBuilder::newComponent('ClassFormAdapter', 'classFormAdapter'),
			Seasar_PhpSeasarBuilder::newComponent('AssociationFormAdapter', 'associationFormAdapter'),
			Seasar_PhpSeasarBuilder::newComponent('ObjectFormAdapter', 'objectFormAdapter'),
			// request handler
			Seasar_PhpSeasarBuilder::newComponent('WebDdmHandler', 'web.ddm.handler'),
			Seasar_PhpSeasarBuilder::newComponent('WebDdmClassHandler', 'web.ddm.class.handler'),
			Seasar_PhpSeasarBuilder::newComponent('WebDdmTypeHandler', 'web.ddm.type.handler'),
			Seasar_PhpSeasarBuilder::newComponent('WebDdmAttributeHandler', 'web.ddm.attribute.handler'),
			Seasar_PhpSeasarBuilder::newComponent('WebDdmAssociationHandler', 'web.ddm.association.handler')
			);
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_DdmModuleLoader' here
	/* PROTECTED REGION END */
}
?>
