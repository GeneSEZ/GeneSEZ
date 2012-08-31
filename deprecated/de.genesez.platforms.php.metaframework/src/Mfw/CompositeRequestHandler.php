<?php
require_once 'Mfw/RequestHandler.php';
require_once 'UML/MultiQualifiedAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239096309671_611315_815) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines a <b>composite structure</b> of request handlers, i.e. a request 
 * is handled using several other request handlers.
 * @see		Mfw_RequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_CompositeRequestHandler extends Mfw_RequestHandler {
	
	// -- attribute, constant + association declarations --------------------
	

	
	// -- association accessors ---------------------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>nestedRequestHandler</var>: [contains the request handlers to build the composite]</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name);
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1239096309671_611315_815) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_CompositeRequestHandler' here
	/* PROTECTED REGION END */
}
?>
