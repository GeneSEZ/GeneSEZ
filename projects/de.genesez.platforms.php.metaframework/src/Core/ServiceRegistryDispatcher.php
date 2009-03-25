<?php
/**
 * @author	dreamer
 * @package	Core
 */

require_once 'Core/ServiceRegistry.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/Dispatcher.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_Dispatcher
 * @author	dreamer
 * @package	Core
 */
class Core_ServiceRegistryDispatcher  implements Core_Dispatcher {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Core_ServiceRegistry	$_serviceRegistry
	 */
	private $_serviceRegistry;
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 */
	public function dispatch($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238001182281_78033_1414) ENABLED START */
		// look up in seasar config for handler
		$name = $contextInfo->getHandler();
		$handler = NULL;
		if ($this->serviceRegistry->hasComponent($name)) {
			$handler = $this->serviceRegistry->getComponent($name);
		} else {
			// TODO: use DefaultController, if it is not possible to handle the request -> error.handler
			$handler = $this->serviceRegistry->getComponent('default.handler');
			//$handler = $this->serviceRegistry->getComponent('error.handler');
		}
		// invoke request handler with context path
		$handler->handle($contextInfo);
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Core_ServiceRegistryDispatcher::getServiceRegistry() $_serviceRegistry}
	 * @param	Core_ServiceRegistry	$serviceRegistry	the value to set
	 */
	public 	 function setServiceRegistry(Core_ServiceRegistry $serviceRegistry) {
		$this->_serviceRegistry = $serviceRegistry;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
	// TODO: put your further code implementations for class 'Core_ServiceRegistryDispatcher' here
	/* PROTECTED REGION END */
}
?>
