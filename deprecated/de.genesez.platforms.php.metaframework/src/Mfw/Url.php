<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241445333663_239738_361) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Helper class to access common parts of URLs.
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_Url   {
	
	
	
	
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

	/**
	 * Transforms the <b>request path</b> to an array for easier access to 
	 * context names of the URL.
	 * @param	string	$requestPath	optional parameter specifying the request path to use, otherwise {@link requestPath()} is used
	 * @return	array of string
	 */
	public static function requestInfo($requestPath = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241767443046_404329_497) ENABLED START */
		if ($requestPath === null) {
			$requestPath = self::requestPath();
		}
		$items = array();
		$parts = explode('/', $requestPath);
		foreach ($parts as $item) {
			if ($item !== '') {
				$items[] = $item;
			}
		}
		return $items;
		/* PROTECTED REGION END */
	}

	/**
	 * Returns the base server URL, i.e. the root URL which is accessible from a 
	 * web browser. This URL <b>ends</b> with a<b> slash</b> and does <b>not</b> 
	 * contain the script called.
	 * @return	string
	 */
	public static function baseServerUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241611215187_279485_360) ENABLED START */
		return substr($_SERVER['SCRIPT_NAME'], 0, strrpos($_SERVER['SCRIPT_NAME'], '/') +1);
		/* PROTECTED REGION END */
	}

	/**
	 * Returns the URL of the current request, i.e. the url of the <b>requested</b> 
	 * php script, without any additional path information.
	 * @return	string
	 */
	public static function baseRequestUri() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241611279953_458538_368) ENABLED START */
		return $_SERVER['SCRIPT_NAME'];
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241445333663_239738_361) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_Url' here
	/* PROTECTED REGION END */
}
?>
