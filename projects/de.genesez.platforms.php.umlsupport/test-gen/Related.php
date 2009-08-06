<?php
require_once 'Hub.php';
require_once 'UML/OneAssociation.php';
require_once 'UML/ManyAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239825675078_318048_406) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * This class is used to test the association handling library. It has several associations with the class {@link Hub}. The dynamic creation and destruction of links between objects of both classes is subject to test.
 * 
 * @version 2009-03-09
 * @author	dreamer
 * @package	UmlSupport
 */
class Related   {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @var	Hub	stores the linked object of the  bidirectional one to one association to {@link Hub} (symmetry ensured) 
	 */
	private $_bidiOneToOneHub;
	/**
	 * @var	array of Hub	stores the linked objects of the  bidirectional many to many association to {@link Hub} (symmetry ensured) 
	 */
	private $_bidiManyToManyHub = array();
	/**
	 * @var	Hub	stores the linked object of the  bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified) 
	 */
	private $_bidiOneToSingleQualifiedOneHub;
	/**
	 * @var	Hub	stores the linked object of the  bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified) 
	 */
	private $_bidiOneToMultiQualifiedOneHub;
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>bidiOneToOneHub</var>: the bidirectional one to one association to {@link Hub} (symmetry ensured)</li>
	 *   <li><var>bidiManyToManyHub</var>: the bidirectional many to many association to {@link Hub} (symmetry ensured)</li>
	 *   <li><var>bidiOneToSingleQualifiedOneHub</var>: the bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified)</li>
	 *   <li><var>bidiOneToMultiQualifiedOneHub</var>: the bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();
	
	
	
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>bidiOneToOneHub</var>: the  bidirectional one to one association to {@link Hub} (symmetry ensured)</li>
	 *   <li><var>bidiManyToManyHub</var>: the  bidirectional many to many association to {@link Hub} (symmetry ensured)</li>
	 *   <li><var>bidiOneToSingleQualifiedOneHub</var>: the  bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified)</li>
	 *   <li><var>bidiOneToMultiQualifiedOneHub</var>: the  bidirectional one to one association to {@link Hub} (symmetry not ensured, opposite is qualified)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
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
	 * lazily initializes the requested association management objects
	 * @param	string	&$name	the name of the association role
	 * @return	Association|QualifiedAssociation	the association management object
	 */
	private function getInitializedAssociation(&$name) {
		if (!array_key_exists($name, $this->associations)) {
			switch ($name) {
				case 'bidiOneToOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->_bidiOneToOneHub, 'bidiOneToOneRelated'); break;
				case 'bidiManyToManyHub': $this->associations[$name] = new UML_ManyAssociation($this, $this->_bidiManyToManyHub, 'bidiManyToManyRelated'); break;
				case 'bidiOneToSingleQualifiedOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->_bidiOneToSingleQualifiedOneHub); break;
				case 'bidiOneToMultiQualifiedOneHub': $this->associations[$name] = new UML_OneAssociation($this, $this->_bidiOneToMultiQualifiedOneHub); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239825675078_318048_406) ENABLED START */
	// TODO: put your further code implementations for class 'Related' here
	/* PROTECTED REGION END */
}
?>
