<?php
require_once 'Core/Dto.php';
require_once 'Core/RequestHandler.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/BaseRequestHandler.php';
require_once 'Core/CompositeRequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239126507031_967775_1198) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseRequestHandler
 * @see		Core_CompositeRequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
class Core_BaseCompositeRequestHandler extends Core_BaseRequestHandler implements Core_CompositeRequestHandler {

	/**
	 * @var	array of Core_RequestHandler	stores the linked objects of the  multi qualified unidirectional to one association to {@link Core_RequestHandler} (symmetry ensured) 
	 */
	private $_nestedRequestHandler = array();
	/**
	 * holds the association management object for the multi qualified unidirectional to one association to {@link Core_RequestHandler} (symmetry ensured)
	 * @var UML_MultiQualifiedAssociation
	 */
	private $associations;
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Core_BaseCompositeRequestHandler}
	 * @generated	constructor stub for implementation
	 * @param	array	$requestHandlers	array of type 'Core_RequestHandler'
	 */
	public function __construct($requestHandlers) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240398478812_21504_360) ENABLED START */
		foreach ($requestHandlers as $key => $handler) {
			$this->nestedRequestHandler->insert($key, $handler);
		}
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239127196828_615219_1284) ENABLED START */
		$dto = new Core_BaseDto(array(), $this->view);
		foreach ($this->nestedRequestHandler->iterator() as $key => $value) {
			$dto->$key = $value->handle($handlerInfo);
		}
		return $dto;
		/* PROTECTED REGION END */
	}



	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedRequestHandler</var>: the  multi qualified unidirectional to one association to {@link Core_RequestHandler} (symmetry ensured)</li>
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
	// TODO: put your further code implementations for class 'Core_BaseCompositeRequestHandler' here
	/* PROTECTED REGION END */
}
?>
