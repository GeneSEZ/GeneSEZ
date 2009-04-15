<?php
require_once 'UML/OneAssociation.php';
require_once 'UML/ManyAssociation.php';
require_once 'UML/SingleQualifiedAssociation.php';
require_once 'UML/MultiQualifiedAssociation.php';

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
	 * @var array	stores the linked object of the single qualified unidirectional to one association
	 */
	private $unidiSingleQualifiedToOneRelated;
	/**
	 * @var array	stores the linked objects of the single qualified unidirectional to many association
	 */
	private $unidiSingleQualifiedToManyRelated;
	/**
	 * @var array	stores the linked object of the single qualified bidirectional to one association
	 */
	private $bidiSingleQualifiedOneToOneRelated;
	/**
	 * @var array	stores the linked object of the multi qualified unidirectional to one association
	 */
	private $unidiMultiQualifiedToOneRelated;
	/**
	 * @var array	stores the linked objects of the multi qualified unidirectional to many association
	 */
	private $unidiMultiQualifiedToManyRelated;
	/**
	 * @var array	stores the linked objects of the multi qualified bidirectional to one association
	 */
	private $bidiMultiQualifiedOneToOneRelated;
	
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>unidiToOneRelated</var>: the unidirectional to one association to {@link Related}</li>
	 *   <li><var>bidiOneToOneRelated</var>: the bidirectional one to one association</li>
	 *   <li><var>unidiToManyRelated</var>: the unidirectional to many association</li>
	 *   <li><var>bidiManyToManyRelated</var>: the bidirectional many to many association</li>
	 *   <li><var>unidiSingleQualifiedToOneRelated</var>: the single qualified unidirectional to one association</li>
	 *   <li><var>unidiSingleQualifiedToManyRelated</var>: the single qualified unidirectional to many association</li>
	 *   <li><var>bidiSingleQualifiedToOneRelated</var>: the single qualified bidirectional one to one association</li>
	 *   <li><var>unidiMultiQualifiedToOneRelated</var>: the multi qualified unidirectional to one association</li>
	 *   <li><var>unidiMultiQualifiedToManyRelated</var>: the multi qualified unidirectional to one association</li>
	 *   <li><var>bidiMultiQualifiedOneToOneRelated</var>: the multi qualified bidirectional one to one association</li>
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
			case 'unidiToOneRelated':
			case 'bidiOneToOneRelated':
			case 'unidiToManyRelated':
			case 'bidiManyToManyRelated':
			case 'unidiSingleQualifiedToOneRelated':
			case 'unidiSingleQualifiedToManyRelated':
			case 'bidiSingleQualifiedOneToOneRelated':
			case 'unidiMultiQualifiedToOneRelated':
			case 'unidiMultiQualifiedToManyRelated':
			case 'bidiMultiQualifiedOneToOneRelated':
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
				case 'unidiToOneRelated': $this->associations[$name] = new UML_OneAssociation($this, $this->unidiToOneRelated); break;
				case 'bidiOneToOneRelated' : $this->associations[$name] = new UML_OneAssociation($this, $this->bidiOneToOneRelated, 'bidiOneToOneHub'); break;
				case 'unidiToManyRelated' : $this->associations[$name] = new UML_ManyAssociation($this, $this->unidiToManyRelated); break;
				case 'bidiManyToManyRelated' : $this->associations[$name] = new UML_ManyAssociation($this, $this->bidiManyToManyRelated, 'bidiManyToManyHub'); break;
				case 'unidiSingleQualifiedToOneRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->unidiSingleQualifiedToOneRelated); break;
				case 'unidiSingleQualifiedToManyRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->unidiSingleQualifiedToManyRelated, null, true); break;
				case 'bidiSingleQualifiedOneToOneRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->bidiSingleQualifiedOneToOneRelated, 'bidiOneToSingleQualifiedOneHub'); break;
				case 'unidiMultiQualifiedToOneRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->unidiMultiQualifiedToOneRelated); break;
				case 'unidiMultiQualifiedToManyRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->unidiMultiQualifiedToOneRelated, null, true); break;
				case 'bidiMultiQualifiedOneToOneRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->unidiMultiQualifiedToOneRelated, 'bidiOneToMultiQualifiedOneHub'); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
}
?>