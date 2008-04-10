<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._12_5_8a7027a_1182165360608_205087_392) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._12_5_8a7027a_1182165360608_205087_392) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
 class LicensePlate   {
	
	// -- attributes --------------------------------------------------------
	
	/**
	 * @var		string	$key	
	 * @see		LicensePlate::getKey()
	 */
	private $key;
	
	// -- associations ------------------------------------------------------
	
	/**
	 * @var		Car	$car	
	 * @see		LicensePlate::getCar()
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
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_8a7027a_1182165461531_685084_422) ENABLED START -->
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
	 * @see		LicensePlate::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	
	/**
	 * getter for the attribute $key
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_8a7027a_1182165627283_234962_549) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	string	the value of $key
	 */
	private function getKey() {
		return $key;
	}
	
	/**
	 * setter for the attribute $key
	 * @param	string	$key	the value to set
	 * @see		LicensePlate::getKey()
	 */
	private function setKey(string $key) {
		self::$key = $key;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
	// TODO: put your further code implementations for class 'LicensePlate' here
	/* PROTECTED REGION END */
}
?>
