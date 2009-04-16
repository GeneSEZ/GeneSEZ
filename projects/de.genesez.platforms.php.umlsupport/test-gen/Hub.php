<?php
require_once 'Related.php';
require_once 'UML/OneAssociation.php';
require_once 'UML/ManyAssociation.php';
require_once 'UML/SingleQualifiedAssociation.php';
require_once 'UML/MultiQualifiedAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239825669734_468125_386) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * This class is used to test the association handling library. It has several associations with the class {@link Related}. The dynamic creation and destruction of links between objects of both classes is subject to test.
 * 
 * @version 2009-03-09
 * @author	dreamer
 * @package	UmlSupport
 */
class Hub   {
	// -- generated attribute, constant + association declarations ----------

	/**
	 * @var	Related	stores the linked object of the  unidirectional to one association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiToOneRelated;
	/**
	 * @var	Related	stores the linked object of the  bidirectional one to one association to {@link Related} (symmetry ensured) 
	 */
	private $_bidiOneToOneRelated;
	/**
	 * @var	array of Related	stores the linked objects of the  unidirectional to many association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiToManyRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  bidirectional many to many association to {@link Related} (symmetry ensured) 
	 */
	private $_bidiManyToManyRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  single qualified unidirectional to one association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiSingleQualifiedToOneRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  single qualified unidirectional to many association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiSingleQualifiedToManyRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  single qualified bidirectional one to one association to {@link Related} (symmetry ensured) 
	 */
	private $_bidiSingleQualifiedOneToOneRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  multi qualified unidirectional to one association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiMultiQualifiedToOneRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  multi qualified unidirectional to many association to {@link Related} (symmetry ensured) 
	 */
	private $_unidiMultiQualifiedToManyRelated = array();
	/**
	 * @var	array of Related	stores the linked objects of the  multi qualified bidirectional one to one association to {@link Related} (symmetry ensured) 
	 */
	private $_bidiMultiQualifiedOneToOneRelated = array();
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>unidiToOneRelated</var>: the unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiOneToOneRelated</var>: the bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiToManyRelated</var>: the unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiManyToManyRelated</var>: the bidirectional many to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiSingleQualifiedToOneRelated</var>: the single qualified unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiSingleQualifiedToManyRelated</var>: the single qualified unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiSingleQualifiedOneToOneRelated</var>: the single qualified bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiMultiQualifiedToOneRelated</var>: the multi qualified unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiMultiQualifiedToManyRelated</var>: the multi qualified unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiMultiQualifiedOneToOneRelated</var>: the multi qualified bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();





	// -- association + attribute accessors ---------------------------------

	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>unidiToOneRelated</var>: the  unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiOneToOneRelated</var>: the  bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiToManyRelated</var>: the  unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiManyToManyRelated</var>: the  bidirectional many to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiSingleQualifiedToOneRelated</var>: the  single qualified unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiSingleQualifiedToManyRelated</var>: the  single qualified unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiSingleQualifiedOneToOneRelated</var>: the  single qualified bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiMultiQualifiedToOneRelated</var>: the  multi qualified unidirectional to one association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>unidiMultiQualifiedToManyRelated</var>: the  multi qualified unidirectional to many association to {@link Related} (symmetry ensured)</li>
	 *   <li><var>bidiMultiQualifiedOneToOneRelated</var>: the  multi qualified bidirectional one to one association to {@link Related} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
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
	 * lazily initializes the requested association management objects
	 * @param	string	&$name	the name of the association role
	 * @return	Association|QualifiedAssociation	the association management object
	 */
	private function getInitializedAssociation(&$name) {
		if (!array_key_exists($name, $this->associations)) {
			switch ($name) {
				case 'unidiToOneRelated': $this->associations[$name] = new UML_OneAssociation($this, $this->_unidiToOneRelated); break;
				case 'bidiOneToOneRelated': $this->associations[$name] = new UML_OneAssociation($this, $this->_bidiOneToOneRelated, 'bidiOneToOneHub'); break;
				case 'unidiToManyRelated': $this->associations[$name] = new UML_ManyAssociation($this, $this->_unidiToManyRelated); break;
				case 'bidiManyToManyRelated': $this->associations[$name] = new UML_ManyAssociation($this, $this->_bidiManyToManyRelated, 'bidiManyToManyHub'); break;
				case 'unidiSingleQualifiedToOneRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->_unidiSingleQualifiedToOneRelated); break;
				case 'unidiSingleQualifiedToManyRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->_unidiSingleQualifiedToManyRelated, null, true); break;
				case 'bidiSingleQualifiedOneToOneRelated': $this->associations[$name] = new UML_SingleQualifiedAssociation($this, $this->_bidiSingleQualifiedOneToOneRelated, 'bidiOneToSingleQualifiedOneHub'); break;
				case 'unidiMultiQualifiedToOneRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->_unidiMultiQualifiedToOneRelated); break;
				case 'unidiMultiQualifiedToManyRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->_unidiMultiQualifiedToManyRelated, null, true); break;
				case 'bidiMultiQualifiedOneToOneRelated': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->_bidiMultiQualifiedOneToOneRelated, 'bidiOneToMultiQualifiedOneHub'); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239825669734_468125_386) ENABLED START */
	// TODO: put your further code implementations for class 'Hub' here
	/* PROTECTED REGION END */
}
?>
