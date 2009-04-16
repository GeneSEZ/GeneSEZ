<?php
require_once 'Core/Dto.php';
require_once 'UML/MultiQualifiedAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239095304343_83651_754) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_Dto
 * @author	dreamer
 * @package	Metaframework
 */
interface Core_CompositeDto extends Core_Dto {
	// -- attribute + associations declarations  ----------------------------

	// -- association accessors ---------------------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedDto</var>: the  multi qualified unidirectional to one association to {@link Core_Dto} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name);
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239095304343_83651_754) ENABLED START */
	// TODO: put your further code declarations for interface 'Core_CompositeDto' here
	/* PROTECTED REGION END */
}
?>
