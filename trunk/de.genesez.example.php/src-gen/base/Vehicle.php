<?php
/**

 * @author	dreamer
 * @package	base
 */

require_once '../base/VehicleStatus.php';
require_once '../base/WhatAMessException.php';
require_once '../base/NotReallySeriousException.php';

/* PROTECTED REGION ID(php.own.imports._11_5_6340215_1179139182234_646597_164) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * 

 * 
 * @author	dreamer
 * @package	base
 */
abstract class Vehicle   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Vehicle::getMake()}
	 * @var		string	$make
	 * @see		Vehicle::getMake()
	 */
	private $make;
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Vehicle::getState()}
	 * @var		VehicleStatus	$state
	 * @see		Vehicle::getState()
	 */
	private $state;
	
	
	
	// -- method declarations -----------------------------------------------
	/**
	 * nothing
	 * @generated	method stub for implementation
	 * 
	 * @throws		{@link WhatAMessException}
	 * @throws		{@link NotReallySeriousException}
	 * 
	 * @param	int	$distance	
	 * @return	boolean	
	 */
	public abstract function drive($distance);
	
	// -- method implementations --------------------------------------------
	
	
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter method of the attribute {@link Vehicle::$make}
	 * @generated	accessor to get the value of the attribute {@link Vehicle::$make}
	 * @return	string	the value of {@link Vehicle::$make}		 */
	private function getMake() {
		return $make;
	}
	/**
	 * setter method of the attribute {@link Vehicle::getMake() $make}
	 * @generated	setter method for the attribute {@link Vehicle::getMake() $make}
	 * @param	string	$make	the value to set
	 * @see		Vehicle::getMake()
	 */
	private function setMake(string $make) {
		self::$make = $make;
	}
	/**
	 * getter method of the attribute {@link Vehicle::$state}
	 * @generated	accessor to get the value of the attribute {@link Vehicle::$state}
	 * @return	VehicleStatus	the value of {@link Vehicle::$state}		 */
	private function getState() {
		return $state;
	}
	/**
	 * setter method of the attribute {@link Vehicle::getState() $state}
	 * @generated	setter method for the attribute {@link Vehicle::getState() $state}
	 * @param	VehicleStatus	$state	the value to set
	 * @see		Vehicle::getState()
	 */
	private function setState(VehicleStatus $state) {
		self::$state = $state;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._11_5_6340215_1179139182234_646597_164) ENABLED START */
	// TODO: put your further code implementations for class 'Vehicle' here
	/* PROTECTED REGION END */
}
?>
