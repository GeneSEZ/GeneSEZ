<?php
require_once 'Core/Dispatcher.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/Context.php';
require_once 'Core/Resolver.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240215363281_620116_738) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_Resolver
 * @author	dreamer
 * @package	Metaframework
 */
class Core_UrlResolver  implements Core_Resolver {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Core_Dispatcher	$_dispatcher
	 */
	private $_dispatcher;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_Context	$context	
	 * @return	Core_HandlerInfo
	 */
	public function resolveHandler($context) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240215396250_911205_762) ENABLED START */
		$pathinfo = $this->pathInfo();
		$pathparts = $this->checkPath($pathinfo);
		$handleableContext = $context->resolveContext($pathparts);
		$path = substr($pathinfo, strlen($handleableContext));
		if ($path === false) {
			$path = '/';
		}
		$handlerinfo = new Core_HandlerInfo($handleableContext, $path);
		$this->_dispatcher->dispatch($handlerinfo);
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
		$path = '';
		if (array_key_exists('PATH_INFO', $_SERVER)) {
			$path = $_SERVER['PATH_INFO'];
		} else {
			$path = '/';
		}
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
		// TODO: implementation of method 'Core_ContextResolver.pathInvalid(...)'
		throw new Exception('The implementation of the method Core_ContextResolver::pathInvalid is missing !');
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Core_UrlResolver::getDispatcher() $_dispatcher}
	 * @param	Core_Dispatcher	$dispatcher	the value to set
	 */
	public 	 function setDispatcher(Core_Dispatcher $dispatcher) {
		$this->_dispatcher = $dispatcher;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240215363281_620116_738) ENABLED START */
	// TODO: put your further code implementations for class 'Core_ContextResolver' here
	/* PROTECTED REGION END */
}
?>
