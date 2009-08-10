<?php
require_once 'Mfw/PlugIn.php';
require_once 'Mfw/PlugInRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243436601140_962276_1091) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a simple <b>default implementation</b> of the plug-in registry 
 * interface using an associative array to manage the plug-ins and determine 
 * the dependencies.
 * @see		Mfw_PlugInRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayPlugInRegistry  implements Mfw_PlugInRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_ArrayPlugInRegistry::getRegistry()}
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	/**
	 * documented here {@link Mfw_ArrayPlugInRegistry::getChecked()}
	 * @generated	attribute definition
	 * @var		boolean	$checked
	 */
	protected $checked = false;
	/**
	 * documented here {@link Mfw_ArrayPlugInRegistry::getMissing()}
	 * @generated	attribute definition
	 * @var		array	$missing
	 */
	protected $missing = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Registers a plug-in.
	 * @param	Mfw_PlugIn	$plugin	the plug-in to be registered
	 */
	public function register(Mfw_PlugIn $plugin) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436601140_962276_1091__16_0_b6f02e1_1243329382375_477947_880) ENABLED START */
		// TODO: in a reviced implementation, insert the plug-ins additionally into a depencency tree
		$this->registry[$plugin->getId()] = $plugin;
		if ($this->checked === true) {
			$this->checked = false;
		}
		/* PROTECTED REGION END */
	}

	/**
	 * Checks if there are <b>missing dependencies</b> between plug-ins or not.
	 * @return	boolean
	 */
	public function hasMissingDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436601140_962276_1091__16_0_b6f02e1_1243436372546_665562_1082) ENABLED START */
		if ($this->checked === false) {
			$this->checkPlugIns();
		}
		return count($this->missing) > 0;
		/* PROTECTED REGION END */
	}

	/**
	 * Returns an associative array with <b>missing plug-in dependencies</b>. The 
	 * array is structured as follows: identifier of the required plug-in <b>=&gt;</b> 
	 * array of plug-in identifiers defining the dependency.
	 * @return	array
	 */
	public function getMissingDependencies() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243436601140_962276_1091__16_0_b6f02e1_1243436508921_306629_1086) ENABLED START */
		if ($this->checked === false) {
			$this->checkPlugIns();
		}
		return $this->missing;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks for missing plug-ins by evaluating the plug-in dependencies.
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
