<?php
require_once 'Core/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Loader_ModuleLoader  {
	
	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleDependencies();

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getModuleDependencies();

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents();

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasModuleContext();

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Context
	 */
	public function getModuleContext();

	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
	// TODO: put your further code declarations for interface 'ModuleLoader' here
	/* PROTECTED REGION END */
}
?>
