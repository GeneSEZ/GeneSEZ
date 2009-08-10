<?php
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Dto.php';
require_once 'Mfw/RequestHandlerBase.php';
require_once 'Mfw/CompositeRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241623038062_2281_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides an abstract implementation of the <b>Decorator</b> and <b>Delegator</b> 
 * design pattern for request handlers, allowing the addition of 
 * functionality to existing request handlers as well as the delegation to 
 * other request handlers.
 * @see		Mfw_RequestHandlerBase
 * @see		Mfw_CompositeRequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Mfw_DecorateRequestHandler extends Mfw_RequestHandlerBase implements Mfw_CompositeRequestHandler {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_DecorateRequestHandler::getHandler()}
	 * @generated	attribute definition
	 * @var		Mfw_RequestHandler	$handler
	 */
	protected $handler;
	/**
	 * documented here {@link Mfw_DecorateRequestHandler::getHandlerInfo()}
	 * @generated	attribute definition
	 * @var		Mfw_HandlerInfo	$handlerInfo
	 */
	protected $handlerInfo;
	/**
	 * @var	array of Mfw_RequestHandler	stores the linked objects of the  multi qualified unidirectional to one association to {@link Mfw_RequestHandler} (symmetry ensured) ({@link __get() documented here})
	 */
	private $_nestedRequestHandler = array();
	/**
	 * holds the association management object for the multi qualified unidirectional to one association to {@link Mfw_RequestHandler} (symmetry ensured)
	 * @var UML_MultiQualifiedAssociation
	 */
	private $associations;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs a request handler which uses other request handlers to process 
	 * the request.
	 * <br>
	 * <br>Note: the second parameter takes an associative array with <i>key =&gt; value</i> 
	 * pairs, the key specifying the <b>name</b> of the request handler and the 
	 * value specifying the request handler.
	 * @param	Mfw_RequestHandler	$handler	the request handler to decorate
	 * @param	array	$delegateHandler	an associative array with key => value pairs of delegated request handlers
	 */
	public function __construct(Mfw_RequestHandler $handler, array $delegateHandler = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1241623229562_999301_382) ENABLED START */
		$this->handler = $handler;
		foreach ($delegateHandler as $name => $handler) {
			$this->nestedRequestHandler->insert($name, $handler);
		}
		/* PROTECTED REGION END */
	}
	
	// -- method declarations -----------------------------------------------
	
	/**
	 * Decorates the data transfer objects of the delegation and the decorated 
	 * request handler.
	 * @param	Mfw_Dto	$dto	the data transfer object to decorate
	 * @param	Mfw_HandlerInfo	$handlerInfo	information about the current handled context
	 * @return	Mfw_Dto
	 */
	protected abstract function decorate(Mfw_Dto $dto, Mfw_HandlerInfo $handlerInfo);
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Processes the requst using the <b>decorated</b> and the delegation request 
	 * handlers. The data transfer objects of the delegation request handlers are 
	 * added to the data transfer object of the decorated request handler. The 
	 * DTO is then passed to the decorate method.
	 * @param	Mfw_HandlerInfo	$handlerInfo	information about the current handled context
	 * @return	Mfw_Dto
	 */
	public function handle(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241623279562_741440_386) ENABLED START */
//		$this->handlerInfo = $handlerInfo;
		$dto = $this->handler->handle($handlerInfo);
		foreach ($this->nestedRequestHandler->iterator() as $name => $handler) {
			$dto->$name = $handler->handle($handlerInfo);
		}
		return $this->decorate($dto, $handlerInfo);
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedRequestHandler</var>: [contains the request handlers to build the composite]</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'nestedRequestHandler' :
				if ($this->associations === null) {
					$this->associations = new UML_MultiQualifiedAssociation($this, $this->_nestedRequestHandler);
				}
				return $this->associations;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241623038062_2281_361) ENABLED START */
	// TODO: put your further code implementations for class 'DecoratedRequestHandler' here
	/* PROTECTED REGION END */
}
?>
