<?php
require_once 'Smarty/Smarty.class.php';
require_once 'Core/Dto.php';
require_once 'Core/Renderer.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237999928437_189680_1219) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
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
		if (!$this->smarty->template_exists($view)) {
			$view = $this->defaultView();
		}
		if (!$this->smarty->template_exists($view)) {
			$view = $this->defaultView() . '.html';
		}
		if (!$this->smarty->template_exists($view)) {
			$view = $this->defaultView() . '/index.html';
		}
		$this->smarty->assign('dto', $dto);
		$this->smarty->display($view);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	protected function defaultView() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240433824734_817533_526) ENABLED START */
		$view = $_SERVER['PATH_INFO'];
		if (substr($view, 0, 1) === '/') {
			$view = substr($view, 1);
		}
		return $view;
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
