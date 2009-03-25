<?php
/**
 * @author	dreamer
 * @package	
 */

require_once 'Loader/ModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332587625_21111_386) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	
 */
class Metaframework   {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Loader_ModuleLoader	$_modules
	 */
	private $_modules = array();
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class {@link Metaframework}
	 * @generated	constructor stub for implementation
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236332596843_897793_405) ENABLED START */
		// TODO: implementation of constructor for class 'Metaframework'
		throw new Exception('The implementation of the constructor of the class Metaframework is missing !');
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	Loader_ModuleLoader	$loader	
	 */
	public function registerModuleLoader($name, $loader) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236332689875_601091_430) ENABLED START */
		// TODO: implementation of method 'DdmFw.registerModuleLoader(...)'
		throw new Exception('The implementation of the method DdmFw::registerModuleLoader is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	array	$loaders	
	 */
	public function registerModuleLoaders($loaders = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236345050000_299364_554) ENABLED START */
		// TODO: add loaders to current modules so the method can be called more than once!
		$this->_modules = $loaders;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 */
	public function proceed() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237975349578_500094_665) ENABLED START */
		// TODO: check plug-in dependencies, if all needed plug-ins exist
		// core plugin has to be the 1st one!
		$root = $this->_modules[0];
		$container = Seasar_PhpSeasarBuilder::newContainer();
		$isAdding = false;
		foreach ($this->_modules as $name => $module) {
			if ($isAdding && $module->hasModuleContext()) {
				$root->nestedContext->insert($module->getModuleContext());
			}
			// register module components
			foreach ($module->getComponents() as $component) {
				$container->register($component);
			}
			// don't add the first component but all others
			$isAdding = true;
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1236332587625_21111_386) ENABLED START */
	// TODO: put your further code implementations for class 'DdmFw' here
	/* PROTECTED REGION END */
}
?>
