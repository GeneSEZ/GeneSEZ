<?php
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
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_Context   {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_Context::getName()}
	 * @generated	attribute definition
	 * @var		string	$_name
	 */
	private $_name;
	/**
	 * documented here {@link Mfw_Context::getHandler()}
	 * @generated	attribute definition
	 * @var		string	$_handler
	 */
	private $_handler;
	/**
	 * @var	array of Mfw_Context	stores the linked objects of the  bidirectional one to many association to {@link Mfw_Context} (symmetry ensured) ({@link __get() documented here})
	 */
	private $_nestedContext = array();
	/**
	 * @var	Mfw_Context	stores the linked object of the  bidirectional many to one association to {@link Mfw_Context} (symmetry ensured) ({@link __get() documented here})
	 */
	private $_parent;
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>nestedContext</var>: the bidirectional one to many association to {@link Mfw_Context} (symmetry ensured)</li>
	 *   <li><var>parent</var>: the bidirectional many to one association to {@link Mfw_Context} (symmetry ensured)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs a context with a name.
	 * @param	string	$name	the mandatory name and url part of the context
	 * @param	string	$handler	the optional identifier for the handler
	 * @param	array	$nestedContext	an optional list with nested contexts
	 */
	public function __construct($name, $handler = null, array $nestedContext = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1236338382406_230888_479) ENABLED START */
		$this->_name = $name;
		$this->_handler = $handler;
		foreach ($nestedContext as $context) {
			$this->nestedContext->insert($context);
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * resolves the context for the specified path. In case of an unresolvable 
	 * context, the root context is returned.
	 * @param	array	$path	the url path specifying a context
	 * @return	Mfw_Context
	 */
	public function resolveContext(array $path = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240297503531_187744_1117) ENABLED START */
		// leaf context, check handler
		if (!array_key_exists(0, $path)) {
			if ($this->_handler === null) {
				return null;
			} else {
				return $this;
			}
		}
		// goto leaf context
		$name = array_shift($path);
		$context = null;
		foreach ($this->nestedContext->iterator() as $item) {
			if ($item->name === $name) {
				$context = $item->resolveContext($path);
				break;
			}
		}
		// determine which context to return
		if ($context === null) {
			if ($this->_handler === null) {
				// if no handler could be found, always return the root context
				if ($this->parent->get() === null) {
					return $this;
				} else {
					return null;
				}
			} else {
				return $this;
			}
		}
		// return the handler found
		return $context;
		/* PROTECTED REGION END */
	}

	/**
	 * Returns a string representation of a context according the pattern <code>/context/context</code>, i.e. the url part
	 * @return	string
	 */
	public function __toString() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1236344802625_729711_545) ENABLED START */
		$parent = $this->parent->get();
		if ($parent === null) {
			return '/';
		}
		$path = $parent;
		if (strrpos($path, '/') +1 == strlen($path)) {
			return $parent . $this->_name;
		}
		return $parent . '/' . $this->_name;
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>name</var>: the name of the context, i.e. the url part</li>
	 *   <li><var>handler</var>: an identifier for the handler of this url part</li>
	 *   <li><var>nestedContext</var>: [the name of the context, i.e. the url part, an identifier for the handler of this url part, references to the nested contexts, reference to the parent context]</li>
	 *   <li><var>parent</var>: [the name of the context, i.e. the url part, an identifier for the handler of this url part, references to the nested contexts, reference to the parent context]</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'name': return $this->_name;
			case 'handler': return $this->_handler;
			case 'nestedContext':
			case 'parent':
				return $this->getInitializedAssociation($name);
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	/**
	 * magic setter to set the values of the following members:
	 * <ul>
	 *   <li><var>handler</var>: an identifier for the handler of this url part</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @param	mixed	$value	the value to set
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 */
	public function __set($name, $value) {
		switch ($name) {
			case 'handler': $this->_handler = $value; return;
			default: throw new Exception('cannot set the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	/**
	 * checks if a value is assigned to one the following members:
	 * <ul>
	 *   <li><var>handler</var>: an identifier for the handler of this url part</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 * @return	boolean	the value of the member or an exception if the member is neither accessible nor available
	 */
	public function __isset($name) {
		switch ($name) {
			case 'handler': return isset($this->_handler);
			default: throw new Exception('cannot check if the value of an inaccessible or unavailable property is set: ' . $name); break;
		}
	}
	/**
	 * unsets (set to <var>null</var>) the value of the following members:
	 * <ul>
	 *   <li><var>handler</var>: an identifier for the handler of this url part</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the member is neither accessible nor available
	 */
	public function __unset($name) {
		switch ($name) {
			case 'handler': $this->_handler = null; return;
			default: throw new Exception('cannot unset the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	/**
	 * lazily initializes the requested association management objects
	 * @param	string	&$name	the name of the association role
	 * @return	Association|QualifiedAssociation	the association management object
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
