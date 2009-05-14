<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241254501703_427300_301) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	DDM
 */
abstract class Editor_DefaultController extends Util_NotifierController  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$classDao
	 */
	protected $classDao;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$noClassSpecifiedHandler
	 */
	protected $noClassSpecifiedHandler;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$unknownClassSpecifiedHandler
	 */
	protected $unknownClassSpecifiedHandler;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	null	$handlerInfo	
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_406447_303) ENABLED START */
		$this->handlerInfo = $handlerInfo;
		if ($this->hasClass()) {
			if ($this->classDao->exist( $this->getClass() )) {
				return parent::handle($handlerInfo);
			} else {
				return $this->unknownClassSpecified();
			}
		} else {
			return $this->noClassSpecified();
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$action	default value is 'null'
	 * @param	string	$class	default value is 'null'
	 */
	protected function redirect($action = null, $class = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_689012_304) ENABLED START */
		HTTP::redirect($this->newLink($action, $controller));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$action	default value is 'null'
	 * @param	string	$class	default value is 'null'
	 * @return	string
	 */
	protected function newLink($action = null, $class = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_175507_305) ENABLED START */
		$url = self::baseRequestUri() . $this->handlerInfo->context;
		if ($class === null) {
			if ($action === null) {
				// url already complete
			} else {
				$url .= '/' . $this->getClass() . '/' . $action;
			}
		} else {
			if ($action === null) {
				$url .= '/' . $class;
			} else {
				$url .= '/' . $class . '/' . $action;
			}
		}
		return $url;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function noClassSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_802451_306) ENABLED START */
		if ($this->noClassSpecifiedHandler === null) {
			$this->notifier->add(new Msg_Message('no class specified'));
			HTTP::redirect($this->baseRequestUri() . $this->handlerInfo->context->parent->get());
		} else {
			return $this->noClassSpecifiedHandler->handle($this->handlerInfo);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function unknownClassSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_257117_307) ENABLED START */
		if ($this->unknownClassSpecifiedHandler === null) {
			$this->notifier->add(new Msg_Message('unknown class specified'));
			HTTP::redirect($this->baseRequestUri() . $this->handlerInfo->context->parent->get());
		} else {
			return $this->noClassSpecifiedHandler->handle($this->handlerInfo);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function hasClass() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_737147_308) ENABLED START */
		if ($this->handlerInfo->offsetExists(0)) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	protected function getClass() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_97137_309) ENABLED START */
		return $this->handlerInfo[0];
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function hasAction() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_778881_310) ENABLED START */
		if ($this->handlerInfo->offsetExists(1)) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	protected function getAction() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_779696_311) ENABLED START */
		return $this->handlerInfo[1];
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function hasId() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_100548_312) ENABLED START */
		if ($this->handlerInfo->offsetExists(2)) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	protected function getId() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241254501703_452279_313) ENABLED START */
		return $this->handlerInfo[2];
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_DefaultController::getClassDao() $classDao}
	 * @param	mixed	$classDao	the value to set
	 */
	public 	 function setClassDao( $classDao) {
		$this->classDao = $classDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_DefaultController::getNoClassSpecifiedHandler() $noClassSpecifiedHandler}
	 * @param	Core_RequestHandler	$noClassSpecifiedHandler	the value to set
	 */
	public 	 function setNoClassSpecifiedHandler(Core_RequestHandler $noClassSpecifiedHandler) {
		$this->noClassSpecifiedHandler = $noClassSpecifiedHandler;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_DefaultController::getUnknownClassSpecifiedHandler() $unknownClassSpecifiedHandler}
	 * @param	Core_RequestHandler	$unknownClassSpecifiedHandler	the value to set
	 */
	public 	 function setUnknownClassSpecifiedHandler(Core_RequestHandler $unknownClassSpecifiedHandler) {
		$this->unknownClassSpecifiedHandler = $unknownClassSpecifiedHandler;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241254501703_427300_301) ENABLED START */
	// TODO: put your further code implementations for class 'Editor_DefaultController' here
	/* PROTECTED REGION END */
}
?>
