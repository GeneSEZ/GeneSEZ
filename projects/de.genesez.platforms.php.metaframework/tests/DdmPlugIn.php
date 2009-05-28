<?php
require_once 'Core/Context.php';
require_once 'Loader/ModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Loader_ModuleLoader
 * @author	dreamer
 * @package	Metaframework
 */
class DdmModuleLoader  implements Loader_ModuleLoader {
	
	
	
	
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
			Adapter_SeasarPhpBuilder::newComponent('DoctrineTypeDao', 'typeDao'),
			Adapter_SeasarPhpBuilder::newComponent('DoctrineAttributeDao', 'attributeDao'),
			Adapter_SeasarPhpBuilder::newComponent('DoctrineClassDao', 'classDao'),
			Adapter_SeasarPhpBuilder::newComponent('DoctrineAssociationDao', 'associationDao'),
			Adapter_SeasarPhpBuilder::newComponent('DoctrineObjectDao', 'objectDao'),
			// quickform adapter
			Adapter_SeasarPhpBuilder::newComponent('TypeFormAdapter', 'typeFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('AttributeFormAdapter', 'attributeFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('ClassFormAdapter', 'classFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('AssociationFormAdapter', 'associationFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('ObjectFormAdapter', 'objectFormAdapter'),
			// request handler
			Adapter_SeasarPhpBuilder::newComponent('WebDdmHandler', 'web.ddm.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmClassHandler', 'web.ddm.class.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmTypeHandler', 'web.ddm.type.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmAttributeHandler', 'web.ddm.attribute.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmAssociationHandler', 'web.ddm.association.handler')
			);
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_DdmModuleLoader' here
	/* PROTECTED REGION END */
}
?>
