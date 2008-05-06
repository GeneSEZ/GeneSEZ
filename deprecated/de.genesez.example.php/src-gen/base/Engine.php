<?php
/**

 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';

/* PROTECTED REGION ID(php.own.imports._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**

 * 
 * @author	dreamer
 * @package	base
 */
class Engine   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Engine::getPs()}
	 * @var		byte	$ps
	 * @see		Engine::getPs()
	 */
	private $ps;
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Engine::getName()}
	 * @var		string	$name
	 * @see		Engine::getName()
	 */
	private $name;
	
	// -- associations ------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition for association to {@link Car}, documented here {@link Engine::getCar()}
	 * @var		Car	$car
	 * @see		Engine::getCar()
	 */
	private $car;
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class {@link Engine}
	 * @generated	constructor for class {@link Engine}
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
	 * getter method of the association attribute {@link Engine::$car}
	 * @generated	accessor to get the value of the association attribute {@link Engine::$car} from association to {@link Car}
	 * @return	Car	the value of {@link Engine::$car}
	 */
	private function getCar() {
		return $car;
	}
	/**
	 * setter method of the association attribute {@link Engine::getCar() $car}
	 * @generated	setter method for the association attribute from association to {@link Car}
	 * @param	Car	$car	the value to set
	 * @see		Engine::getCar()
	 */
	private function setCar(Car $car) {
		self::$car = $car;
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter method of the attribute {@link Engine::$ps}
	 * @generated	accessor to get the value of the attribute {@link Engine::$ps}
	 * @return	byte	the value of {@link Engine::$ps}		 */
	private function getPs() {
		return $ps;
	}
	/**
	 * setter method of the attribute {@link Engine::getPs() $ps}
	 * @generated	setter method for the attribute {@link Engine::getPs() $ps}
	 * @param	byte	$ps	the value to set
	 * @see		Engine::getPs()
	 */
	private function setPs(byte $ps) {
		self::$ps = $ps;
	}
	/**
	 * getter method of the attribute {@link Engine::$name}
	 * @generated	accessor to get the value of the attribute {@link Engine::$name}
	 * @return	string	the value of {@link Engine::$name}		 */
	private function getName() {
		return $name;
	}
	/**
	 * setter method of the attribute {@link Engine::getName() $name}
	 * @generated	setter method for the attribute {@link Engine::getName() $name}
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
