<?php

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
	 * @var		string	$_url
	 */
	private $_url;
	/**
	 * @generated	attribute definition
	 * @var		string	$_pathInfo
	 */
	private $_pathInfo;
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class {@link Core_HandlerInfo}
	 * @generated	constructor stub for implementation
	 * @param	string	$handler	
	 * @param	string	$pathInfo	
	 * @param	string	$url	default value is 'null'
	 */
	public function __construct($handler, $pathInfo, $url = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236338137828_752628_437) ENABLED START */
		$this->_handler = $handler;
		$this->_pathInfo = $pathInfo;
		$this->_url = $url;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain the unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>url</var>: </li>
	 *   <li><var>pathInfo</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 * @return	mixed	the value of the member or an exception if the member is neither accessible nor available
	 */
	public function __get($name) {
		switch ($name) {
			case 'handler': return $this->_handler;
			case 'url': return $this->_url;
			case 'pathInfo': return $this->_pathInfo;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1236337727984_243900_412) ENABLED START */
	// TODO: put your further code implementations for class 'HandlerInfo' here
	public function offsetExists($offset) {}
	public function offsetGet($offset) {}
	public function offsetSet($offset, $value) {}
	public function offsetUnset($offset) {}
	/* PROTECTED REGION END */
}
?>
