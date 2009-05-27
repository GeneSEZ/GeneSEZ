<?php
require_once 'Loader/PlugInLoader.php';
require_once 'Core/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332587625_21111_386) ENABLED START */
spl_autoload_register(array('Metaframework', 'autoload'));
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
class Metaframework   {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * documented here {@link Metaframework::getAutoloadDirs()}
	 * @generated	attribute definition
	 * @var		string	$autoloadDirs
	 */
	protected static $autoloadDirs = array();
	/**
	 * @generated	attribute definition
	 * @var		Loader_PlugInLoader	$modules
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

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs the frontend of the framework. Additional plugin folders can be 
 * specified for autoloading classes.
	 * @generated	constructor stub for implementation
	 * @param	null	$additionalPluginDirs	an array of additional plugin folders
	 */
	public function __construct($additionalPluginDirs = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1241076400375_384996_361) ENABLED START */
		$sourceDirs = array();
		$pluginDirs = array_merge(array(realpath(dirname($_SERVER['SCRIPT_FILENAME']) . '/../modules')), $additionalPluginDirs);
		foreach ($pluginDirs as $pluginDir) {
			if (!is_dir($pluginDir)) {
				continue;
			}
			$content = scandir($pluginDir);
			foreach ($content as $dir) {
				$path = $pluginDir . '/' . $dir;
				if (is_dir($path) && $dir != '.' && $dir != '..') {
					$sourceDirs[] = $path;
				}
			}
		}
		self::$autoloadDirs = array_merge(array(self::baseDir()), $sourceDirs);
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * registers a module loader instance with the given name
	 * @param	string	$name	name of the plugin
	 * @param	Loader_PlugInLoader	$loader	module loader instance of the plugin
	 */
	public function registerModuleLoader($name, $loader) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236332689875_601091_430) ENABLED START */
		// TODO: in a reviced implementation, insert the plug-ins additionally into a depencency tree
		$this->modules[$name] = $loader;
		/* PROTECTED REGION END */
	}

	/**
	 * registers several plugins
	 * @param	array	$loaders	associative array of plugin loader instances, key is plugin name
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
		$this->checkPlugIns();
		$this->buildContainer();
		// config frameworks
		reset($this->modules);
		current($this->modules)->configureFrameworks($this->container);
		// process request
		$resolver = $this->container->getComponent('resolver');
		$resolver->resolveHandler($this->rootContext);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function buildContainer() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237987504359_726879_1039) ENABLED START */
		// TODO: check plug-in dependencies, if all needed plug-ins exist
		// core plugin has to be the 1st one!
		reset($this->modules);
		if (current($this->modules) === false) {
			throw new Exception('no core plug-in found!');
		}
		$this->rootContext = current($this->modules)->getModuleContext();
		$container = Adapter_SeasarPhpBuilder::newContainer();
		$isAdding = false;
		foreach ($this->modules as $name => $module) {
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
		}
		Adapter_SeasarPhpBuilder::finishContainer($container);
		$this->container = $container->getComponent('serviceRegistry');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function checkPlugIns() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238097872890_554445_715) ENABLED START */
		// store all dependencies in one array, key -> needed, value -> array of dependants
		// just a simple implementation, not one with a high performance
		$dependencies = array();
		foreach ($this->modules as $name => $module) {
			if ($module->hasModuleDependencies()) {
				foreach ($module->getModuleDependencies() as $required) {
					if (array_key_exists($required, $dependencies)) {
						$dependencies[$required][] = $name;
					} else {
						$dependencies[$required] = array($name);
					}
				}
			}
		}
		$missing = array();
		// check if all required modules exist
		foreach ($dependencies as $name => $required) {
			if (!array_key_exists($name, $this->modules)) {
				$missing[$name] = $required;
			}
		}
		if (count($missing) > 0) {
			throw new Exception('there are missing required modules, all direct dependencies:\n' . var_export($missing, true));
		}
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
		foreach (self::$autoloadDirs as $dir) {
			$file = $dir . '/' . $path . '.php';
			if (is_file($file) && is_readable($file)) {
				require_once $file;
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function baseDir() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238019277984_968240_1483) ENABLED START */
		return dirname(__FILE__);
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
