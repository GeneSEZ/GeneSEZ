<?php
require_once 'Core/ServiceRegistry.php';
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
	 * @var		string	$view
	 */
	protected $view;
	/**
	 * @generated	attribute definition
	 * @var		Core_ServiceRegistry	$serviceRegistry
	 */
	protected $serviceRegistry;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function baseServerUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239126458937_358804_1194) ENABLED START */
		return substr($_SERVER['SCRIPT_NAME'], 0, strrpos($_SERVER['SCRIPT_NAME'], '/') +1);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function baseRequestUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240211928703_764012_723) ENABLED START */
		return $_SERVER['SCRIPT_NAME'];
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	string
	 */
	public function baseHandlerUri($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240404866671_222215_518) ENABLED START */
		return $_SERVER['SCRIPT_NAME'] . $handlerInfo->context;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public static function defaultView() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240240687687_163465_951) ENABLED START */
		$view = Core_Url::requestPath();
		if (substr($view, 0, 1) === '/') {
			$view = substr($view, 1);
		}
		return $view;
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Core_BaseRequestHandler::getView() $view}
	 * @param	string	$view	the value to set
	 */
	
	public 	 function setView($view) {
		$this->view = $view;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_BaseRequestHandler::getServiceRegistry() $serviceRegistry}
	 * @param	Core_ServiceRegistry	$serviceRegistry	the value to set
	 */
	public 	 function setServiceRegistry(Core_ServiceRegistry $serviceRegistry) {
		$this->serviceRegistry = $serviceRegistry;
	}

	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>view</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'view': return $this->view;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239125989500_25423_1168) ENABLED START */
	// TODO: put your further code implementations for class 'Core_BaseRequestHandler' here
	/* PROTECTED REGION END */
}
?>
