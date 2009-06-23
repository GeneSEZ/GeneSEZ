<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243539420937_141797_393) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * <p>
 *   Implementation of the <b>service registry</b> interface using the <b>seasar</b> 
 *   dependency injection framework.
 * </p>
 * @see		Mfw_ServiceRegistry
 * @author	dreamer
 * @package	de.genesez.metaframework.core
 */
class Mfw_SeasarServiceRegistry  implements Mfw_ServiceRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		S2Container	$_container
	 */
	private $_container;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	mixed	$component	
	 */
	public function register($name, $component) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243604113781_343346_404) ENABLED START */
		$this->_container->register($component);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243604113781_227526_405) ENABLED START */
		return $this->_container->hasComponentDef($name);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	mixed
	 */
	public function getComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243604113781_445463_406) ENABLED START */
		return $this->_container->getComponent($name);
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Mfw_SeasarServiceRegistry::getContainer() $_container}
	 * @param	S2Container	$container	the value to set
	 */
	public 	 function setContainer(S2Container $container) {
		$this->_container = $container;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243539420937_141797_393) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_SeasarServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
