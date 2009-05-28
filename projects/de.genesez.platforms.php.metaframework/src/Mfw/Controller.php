<?php
require_once 'Core/ServiceRegistry.php';
require_once 'Core/RequestHandler.php';
require_once 'Core/HandlerInfo.php';
require_once 'Core/Action.php';
require_once 'Core/Dto.php';
require_once 'Core/BaseRequestHandler.php';
require_once 'UML/MultiQualifiedAssociation.php';
require_once 'UML/OneAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239126599921_834943_1226) ENABLED START */
// TODO: put your further include + require statements here
require_once 'HTTP.php';
/* PROTECTED REGION END */

/**
 * @see		Core_BaseRequestHandler
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Core_Controller extends Core_BaseRequestHandler  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Core_ServiceRegistry	$serviceRegistry
	 */
	protected $serviceRegistry;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$noActionSpecifiedHandler
	 */
	protected $noActionSpecifiedHandler;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$unknownActionSpecifiedHandler
	 */
	protected $unknownActionSpecifiedHandler;
	/**
	 * @generated	attribute definition
	 * @var		Core_RequestHandler	$noIdSpecifiedHandler
	 */
	protected $noIdSpecifiedHandler;
	/**
	 * @generated	attribute definition
	 * @var		Core_HandlerInfo	$handlerInfo
	 */
	protected $handlerInfo;

	/**
	 * @var	array of Core_Action	stores the linked objects of the  multi qualified unidirectional to one association to {@link Core_Action} (symmetry ensured) 
	 */
	private $_actions = array();
	/**
	 * @var	Core_Action	stores the linked object of the  unidirectional to one association to {@link Core_Action} (symmetry ensured) 
	 */
	private $_defaultAction;
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>actions</var>: the multi qualified unidirectional to one association to {@link Core_Action} (symmetry ensured)</li>
	 *   <li><var>defaultAction</var>: the unidirectional to one association to {@link Core_Action} (symmetry ensured)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Core_Controller}
	 * @generated	constructor stub for implementation
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240241341890_219976_955) ENABLED START */
		$list = new Core_Action('list', false, 'listing');
		$this->defaultAction->insert($list);
		$this->actions->insert('list', $list);
		$this->actions->insert('create', new Core_Action('create', false));
		$this->actions->insert('edit', new Core_Action('edit'));
		$this->actions->insert('delete', new Core_Action('delete'));
		$this->actions->insert('show', new Core_Action('show'));
		/* PROTECTED REGION END */
	}


	// -- method declarations -----------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function create();

	/**
	 * @generated	method stub for implementation
	 * @param	string	$id	
	 * @return	Core_Dto
	 */
	public abstract function delete($id);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$id	
	 * @return	Core_Dto
	 */
	public abstract function edit($id);

	/**
	 * @generated	method stub for implementation
	 * @param	string	$id	
	 * @return	Core_Dto
	 */
	public abstract function show($id);

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public abstract function listing();

	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @param	Core_HandlerInfo	$handlerInfo	
	 * @return	Core_Dto
	 */
	public function handle($handlerInfo) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1239126840906_396271_1264) ENABLED START */
		$this->handlerInfo = $handlerInfo;
		if ($this->hasAction()) {
			// obtain action object from association by action name
			$action = $this->actions->get($this->getAction());
			if ($action !== null) {
				$method = $action->method;
				if ($action->withId === true) {
					if ($this->hasId() === true) {
						return $this->$method($this->getId());
					} else {
						return $this->noIdSpecified();
					}
				} else {
					return $this->$method();
				}
			} else {
				return $this->unknownActionSpecified();
			}
		} else {
			return $this->noActionSpecified();
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$action	default value is 'null'
	 * @param	string	$controller	default value is 'null'
	 */
	protected function redirect($action = null, $controller = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240245232109_266957_1067) ENABLED START */
		HTTP::redirect($this->newLink($action, $controller));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$action	default value is 'null'
	 * @param	string	$controller	default value is 'null'
	 * @return	string
	 */
	protected function newLink($action = null, $controller = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241252566718_740823_756) ENABLED START */
		$url = self::baseRequestUri();
		if ($controller === null) {
			if ($action === null) {
				$url .= $this->handlerInfo->context;
			} else {
				$url .= $this->handlerInfo->context . '/' . $action;
			}
		} else {
			if ($action === null) {
				$url .= $this->handlerInfo->context->parent->get() . '/' . $controller;
			} else {
				$url .= $this->handlerInfo->context->parent->get() . '/' . $controller . '/' . $action;
			}
		}
		return $url;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	protected function noActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240238021984_342013_941) ENABLED START */
		if ($this->noActionSpecifiedHandler !== null) {
			return $this->noActionSpecifiedHandler->handle($this->handlerInfo);
		}
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	protected function unknownActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240238044687_348789_945) ENABLED START */
		if ($this->unknownActionSpecifiedHandler !== null) {
			return $this->unknownActionSpecifiedHandler->handle($this->handlerInfo);
		}
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	protected function noIdSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241765470421_127482_360) ENABLED START */
		if ($this->noIdSpecifiedHandler !== null) {
			return $this->noIdSpecifiedHandler->handle($this->handlerInfo);
		}
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function hasAction() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240237592375_894118_929) ENABLED START */
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
	protected function getAction() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240241847671_159587_962) ENABLED START */
		return $this->handlerInfo[0];
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	boolean
	 */
	protected function hasId() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240237600734_364201_933) ENABLED START */
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
	protected function getId() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240241852625_638835_966) ENABLED START */
		return $this->handlerInfo[1];
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Core_Controller::getServiceRegistry() $serviceRegistry}
	 * @param	Core_ServiceRegistry	$serviceRegistry	the value to set
	 */
	public 	 function setServiceRegistry(Core_ServiceRegistry $serviceRegistry) {
		$this->serviceRegistry = $serviceRegistry;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_Controller::getNoActionSpecifiedHandler() $noActionSpecifiedHandler}
	 * @param	Core_RequestHandler	$noActionSpecifiedHandler	the value to set
	 */
	public 	 function setNoActionSpecifiedHandler(Core_RequestHandler $noActionSpecifiedHandler) {
		$this->noActionSpecifiedHandler = $noActionSpecifiedHandler;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_Controller::getUnknownActionSpecifiedHandler() $unknownActionSpecifiedHandler}
	 * @param	Core_RequestHandler	$unknownActionSpecifiedHandler	the value to set
	 */
	public 	 function setUnknownActionSpecifiedHandler(Core_RequestHandler $unknownActionSpecifiedHandler) {
		$this->unknownActionSpecifiedHandler = $unknownActionSpecifiedHandler;
	}
	/**
	 * @generated	setter method for the attribute {@link Core_Controller::getNoIdSpecifiedHandler() $noIdSpecifiedHandler}
	 * @param	Core_RequestHandler	$noIdSpecifiedHandler	the value to set
	 */
	public 	 function setNoIdSpecifiedHandler(Core_RequestHandler $noIdSpecifiedHandler) {
		$this->noIdSpecifiedHandler = $noIdSpecifiedHandler;
	}

	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>actions</var>: the  multi qualified unidirectional to one association to {@link Core_Action} (symmetry ensured)</li>
	 *   <li><var>defaultAction</var>: the  unidirectional to one association to {@link Core_Action} (symmetry ensured)</li>
	 * </ul>
	 * @param	string	$name	the name of the member
	 * @throws	{@link Exception} if the specified member is neither accessible nor available
	 * @return	mixed	the value of the member or an association management object
	 */
	public function __get($name) {
		switch ($name) {
			case 'actions':
			case 'defaultAction':
				return $this->getInitializedAssociation($name);
			default: throw new Exception('cannot get the value of an inaccessible or unavailable property: ' . $name); break;
		}
	}

	/**
	 * lazily initializes the requested association management objects
	 * @param	string	&$name	the name of the association role
	 * @return	Association|QualifiedAssociation	the association management object
	 */
	private function getInitializedAssociation(&$name) {
		if (!array_key_exists($name, $this->associations)) {
			switch ($name) {
				case 'actions': $this->associations[$name] = new UML_MultiQualifiedAssociation($this, $this->_actions); break;
				case 'defaultAction': $this->associations[$name] = new UML_OneAssociation($this, $this->_defaultAction); break;
				default: throw new Exception('non-existing association specified: ' . $name); break;
			}
		}
		return $this->associations[$name];
	}
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1239126599921_834943_1226) ENABLED START */
	// TODO: put your further code implementations for class 'Core_Controller' here
	/* PROTECTED REGION END */
}
?>
