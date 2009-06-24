<?php
require_once 'Mfw/InterceptorRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329579703_739060_909) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_InterceptorRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayInterceptorRegistry  implements Mfw_InterceptorRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$pattern	
	 * @param	string	$interceptor	
	 */
	public function register($pattern, $interceptor) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243329511140_342525_904) ENABLED START */
		$this->registry[] = array($pattern => $interceptor);
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243329579703_739060_909) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_ArrayInterceptorRegistry' here
	public function getIterator() {
		return new ArrayIterator($this->registry);
	}
	/* PROTECTED REGION END */
}
?>
