<?php
/**
 * @author	dreamer
 * @package	
 */

require_once 'Loader/ModuleLoader.php';
require_once 'Core/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332587625_21111_386) ENABLED START */
spl_autoload_register(array('Metaframework', 'autoload'));
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	
 */
class Metaframework   {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Loader_ModuleLoader	$modules
	 */
	protected $modules = array();
	/**
	 * @generated	attribute definition
	 * @var		Core_Context	$rootContext
	 */
	protected $rootContext;
	/**
	 * @generated	attribute definition
	 * @var		S2Container	$container
	 */
	protected $container;
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	Loader_ModuleLoader	$loader	
	 */
	public function registerModuleLoader($name, $loader) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236332689875_601091_430) ENABLED START */
		$this->modules[$name] = $loader;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	array	$loaders	
	 */
	public function registerModuleLoaders($loaders = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236345050000_299364_554) ENABLED START */
		foreach ($loaders as $name => $loader) {
			$this->registerModuleLoader($name, $loader);
		}
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 */
	public function proceed() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237975349578_500094_665) ENABLED START */
		$this->buildContainer();
		// config frameworks
		reset($this->modules);
		current($this->modules)->configureFrameworks($this->container);
		// process request
		$dispatcher = $this->container->getComponent('dispatcher');
		$dispatcher->dispatch($this->rootContext);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 */
	protected function buildContainer() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237987504359_726879_1039) ENABLED START */
		// TODO: check plug-in dependencies, if all needed plug-ins exist
		$it = new ArrayIterator($this->modules);
		// core plugin has to be the 1st one!
		if (!$it->valid()) {
			throw new Exception('no core plug-in found!');
		}
		$this->rootContext = $it->current()->getModuleContext();
		$container = Adapter_SeasarPhpBuilder::newContainer();
		$isAdding = false;
		$it->rewind();
		while ($it->valid()) {
			$module = $it->current();
			// add context structure
			if ($isAdding && $module->hasModuleContext()) {
				$this->rootContext->nestedContext->insert($module->getModuleContext());
			}
			// register module components
			foreach ($module->getComponents() as $component) {
				$container->register($component);
			}
			// don't add the first component (core plug-in) but all others
			$isAdding = true;
			$it->next();
		}
		$this->container = $container->getComponent('serviceRegistry');
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$classname	
	 * @return	boolean
	 */
	public static function autoload($classname) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238019127843_233433_1477) ENABLED START */
		$path = str_replace('_', '/', $classname);
		$file = self::baseDir() . $path . '.php';
		if (file_exists($file) && is_readable($file)) {
			require_once $file;
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function baseDir() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238019277984_968240_1483) ENABLED START */
		return dirname(__FILE__) . '/';
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function baseUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238019295890_719184_1487) ENABLED START */
		return substr($_SERVER['SCRIPT_NAME'], 0, strrpos($_SERVER['SCRIPT_NAME'], '/') +1);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function baseRequestUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238019301890_127500_1491) ENABLED START */
		return $_SERVER['SCRIPT_NAME'] . '/';
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1236332587625_21111_386) ENABLED START */
	// TODO: put your further code implementations for class 'DdmFw' here
	/* PROTECTED REGION END */
}

?>