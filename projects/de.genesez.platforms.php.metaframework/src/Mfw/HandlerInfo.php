<?php
require_once 'Mfw/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236337727984_243900_412) ENABLED START */
// TODO: put your further include + require statements here
require_once 'Mfw/Url.php';
/* PROTECTED REGION END */

/**
 * Provides information to <b>locate</b> request handler, the <b>execution 
 * context</b> of the request handler and information about the url paths.
 * @see		ArrayAccess
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_HandlerInfo  implements ArrayAccess {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_HandlerInfo::getHandler()}
	 * @generated	attribute definition
	 * @var		string	$_handler
	 */
	private $_handler;
	/**
	 * documented here {@link Mfw_HandlerInfo::getContext()}
	 * @generated	attribute definition
	 * @var		Mfw_Context	$_context
	 */
	private $_context;
	/**
	 * documented here {@link Mfw_HandlerInfo::getPathInfo()}
	 * @generated	attribute definition
	 * @var		string	$_pathInfo
	 */
	private $_pathInfo = array();
	/**
	 * documented here {@link Mfw_HandlerInfo::getRequestedPath()}
	 * @generated	attribute definition
	 * @var		string	$_requestedPath
	 */
	private $_requestedPath;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs a handler info object.
	 * @param	Mfw_Context	$context	the context of the request handler
	 * @param	string	$pathInfo	the additional url part relative to the request handler
	 * @param	string	$requestedPath	the path info of the currently executing script
	 */
	public function __construct(Mfw_Context $context, $pathInfo, $requestedPath) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236338137828_752628_437) ENABLED START */
		$this->_context = $context;
		$this->_handler = $context->handler;
		$this->_pathInfo = Mfw_Url::requestInfo($pathInfo);
		$this->_requestedPath = $requestedPath;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>handler</var>: the request handler to call</li>
	 *   <li><var>context</var>: the context on which the request handler operates (and therefore the 
context defining the request handler)
</li>
	 *   <li><var>pathInfo</var>: The url part which is specified in addition to the url part on which the 
request handler operates.
</li>
	 *   <li><var>requestedPath</var>: The complete path which was requested, i.e. the concatenated value of 
context and path info. In other words the path info of the requested php 
script (index.php).
</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'handler': return $this->_handler;
			case 'context': return $this->_context;
			case 'pathInfo': return $this->_pathInfo;
			case 'requestedPath': return $this->_requestedPath;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1236337727984_243900_412) ENABLED START */
	// TODO: put your further code implementations for class 'HandlerInfo' here
	public function offsetExists($offset) {
		return array_key_exists($offset, $this->_pathInfo);
	}
	public function offsetGet($offset) {
		return $this->_pathInfo[$offset];
	}
	public function offsetSet($offset, $value) {
		$this->_pathInfo[$offset] = $value;
	}
	public function offsetUnset($offset) {
		unset($this->_pathInfo[$offset]);
	}
	/* PROTECTED REGION END */
}
?>
