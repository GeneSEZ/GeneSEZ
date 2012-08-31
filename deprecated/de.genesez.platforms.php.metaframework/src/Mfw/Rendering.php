<?php
require_once 'Mfw/Dto.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999928437_779424_1221) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the rendering interface used to <b>render </b>a response or output.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_Rendering  {
	
	
	
	/**
	 * Displays the information of the specified data transfer object.
	 * @param	Mfw_Dto	$dto	the data to be displayed
	 */
	public function render(Mfw_Dto $dto);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1237999928437_779424_1221) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_Rendering' here
	/* PROTECTED REGION END */
}
?>
