<?php
/**

 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_6340215_1182161482703_876307_352) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**

 * 
 * @author	dreamer
 * @package	base
 */
class License   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition, documented here {@link License::getRegistration()}
	 * @var		string	$registration
	 * @see		License::getRegistration()
	 */
	private $registration;
	
	// -- associations ------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition for association to {@link Car}, documented here {@link License::getCar()}
	 * @var		Car	$car
	 * @see		License::getCar()
	 */
	private $car;
	
	
	
	
	
	// -- association accessors ---------------------------------------------
	/**
	 * getter method of the association attribute {@link License::$car}
	 * @generated	accessor to get the value of the association attribute {@link License::$car} from association to {@link Car}
	 * @return	Car	the value of {@link License::$car}
	 */
	private function getCar() {
		return $car;
	}
	/**
	 * setter method of the association attribute {@link License::getCar() $car}
	 * @generated	setter method for the association attribute from association to {@link Car}
	 * @param	Car	$car	the value to set
	 * @see		License::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter method of the attribute {@link License::$registration}
	 * @generated	accessor to get the value of the attribute {@link License::$registration}
	 * @return	string	the value of {@link License::$registration}		 */
	private function getRegistration() {
		return $registration;
	}
	/**
	 * setter method of the attribute {@link License::getRegistration() $registration}
	 * @generated	setter method for the attribute {@link License::getRegistration() $registration}
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
