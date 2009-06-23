<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240322753437_323386_425) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Simple class to represent a message.
 * @see		Mfw_DtoBase
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class Msg_Message extends Mfw_DtoBase  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		string	$_info
	 */
	const INFO  = 'info';
	/**
	 * @generated	attribute definition
	 * @var		string	$_warning
	 */
	const WARNING  = 'warning';
	/**
	 * @generated	attribute definition
	 * @var		string	$_error
	 */
	const ERROR  = 'error';
	
	// -- constructors + destructors ----------------------------------------
	
	/**
	 * @generated	constructs an object of class {@link Msg_Message}
	 * @param	string	$message	
	 * @param	string	$severity	default value is 'self::INFO'
	 */
	public function __construct($message, $severity = self::INFO) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240322762234_410753_447) ENABLED START */
		parent::__construct();
		$this->message = $message;
		$this->severity = $severity;
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function view() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241034790140_715684_434) ENABLED START */
		return 'de.genesez.modules.util/message.html';
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240322753437_323386_425) ENABLED START */
	// TODO: put your further code implementations for class 'Msg_Message' here
	/* PROTECTED REGION END */
}
?>
