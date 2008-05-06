<?php
/**

 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**

 * 
 * @author	dreamer
 * @package	base
 */
class LicensePlate   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition, documented here {@link LicensePlate::getKey()}
	 * @var		string	$key
	 * @see		LicensePlate::getKey()
	 */
	private $key;
	
	// -- associations ------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition for association to {@link Car}, documented here {@link LicensePlate::getCar()}
	 * @var		Car	$car
	 * @see		LicensePlate::getCar()
	 */
	private $car;
	
	
	
	
	
	// -- association accessors ---------------------------------------------
	/**
	 * getter method of the association attribute {@link LicensePlate::$car}
	 * @generated	accessor to get the value of the association attribute {@link LicensePlate::$car} from association to {@link Car}
	 * @return	Car	the value of {@link LicensePlate::$car}
	 */
	private function getCar() {
		return $car;
	}
	/**
	 * setter method of the association attribute {@link LicensePlate::getCar() $car}
	 * @generated	setter method for the association attribute from association to {@link Car}
	 * @param	Car	$car	the value to set
	 * @see		LicensePlate::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter method of the attribute {@link LicensePlate::$key}
	 * @generated	accessor to get the value of the attribute {@link LicensePlate::$key}
	 * @return	string	the value of {@link LicensePlate::$key}		 */
	private function getKey() {
		return $key;
	}
	/**
	 * setter method of the attribute {@link LicensePlate::getKey() $key}
	 * @generated	setter method for the attribute {@link LicensePlate::getKey() $key}
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
