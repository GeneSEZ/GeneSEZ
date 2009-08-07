<?php
require_once 'Mfw/ExtensionRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243325164078_119756_635) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a simple <b>default implementation</b> of the extension registry 
 * interface using an associative array to manage the contributions made to 
 * particular extensions.
 * @see		Mfw_ExtensionRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayExtensionRegistry  implements Mfw_ExtensionRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_ArrayExtensionRegistry::getRegistry()}
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Registers a contribution for the specified extension.
	 * @param	string	$extension	the extension on which a contribution is done
	 * @param	mixed	$contribution	the contribution for the specified extension
	 */
	public function register($extension, $contribution) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325164078_119756_635__16_0_b6f02e1_1243328733390_261363_857) ENABLED START */
		if ($this->hasContributions($extension)) {
			$this->registry[$extension][] = $contribution;
		} else {
			$this->registry[$extension] = array($contribution);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * Checks for <b>contributions</b> to the specified extension.
	 * @param	string	$extension	the identifier of the extension
	 * @return	boolean
	 */
	public function hasContributions($extension) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325164078_119756_635__16_0_b6f02e1_1243324733906_887340_379) ENABLED START */
		return isset($this->registry[$extension]);
		/* PROTECTED REGION END */
	}

	/**
	 * Returns an array with the <b>contributions</b> of the specified extensions.
	 * @param	string	$extension	the identifier of the extension
	 * @return	array of mixed
	 */
	public function getContributions($extension) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243325164078_119756_635__16_0_b6f02e1_1243324770125_599488_383) ENABLED START */
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
