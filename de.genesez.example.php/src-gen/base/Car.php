<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._11_5_6340215_1177945913718_872802_139) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */

require_once '../base/Wheel.php';
require_once '../base/License.php';
require_once '../base/LicensePlate.php';
require_once '../base/Engine.php';
require_once '../base/NotReallySeriousException.php';
require_once '../base/Vehicle.php';

/* PROTECTED REGION ID(php.own.imports._11_5_6340215_1177945913718_872802_139) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A car is a vehicle with four wheels and drives on the road.
 * 
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._11_5_6340215_1177945913718_872802_139) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
class Car extends Vehicle  {
	
	// -- attributes --------------------------------------------------------
	/**
	 * @var		int	$maxSpeed	describs the maximum speed of a car
	 * @see		Car::getMaxSpeed()
	 */
	private $maxSpeed;
	
	// -- associations ------------------------------------------------------
	/**
	 * @var		Wheel	$spare	reference to the spared wheel
	 * @see		Car::getSpare()
	 */
	private $spare;
	/**
	 * @var		License	$license	
	 * @see		Car::getLicense()
	 */
	private $license;
	/**
	 * @var		LicensePlate	$licensePlate	
	 * @see		Car::getLicensePlate()
	 */
	private $licensePlate;
	/**
	 * @var		Engine	$engine	
	 * @see		Car::getEngine()
	 */
	private $engine;
	/**
	 * @var		Wheel	$wheels	reference to normal wheels on a car
	 * @see		Car::getWheels()
	 */
	private $wheels = array();
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class Car
	 * 
	 * constructor of the class car
	 * 
	 * the constructor may throw the following exceptions:
	 * {@link NotReallySeriousException NotReallySeriousException}
	 * @throws		NotReallySeriousException
	 * 
	 * @param	int	$mxs	maximum of speed
	 * @param	string	$make	i don't know what make do
	 */
	public function __construct($mxs, $make) {
		/* PROTECTED REGION ID(php.constructor._11_5_6340215_1179229080562_965427_117) ENABLED START */
		// TODO: implementation of method 'Car.car(...)'
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @internal <!-- PROTECTED REGION ID(php.own.operation.comment._12_5_b6f02e1_1204102049578_778385_691) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @param	int	$distance	
	 * @return	boolean	
	 */
	public function drive($distance) {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.implementation._12_5_b6f02e1_1204102049578_778385_691) ENABLED START */
		// TODO: implementation of method 'Car.drive(...)'
		/* PROTECTED REGION END */
		return $returnValue;
	}
	
	// -- methods for derived attributes ------------------------------------
	/**
	 * getter for the attribute $noOfWheels
	 * 
	 * count the number of wheels
	 * @return	int	the value of $noOfWheels
	 */
	private function getNoOfWheels() {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.derived.attribute.implementation._11_5_6340215_1178786244296_257674_121) ENABLED START */
		// TODO: implementation of method 'Car.getNoOfWheels(...)'
		/* PROTECTED REGION END */
		return returnValue;
	}
	
	// -- association accessors ---------------------------------------------
	/**
	 * getter for the association attribute $spare
	 * 
	 * reference to the spared wheel
	 * @return	Wheel	the value of $spare
	 */
	private function getSpare() {
		return $spare;
	}
	/**
	 * setter for the association attribute $spare
	 * @param	Wheel	$spare	the value to set
	 * @see		Car::getSpare()
	 */
	private function setSpare(Wheel $spare) {
		self::$spare = $spare;
	}
	/**
	 * getter for the association attribute $license
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_6340215_1182161516984_882840_381) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	License	the value of $license
	 */
	private function getLicense() {
		return $license;
	}
	/**
	 * setter for the association attribute $license
	 * @param	License	$license	the value to set
	 * @see		Car::getLicense()
	 */
	private function setLicense(License $license) {
		self::$license = $license;
	}
	/**
	 * getter for the association attribute $licensePlate
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_8a7027a_1182165461531_196368_421) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	LicensePlate	the value of $licensePlate
	 */
	private function getLicensePlate() {
		return $licensePlate;
	}
	/**
	 * setter for the association attribute $licensePlate
	 * @param	LicensePlate	$licensePlate	the value to set
	 * @see		Car::getLicensePlate()
	 */
	private function setLicensePlate(LicensePlate $licensePlate) {
		self::$licensePlate = $licensePlate;
	}
	/**
	 * getter for the association attribute $engine
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_8a7027a_1182165513891_613516_500) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	Engine	the value of $engine
	 */
	private function getEngine() {
		return $engine;
	}
	/**
	 * setter for the association attribute $engine
	 * @param	Engine	$engine	the value to set
	 * @see		Car::getEngine()
	 */
	private function setEngine(Engine $engine) {
		self::$engine = $engine;
	}
	/**
	 * getter for the association attribute $wheels
	 * 
	 * reference to normal wheels on a car
	 * @return	array	the value of $wheels as an array of type Wheel
	 */
	private function getWheels() {
		return array_values($wheels);
	}
	/**
	 * adds the given value to the association attribute $wheels
	 * @param	Wheel	$toAdd	the value to add
	 * @see		Car::getWheels()
	 */
	private function insertInWheels(Wheel $toAdd) {
		self::$wheels[] = $toAdd;
	}
	/**
	 * removes the given value from the association attribute $wheels
	 * @param	Wheel	$toRemove	the value to remove
	 * @see		Car::getWheels()
	 */
	private function removeFromWheels(Wheel $toRemove) {
		$entry = array_search($toRemove, $wheels);
		if ($entry !== FALSE) {
			unset(self::$wheels[$entry]);
		}
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter for the attribute $maxSpeed
	 * 
	 * describs the maximum speed of a car
	 * @return	int	the value of $maxSpeed
	 */
	private function getMaxSpeed() {
		return $maxSpeed;
	}
	/**
	 * setter for the attribute $maxSpeed
	 * @param	int	$maxSpeed	the value to set
	 * @see		Car::getMaxSpeed()
	 */
	private function setMaxSpeed(int $maxSpeed) {
		self::$maxSpeed = $maxSpeed;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._11_5_6340215_1177945913718_872802_139) ENABLED START */
	// TODO: put your further code implementations for class 'Car' here
	/* PROTECTED REGION END */
}
?>
