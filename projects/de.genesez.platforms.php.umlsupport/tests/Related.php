<?php
require_once 'uml/OneAssociation.php';
require_once 'uml/ManyAssociation.php';

/**
 * This class is used to test the association handling library. It has several associations 
 * with the class {@link Hub}. The dynamic creation and destruction of links between objects 
 * of both classes is subject to test.
 * 
 * @author toh
 * @version 2009-03-09
 */
class Related {
	/**
	 * @var Hub	stores the linked / referenced object of the bidirectional one to one association
	 */
	private $bidiOneToOneHub;
	/**
	 * @var Hub	stores the linked objects of the bidirectional many to many association
	 */
	private $bidiManyToManyHub;
	/**
	 * @var Hub	stores the linked object of the bidirectional one to single qualified one association
	 */
	private $bidiOneToSingleQualifiedOneHub;
	/**
	 * @var Hub	stores the linked object of the bidirectional one to multi qualified one association
	 */
	private $bidiOneToMultiQualifiedOneHub;
	
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>bidiOneToOne</var>: for the bidirectional one to one association</li>
	 *   <li><var>bidiManyToMany</var>: for the bidirectional many to many association</li>
	 *   <li><var>bidiOneToSingleQualifiedOneHub</var>: for the bidirectional one to one single qualified association</li>
	 *   <li><var>bidiOneToMultiQualifiedOneHub</var>: for the bidirectional one to one multi qualified association</li>
	 * </ul>
	 * @var Association
	 */
	private $associations = array();
	
	
	/**
	 * getter accessor for properties
	 * @param string $name	the name of the property
	 * @return mixed		the value of the property
	 * @throws Exception	if the specified property does not exist or is inaccessible
	 */
	public function __get($name) {
		switch ($name) {
			case 'bidiOneToOneHub':
			case 'bidiManyToManyHub':
			case 'bidiOneToSingleQualifiedOneHub':
			case 'bidiOneToMultiQualifiedOneHub':
				return $this->getInitializedAssociation($name);
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}
	
	/**
	 * initializes the association management objects
	 * @param	string	$name	the name of the association role
	 * @return	Association		the association management object
	 */
	private function getInitializedAssociation(&$name) {
		if (!array_key_exists($name, $this->associations)) {
			switch ($name) {
				case 'bidiOneToOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->bidiOneToOneHub, 'bidiOneToOneRelated'); break;
				case 'bidiManyToManyHub' : $this->associations[$name] = new UML_ManyAssociation($this, $this->bidiManyToManyHub, 'bidiManyToManyRelated'); break;
				case 'bidiOneToSingleQualifiedOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->bidiOneToSingleQualifiedOneHub); break;
				case 'bidiOneToMultiQualifiedOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->bidiOneToSingleQualifiedOneHub); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
}
?>