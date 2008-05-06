<?php
/**

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

 * 
 * @see		Vehicle
 * @author	dreamer
 * @package	base
 */
class Car extends Vehicle  {
	
	// -- attributes --------------------------------------------------------
	/**
	 * describs the maximum speed of a car
	 * @generated	attribute definition, documented here {@link Car::getMaxSpeed()}
	 * @var		int	$maxSpeed
	 * @see		Car::getMaxSpeed()
	 */
	private $maxSpeed;
	
	// -- associations ------------------------------------------------------
	/**
	 * reference to the spared wheel
	 * @generated	attribute definition for association to {@link }, documented here {@link Car::getSpare()}
	 * @var		Wheel	$spare
	 * @see		Car::getSpare()
	 */
	private $spare;
	/**
	 * 
	 * @generated	attribute definition for association to {@link License}, documented here {@link Car::getLicense()}
	 * @var		License	$license
	 * @see		Car::getLicense()
	 */
	private $license;
	/**
	 * 
	 * @generated	attribute definition for association to {@link LicensePlate}, documented here {@link Car::getLicensePlate()}
	 * @var		LicensePlate	$licensePlate
	 * @see		Car::getLicensePlate()
	 */
	private $licensePlate;
	/**
	 * 
	 * @generated	attribute definition for association to {@link Engine}, documented here {@link Car::getEngine()}
	 * @var		Engine	$engine
	 * @see		Car::getEngine()
	 */
	private $engine;
	/**
	 * reference to normal wheels on a car
	 * @generated	attribute definition for association to {@link Wheel}, documented here {@link Car::getWheels()}
	 * @var		Wheel	$wheels
	 * @see		Car::getWheels()
	 */
	private $wheels = array();
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructor of the class car
	 * @generated	constructor for class {@link Car}
	 * 
	 * @throws		{@link NotReallySeriousException}
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
	
	 * @generated	method stub for implementation
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
	 * count the number of wheels
	 * @generated	accessor to get the value of the derived attribute $noOfWheels
	 * @return	int	the value of $noOfWheels		 */
	private function getNoOfWheels() {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.derived.attribute.implementation._11_5_6340215_1178786244296_257674_121) ENABLED START */
		// TODO: implementation of method 'Car.getNoOfWheels(...)'
		/* PROTECTED REGION END */
		return returnValue;
	}
	
	// -- association accessors ---------------------------------------------
	/**
	 * reference to the spared wheel
	 * @generated	accessor to get the value of the association attribute {@link Car::$spare} from association to {@link Wheel}
	 * @return	Wheel	the value of {@link Car::$spare}
	 */
	private function getSpare() {
		return $spare;
	}
	/**
	 * setter method of the association attribute {@link Car::getSpare() $spare}
	 * @generated	setter method for the association attribute from association to {@link Wheel}
	 * @param	Wheel	$spare	the value to set
	 * @see		Car::getSpare()
	 */
	private function setSpare(Wheel $spare) {
		self::$spare = $spare;
	}
	/**
	 * getter method of the association attribute {@link Car::$license}
	 * @generated	accessor to get the value of the association attribute {@link Car::$license} from association to {@link License}
	 * @return	License	the value of {@link Car::$license}
	 */
	private function getLicense() {
		return $license;
	}
	/**
	 * setter method of the association attribute {@link Car::getLicense() $license}
	 * @generated	setter method for the association attribute from association to {@link License}
	 * @param	License	$license	the value to set
	 * @see		Car::getLicense()
	 */
	private function setLicense(License $license) {
		self::$license = $license;
	}
	/**
	 * getter method of the association attribute {@link Car::$licensePlate}
	 * @generated	accessor to get the value of the association attribute {@link Car::$licensePlate} from association to {@link LicensePlate}
	 * @return	LicensePlate	the value of {@link Car::$licensePlate}
	 */
	private function getLicensePlate() {
		return $licensePlate;
	}
	/**
	 * setter method of the association attribute {@link Car::getLicensePlate() $licensePlate}
	 * @generated	setter method for the association attribute from association to {@link LicensePlate}
	 * @param	LicensePlate	$licensePlate	the value to set
	 * @see		Car::getLicensePlate()
	 */
	private function setLicensePlate(LicensePlate $licensePlate) {
		self::$licensePlate = $licensePlate;
	}
	/**
	 * getter method of the association attribute {@link Car::$engine}
	 * @generated	accessor to get the value of the association attribute {@link Car::$engine} from association to {@link Engine}
	 * @return	Engine	the value of {@link Car::$engine}
	 */
	private function getEngine() {
		return $engine;
	}
	/**
	 * setter method of the association attribute {@link Car::getEngine() $engine}
	 * @generated	setter method for the association attribute from association to {@link Engine}
	 * @param	Engine	$engine	the value to set
	 * @see		Car::getEngine()
	 */
	private function setEngine(Engine $engine) {
		self::$engine = $engine;
	}
	/**
	 * reference to normal wheels on a car
	 * @generated	accessor to get the value of the association attribute {@link Car::$wheels} from association to {@link Wheel}
	 * @return	array	the value of {@link Car::$wheels} as an array of type Wheel
	 */
	private function getWheels() {
		return array_values($wheels);
	}
	/**
	 * adds the given value to the association attribute {@link Car::getWheels() $wheels}
	 * @generated	adder method for the multi-valued association attribute from association to {@link Wheel}
	 * @param	Wheel	$toAdd	the value to add
	 * @see		Car::getWheels()
	 */
	private function insertInWheels(Wheel $toAdd) {
		self::$wheels[] = $toAdd;
	}
	/**
	 * removes the given value from the association attribute {@link Car::getWheels() $wheels}
	 * @generated	method to remove values from the multi-valued association attribute from association to {@link Wheel}
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
	 * describs the maximum speed of a car
	 * @generated	accessor to get the value of the attribute {@link Car::$maxSpeed}
	 * @return	int	the value of {@link Car::$maxSpeed}		 */
	private function getMaxSpeed() {
		return $maxSpeed;
	}
	/**
	 * setter method of the attribute {@link Car::getMaxSpeed() $maxSpeed}
	 * @generated	setter method for the attribute {@link Car::getMaxSpeed() $maxSpeed}
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
