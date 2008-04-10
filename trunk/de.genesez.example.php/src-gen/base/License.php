<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._12_5_6340215_1182161482703_876307_352) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_6340215_1182161482703_876307_352) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._12_5_6340215_1182161482703_876307_352) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
 class License   {
	
	// -- attributes --------------------------------------------------------
	
	/**
	 * @var		string	$registration	
	 * @see		License::getRegistration()
	 */
	private $registration;
	
	// -- associations ------------------------------------------------------
	
	/**
	 * @var		Car	$car	
	 * @see		License::getCar()
	 */
	private $car;
	
	// -- constructors + destructors ----------------------------------------
	
	// -- method declarations -----------------------------------------------
	
	// -- method implementations --------------------------------------------
	
	// -- methods for derived attributes ------------------------------------
	
	// -- association accessors ---------------------------------------------
	
	/**
	 * getter for the association attribute $car
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_6340215_1182161516984_430722_382) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	Car	the value of $car
	 */
	private function getCar() {
		return $car;
	}
	
	/**
	 * setter for the association attribute $car
	 * @param	Car	$car	the value to set
	 * @see		License::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	
	/**
	 * getter for the attribute $registration
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_6340215_1182161578281_520275_451) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	string	the value of $registration
	 */
	private function getRegistration() {
		return $registration;
	}
	
	/**
	 * setter for the attribute $registration
	 * @param	string	$registration	the value to set
	 * @see		License::getRegistration()
	 */
	private function setRegistration(string $registration) {
		self::$registration = $registration;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._12_5_6340215_1182161482703_876307_352) ENABLED START */
	// TODO: put your further code implementations for class 'License' here
	/* PROTECTED REGION END */
}
?>
