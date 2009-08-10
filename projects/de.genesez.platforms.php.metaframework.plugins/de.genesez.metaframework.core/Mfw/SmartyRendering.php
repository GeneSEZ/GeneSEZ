<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243539497906_977189_432) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A <b>renderer</b> implementation which generates a response using the 
 * smarty template engine.
 * @see		Mfw_Rendering
 * @author	dreamer
 * @package	de.genesez.metaframework.core
 */
class Mfw_SmartyRendering  implements Mfw_Rendering {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		Smarty	$smarty
	 */
	protected $smarty;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Mfw_Dto	$dto	
	 */
	public function render(Mfw_Dto $dto) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243595046187_312569_400) ENABLED START */
		$this->templateBasePath = realpath('./' . $this->smarty->template_dir) . '/';
		$view = $dto->view();
		$this->assignGlobalVariables($this->smarty);
		$this->smarty->assign('dto', $dto);
		$this->smarty->display($view);
		/* PROTECTED REGION END */
	}

	/**
	 * The dynamically registered template function plugin <b>render</b> for 
	 * smarty templates. It is the smarty template function port of the <b>Renderer</b> 
	 * interface, i.e. you specifiy only a dto to render it. If there is no 
	 * &lt;code&gt;dto&lt;/code&gt; parameter with an instance of type &lt;code&gt;Mfw_Dto&lt;/code&gt; a 
	 * smarty error is triggered.<br><br>The view of a dto must not exist; in 
	 * this case this function derives a default template from the URL.<br>
	 * @param	array	$params	the parameters of the template function as an associative array with key:value pairs
	 * @param	Smarty	$smarty	reference to the smarty object
	 * @return	string
	 */
	public function checkInclude(array $params, Smarty &$smarty) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497906_111858_437) ENABLED START */
		if (array_key_exists('dto', $params)) {
			if ($params['dto'] instanceof Mfw_Dto) {
				$view = $params['dto']->view();
				if ($this->isSmartyTemplate($view)) {
					return $this->renderInclude($view, $params);
				}
				return $this->processInclude($view, $params);
			} else {
				$this->smarty->trigger_error('unable to render include: the dto type (' . gettype($params['dto']) . ') must implement the \'Mfw_Dto\' interface! ');
			}
		} else {
			$this->smarty->trigger_error('unable to render include: there is no \'dto\' parameter! ' . print_r($params, true));
		}
		/* PROTECTED REGION END */
	}

	/**
	 * Tries to determine a default smarty template to render the template 
	 * function parameters, that is the data transfer object.
	 * <br>
	 * <br>If successful, the smarty template found is rendered, otherwise a smarty 
	 * error is triggered.
	 * @param	string	$view	the template as specified by the data transfer object
	 * @param	array	$params	the parameters of the template function as an associative array with key:value pairs
	 * @return	string
	 */
	protected function processInclude($view, array $params) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497906_99424_438) ENABLED START */
		if ($view === null || $view === '') {
			// check suffixes with url fallback
			$requestPath = Mfw_Url::requestInfo();
			for ($i = count($requestPath); $i >= 0; --$i) {
				$part = array_slice($requestPath, 0, $i);
				$view = implode('/', $part);
				foreach ($this->defaultSuffixes() as $suffix) {
					$name = $this->buildView($suffix, $view);
					if ($this->isSmartyTemplate($name)) {
						return $this->renderInclude($name, $params);
					}
				}
				// fallback for default controller
				if ($i == count($requestPath)) {
					// exclude 'class' context
					$context = Mfw_Url::requestInfo();
					array_splice($context, $i -2, 1);
					$view = implode('/', $context);
					foreach ($this->defaultSuffixes() as $suffix) {
						$name = $this->buildView($suffix, $view);
						if ($this->isSmartyTemplate($name)) {
							return $this->renderInclude($name, $params);
						}
					}
					// exclude 'class' context and 'id'
					$context = Mfw_Url::requestInfo();
					array_splice($context, $i -1, 1);
					array_splice($context, $i -3, 1);
					$view = implode('/', $context);
					foreach ($this->defaultSuffixes() as $suffix) {
						$name = $this->buildView($suffix, $view);
						if ($this->isSmartyTemplate($name)) {
							return $this->renderInclude($name, $params);
						}
					}
				}
			}
		} else {
			// check only suffixes
			foreach ($this->defaultSuffixes() as $suffix) {
				$name = $this->buildView($suffix, $view);
				if ($this->isSmartyTemplate($name)) {
					return $this->renderInclude($name, $params);
				}
			}
		}
		$this->smarty->trigger_error('unable to determine template resource: \''. $view .'\'! ' . print_r($params, true));
		/* PROTECTED REGION END */
	}

	/**
	 * Evaluates the specified smarty template and returns its contents, i.e. the 
	 * content of the compiled smarty template.
	 * @param	string	$view	a valid smarty template
	 * @param	array	$params	the parameters of the template function as an associative array with key:value pairs
	 * @return	string
	 */
	protected function renderInclude($view, array $params) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497906_926281_439) ENABLED START */
		// TODO: exists another way to do this?
		$smarty = new Smarty();
		$smarty->template_dir = $this->smarty->template_dir;
		$smarty->compile_dir = $this->smarty->compile_dir;
		$smarty->register_function('render', array($this, 'checkInclude'));
		$this->assignGlobalVariables($smarty);
		$smarty->assign($params);
		return $smarty->fetch($view);
		// this does NOT work!  it works for the first time 'render' is used, further usage results in lost dto parameters
//		return $this->smarty->_smarty_include(array(
//			'smarty_include_tpl_file' => $view,
//			'smarty_include_vars' => $params
//		));
//		return $view;
		/* PROTECTED REGION END */
	}

	/**
	 * Checks if the specified template is a smarty template file and readable.
	 * @param	string	$name	the smarty template to check
	 * @return	boolean
	 */
	protected function isSmartyTemplate($name) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497921_826248_440) ENABLED START */
		$view = realpath('./' . $this->smarty->template_dir) . '/' . $name;
		if (is_file($view) && is_readable($view)) {
			return true;
		} else {
			return false;
		}
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497921_581271_441) ENABLED START */
		if ($view === null) {
			$view = Mfw_Url::requestPath();
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497921_845108_442) ENABLED START */
		return array('', '.html', '.tpl', '/index.html', '/index.tpl');
		/* PROTECTED REGION END */
	}

	/**
	 * Registers useful variables on the given Smarty instance to be globally 
	 * available in templates.
	 * @param	Smarty	$smarty	the smarty instance to which the variables are assigned
	 */
	protected function assignGlobalVariables(Smarty $smarty) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243539497921_797542_443) ENABLED START */
		$smarty->assign('webbase', Mfw_Url::baseServerUri());
		$smarty->assign('requestbase', Mfw_Url::baseRequestUri());
		$smarty->assign('context', Mfw_Url::requestPath());
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Mfw_SmartyRendering::getSmarty() $smarty}
	 * @param	Smarty	$smarty	the value to set
	 */
	public 	 function setSmarty(Smarty $smarty) {
		$this->smarty = $smarty;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243539497906_977189_432) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_SmartyRendering' here
	/* PROTECTED REGION END */
}
?>
