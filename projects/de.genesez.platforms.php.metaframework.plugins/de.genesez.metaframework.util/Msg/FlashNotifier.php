<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240322907125_749427_515) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Helps to store data in the session of an user for a given count of 
 * request-response cycles. Such a concept is often used to show inform the 
 * user with messages which disappear after subsequent requests.
 * @see		Mfw_Dto
 * @see		Countable
 * @see		IteratorAggregate
 * @see		ArrayAccess
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class Msg_FlashNotifier  implements Mfw_Dto, Countable, IteratorAggregate, ArrayAccess {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		string	$_iD_MESSAGES
	 */
	const ID_MESSAGES  = 'de.genesez.metaframeowork.util.flash.notifier';
	/**
	 * @generated	attribute definition
	 * @var		null	$_iD_EXPIRATION
	 */
	const ID_EXPIRATION  = 'expiration';
	/**
	 * @generated	attribute definition
	 * @var		null	$_iD_DATA
	 */
	const ID_DATA  = 'data';
	/**
	 * @generated	attribute definition
	 * @var		array	$_expiration
	 */
	private $_expiration;
	/**
	 * @generated	attribute definition
	 * @var		array	$_container
	 */
	private $_container;
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs a flash notifer object using the specified container for 
	 * storage. If the parameter is null, the current session is used.<br><br>Note: 
	 * the parameter has to be an object (e.g. ArrayObject) instead of a simple 
	 * array due to the missing reference operator.
	 * @param	array	$container	default value is 'null'
	 */
	public function __construct(array &$container = null) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240323336359_632974_586) ENABLED START */
		$this->initContainer($container);
		$this->decrementExpiration();
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323454906_411152_591) ENABLED START */
		return 'de.genesez.modules.util/notifier.html';
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	int
	 */
	public function count() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323473109_362519_595) ENABLED START */
		return count($this->container);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Iterator
	 */
	public function getIterator() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323485000_255595_599) ENABLED START */
		return new ArrayIterator($this->container);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	Msg_Message	$message	
	 * @param	int	$expiration	default value is '1'
	 */
	public function add(Msg_Message $message, $expiration = 1) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323524687_783348_624) ENABLED START */
		$this->container[] = $message;
		$this->expiration[] = $expiration;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	array	$container	default value is 'null'
	 */
	protected function initContainer(array &$container = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323561812_616133_630) ENABLED START */
		// determine container
		if ($container === null) {
			// init messages in session
			if (!session_id()) {
				session_start();
			}
			if (!array_key_exists(self::ID_MESSAGES, $_SESSION)) {
				$_SESSION[self::ID_MESSAGES] = array();
			}
			$container = &$_SESSION[self::ID_MESSAGES];
		}
		// init container
		if (!array_key_exists(self::ID_EXPIRATION, $container)) {
			$container[self::ID_EXPIRATION] = array();
		}
		if (!array_key_exists(self::ID_DATA, $container)) {
			$container[self::ID_DATA] = array();
		}
		$this->expiration = &$container[self::ID_EXPIRATION];
		$this->container = &$container[self::ID_DATA];
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 */
	protected function decrementExpiration() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240323588000_409313_634) ENABLED START */
		foreach ($this->expiration as $key => $value) {
			if ($value == 0) {
				unset($this->container[$key]);
				unset($this->expiration[$key]);
			} else {
				$this->expiration[$key]--;
			}
		}
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240322907125_749427_515) ENABLED START */
	// TODO: put your further code implementations for class 'Msg_FlashNotifier' here
	public function offsetExists($offset) {
		return array_key_exists($offset, $this->container);
	}
	public function offsetGet($offset) {
		return $this->container[$offset];
	}
	public function offsetSet($offset, $value) {
		$this->container[$offset] = $value;
	}
	public function offsetUnset($offset) {
		unset($this->container[$offset]);
	}
	/* PROTECTED REGION END */
}
?>
