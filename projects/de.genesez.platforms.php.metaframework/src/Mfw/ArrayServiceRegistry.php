<?php
require_once 'Mfw/ServiceRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1244721052593_172515_1194) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a simple <b>default implementation</b> of the service registry 
 * interface using an associative array to manage components.
 * @see		Mfw_ServiceRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayServiceRegistry  implements Mfw_ServiceRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_ArrayServiceRegistry::getRegistry()}
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	mixed	$component	
	 */
	public function register($name, $component) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243435817093_715363_1072) ENABLED START */
		$this->registry[$name] = $component;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999613687_791397_1116) ENABLED START */
		return isset($this->registry[$name]);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	mixed
	 */
	public function getComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999613703_927330_1117) ENABLED START */
		return $this->registry[$name];
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1244721052593_172515_1194) ENABLED START */
	// TODO: put your further code implementations for class 'ArrayServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
