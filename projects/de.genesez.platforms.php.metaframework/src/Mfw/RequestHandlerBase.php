<?php
require_once 'Mfw/ServiceRegistry.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/RequestHandler.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239125989500_25423_1168) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a <b>base implementation</b> for request handlers by providing 
 * useful methods as well as a reference to the service registry..
 * @see		Mfw_RequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Mfw_RequestHandlerBase  implements Mfw_RequestHandler {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_RequestHandlerBase::getView()}
	 * @generated	attribute definition
	 * @var		string	$view
	 */
	protected $view;
	/**
	 * documented here {@link Mfw_RequestHandlerBase::getServiceRegistry()}
	 * @generated	attribute definition
	 * @var		Mfw_ServiceRegistry	$serviceRegistry
	 */
	protected $serviceRegistry;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Returns the base server URL, i.e. the accessible <b>root url</b> of the 
	 * server, see {@link Mfw_Url::baseServerUri()}
	 * @return	string
	 */
	public static function baseServerUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239126458937_358804_1194) ENABLED START */
		return Mfw_Url::baseServerUri();
		/* PROTECTED REGION END */
	}

	/**
	 * Returns the base request URL, i.e. the url of the <b>requested</b> php 
	 * script, see {@link Mfw_Url::baseRequestUri()}
	 * @return	string
	 */
	public static function baseRequestUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240211928703_764012_723) ENABLED START */
		return Mfw_Url::baseRequestUri();
		/* PROTECTED REGION END */
	}

	/**
	 * Returns the URL of the <b>current handler</b>, i.e. the base request uri 
	 * concatenated with the context path of the current request handler.
	 * @param	Mfw_HandlerInfo	$handlerInfo	information about the current handled context
	 * @return	string
	 */
	public function baseHandlerUri(Mfw_HandlerInfo $handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240404866671_222215_518) ENABLED START */
		return $_SERVER['SCRIPT_NAME'] . $handlerInfo->context;
		/* PROTECTED REGION END */
	}

	/**
	 * Returns a <b>default identifier</b> of the view used to render the output 
	 * of the current request.
	 * @return	string
	 */
	public static function defaultView() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240240687687_163465_951) ENABLED START */
		$view = Mfw_Url::requestPath();
		if (substr($view, 0, 1) === '/') {
			$view = substr($view, 1);
		}
		return $view;
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * documented here {@link Mfw_RequestHandlerBase::getView()}
	 * @generated	setter method for the attribute {@link Mfw_RequestHandlerBase::getView() $view}
	 * @param	string	$view	the value to set
	 */
	
	public 	 function setView($view) {
		$this->view = $view;
	}
	/**
	 * documented here {@link Mfw_RequestHandlerBase::getServiceRegistry()}
	 * @generated	setter method for the attribute {@link Mfw_RequestHandlerBase::getServiceRegistry() $serviceRegistry}
	 * @param	Mfw_ServiceRegistry	$serviceRegistry	the value to set
	 */
	public 	 function setServiceRegistry(Mfw_ServiceRegistry $serviceRegistry) {
		$this->serviceRegistry = $serviceRegistry;
	}
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>view</var>: the identifier of the view which generates the output</li>
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
	// TODO: put your further code implementations for class 'Mfw_BaseRequestHandler' here
	/* PROTECTED REGION END */
}
?>
