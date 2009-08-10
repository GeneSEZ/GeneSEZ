<?php
require_once 'Mfw/ServiceRegistry.php';
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Locator.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a <b>service registry</b> based implementation of the locator 
 * interface. The request handler is obtained from a service registry.
 * @see		Mfw_Locator
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ServiceRegistryLocator  implements Mfw_Locator {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_ServiceRegistryLocator::getServiceRegistry()}
	 * @generated	attribute definition
	 * @var		Mfw_ServiceRegistry	$serviceRegistry
	 */
	protected $serviceRegistry;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Locates the request handler using the specified information.
	 * @param	Mfw_HandlerInfo	$handlerInfo	the information needed to find the request handler
	 * @return	Mfw_RequestHandler
	 */
	public function locate(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238001028515_778985_1381__16_0_b6f02e1_1238000869515_422706_1273) ENABLED START */
		// look up in seasar config for handler
		$name = $handlerInfo->handler;
		if ($name === null || $name === '') {
			return $this->unresolvableHandler($handlerInfo);
		}
		if (!$this->serviceRegistry->hasComponent($name)) {
			return $this->noHandlerFound($handlerInfo);
		}
		// invoke request handler with context path
		$handler = $this->serviceRegistry->getComponent($name);
		$dto = $handler->handle($handlerInfo);
		return $dto;
		/* PROTECTED REGION END */
	}
	
	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_HandlerInfo	$handlerInfo	
	 */
	protected function noHandlerFound(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240231388968_524116_914) ENABLED START */
		// TODO: implementation of method 'Mfw_ServiceRegistryLocator.noHandlerFound(...)'
		throw new Exception('The implementation of the method Mfw_ServiceRegistryLocator::noHandlerFound is missing !');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_HandlerInfo	$handlerInfo	
	 */
	protected function unresolvableHandler(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240231367593_354798_910) ENABLED START */
		// TODO: implementation of method 'Mfw_ServiceRegistryLocator.unresolvableHandler(...)'
		throw new Exception('The implementation of the method Mfw_ServiceRegistryLocator::unresolvableHandler is missing !');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * documented here {@link Mfw_ServiceRegistryLocator::getServiceRegistry()}
	 * @generated	setter method for the attribute {@link Mfw_ServiceRegistryLocator::getServiceRegistry() $serviceRegistry}
	 * @param	Mfw_ServiceRegistry	$serviceRegistry	the value to set
	 */
	public 	 function setServiceRegistry(Mfw_ServiceRegistry $serviceRegistry) {
		$this->serviceRegistry = $serviceRegistry;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_ServiceRegistryLocator' here
	/* PROTECTED REGION END */
}
?>
