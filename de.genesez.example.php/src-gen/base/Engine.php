<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._12_5_8a7027a_1182165491328_680838_471) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._12_5_8a7027a_1182165491328_680838_471) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
class Engine   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * @var		byte	$ps	
	 * @see		Engine::getPs()
	 */
	private $ps;
	/**
	 * @var		string	$name	
	 * @see		Engine::getName()
	 */
	private $name;
	
	// -- associations ------------------------------------------------------
	/**
	 * @var		Car	$car	
	 * @see		Engine::getCar()
	 */
	private $car;
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class Engine
	 * @param	byte	$ps	
	 * @param	string	$name	
	 */
	public function __construct($ps, $name) {
		/* PROTECTED REGION ID(php.constructor._12_5_8a7027a_1182275619895_618915_478) ENABLED START */
		// TODO: implementation of method 'Engine.engine(...)'
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	
	
	// -- association accessors ---------------------------------------------
	/**
	 * getter for the association attribute $car
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._12_5_8a7027a_1182165513891_692901_501) ENABLED START -->
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
	 * @see		Engine::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter for the attribute $ps
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_8a7027a_1182165634143_800264_551) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	byte	the value of $ps
	 */
	private function getPs() {
		return $ps;
	}
	/**
	 * setter for the attribute $ps
	 * @param	byte	$ps	the value to set
	 * @see		Engine::getPs()
	 */
	private function setPs(byte $ps) {
		self::$ps = $ps;
	}
	/**
	 * getter for the attribute $name
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_8a7027a_1182275655836_342436_482) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	string	the value of $name
	 */
	private function getName() {
		return $name;
	}
	/**
	 * setter for the attribute $name
	 * @param	string	$name	the value to set
	 * @see		Engine::getName()
	 */
	private function setName(string $name) {
		self::$name = $name;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
	// TODO: put your further code implementations for class 'Engine' here
	/* PROTECTED REGION END */
}
?>
