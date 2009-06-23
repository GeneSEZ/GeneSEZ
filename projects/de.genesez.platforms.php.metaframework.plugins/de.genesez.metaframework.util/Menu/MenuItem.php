<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240323698234_181024_674) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_DtoBase
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class Menu_MenuItem extends Mfw_DtoBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @var	Menu_Menu	stores the linked object of the  bidirectional many to one association to {@link Menu_Menu} (symmetry ensured) 
	 */
	private $_menu;
	/**
	 * holds the association management object for the bidirectional many to one association to {@link Menu_Menu} (symmetry ensured)
	 * @var UML_OneAssociation
	 */
	private $associations;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link Menu_MenuItem}
	 * @param	string	$name	
	 * @param	string	$link	
	 * @param	boolean	$isSelected	default value is 'false'
	 */
	public function __construct($name, $link, $isSelected = false) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240324079234_758890_830) ENABLED START */
//		parent::__construct();
		$this->name = $name;
		$this->link = $link;
		$this->isSelected = $isSelected;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function isMenuItem() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323947796_532814_782) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getName() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324215875_985191_842) ENABLED START */
		return $this->name;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getLink() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324224343_475448_846) ENABLED START */
		return $this->link;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function isSelected() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324228453_172161_850) ENABLED START */
		return $this->isSelected;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240396212515_458066_459) ENABLED START */
		return 'de.genesez.modules.util/menu.item.html';
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>menu</var>: the  bidirectional many to one association to {@link Menu_Menu} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'menu' :
				if ($this->associations === null) {
					$this->associations = new UML_OneAssociation($this, $this->_menu, 'items');
				}
				return $this->associations;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240323698234_181024_674) ENABLED START */
	// TODO: put your further code implementations for class 'Menu_MenuItem' here
	public function offsetGet($offset) {
		if ($offset == 'menu') {
			return $this->__get($offset);
		}
		return parent::offsetGet($offset);
	}
	/* PROTECTED REGION END */
}
?>
