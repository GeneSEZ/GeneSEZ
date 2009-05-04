<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241445333663_239738_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Helper class to access PHP-specific data.
 * @author	dreamer
 * @package	Metaframework
 */
class Core_Php   {




	// -- method implementations --------------------------------------------
	
	/**
	 * Returns the <b>PATH_INFO</b> of an PHP script. Because the correct setting 
	 * of the PATH_INFO variable is not ensured, this method implements a work 
	 * aroud to get this information.
	 * @return	string
	 */
	public static function requestPath() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241445345522_596318_380) ENABLED START */
		$requesturi = $_SERVER['REQUEST_URI'];
		$scriptname = $_SERVER['SCRIPT_NAME'];
		$path = preg_replace('#^' . $scriptname . '#', '', $requesturi);
		$path = preg_replace('/\?(.*)/', '', $path);
		return $path;
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241445333663_239738_361) ENABLED START */
	// TODO: put your further code implementations for class 'Core_Php' here
	/* PROTECTED REGION END */
}
?>
