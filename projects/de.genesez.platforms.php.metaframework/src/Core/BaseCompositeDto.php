<?php
require_once 'Core/BaseDto.php';
require_once 'Core/CompositeDto.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239096946484_735379_1025) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseDto
 * @see		Core_CompositeDto
 * @author	dreamer
 * @package	Metaframework
 */
class Core_BaseCompositeDto extends Core_BaseDto implements Core_CompositeDto {

	/**
	 * @var	array of Core_Dto	stores the linked objects of the  multi qualified unidirectional to one association to {@link Core_Dto} (symmetry ensured) 
	 */
	private $_nestedDto = array();
	/**
	 * holds the association management object for the multi qualified unidirectional to one association to {@link Core_Dto} (symmetry ensured)
	 * @var UML_MultiQualifiedAssociation
	 */
	private $associations;






	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedDto</var>: the  multi qualified unidirectional to one association to {@link Core_Dto} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'nestedDto' :
				if ($this->associations === null) {
					$this->associations = new UML_MultiQualifiedAssociation($this, $this->_nestedDto);
				}
				return $this->associations;
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239096946484_735379_1025) ENABLED START */
	// TODO: put your further code implementations for class 'Core_BaseCompositeDto' here
	/* PROTECTED REGION END */
}
?>
