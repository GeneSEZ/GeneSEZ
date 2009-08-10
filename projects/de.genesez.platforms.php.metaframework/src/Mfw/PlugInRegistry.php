<?php
require_once 'Mfw/PlugIn.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329329406_140543_862) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the interface for the <b>plug-in registry</b>. A plug-in registry 
 * is used to <b>register</b> plug-ins and to evaluate the <b>dependencies</b> 
 * between plug-ins.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_PlugInRegistry  {
	
	
	
	/**
	 * Registers a plug-in.
	 * @param	Mfw_PlugIn	$plugin	the plug-in to be registered
	 */
	public function register(Mfw_PlugIn $plugin);

	/**
	 * Checks if there are <b>missing dependencies</b> between plug-ins or not.
	 * @return	boolean
	 */
	public function hasMissingDependencies();

	/**
	 * Returns an associative array with <b>missing plug-in dependencies</b>. The 
	 * array is structured as follows: identifier of the required plug-in <b>=&gt;</b> 
	 * array of plug-in identifiers defining the dependency.
	 * @return	array
	 */
	public function getMissingDependencies();

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1243329329406_140543_862) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_PlugInRegistry' here
	/* PROTECTED REGION END */
}
?>
