<?php
require_once 'Smarty/Smarty.class.php';
require_once 'Core/Dto.php';
require_once 'Core/Renderer.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999928437_189680_1219) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A <b>renderer</b> implementation which generates a response using the 
 * smarty template engine.
 * @see		Core_Renderer
 * @author	dreamer
 * @package	Metaframework
 */
class Adapter_SmartyRenderer  implements Core_Renderer {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Smarty	$smarty
	 */
	protected $smarty;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_Dto	$dto	
	 */
	public function render($dto) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238000667953_464139_1265) ENABLED START */
		$view = $dto->view();
		$this->smarty->assign('webbase', Core_Url::baseServerUri());
		$this->smarty->assign('requestbase', Core_Url::baseRequestUri());
		$this->smarty->assign('dto', $dto);
		$this->smarty->display($view);
		/* PROTECTED REGION END */
	}

	/**
	 * tries to find a template resource for a specified, non-existing template 
	 * resource. This method is registered as 
	 * &lt;code&gt;default_template_handler_func&lt;/code&gt;. Smarty uses this method to 
	 * obtain the source of a template when the specified template resource 
	 * doesn't exist.
	 * @param	string	$resource_type	the type of the non-existing template resource
	 * @param	string	$resource_name	the name of the non-existing template resource
	 * @param	string	$template_source	variable to return the template content
	 * @param	int	$template_timestamp	variable to return the timestamp of the template content
	 * @param	Smarty	$smarty_obj	reference to the smarty object
	 * @return	boolean
	 */
	public function defaultTemplateHandler($resource_type, $resource_name, &$template_source, &$template_timestamp, &$smarty_obj) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241024432671_172546_369) ENABLED START */
		if ($resource_type == 'file') {
			// check default suffixes for templates
			foreach ($this->defaultSuffixes() as $value) {
				$view = $this->buildView($value);
				if ($this->isSmartyTemplate($view)) {
					// does not work: caching problems, every template determined by this function has same compiled template name
//					$template_source = file_get_contents($base . $view);
//					$template_timestamp = filemtime($base . $view);
					$smarty_obj->display($view);
					return true;
				}
			}
			// check url fallback
			$requestPath = Core_Url::requestPath();
			for ($i = count($requestPath); $i > 0; --$i) {
				$part = array_slice($requestPath, 0, $i);
				$view = implode('/', $part);
				foreach ($this->defaultSuffixes() as $suffix) {
					$name = $this->buildView($suffix, $view);
					if ($this->isSmartyTemplate($name)) {
						$smarty_obj->display($view);
						return true;
					}
				}
			}
			return false;
		}
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * generates the default template based on the path info of the current url 
	 * location and an optional suffix.
	 * @param	string	$suffix	the suffix for the template resource
	 * @param	string	$view	default value is 'null'
	 * @return	string
	 */
	protected function buildView($suffix = null, $view = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240433824734_817533_526) ENABLED START */
		if ($view === null) {
			$view = Core_Url::requestPath();
		}
		if ($suffix !== null) {
			$view .= $suffix;
		}
		$view = preg_replace('#^/+#', '', $view);
		return $view;
		/* PROTECTED REGION END */
	}

	/**
	 * returns an array of possible template resource suffixes, used to find a 
	 * default template file resource
	 * @return	array of string
	 */
	protected function defaultSuffixes() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241024375453_409016_363) ENABLED START */
		return array('', '.html', '.tpl', '/index.html', '/index.tpl');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @return	boolean
	 */
	protected function isSmartyTemplate($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241769056828_26378_516) ENABLED START */
		$base = realpath('./' . $this->smarty->template_dir) . '/';
		if (is_file($base . $name) && is_readable($base . $name)) {
			return true;
		} else {
			return false;
		}
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Adapter_SmartyRenderer::getSmarty() $smarty}
	 * @param	Smarty	$smarty	the value to set
	 */
	public 	 function setSmarty(Smarty $smarty) {
		$this->smarty = $smarty;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237999928437_189680_1219) ENABLED START */
	// TODO: put your further code implementations for class 'Smarty_SmartyRenderer' here
	/* PROTECTED REGION END */
}
?>
