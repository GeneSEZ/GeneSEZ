<?php
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Context.php';
require_once 'Mfw/Resolver.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240215363281_620116_738) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Provides an <b>URL</b> based implementation of the resolver interface. The 
 * requested functionality is defined by the requested URL.
 * @see		Mfw_Resolver
 * @author	dreamer
 * @package	Metaframework
 */
class Mfw_UrlResolver  implements Mfw_Resolver {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Resolves the needed information to handle a request.
	 * @param	Mfw_Context	$context	the context structure of the application
	 * @return	Mfw_HandlerInfo
	 */
	public function resolve(Mfw_Context $context) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240215363281_620116_738__16_0_b6f02e1_1237827425625_150554_301) ENABLED START */
		$pathinfo = $this->pathInfo();
		$pathparts = $this->checkPath($pathinfo);
		$handleableContext = $context->resolveContext($pathparts);
		$path = substr($pathinfo, strlen($handleableContext));
		if ($path === false) {
			$path = '/';
		}
		$handlerinfo = new Mfw_HandlerInfo($handleableContext, $path, $pathinfo);
		return $handlerinfo;
		/* PROTECTED REGION END */
	}
	
	/**
	 * obtains the <i>path info</i> of the current executing script and ensures 
	 * it begins with an slash '/'
	 * @return	string
	 */
	protected function pathInfo() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240215501687_611602_772) ENABLED START */
		$path = Mfw_Url::requestPath();
		if (substr($path, 0, 1) !== '/') {
			$path = '/' + $path;
		}
		return $path;
		/* PROTECTED REGION END */
	}

	/**
	 * validates the <i>path info</i> by checking if each path entry consists 
	 * only of word characters or numbers
	 * @param	string	$path	the path info to check
	 * @return	array of string
	 */
	protected function checkPath($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240219811531_934900_902) ENABLED START */
		$pattern = '((\d|\w)+)';
		$pathinfo = array();
		$array = explode('/', $path);
		foreach ($array as $item) {
			// filter empty contexts
			if ($item === '' || $item === '/') {
				continue;
			}
			// validate context names
			$result = preg_match($pattern, $item);
			if ($result !== 1) {
				$this->pathInvalid();
			} else {
				$pathinfo[] = $item;
			}
		}
		return $pathinfo;
		/* PROTECTED REGION END */
	}

	/**
	 * handler method if an invalid path entry is detected
	 * @param	string	$path	the path info
	 * @param	string	$entry	the invalid path entry
	 */
	protected function pathInvalid($path, $entry) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240219646828_34822_898) ENABLED START */
		// TODO: implementation of method 'Mfw_ContextResolver.pathInvalid(...)'
		throw new Exception('The implementation of the method Mfw_ContextResolver::pathInvalid is missing !');
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240215363281_620116_738) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_ContextResolver' here
	/* PROTECTED REGION END */
}
?>
