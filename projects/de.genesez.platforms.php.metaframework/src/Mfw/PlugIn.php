<?php
require_once 'Mfw/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_PlugIn  {
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getId();

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasDependencies();

	/**
	 * @generated	method stub for implementation
	 * @return	array of string
	 */
	public function getDependencies();

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents();

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasContext();

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Context
	 */
	public function getContext();

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasExtensions();

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getExtensions();

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasInterceptors();

	/**
	 * @generated	method stub for implementation
	 * @return	array of mixed
	 */
	public function getInterceptors();

	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
	// TODO: put your further code declarations for interface 'ModuleLoader' here
	/* PROTECTED REGION END */
}
?>
