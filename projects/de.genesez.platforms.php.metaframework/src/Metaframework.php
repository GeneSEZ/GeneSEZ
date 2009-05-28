<?php
require_once 'Mfw/Context.php';
require_once 'Mfw/CorePlugIn.php';
require_once 'Mfw/ServiceRegistry.php';
require_once 'Mfw/PlugInRegistry.php';
require_once 'Mfw/ExtensionRegistry.php';
require_once 'Mfw/InterceptorRegistry.php';
require_once 'Mfw/PlugIn.php';

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
	 * @var		Mfw_Context	$rootContext
	 */
	protected $rootContext;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_CorePlugIn	$corePlugIn
	 */
	protected $corePlugIn;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_ServiceRegistry	$serviceRegistry
	 */
	protected $serviceRegistry;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_PlugInRegistry	$plugInRegistry
	 */
	protected $plugInRegistry;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_ExtensionRegistry	$extensionRegistry
	 */
	protected $extensionRegistry;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_InterceptorRegistry	$interceptorRegistry
	 */
	protected $interceptorRegistry;

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs the frontend of the framework. Additional plug-in folders can 
 * be specified for autoloading support of plug-in classes.
	 * @generated	constructor stub for implementation
	 * @param	array	$additionalPluginDirs	an array of additional plugin folders
	 */
	public function __construct($additionalPluginDirs = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1241076400375_384996_361) ENABLED START */
		// collect autoload source directories
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
	 * @generated	method stub for implementation
	 * @param	Mfw_CorePlugIn	$corePlugIn	
	 */
	public function initialize($corePlugIn) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243525435078_136280_1251) ENABLED START */
		$this->corePlugIn = $corePlugIn;
		$this->rootContext = $corePlugIn->getContext();
		$this->serviceRegistry = $corePlugIn->getServiceRegistry();
		$this->plugInRegistry = $this->serviceRegistry->getComponent('plugInRegistry');
		$this->extensionRegistry = $this->serviceRegistry->getComponent('extensionRegistry');
		$this->interceptorRegistry = $this->serviceRegistry->getComponent('interceptorRegistry');
		$this->registerPlugInInRegistries($corePlugIn);
		/* PROTECTED REGION END */
	}

	/**
	 * registers a plug-in
	 * @param	Mfw_PlugIn	$plugin	
	 */
	public function registerPlugIn($plugin) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236332689875_601091_430) ENABLED START */
		$this->registerPlugInInRegistries($plugin);
		// add context structure
		if ($plugin->hasContext()) {
			$this->rootContext->nestedContext->insert($plugin->getContext());
		}
		// register plugin components
		foreach ($plugin->getComponents() as $component) {
			$this->serviceRegistry->register($component);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * registers several plug-ins
	 * @param	array	$plugins	array of type 'Mfw_PlugIn', default value is 'array()'
	 */
	public function registerPlugIns($plugins = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236345050000_299364_554) ENABLED START */
		foreach ($plugins as $plugin) {
			$this->registerPlugIn($plugin);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	public function proceed() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237975349578_500094_665) ENABLED START */
		if ($this->plugInRegistry->hasMissingDependencies() === true) {
			echo 'there are missing plug-ins:' . '<br />';
			print_r($this->plugInRegistry->getMissingDependencies());
			exit;
		}
		// config frameworks
		$this->corePlugIn->finalize();
		// process request
		$resolver = $this->serviceRegistry->getComponent('resolver');
		$resolver->resolveHandler($this->corePlugIn->getContext());
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_PlugIn	$plugin	
	 */
	protected function registerPlugInInRegistries($plugin) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237987504359_726879_1039) ENABLED START */
		$this->plugInRegistry->register($plugin);
		// register extensions + contributions
		foreach ($plugin->getExtensions() as $extension => $contribution) {
			$this->extensionRegistry->register($extension, $contribution);
		}
		// register interceptors
		foreach ($plugin->getInterceptors() as $pattern => $interceptor) {
			$this->interceptorRegistry->register($pattern, $interceptor);
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
