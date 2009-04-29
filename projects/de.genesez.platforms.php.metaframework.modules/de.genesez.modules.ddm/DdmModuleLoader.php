<?php
require_once 'Core/Context.php';
require_once 'Loader/ModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240383889812_628548_635) ENABLED START */
// TODO: put your further include + require statements here

/* PROTECTED REGION END */

/**
 * @see		Loader_ModuleLoader
 * @author	dreamer
 * @package	DDM
 */
class DdmModuleLoader  implements Loader_ModuleLoader {




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
	 * @return	boolean
	 */
	public function hasModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240383978406_699905_688) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Context
	 */
	public function getModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240383988250_305730_692) ENABLED START */
		return new Core_Context('ddm', 'ddm.home.handler', array(
			new Core_Context('class', 'web.ddm.class.handler'),
			new Core_Context('type', 'ddm.type.handler'),
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240384049984_368807_718) ENABLED START */
		spl_autoload_register(array('DdmModuleLoader', 'autoload'));
		return array(
			// quickform adapter
			Adapter_SeasarPhpBuilder::newComponent('Form_TypeAdapter', 'typeAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('AttributeFormAdapter', 'attributeFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('ClassFormAdapter', 'classFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('AssociationFormAdapter', 'associationFormAdapter'),
			Adapter_SeasarPhpBuilder::newComponent('ObjectFormAdapter', 'objectFormAdapter'),
			// request handler
			Adapter_SeasarPhpBuilder::newComponent('Editor_TypeHandler', 'type.handler'),
			Adapter_SeasarPhpBuilder::newComponent('Editor_DdmHomeHandler', 'ddm.home.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmClassHandler', 'web.ddm.class.handler'),
			Adapter_SeasarPhpBuilder::newComponent('Editor_EditorRequestHandler', 'ddm.type.handler', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('notifier', 'notifier'),
				Adapter_SeasarPhpBuilder::newProperty('contentHandler', 'type.handler'),
			)),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmAttributeHandler', 'web.ddm.attribute.handler'),
			Adapter_SeasarPhpBuilder::newComponent('WebDdmAssociationHandler', 'web.ddm.association.handler')
		);
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240383889812_628548_635) ENABLED START */
	// TODO: put your further code implementations for class 'DdmModuleLoader' here
	public static function autoload($classname) {
		$path = str_replace('_', '/', $classname);
		$file = dirname(__FILE__) . '/' . $path . '.php';
		if (file_exists($file) && is_readable($file)) {
			require_once $file;
			return true;
		}
		return false;
	}
	/* PROTECTED REGION END */
}
?>
