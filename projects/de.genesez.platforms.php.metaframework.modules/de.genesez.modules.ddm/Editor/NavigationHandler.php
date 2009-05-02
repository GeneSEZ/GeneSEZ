<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240397545109_914177_263) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseRequestHandler
 * @author	dreamer
 * @package	DDM
 */
class Editor_NavigationHandler extends Core_BaseRequestHandler  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Core_HandlerInfo	$handlerInfo
	 */
	protected $handlerInfo;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240397637656_702620_305) ENABLED START */
		$this->handlerInfo = $handlerInfo;
		$dto = new Menu_MenuBar(array(
			new Menu_Menu('class', $this->createLinkTo('/class'), array(
				new Menu_MenuItem('create new', $this->createLinkTo('/class/create'), $this->isCurrentContext('/class/create')),
				new Menu_MenuItem('list', $this->createLinkTo('/class/list'), $this->isCurrentContext('/class/list'))
			), $this->isCurrentContext('/class')),
			new Menu_Menu('type', $this->createLinkTo('/type'), array(
				new Menu_MenuItem('create new', $this->createLinkTo('/type/create'), $this->isCurrentContext('/type/create')),
				new Menu_MenuItem('list', $this->createLinkTo('/type/list'), $this->isCurrentContext('/type/list'))
			), $this->isCurrentContext('/type')),
			new Menu_Menu('attribute', $this->createLinkTo('/attribute'), array(
				new Menu_MenuItem('create new', $this->createLinkTo('/attribute/create'), $this->isCurrentContext('/attribute/create')),
				new Menu_MenuItem('list', $this->createLinkTo('/attribute/list'), $this->isCurrentContext('/attribute/list'))
			), $this->isCurrentContext('/attribute')),
			new Menu_Menu('association', $this->createLinkTo('/association'), array(
				new Menu_MenuItem('create new', $this->createLinkTo('/association/create'), $this->isCurrentContext('/association/create')),
				new Menu_MenuItem('list', $this->createLinkTo('/association/list'), $this->isCurrentContext('/association/list'))
			), $this->isCurrentContext('/association'))
			));
		return $dto;
		/* PROTECTED REGION END */
	}

	/**
	 * creates a link to with the specified path and the handler context as its 
	 * base
	 * @param	string	$path	
	 * @return	string
	 */
	protected function createLinkTo($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240409683421_667990_618) ENABLED START */
		return $_SERVER['SCRIPT_NAME'] . $this->handlerInfo->context->parent->get() . $path;
		/* PROTECTED REGION END */
	}

	/**
	 * checks if the specified path with the handler context as its base is the 
	 * current location
	 * @param	string	$path	
	 * @return	boolean
	 */
	protected function isCurrentContext($path) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240410059718_458730_623) ENABLED START */
		$pathinfo = '/' . $this->handlerInfo->context->name . '/' . implode('/', $this->handlerInfo->pathInfo);
		if ($pathinfo == $path) {
			return true;
		} else {
			return false;
		}
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240397545109_914177_263) ENABLED START */
	// TODO: put your further code implementations for class 'Editor_NavigationHandler' here
	/* PROTECTED REGION END */
}
?>
