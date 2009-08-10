<?php
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/Action.php';
require_once 'Mfw/Dto.php';
require_once 'Mfw/NoActionSpecifiedException.php';
require_once 'Mfw/NoIdSpecifiedException.php';
require_once 'Mfw/UnknownActionSpecifiedException.php';
require_once 'Mfw/RequestHandlerBase.php';
require_once 'UML/MultiQualifiedAssociation.php';
require_once 'UML/OneAssociation.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1239126599921_834943_1226) ENABLED START */
// TODO: put your further include + require statements here
require_once 'HTTP.php';
/* PROTECTED REGION END */

/**
 * Provides an abstract <b>default implementation</b> of a common concept of 
 * request handling of MVC web frameworks by relying on the url pattern: 
 * &lt;code&gt;/&lt;controller&gt;/&lt;action&gt;&lt;/code&gt;
 * @see		Mfw_RequestHandlerBase
 * @author	dreamer
 * @package	Metaframework
 */
abstract class Mfw_Controller extends Mfw_RequestHandlerBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * documented here {@link Mfw_Controller::getHandlerInfo()}
	 * @generated	attribute definition
	 * @var		Mfw_HandlerInfo	$handlerInfo
	 */
	protected $handlerInfo;
	/**
	 * @var	array of Mfw_Action	stores the linked objects of the  multi qualified unidirectional to one association to {@link Mfw_Action} (symmetry ensured) 
	 */
	private $_actions = array();
	/**
	 * @var	Mfw_Action	stores the linked object of the  unidirectional to one association to {@link Mfw_Action} (symmetry ensured) 
	 */
	private $_defaultAction;
	/**
	 * holds all association management objects
	 * <ul>
	 *   <li><var>actions</var>: the multi qualified unidirectional to one association to {@link Mfw_Action} (symmetry ensured)</li>
	 *   <li><var>defaultAction</var>: the unidirectional to one association to {@link Mfw_Action} (symmetry ensured)</li>
	 * </ul>
	 * @var array of Association and/or QualifiedAssociation
	 */
	private $associations = array();
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * Constructs a controller
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240241341890_219976_955) ENABLED START */
		$list = new Mfw_Action('list', false, 'listing');
		$this->defaultAction->insert($list);
		$this->actions->insert('list', $list);
		$this->actions->insert('create', new Mfw_Action('create', false));
		$this->actions->insert('edit', new Mfw_Action('edit'));
		$this->actions->insert('delete', new Mfw_Action('delete'));
		$this->actions->insert('show', new Mfw_Action('show'));
		/* PROTECTED REGION END */
	}
	
	// -- method declarations -----------------------------------------------
	
	/**
	 * Creates a new domain object.
	 * @return	Mfw_Dto
	 */
	public abstract function create();

	/**
	 * Deletes the domain object with the specified id.
	 * @param	string	$id	the id of the domain object to be deleted
	 * @return	Mfw_Dto
	 */
	public abstract function delete($id);

	/**
	 * Edits the domain object with the specified id.
	 * @param	string	$id	the id of the domain object to be edited
	 * @return	Mfw_Dto
	 */
	public abstract function edit($id);

	/**
	 * Shows the detailsof the domain object with the specified id.
	 * @param	string	$id	the id of the domain object to be displayed
	 * @return	Mfw_Dto
	 */
	public abstract function show($id);

	/**
	 * Lists all domain objects of the same type.
	 * @return	Mfw_Dto
	 */
	public abstract function listing();
	
	// -- method implementations --------------------------------------------
	
	/**
	 * Processes the current request and <b>checks</b> for additional url parts 
	 * specifying the <b>action</b> to be called.
	 * @throws		{@link Mfw_NoActionSpecifiedException}
	 * @throws		{@link Mfw_NoIdSpecifiedException}
	 * @throws		{@link Mfw_UnknownActionSpecifiedException}
	 * @param	Mfw_HandlerInfo	$handlerInfo	information about the current handled context
	 * @return	Mfw_Dto
	 */
	public function handle(Mfw_HandlerInfo $handlerInfo) {
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
	 * Redirects the request to another controller and/or action. You may specify 
	 * at least one of both parameters.
	 * @param	string	$action	the optional action to redirect to
	 * @param	string	$controller	the optional controller to redirect to
	 */
	protected function redirect($action = null, $controller = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240245232109_266957_1067) ENABLED START */
		HTTP::redirect($this->newLink($action, $controller));
		/* PROTECTED REGION END */
	}

	/**
	 * Creates a <b>url</b> pointing to the specified action and the specified controller. If the controller is not specified, the current controller is used. If a controller is specified, it is assumed that it is on the same level as the current controller, i.e.: current url: <code>...fixed part.../current controller/action</code>, target url: <code>...fixed part.../controller/action</code>
	 * @param	string	$action	the optional action of the url to be created
	 * @param	string	$controller	the optional controller of the url to be created, default is the current controller
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
	 * Handles the request if the <b>action</b> is <b>missing</b> within the 
	 * requested url.
	 * @throws		{@link Mfw_NoActionSpecifiedException}
	 * @return	Mfw_Dto
	 */
	protected function noActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240238021984_342013_941) ENABLED START */
		throw new Mfw_NoActionSpecifiedException();
		/* PROTECTED REGION END */
	}

	/**
	 * Handles the request if the <b>action</b> of the requested url is <b>unknown</b>.
	 * @throws		{@link Mfw_UnknownActionSpecifiedException}
	 * @return	Mfw_Dto
	 */
	protected function unknownActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240238044687_348789_945) ENABLED START */
		throw new Mfw_UnknownActionSpecifiedException();
		/* PROTECTED REGION END */
	}

	/**
	 * Handles the request if the requested action needs an id but the <b>id</b> 
	 * is <b>missing</b> within the requested url.
	 * @throws		{@link Mfw_NoIdSpecifiedException}
	 * @return	Mfw_Dto
	 */
	protected function noIdSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241765470421_127482_360) ENABLED START */
		throw new Mfw_NoIdSpecifiedException();
		/* PROTECTED REGION END */
	}

	/**
	 * Checks the requested url for a specified action.
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
	 * Returns the action specified from the requested url.
	 * @return	string
	 */
	protected function getAction() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240241847671_159587_962) ENABLED START */
		return $this->handlerInfo[0];
		/* PROTECTED REGION END */
	}

	/**
	 * Checks the requested url for a specified id.
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
	 * Returns the specified id from the requested url.
	 * @return	string
	 */
	protected function getId() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240241852625_638835_966) ENABLED START */
		return $this->handlerInfo[1];
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * magic getter to obtain associations or unmodifiable values of the following members:
	 * <ul>
	 *   <li><var>actions</var>: the  multi qualified unidirectional to one association to {@link Mfw_Action} (symmetry ensured)</li>
	 *   <li><var>defaultAction</var>: the  unidirectional to one association to {@link Mfw_Action} (symmetry ensured)</li>
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
	// TODO: put your further code implementations for class 'Mfw_Controller' here
	/* PROTECTED REGION END */
}
?>
