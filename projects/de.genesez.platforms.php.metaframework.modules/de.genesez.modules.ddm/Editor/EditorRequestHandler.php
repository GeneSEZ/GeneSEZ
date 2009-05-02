<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240398668828_377703_375) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_BaseCompositeRequestHandler
 * @author	dreamer
 * @package	DDM
 */
class Editor_EditorRequestHandler extends Core_BaseCompositeRequestHandler  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Msg_FlashNotifier	$_notifier
	 */
	private $_notifier;

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Editor_EditorRequestHandler}
	 * @generated	constructor stub for implementation
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240402786000_724799_604) ENABLED START */
		parent::__construct(array(
			'navigation' => new Editor_NavigationHandler()
		));
		$this->view = 'ddm/editor.html';
		/* PROTECTED REGION END */
	}



	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240399318375_689601_530) ENABLED START */
		$dto = parent::handle($handlerInfo);
		$dto->notifier = $this->_notifier;
		$dto->title = 'dynamic data model editor';
		$dto->css = array($this->baseServerUri() . 'base.css');
		$dto->scripts = array();
		return $dto;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Core_RequestHandler	$contentHandle	
	 */
	public function setContentHandler($contentHandle) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240850470891_866457_512) ENABLED START */
		$this->nestedRequestHandler->insert('content', $contentHandle);
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_EditorRequestHandler::getNotifier() $_notifier}
	 * @param	Msg_FlashNotifier	$notifier	the value to set
	 */
	public 	 function setNotifier(Msg_FlashNotifier $notifier) {
		$this->_notifier = $notifier;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240398668828_377703_375) ENABLED START */
	// TODO: put your further code implementations for class 'Editor_EditorRequestHandler' here
	/* PROTECTED REGION END */
}
?>
