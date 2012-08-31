<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999613687_797910_1115) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the inteface for the <b>service registry</b>. A service registry 
 * is used to <b>lookup </b>and <b>obtain</b> components according the 
 * service locator pattern. An implementation can use a dependency injection 
 * container.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_ServiceRegistry  {
	
	
	
	/**
	 * Registers a component using its <b>name</b> for further lookup.
	 * @param	string	$name	the name of the component
	 * @param	mixed	$component	the component to be registered
	 */
	public function register($name, $component);

	/**
	 * Checks if a component with the specified name <b>exists</b> or in other 
	 * words was registered.
	 * @param	string	$name	the name of the component
	 * @return	boolean
	 */
	public function hasComponent($name);

	/**
	 * Returns the component with the specified name. Verify the existence of the 
	 * component using {@link hasComponent()} first.
	 * @param	string	$name	the name of the component
	 * @return	mixed
	 */
	public function getComponent($name);

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1237999613687_797910_1115) ENABLED START */
	// TODO: put your further code declarations for interface 'Mfw_ServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
