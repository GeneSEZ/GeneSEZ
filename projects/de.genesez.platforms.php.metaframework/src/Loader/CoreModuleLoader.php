<?php
require_once 'Core/Context.php';
require_once 'Core/ServiceRegistry.php';
require_once 'Loader/ModuleLoader.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237975932171_599452_831) ENABLED START */
require_once 's2container/S2Container.php';
require_once 'Doctrine/Doctrine.php';
require_once 'Smarty/Smarty.class.php';

spl_autoload_register(array('Doctrine', 'autoload'));

S2ContainerClassLoader::import(S2CONTAINER_PHP5);
spl_autoload_register(array('S2ContainerClassLoader', 'load'));
/* PROTECTED REGION END */

/**
 * @see		Loader_ModuleLoader
 * @author	dreamer
 * @package	Metaframework
 */
class Loader_CoreModuleLoader  implements Loader_ModuleLoader {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		string	$config
	 */
	protected $config = array();

	
	/**
	 * constructs an object of class {@link Loader_CoreModuleLoader}
	 * @generated	constructor stub for implementation
	 * @param	array	$config	array of type 'string'
	 */
	public function __construct($config) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1237997953375_167741_1072) ENABLED START */
		$this->config = $config;
		// config doctrine
		$datasource = $this->checkConfigEntry('data.source');
		Doctrine_Manager::connection($datasource);
		// config seasar
		
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240212756328_399075_727) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getModuleDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240212756328_897389_728) ENABLED START */
		return array();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237975998187_888171_855) ENABLED START */
		return array(
			Adapter_SeasarPhpBuilder::newComponent('Adapter_SeasarServiceRegistry', 'serviceRegistry', array(), array(
				// don't use special 'container' value to get a container instance - doesn't work :-(
				// insead, use auto binding - now it seams to work :-)
				Adapter_SeasarPhpBuilder::newProperty('container', 'container')
			)),
			Adapter_SeasarPhpBuilder::newComponent('Core_ServiceRegistryDispatcher', 'dispatcher', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('serviceRegistry', 'serviceRegistry'),
			)),
			Adapter_SeasarPhpBuilder::newComponent('Core_UrlResolver', 'resolver', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('dispatcher', 'dispatcher')
			)),
			Adapter_SeasarPhpBuilder::newComponent('Smarty', 'smarty'),
			Adapter_SeasarPhpBuilder::newComponent('Adapter_SmartyRenderer', 'renderer', array(), array(
				Adapter_SeasarPhpBuilder::newProperty('smarty', 'smarty')
			))
		);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237994233234_419091_1051) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Context
	 */
	public function getModuleContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237994233234_645847_1052) ENABLED START */
		$handler = '';
		if (array_key_exists('root.handler', $this->config)) {
			$handler = $this->config['root.handler'];
		}
		return new Core_Context('/', $handler);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_ServiceRegistry	$serviceRegistry	
	 */
	public function configureFrameworks($serviceRegistry) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238012074656_368905_1469) ENABLED START */
		$smarty = $serviceRegistry->getComponent('smarty');
		
		// smarty
		$smarty_template_dir = $this->checkConfigEntry('smarty.template.dir');
		$smarty->template_dir = $smarty_template_dir;
		
		$smarty_compile_dir = $this->checkConfigEntry('smarty.compile.dir');
		$smarty->compile_dir = $smarty_compile_dir;
		
		// register smarty template render function
		$renderer = $serviceRegistry->getComponent('renderer');
		$smarty->register_function('render', array($renderer, 'checkInclude'));
//		$smarty->register_resource('mfw', array(
//			$renderer, 'fetchMfwResourceSource', 'fetchMfwResourceTimestamp', 
//			'isMfwResourceSecured', 'isMfwResourceTrusted'));
//		$smarty->default_resource_type = 'mfw';
//		$smarty->default_template_handler_func = array($renderer, 'defaultTemplateHandler');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$key	
	 */
	protected function checkConfigEntry($key) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238011634203_792078_1422) ENABLED START */
		if (array_key_exists($key, $this->config)) {
			return $this->config[$key];
		} else {
			throw new Exception('configuration entry \'' . $key . '\' is missing');
		}
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237975932171_599452_831) ENABLED START */
	// TODO: put your further code implementations for class 'Loader_CoreModuleLoader' here
	/* PROTECTED REGION END */
}
?>
