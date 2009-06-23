<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240242598453_62053_985) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_Action   {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		string	$_name
	 */
	private $_name;
	/**
	 * @generated	attribute definition
	 * @var		string	$_method
	 */
	private $_method;
	/**
	 * @generated	attribute definition
	 * @var		boolean	$_withId
	 */
	private $_withId;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link Mfw_Action}
	 * @param	string	$name	
	 * @param	boolean	$withId	default value is 'true'
	 * @param	string	$method	default value is 'null'
	 */
	public function __construct($name, $withId = true, $method = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240242723296_780498_1026) ENABLED START */
		$this->_name = $name;
		if ($method === null) {
			$this->_method = $name;
		} else {
			$this->_method = $method;
		}
		$this->_withId = $withId;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>name</var>: </li>
	 *   <li><var>method</var>: </li>
	 *   <li><var>withId</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'name': return $this->_name;
			case 'method': return $this->_method;
			case 'withId': return $this->_withId;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240242598453_62053_985) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_Action' here
	/* PROTECTED REGION END */
}
?>
