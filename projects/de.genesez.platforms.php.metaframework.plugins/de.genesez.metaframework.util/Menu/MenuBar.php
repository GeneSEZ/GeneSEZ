<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240323712078_686210_714) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_DtoBase
 * @see		IteratorAggregate
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class Menu_MenuBar extends Mfw_DtoBase implements IteratorAggregate {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @var	array of Menu_Menu	stores the linked objects of the  bidirectional one to many association to {@link Menu_Menu} (symmetry ensured) 
	 */
	private $_menus = array();
	/**
	 * holds the association management object for the bidirectional one to many association to {@link Menu_Menu} (symmetry ensured)
	 * @var UML_ManyAssociation
	 */
	private $associations;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link Menu_MenuBar}
	 * @param	array	$menus	array of type 'Menu_Menu', default value is 'array()'
	 */
	public function __construct(array $menus = array()) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240323723765_268360_733) ENABLED START */
		parent::__construct();
		foreach ($menus as $menu) {
			$this->menus->insert($menu);
		}
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Iterator
	 */
	public function getIterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323910734_156992_778) ENABLED START */
		return $this->menus->iterator();
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240396182187_280751_455) ENABLED START */
		return 'de.genesez.modules.util/menu.bar.html';
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>menus</var>: the  bidirectional one to many association to {@link Menu_Menu} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'menus' :
				if ($this->associations === null) {
					$this->associations = new UML_ManyAssociation($this, $this->_menus, 'menuBar');
				}
				return $this->associations;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240323712078_686210_714) ENABLED START */
	// TODO: put your further code implementations for class 'Menu_MenuBar' here
	public function offsetGet($offset) {
		if ($offset == 'menus') {
			return $this->__get($offset);
		}
		return parent::offsetGet($offset);
	}
	/* PROTECTED REGION END */
}
?>
