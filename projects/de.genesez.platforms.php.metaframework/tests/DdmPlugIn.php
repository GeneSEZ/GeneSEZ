<?php
require_once 'Mfw/Context.php';
require_once 'Mfw/PlugInBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_PlugIn
 * @author	dreamer
 * @package	Metaframework
 */
class DdmPlugIn extends Mfw_PlugInBase {
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982820437_568347_1028) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313375_834057_962) ENABLED START */
		return array(
			'de.genesez.metaframework.core'
		);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313390_339484_965) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Context
	 */
	public function getContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237982313390_105015_964) ENABLED START */
		return new Mfw_Context('ddm', 'web.ddm.handler', array(
			new Mfw_Context('class', 'web.ddm.class.handler'),
			new Mfw_Context('type', 'web.ddm.type.handler'),
			new Mfw_Context('attribute', 'web.ddm.attribute.handler'),
			new Mfw_Context('association', 'web.ddm.association.handler'),
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
			Mfw_SeasarPhpBuilder::newComponent('DoctrineTypeDao', 'typeDao'),
			Mfw_SeasarPhpBuilder::newComponent('DoctrineAttributeDao', 'attributeDao'),
			Mfw_SeasarPhpBuilder::newComponent('DoctrineClassDao', 'classDao'),
			Mfw_SeasarPhpBuilder::newComponent('DoctrineAssociationDao', 'associationDao'),
			Mfw_SeasarPhpBuilder::newComponent('DoctrineObjectDao', 'objectDao'),
			// quickform adapter
			Mfw_SeasarPhpBuilder::newComponent('TypeFormAdapter', 'typeFormAdapter'),
			Mfw_SeasarPhpBuilder::newComponent('AttributeFormAdapter', 'attributeFormAdapter'),
			Mfw_SeasarPhpBuilder::newComponent('ClassFormAdapter', 'classFormAdapter'),
			Mfw_SeasarPhpBuilder::newComponent('AssociationFormAdapter', 'associationFormAdapter'),
			Mfw_SeasarPhpBuilder::newComponent('ObjectFormAdapter', 'objectFormAdapter'),
			// request handler
			Mfw_SeasarPhpBuilder::newComponent('WebDdmHandler', 'web.ddm.handler'),
			Mfw_SeasarPhpBuilder::newComponent('WebDdmClassHandler', 'web.ddm.class.handler'),
			Mfw_SeasarPhpBuilder::newComponent('WebDdmTypeHandler', 'web.ddm.type.handler'),
			Mfw_SeasarPhpBuilder::newComponent('WebDdmAttributeHandler', 'web.ddm.attribute.handler'),
			Mfw_SeasarPhpBuilder::newComponent('WebDdmAssociationHandler', 'web.ddm.association.handler')
			);
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237982284390_612829_940) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_DdmPlugIn' here
	public function getId() {
		return 'de.genesez.metaframework.ddm';
	}
	/* PROTECTED REGION END */
}
?>
