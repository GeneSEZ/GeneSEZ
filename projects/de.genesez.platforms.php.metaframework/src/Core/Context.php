<?php
require_once 'Core/HandlerInfo.php';
require_once 'Core/Resolver.php';
require_once 'UML/ManyAssociation.php';
require_once 'UML/OneAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236334265906_925929_844) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * The context describes an accessible part of an URL and provides an handler for it. 
 * 
 * A URL can be splitted on each occurence of the slash <code>/</code>. Then each part 
 * forms a context. For example, the following URL:
 * <code>web.server/web.app.root/subcontext/subsub</code>
 * consists of three contexts:
 * <ul>
 * <li>the root context <code>web.server/web.app.root/</code></li>
 * <li>a nested sub context <code>subcontext</code> below the root context</li>
 * <li>and a nested context below the subcontext <code>subsub</code>.</li>
 * </ul>
 * @see		Core_Resolver
 * @author	dreamer
 * @package	Core
 */
class Core_Context  implements Core_Resolver {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		string	$_name
	 */
	private $_name;
	/**
	 * @generated	attribute definition
	 * @var		string	$_handler
	 */
	private $_handler;
	/**
	 * @generated	attribute definition
	 * @var		string	$_layout
	 */
	private $_layout;
	/**
	 * stores the linked objects of the bidirectional one to many association to {@link Core_Context}
	 * @var		array	documented here {@link __get()}
	 */
	private $_nestedContext = array();
	/**
	 * stores the linked object of the bidirectional many to one association to {@link Core_Context}
	 * @var		Core_Context	documented here {@link __get()}
	 */
	private $_parent;
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>nestedContext</var>: the bidirectional one to many association to {@link Core_Context}</li>
	 *   <li><var>parent</var>: the bidirectional many to one association to {@link Core_Context}</li>
	 * </ul>
	 * @var Association
	 */
	private $associations = array();
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class {@link Core_Context}
	 * @generated	constructor stub for implementation
	 * @param	string	$name	
	 * @param	string	$handler	default value is 'null'
	 * @param	array	$nestedContext	array of type 'Core_Context', default value is 'array()'
	 * @param	string	$layout	default value is 'null'
	 */
	public function __construct($name, $handler = null, $nestedContext = array(), $layout = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236338382406_230888_479) ENABLED START */
		$this->_name = $name;
		$this->_handler = $handler;
		$this->_layout = $layout;
		foreach ($nestedContext as $context) {
			$this->nestedContext->insert($context);
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	Core_HandlerInfo
	 */
	public function resolveHandler($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344597078_642983_540) ENABLED START */
		$handler = null;
		// check if this context is addressed
		if ($path === '' || $path === '/') {
			$path = '/';
			$handler = $this->handler;
		} else {
			// check if sub context exists
			$name = $this->_getContextName($path);
			if ($this->_hasNestedContext($name)) {
				$subPath = $this->_getNestedContextPath($path);
				$subHandler = $this->_getNestedContext($name)->resolveHandler($subPath);
				// check handler of sub context
				if ($subHandler !== null) {
					return $subHandler;
				}
				// no nested context handler -> fallback
				$handler = $this->handler;
			} else {
				$handler = $this->handler;
			}
		}
		// return context handler
		if ($handler === null) {
			return null;
		} else {
			return new Core_HandlerInfo($handler, $path);
		}
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	string
	 */
	public function resolveLayout($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238062942906_584232_690) ENABLED START */
		// TODO: implementation of method 'Core_Context.resolveLayout(...)'
		throw new Exception('The implementation of the method Core_Context::resolveLayout is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	string
	 */
	private function _getContextName($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344451046_376159_524) ENABLED START */
		$start = stripos($path, '/') +1;
		$end = stripos($path, '/', $start);
		if ($end === false) {
			$end = strlen($path);
		}
		$context = substr($path, $start, $end - $start);
		return $context;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$path	
	 * @return	string
	 */
	private function _getNestedContextPath($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344470703_627145_528) ENABLED START */
		if (substr($path, 0, 1) === '/') {
			$offset = 1;
		} else {
			$offset = 0;
		}
		$start = stripos($path, '/', $offset);
		if ($start === false) {
			return '';
		}
		return substr($path, $start);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	private function _hasNestedContext($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344500656_69056_532) ENABLED START */
		foreach ($this->nestedContext->getAll() as $context) {
			if ($context->name === $name) {
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	string
	 */
	private function _getNestedContext($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344519843_703618_536) ENABLED START */
		foreach ($this->nestedContext->getAll() as $context) {
			if ($context->name === $name) {
				return $context;
			}
		}
		return null;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function __toString() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344802625_729711_545) ENABLED START */
		// TODO: implementation of method 'Context.__toString(...)'
		throw new Exception('The implementation of the method Context::__toString is missing !');
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain the unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>name</var>: </li>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>layout</var>: </li>
	 *   <li><var>nestedContext</var>: the bidirectional one to many association to {@link Core_Context}</li>
	 *   <li><var>parent</var>: the bidirectional many to one association to {@link Core_Context}</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 * @return	mixed	the value of the member or an exception if the member is neither accessible nor available
	 */
	public function __get($name) {
		switch ($name) {
			case 'name': return $this->_name;
			case 'handler': return $this->_handler;
			case 'layout': return $this->_layout;
			case 'nestedContext': return $this->getInitializedAssociation($name);
			case 'parent': return $this->getInitializedAssociation($name);
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	/**
	 * magic setter to set the values of the following members:
	 * <ul>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>layout</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @param	mixed	$value	the value to set
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 */
	public function __set($name, $value) {
		switch ($name) {
			case 'handler': $this->_handler = $value; return;
			case 'layout': $this->_layout = $value; return;
			default: throw new Exception('cannot set the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	/**
	 * checks if a value is assigned to one the following members:
	 * <ul>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>layout</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 * @return	boolean	the value of the member or an exception if the member is neither accessible nor available
	 */
	public function __isset($name) {
		switch ($name) {
			case 'handler': return isset($this->_handler);
			case 'layout': return isset($this->_layout);
			default: throw new Exception('cannot check if the value of an inaccessible or unavailable property is set: ' . $name); break;
		}
	}
	/**
	 * unsets (set to <var>null</var>) the value of the following members:
	 * <ul>
	 *   <li><var>handler</var>: </li>
	 *   <li><var>layout</var>: </li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 */
	public function __unset($name) {
		switch ($name) {
			case 'handler': $this->_handler = null; return;
			case 'layout': $this->_layout = null; return;
			default: throw new Exception('cannot unset the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	/**
	 * lazily initializes the requested association management objects
	 * @param	string	&$name	the name of the association role
	 * @return	Association		the association management object
	 */
	private function getInitializedAssociation(&$name) {
		if (!array_key_exists($name, $this->associations)) {
			switch ($name) {
				case 'nestedContext': $this->associations[$name] = new UML_ManyAssociation($this, $this->_nestedContext, 'parent'); break;
				case 'parent': $this->associations[$name] = new UML_OneAssociation($this, $this->_parent, 'nestedContext'); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1236334265906_925929_844) ENABLED START */
	// TODO: put your further code implementations for class 'Context' here
	/* PROTECTED REGION END */
}
?>
