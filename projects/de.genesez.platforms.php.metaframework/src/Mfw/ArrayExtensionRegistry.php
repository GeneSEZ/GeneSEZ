<?php
require_once 'Mfw/ExtensionRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243325164078_119756_635) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_ExtensionRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayExtensionRegistry  implements Mfw_ExtensionRegistry {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @param	mixed	$contribution	
	 */
	public function register($extension, $contribution) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243328733390_261363_857) ENABLED START */
		if ($this->hasContributions($extension)) {
			$this->registry[$extension][] = $contribution;
		} else {
			$this->registry[$extension] = array($contribution);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @return	boolean
	 */
	public function hasContributions($extension) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243324733906_887340_379) ENABLED START */
		return isset($this->registry[$extension]);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$extension	
	 * @return	array of mixed
	 */
	public function getContributions($extension) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243324770125_599488_383) ENABLED START */
		return $this->registry[$extension];
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243325164078_119756_635) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_ArrayExtensionRegistry' here
	/* PROTECTED REGION END */
}
?>
