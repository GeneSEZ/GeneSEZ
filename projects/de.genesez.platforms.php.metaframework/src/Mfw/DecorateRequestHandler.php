<?php
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Dto.php';
require_once 'Mfw/RequestHandlerBase.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241623038062_2281_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Abstract implementation of the <b>Decorator</b> and <b>Delegator</b> 
 * design pattern for request handlers, allowing the addition of 
 * functionality to existing request handlers 
 * as well as the delegation to other request handlers.
 * @see		Mfw_RequestHandlerBase
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Mfw_DecorateRequestHandler extends Mfw_RequestHandlerBase  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Mfw_RequestHandler	$handler
	 */
	protected $handler;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_HandlerInfo	$handlerInfo
	 */
	protected $handlerInfo;
	/**
	 * @generated	attribute definition
	 * @var		Mfw_RequestHandler	$delegateHandler
	 */
	protected $delegateHandler = array();

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Creates a new request handler which uses other request handlers to process 
 * the request.
	 * @generated	constructor stub for implementation
	 * @param	Mfw_RequestHandler	$handler	the request handler to decorate
	 * @param	array	$delegateHandler	an associative array with key => value pairs of delegated request handlers
	 */
	public function __construct($handler, $delegateHandler = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1241623229562_999301_382) ENABLED START */
		$this->handler = $handler;
		$this->delegateHandler = $delegateHandler;
		/* PROTECTED REGION END */
	}


	// -- method declarations -----------------------------------------------
	
	/**
	 * Decorates the data transfer objects of the delegation and the decorated 
	 * request handler.
	 * @param	Mfw_Dto	$dto	the data transfer object to decorate
	 * @param	Mfw_HandlerInfo	$handlerInfo	
	 * @return	Mfw_Dto
	 */
	protected abstract function decorate($dto, $handlerInfo);

	// -- method implementations --------------------------------------------
	
	/**
	 * Handles the requst using the decorated and the delegation request 
	 * handlers. The data transfer objects of the delegation request handlers are 
	 * added to the data transfer object of the decorated request handler. The 
	 * DTO is then passed to the decorate method.
	 * @param	Mfw_HandlerInfo	$handlerInfo	
	 * @return	Mfw_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241623279562_741440_386) ENABLED START */
//		$this->handlerInfo = $handlerInfo;
		$dto = $this->handler->handle($handlerInfo);
		foreach ($this->delegateHandler as $name => $handler) {
			$dto->$name = $handler->handle($handlerInfo);
		}
		return $this->decorate($dto, $handlerInfo);
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241623038062_2281_361) ENABLED START */
	// TODO: put your further code implementations for class 'DecoratedRequestHandler' here
	/* PROTECTED REGION END */
}
?>
