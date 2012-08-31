<?php
require_once 'Mfw/InterceptorRegistry.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243329579703_739060_909) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides a simple <b>default implementation</b> of the inteceptor registry 
 * interface using an associative array to manage the interceptors with their 
 * patterns.
 * @see		Mfw_InterceptorRegistry
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_ArrayInterceptorRegistry  implements Mfw_InterceptorRegistry {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_ArrayInterceptorRegistry::getRegistry()}
	 * @generated	attribute definition
	 * @var		array	$registry
	 */
	protected $registry = array();
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Registers an interceptor for the specified url pattern.
	 * @param	string	$pattern	the url pattern, i.e. a regular expression a url must match
	 * @param	string	$interceptor	the identifier of the interceptor
	 */
	public function register($pattern, $interceptor) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243329579703_739060_909__16_0_b6f02e1_1243329511140_342525_904) ENABLED START */
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
