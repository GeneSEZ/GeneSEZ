<?php
require_once 'Mfw/ServiceRegistry.php';
require_once 'Mfw/PlugIn.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243439308984_194621_1131) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the special <b>core plug-in</b> interface for the metaframework. 
 * The core plug-in provides <b>implementations</b> of the <b>infrastructure 
 * interfaces</b> the metaframework defines and has therefore some more 
 * methods to configure the underlying frameworks, libraries or 
 * implementations.
 * @see		Mfw_PlugIn
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_CorePlugIn extends Mfw_PlugIn {
	
	
	
	/**
	 * Returns the service registry of the metaframework
	 * @return	Mfw_ServiceRegistry
	 */
	public function getServiceRegistry();

	/**
	 * <p>
	 *   Finalizes the <b>construction</b> phase of the metaframework, i.e. 
	 *   directly after the registration of the plug-ins and <b>before</b> the <b>request 
	 *   processing is initiated</b>.
	 * </p>
	 */
	public function finishInitialization();

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243439308984_194621_1131) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_CorePlugInLoader' here
	/* PROTECTED REGION END */
}
?>
