<?php
require_once 'Core/RequestHandler.php';
require_once 'UML/MultiQualifiedAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239096309671_611315_815) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_RequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
interface Core_CompositeRequestHandler extends Core_RequestHandler {
	// -- attribute + associations declarations  ----------------------------

	// -- association accessors ---------------------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedRequestHandler</var>: the  multi qualified unidirectional to one association to {@link Core_RequestHandler} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name);
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239096309671_611315_815) ENABLED START */
	// TODO: put your further code declarations for interface 'Core_CompositeRequestHandler' here
	/* PROTECTED REGION END */
}
?>
