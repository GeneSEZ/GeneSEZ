<?php
require_once 'uml/OneAssociation.php';
require_once 'uml/ManyAssociation.php';

/**
 * This class is used to test the association handling library. It has several associations 
 * with the class {@link Related}. The dynamic creation and destruction of links between objects 
 * of both classes is subject to test.
 * 
 * @author toh
 * @version 2009-03-09
 */
class Hub {
	
	/**
	 * @var Related	stores the linked / referenced object of the unidirectional to one association
	 */
	private $unidiToOneRelated;
	/**
	 * @var Related	stores the linked / referenced object of the bidirectional one to one association
	 */
	private $bidiOneToOneRelated;
	/**
	 * @var Related	stores the linked objects of the unidirectional to many association
	 */
	private $unidiToManyRelated;
	/**
	 * @var Related	stores the linked objects of the bidirectional many to many association
	 */
	private $bidiManyToManyRelated;
	
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>unidiToOneRelated</var>: the unidirectional to one association to {@link Related}</li>
	 *   <li><var>bidiOneToOneRelated</var>: the bidirectional one to one association</li>
	 *   <li><var>unidiToManyRelated</var>: the unidirectional to many association</li>
	 *   <li><var>bidiManyToManyRelated</var>: the bidirectional many to many association</li>
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
			case 'unidiToOneRelated': return $this->getInitializedAssociation($name);
			case 'bidiOneToOneRelated' : return $this->getInitializedAssociation($name);
			case 'unidiToManyRelated' : return $this->getInitializedAssociation($name);
			case 'bidiManyToManyRelated' : return $this->getInitializedAssociation($name);
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
				case 'unidiToOneRelated': $this->associations[$name] = new UML_OneAssociation($this, $this->unidiToOneRelated); break;
				case 'bidiOneToOneRelated' : $this->associations[$name] = new UML_OneAssociation($this, $this->bidiOneToOneRelated, 'bidiOneToOneHub'); break;
				case 'unidiToManyRelated' : $this->associations[$name] = new UML_ManyAssociation($this, $this->unidiToManyRelated); break;
				case 'bidiManyToManyRelated' : $this->associations[$name] = new UML_ManyAssociation($this, $this->bidiManyToManyRelated, 'bidiManyToManyHub'); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
}
?>