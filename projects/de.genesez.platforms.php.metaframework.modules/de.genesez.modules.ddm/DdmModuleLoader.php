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
		return array(
			Adapter_SeasarPhpBuilder::newComponent('Editor_TypeHandler', 'ddm.type.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('typeDao', Doctrine::getTable('ddm_type'))
			)),
			Adapter_SeasarPhpBuilder::newComponent('Editor_ClassHandler', 'ddm.class.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('classDao', Doctrine::getTable('ddm_class'))
			)),
			Adapter_SeasarPhpBuilder::newComponent('Editor_AttributeHandler', 'ddm.attribute.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('attributeDao', Doctrine::getTable('ddm_attribute'))
			)),
			Adapter_SeasarPhpBuilder::newComponent('Editor_AssociationHandler', 'ddm.association.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('associationDao', Doctrine::getTable('ddm_association'))
			)),
			Adapter_SeasarPhpBuilder::newComponent('Editor_ObjectHandler', 'ddm.object.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('objectDao', Doctrine::getTable('ddm_object'))
			))
		);
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240383889812_628548_635) ENABLED START */
	// TODO: put your further code implementations for class 'DdmModuleLoader' here
	/* PROTECTED REGION END */
}
?>
