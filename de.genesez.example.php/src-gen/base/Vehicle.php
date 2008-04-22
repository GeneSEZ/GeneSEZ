<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._11_5_6340215_1179139182234_646597_164) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
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
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._11_5_6340215_1179139182234_646597_164) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
abstract class Vehicle   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * @var		string	$make	
	 * @see		Vehicle::getMake()
	 */
	private $make;
	/**
	 * @var		VehicleStatus	$state	
	 * @see		Vehicle::getState()
	 */
	private $state;
	
	
	
	// -- method declarations -----------------------------------------------
	/**
	 * nothing
	 * 
	 * the operation may throw the following exceptions:
	 * {@link WhatAMessException WhatAMessException}, {@link NotReallySeriousException NotReallySeriousException}
	 * @throws		WhatAMessException
	 * @throws		NotReallySeriousException
	 * 
	 * @param	int	$distance	
	 * @return	boolean	
	 */
	public abstract function drive($distance);
	
	// -- method implementations --------------------------------------------
	
	
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter for the attribute $make
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._11_5_6340215_1177946075218_295795_245) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	string	the value of $make
	 */
	private function getMake() {
		return $make;
	}
	/**
	 * setter for the attribute $make
	 * @param	string	$make	the value to set
	 * @see		Vehicle::getMake()
	 */
	private function setMake(string $make) {
		self::$make = $make;
	}
	/**
	 * getter for the attribute $state
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_8a7027a_1181722336392_384956_511) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	VehicleStatus	the value of $state
	 */
	private function getState() {
		return $state;
	}
	/**
	 * setter for the attribute $state
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
