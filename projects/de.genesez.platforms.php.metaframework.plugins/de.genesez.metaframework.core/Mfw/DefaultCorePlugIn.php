<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243684038328_916775_329) ENABLED START */
require_once 's2container/S2Container.php';
require_once 'Doctrine/Doctrine.php';
require_once 'Smarty/Smarty.class.php';

spl_autoload_register(array('Doctrine', 'autoload'));

S2ContainerClassLoader::import(S2CONTAINER_PHP5);
spl_autoload_register(array('S2ContainerClassLoader', 'load'));
/* PROTECTED REGION END */

/**
 * Provides a default implementation of the core plug-in interface.
 * @see		Mfw_PlugInBase
 * @see		Mfw_CorePlugIn
 * @author	dreamer
 * @package	de.genesez.metaframework.core
 */
class Mfw_DefaultCorePlugIn extends Mfw_PlugInBase implements Mfw_CorePlugIn {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		string	$config
	 */
	protected $config = array();
	/**
	 * @generated	attribute definition
	 * @var		S2Container	$container
	 */
	protected $container;
	
	
	/**
	 * Constructs a core plug-in with configuration options.
	 * @param	array	$config	array of type 'string'
	 */
	public function __construct(array $config) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1243684038343_975520_335) ENABLED START */
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
	 * @return	string
	 */
	public function getId() {
		return 'de.genesez.metaframework.core';
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_ServiceRegistry
	 */
	public function getServiceRegistry() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243684120953_545656_381) ENABLED START */
		if ($this->container === null) {
			$this->container = Mfw_SeasarPhpBuilder::newContainer(
				$this->getComponents()
			);
			Mfw_SeasarPhpBuilder::finishContainer($this->container);
		}
		return $this->container->getComponent('serviceRegistry');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243684038343_689377_337) ENABLED START */
		return array(
			Mfw_SeasarPhpBuilder::newComponent('Mfw_SeasarServiceRegistry', 'serviceRegistry', array(), array(
				// don't use special 'container' value to get a container instance - doesn't work :-(
				// insead, use auto binding - now it seams to work :-)
				Mfw_SeasarPhpBuilder::newProperty('container', 'container')
			)),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_ArrayPlugInRegistry', 'plugInRegistry'),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_ArrayExtensionRegistry', 'extensionRegistry'),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_ArrayInterceptorRegistry', 'interceptorRegistry'),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_ServiceRegistryLocator', 'locator', array(), array(
				Mfw_SeasarPhpBuilder::newProperty('serviceRegistry', 'serviceRegistry'),
			)),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_UrlResolver', 'resolver'),
			Mfw_SeasarPhpBuilder::newComponent('Smarty', 'smarty'),
			Mfw_SeasarPhpBuilder::newComponent('Mfw_SmartyRendering', 'rendering', array(), array(
				Mfw_SeasarPhpBuilder::newProperty('smarty', 'smarty')
			))
		);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Context
	 */
	public function getContext() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243684038343_616250_339) ENABLED START */
		$handler = '';
		if (array_key_exists('root.handler', $this->config)) {
			$handler = $this->config['root.handler'];
		}
		return new Mfw_Context('/', $handler);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	public function finishInitialization() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243684038343_292645_340) ENABLED START */
		$serviceRegistry = $this->container->getComponent('serviceRegistry');
		
		// smarty
		$smarty = $serviceRegistry->getComponent('smarty');
		$smarty_template_dir = $this->checkConfigEntry('smarty.template.dir');
		$smarty->template_dir = $smarty_template_dir;
		$smarty_compile_dir = $this->checkConfigEntry('smarty.compile.dir');
		$smarty->compile_dir = $smarty_compile_dir;
		
		// register smarty template render function
		$rendering = $serviceRegistry->getComponent('rendering');
		$smarty->register_function('render', array($rendering, 'checkInclude'));
		
//		$smarty->register_resource('mfw', array(
//			$rendering, 'fetchMfwResourceSource', 'fetchMfwResourceTimestamp', 
//			'isMfwResourceSecured', 'isMfwResourceTrusted'));
//		$smarty->default_resource_type = 'mfw';
//		$smarty->default_template_handler_func = array($rendering, 'defaultTemplateHandler');
		
		// finalize seasar container
		Mfw_SeasarPhpBuilder::finishContainer($this->container);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$key	
	 */
	protected function checkConfigEntry($key) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243684038343_842790_341) ENABLED START */
		if (array_key_exists($key, $this->config)) {
			return $this->config[$key];
		} else {
			throw new Exception('configuration entry \'' . $key . '\' is missing');
		}
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243684038328_916775_329) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_DefaultCorePlugIn' here
	/* PROTECTED REGION END */
}
?>
