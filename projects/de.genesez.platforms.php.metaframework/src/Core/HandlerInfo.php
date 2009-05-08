<?php
require_once 'Core/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236337727984_243900_412) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		ArrayAccess
 * @author	dreamer
 * @package	Metaframework
 */
class Core_HandlerInfo  implements ArrayAccess {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		string	$_handler
	 */
	private $_handler;
	/**
	 * @generated	attribute definition
	 * @var		Core_Context	$_context
	 */
	private $_context;
	/**
	 * @generated	attribute definition
	 * @var		string	$_pathInfo
	 */
	private $_pathInfo = array();

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Core_HandlerInfo}
	 * @generated	constructor stub for implementation
	 * @param	Core_Context	$context	
	 * @param	string	$pathInfo	
	 */
	public function __construct($context, $pathInfo) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236338137828_752628_437) ENABLED START */
		$this->_context = $context;
		$this->_handler = $context->handler;
		$this->_pathInfo = Core_Url::requestInfo($pathInfo);
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------


	// -- association + attribute accessors ---------------------------------

	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>context</var>: </li>
	 *   <li><var>pathInfo</var>: </li>
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
