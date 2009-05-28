<?php
require_once 'Core/ServiceRegistry.php';
require_once 'Core/Renderer.php';
require_once 'Core/RequestHandler.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/Dto.php';
require_once 'Core/Dispatcher.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_Dispatcher
 * @author	dreamer
 * @package	Metaframework
 */
class Core_ServiceRegistryDispatcher  implements Core_Dispatcher {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Core_ServiceRegistry	$_serviceRegistry
	 */
	private $_serviceRegistry;
	/**
	 * @generated	attribute definition
	 * @var		Core_Renderer	$_renderer
	 */
	private $_renderer;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$noHandlerFoundHandler
	 */
	protected $noHandlerFoundHandler;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$unresolvableHandlerHandler
	 */
	protected $unresolvableHandlerHandler;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 */
	protected function noHandlerFound($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240231388968_524116_914) ENABLED START */
		if ($this->noHandlerFoundHandler !== null) {
			$dto = $this->noHandlerFoundHandler->handle($handlerInfo);
			$this->render($dto);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 */
	protected function unresolvableHandler($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240231367593_354798_910) ENABLED START */
		if ($this->unresolvableHandlerHandler !== null) {
			$dto = $this->unresolvableHandlerHandler->handle($handlerInfo);
			$this->render($dto);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_Dto	$dto	
	 */
	protected function render($dto) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240236389843_932232_920) ENABLED START */
		$this->_renderer->render($dto);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 */
	public function dispatch($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238001182281_78033_1414) ENABLED START */
		// look up in seasar config for handler
		$name = $handlerInfo->handler;
		if ($name === null || $name === '') {
			$this->unresolvableHandler($handlerInfo);
			return;
		}
		if (!$this->_serviceRegistry->hasComponent($name)) {
			$this->noHandlerFound($handlerInfo);
			return;
		}
		// invoke request handler with context path
		$handler = $this->_serviceRegistry->getComponent($name);
		$dto = $handler->handle($handlerInfo);
		if ($dto !== true) {
			$this->render($dto);
		}
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
	/**
	 * @generated	setter method for the attribute {@link Core_ServiceRegistryDispatcher::getRenderer() $_renderer}
	 * @param	Core_Renderer	$renderer	the value to set
	 */
	public 	 function setRenderer(Core_Renderer $renderer) {
		$this->_renderer = $renderer;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_ServiceRegistryDispatcher::getNoHandlerFoundHandler() $noHandlerFoundHandler}
	 * @param	Core_RequestHandler	$noHandlerFoundHandler	the value to set
	 */
	public 	 function setNoHandlerFoundHandler(Core_RequestHandler $noHandlerFoundHandler) {
		$this->noHandlerFoundHandler = $noHandlerFoundHandler;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_ServiceRegistryDispatcher::getUnresolvableHandlerHandler() $unresolvableHandlerHandler}
	 * @param	Core_RequestHandler	$unresolvableHandlerHandler	the value to set
	 */
	public 	 function setUnresolvableHandlerHandler(Core_RequestHandler $unresolvableHandlerHandler) {
		$this->unresolvableHandlerHandler = $unresolvableHandlerHandler;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1238001028515_778985_1381) ENABLED START */
	// TODO: put your further code implementations for class 'Core_ServiceRegistryDispatcher' here
	/* PROTECTED REGION END */
}
?>
