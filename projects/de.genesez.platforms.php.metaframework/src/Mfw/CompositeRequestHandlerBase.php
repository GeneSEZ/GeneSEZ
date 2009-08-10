<?php
require_once 'Mfw/Dto.php';
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/RequestHandlerBase.php';
require_once 'Mfw/CompositeRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239126507031_967775_1198) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a <b>default implementation</b> according the composite design 
 * pattern, by delegating the handling of the request to all nested request 
 * handlers.
 * @see		Mfw_RequestHandlerBase
 * @see		Mfw_CompositeRequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_CompositeRequestHandlerBase extends Mfw_RequestHandlerBase implements Mfw_CompositeRequestHandler {
	
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
	 * Constructs a composite request handler with an associative array 
	 * specifying <b>name =&gt; request handler</b> pairs.
	 * @param	array	$requestHandlers	an associative array specifying name => request handler pairs
	 */
	public function __construct(array $requestHandlers = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240398478812_21504_360) ENABLED START */
		foreach ($requestHandlers as $key => $handler) {
			$this->nestedRequestHandler->insert($key, $handler);
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Processes the request using all nested request handlers by building a <b>composite</b> 
	 * data transfer object.
	 * @param	Mfw_HandlerInfo	$handlerInfo	information about the current handled context
	 * @return	Mfw_Dto
	 */
	public function handle(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243428136578_635889_1061) ENABLED START */
		$dto = new Mfw_DtoBase(array(), $this->view);
		foreach ($this->nestedRequestHandler->iterator() as $name => $handler) {
			$dto->$name = $handler->handle($handlerInfo);
		}
		return $dto;
		/* PROTECTED REGION END */
	}
	

	
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
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239126507031_967775_1198) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_CompositeRequestHandlerBase' here
	/* PROTECTED REGION END */
}
?>
