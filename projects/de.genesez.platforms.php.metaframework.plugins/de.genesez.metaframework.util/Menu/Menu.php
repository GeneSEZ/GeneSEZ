<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240323706500_563325_694) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Menu_MenuItem
 * @see		IteratorAggregate
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class Menu_Menu extends Menu_MenuItem implements IteratorAggregate {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @var	Menu_MenuBar	stores the linked object of the  bidirectional many to one association to {@link Menu_MenuBar} (symmetry ensured) 
	 */
	private $_menuBar;
	/**
	 * @var	array of Menu_MenuItem	stores the linked objects of the  bidirectional one to many association to {@link Menu_MenuItem} (symmetry ensured) 
	 */
	private $_items = array();
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>menuBar</var>: the bidirectional many to one association to {@link Menu_MenuBar} (symmetry ensured)</li>
	 *   <li><var>items</var>: the bidirectional one to many association to {@link Menu_MenuItem} (symmetry ensured)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link Menu_Menu}
	 * @param	string	$name	
	 * @param	string	$link	
	 * @param	array	$items	array of type 'Menu_MenuItem', default value is 'array()'
	 * @param	boolean	$isSelected	default value is 'false'
	 */
	public function __construct($name, $link, array $items = array(), $isSelected = false) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240390896390_12048_437) ENABLED START */
		parent::__construct($name, $link, $isSelected);
		foreach ($items as $item) {
			$this->items->insert($item);
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function isMenuItem() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323959796_153169_786) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Iterator
	 */
	public function getIterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324020484_179022_816) ENABLED START */
		return $this->items->iterator();
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>menuBar</var>: the  bidirectional many to one association to {@link Menu_MenuBar} (symmetry ensured)</li>
	 *   <li><var>items</var>: the  bidirectional one to many association to {@link Menu_MenuItem} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'menuBar':
			case 'items':
				return $this->getInitializedAssociation($name);
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
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
				case 'menuBar': $this->associations[$name] = new UML_OneAssociation($this, $this->_menuBar, 'menus'); break;
				case 'items': $this->associations[$name] = new UML_ManyAssociation($this, $this->_items, 'menu'); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240323706500_563325_694) ENABLED START */
	// TODO: put your further code implementations for class 'Menu_Menu' here
	public function offsetGet($offset) {
		switch ($offset) {
			case 'menuBar' :
			case 'items' :
				return $this->__get($offset);
		}
		return parent::offsetGet($offset);
	}
	/* PROTECTED REGION END */
}
?>
