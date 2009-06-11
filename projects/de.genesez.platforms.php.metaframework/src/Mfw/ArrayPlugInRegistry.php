<?php
require_once 'Mfw/PlugIn.php';
require_once 'Mfw/PlugInRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243436601140_962276_1091) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_PlugInRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayPlugInRegistry  implements Mfw_PlugInRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	/**
	 * @generated	attribute definition
	 * @var		boolean	$checked
	 */
	protected $checked = false;
	/**
	 * @generated	attribute definition
	 * @var		array	$missing
	 */
	protected $missing = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_PlugIn	$plugin	
	 */
	public function register($plugin) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243329382375_477947_880) ENABLED START */
		// TODO: in a reviced implementation, insert the plug-ins additionally into a depencency tree
		$this->registry[$plugin->getId()] = $plugin;
		if ($this->checked === true) {
			$this->checked = false;
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	public function hasMissingDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436372546_665562_1082) ENABLED START */
		if ($this->checked === false) {
			$this->checkPlugIns();
		}
		return count($this->missing) > 0;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array
	 */
	public function getMissingDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436508921_306629_1086) ENABLED START */
		if ($this->checked === false) {
			$this->checkPlugIns();
		}
		return $this->missing;
		/* PROTECTED REGION END */
	}
	
	/**
	 * @generated	method stub for implementation
	 */
	protected function checkPlugIns() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436888468_309878_1116) ENABLED START */
		// store all dependencies in one array, key -> needed, value -> array of dependants
		// just a simple implementation, not one with a high performance
		$dependencies = array();
		foreach ($this->registry as $name => $plugin) {
			foreach ($plugin->getDependencies() as $required) {
				if (array_key_exists($required, $dependencies)) {
					$dependencies[$required][] = $name;
				} else {
					$dependencies[$required] = array($name);
				}
			}
		}
		$this->missing = array();
		// check if all required modules exist
		foreach ($dependencies as $name => $required) {
			if (!array_key_exists($name, $this->registry)) {
				$this->missing[$name] = $required;
			}
		}
		$this->checked = true;
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243436601140_962276_1091) ENABLED START */
	// TODO: put your further code implementations for class 'ArrayPlugInRegistry' here
	/* PROTECTED REGION END */
}
?>
