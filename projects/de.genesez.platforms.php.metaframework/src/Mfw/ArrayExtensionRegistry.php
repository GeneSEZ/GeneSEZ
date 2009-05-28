<?php
require_once 'Core/ExtensionRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243325164078_119756_635) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_ExtensionRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Core_ArrayExtensionRegistry  implements Core_ExtensionRegistry {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	mixed	$value	
	 */
	public function registerContribution($name, $value) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325455421_669669_692) ENABLED START */
		if ($this->hasContribution($name)) {
			$this->registry[$name][] = $value;
		} else {
			$this->registry[$name] = array($value);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasContribution($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325525109_252799_696) ENABLED START */
		return isset($this->registry[$name]);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	array of mixed
	 */
	public function getContribution($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325525109_863194_697) ENABLED START */
		return $this->registry[$name];
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243325164078_119756_635) ENABLED START */
	// TODO: put your further code implementations for class 'Core_ArrayExtensionRegistry' here
	/* PROTECTED REGION END */
}
?>
