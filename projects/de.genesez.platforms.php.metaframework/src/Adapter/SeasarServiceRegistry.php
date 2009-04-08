<?php
require_once 'Core/ServiceRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999613687_255843_1112) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_ServiceRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Adapter_SeasarServiceRegistry  implements Core_ServiceRegistry {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		S2Container	$_container
	 */
	private $_container;
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999841671_206361_1191) ENABLED START */
		return $this->_container->hasComponentDef($name);
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 */
	public function getComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999841671_618567_1192) ENABLED START */
		return $this->_container->getComponent($name);
		/* PROTECTED REGION END */
	}
	
	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Adapter_SeasarServiceRegistry::getContainer() $_container}
	 * @param	S2Container	$container	the value to set
	 */
	public 	 function setContainer(S2Container $container) {
		$this->_container = $container;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237999613687_255843_1112) ENABLED START */
	// TODO: put your further code implementations for class 'Seasar_SeasarServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
