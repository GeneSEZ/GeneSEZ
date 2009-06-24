<?php
require_once 'Mfw/Context.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Defines the main interface for a metaframework plug-in.
 * @author	dreamer
 * @package	Metaframework
 */
interface Mfw_PlugIn  {
	
	
	
	/**
	 * Returns the unique <b>identifier</b> of the plug-in. To define unique 
	 * identifier you can use the inverted domain name, e.g. 
	 * &lt;code&gt;com.example.plugin&lt;/code&gt;.
	 * @return	string
	 */
	public function getId();

	/**
	 * Returns an optional list of <b>plug-in dependencies</b> of the plug-in, 
	 * i.e. a list with plug-in identifiers. If a plug-in has no dependencies an 
	 * empty array can be returned.
	 * @return	array of string
	 */
	public function getDependencies();

	/**
	 * Returns an optional list of <b>components</b> a plug-in <i>may</i> 
	 * provide. Components are <b>ready-to-use</b> objects and managed within the 
	 * service registry. A plug-in can have no components.
	 * @return	array of mixed
	 */
	public function getComponents();

	/**
	 * Returns the <b>context</b> from which a plug-in is <b>accessible</b>. 
	 * Plug-Ins which are accessible by a web client simply return null.
	 * @return	Mfw_Context
	 */
	public function getContext();

	/**
	 * Returns an optional list of <b>extensions</b> or <b>contributions</b> a 
	 * plug-in may provide to any <b>extension</b>. Extensions are defined using 
	 * an associative array with the entries <b>extension =&gt; contribution</b>.
	 * @return	array of mixed
	 */
	public function getExtensions();

	/**
	 * Returns an optional list of <b>interceptors</b> a plug-in may provide. 
	 * Interceptors are defined as key =&gt; value pairs in associative arrays. The 
	 * key is the <b>pattern</b> a url must match and the value is the <b>identifier</b> 
	 * for the service registry.
	 * @return	array of mixed
	 */
	public function getInterceptors();

	
	
	// -- own code declarations ---------------------------------------------
	/* PROTECTED REGION ID(php.interface.own.code.declaration._16_0_b6f02e1_1236332715609_785989_435) ENABLED START */
	// TODO: put your further code declarations for interface 'ModuleLoader' here
	/* PROTECTED REGION END */
}
?>
