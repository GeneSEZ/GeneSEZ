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
	 * @var		Smarty	$_smarty
	 */
	private $_smarty;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	string	$template	
	 * @param	Core_Dto	$dto	
	 */
	public function render($template, $dto) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1238000667953_464139_1265) ENABLED START */
		$this->smarty->assign('dto', $dto);
		$this->smarty->display($view);
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Adapter_SmartyRenderer::getSmarty() $_smarty}
	 * @param	Smarty	$smarty	the value to set
	 */
	public 	 function setSmarty(Smarty $smarty) {
		$this->_smarty = $smarty;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237999928437_189680_1219) ENABLED START */
	// TODO: put your further code implementations for class 'Smarty_SmartyRenderer' here
	/* PROTECTED REGION END */
}
?>
