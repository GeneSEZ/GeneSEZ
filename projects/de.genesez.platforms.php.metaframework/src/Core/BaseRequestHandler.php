<?php
require_once 'Core/Dto.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/RequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239125989500_25423_1168) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_RequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Core_BaseRequestHandler  implements Core_RequestHandler {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		string	$_view
	 */
	private $_view;
	
	
	// -- method declarations -----------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public abstract function handle($handlerInfo);
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function baseUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239126458937_358804_1194) ENABLED START */
		// TODO: implementation of method 'Core_BaseRequestHandler.baseUri(...)'
		throw new Exception('The implementation of the method Core_BaseRequestHandler::baseUri is missing !');
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Core_BaseRequestHandler::getView() $_view}
	 * @param	string	$view	the value to set
	 */
	
	public 	 function setView($view) {
		$this->_view = $view;
	}
	/**
	 * magic getter to obtain the unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>view</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 * @return	mixed	the value of the member or an exception if the member is neither accessible nor available
	 */
	public function __get($name) {
		switch ($name) {
			case 'view': return $this->_view;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239125989500_25423_1168) ENABLED START */
	// TODO: put your further code implementations for class 'Core_BaseRequestHandler' here
	/* PROTECTED REGION END */
}
?>
