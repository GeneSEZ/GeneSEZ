<?php
require_once 'Mfw/ServiceRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999613687_255843_1112) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_ServiceRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_SeasarServiceRegistry  implements Mfw_ServiceRegistry {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		S2Container	$_container
	 */
	private $_container;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	mixed	$component	
	 */
	public function register($component) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243435817093_715363_1072) ENABLED START */
		$this->_container->register($component);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	public function hasComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999613687_791397_1116) ENABLED START */
		return $this->_container->hasComponentDef($name);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	mixed
	 */
	public function getComponent($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237999613703_927330_1117) ENABLED START */
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
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237999613687_255843_1112) ENABLED START */
	// TODO: put your further code implementations for class 'Seasar_SeasarServiceRegistry' here
	/* PROTECTED REGION END */
}
?>
