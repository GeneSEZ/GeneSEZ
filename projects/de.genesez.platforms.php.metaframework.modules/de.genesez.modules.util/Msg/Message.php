<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240322753437_323386_425) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Simple class to represent a message.
 * @see		Core_BaseDto
 * @author	dreamer
 * @package	Utilities
 */
class Msg_Message extends Core_BaseDto  {

	// -- constructors + destructors ----------------------------------------
	
	/**
	 * constructs an object of class {@link Msg_Message}
	 * @generated	constructor stub for implementation
	 * @param	string	$message	
	 */
	public function __construct($message) {
		/* PROTECTED REGION ID(php.constructor._16_0_b6f02e1_1240322762234_410753_447) ENABLED START */
		parent::__construct();
		$this->message = $message;
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




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240322753437_323386_425) ENABLED START */
	// TODO: put your further code implementations for class 'Msg_Message' here
	/* PROTECTED REGION END */
}
?>
