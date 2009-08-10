<?php
/**

 * @author	dreamer
 * @package	base
 */

require_once '../base/Car.php';
require_once '../base/parts/Screw.php';
require_once '../base/FlatTireException.php';
require_once '../base/Changeable.php';

/* PROTECTED REGION ID(php.own.imports._11_5_6340215_1177945943625_542159_161) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**

 * 
 * @see		Changeable
 * @author	dreamer
 * @package	base
 */
class Wheel  implements Changeable {
	
	// -- attributes --------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Wheel::getDiameter()}
	 * @var		float	$diameter
	 * @see		Wheel::getDiameter()
	 */
	private $diameter;
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Wheel::getSpecification()}
	 * @var		string	$specification
	 * @see		Wheel::getSpecification()
	 */
	private $specification = array();
	/**
	 * 
	 * @generated	attribute definition, documented here {@link Wheel::getDurability()}
	 * @var		int	$durability
	 * @see		Wheel::getDurability()
	 */
	private $durability = 100000;
	
	// -- associations ------------------------------------------------------
	/**
	 * 
	 * @generated	attribute definition for association to {@link Car}, documented here {@link Wheel::getMycar()}
	 * @var		Car	$mycar
	 * @see		Wheel::getMycar()
	 */
	private $mycar;
	/**
	 * 
	 * @generated	attribute definition for association to {@link }, documented here {@link Wheel::getScrew()}
	 * @var		Screw	$screw
	 * @see		Wheel::getScrew()
	 */
	private $screw = array();
	
	
	
	// -- method implementations --------------------------------------------
	/**
	
	 * @generated	method stub for implementation
	 * @param	Changeable	$newWheel	
	 * @return	boolean	
	 */
	public function change($newWheel) {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.implementation._11_5_6340215_1179139054625_520706_1) ENABLED START */
		// TODO: implementation of method 'Wheel.change(...)'
		/* PROTECTED REGION END */
		return $returnValue;
	}
	/**
	
	 * @generated	method stub for implementation
	 * 
	 * @throws		{@link FlatTireException}
	 * 
	 * @return	null	
	 */
	public function roll() {
		
		/* PROTECTED REGION ID(php.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		/* PROTECTED REGION END */
		
	}
	
	
	// -- association accessors ---------------------------------------------
	/**
	 * getter method of the association attribute {@link Wheel::$mycar}
	 * @generated	accessor to get the value of the association attribute {@link Wheel::$mycar} from association to {@link Car}
	 * @return	Car	the value of {@link Wheel::$mycar}
	 */
	private function getMycar() {
		return $mycar;
	}
	/**
	 * setter method of the association attribute {@link Wheel::getMycar() $mycar}
	 * @generated	setter method for the association attribute from association to {@link Car}
	 * @param	Car	$mycar	the value to set
	 * @see		Wheel::getMycar()
	 */
	private function setMycar(Car $mycar) {
		self::$mycar = $mycar;
	}
	/**
	 * getter method of the association attribute {@link Wheel::$screw}
	 * @generated	accessor to get the value of the association attribute {@link Wheel::$screw} from association to {@link Screw}
	 * @return	array	the value of {@link Wheel::$screw} as an array of type Screw
	 */
	private function getScrew() {
		return array_values($screw);
	}
	/**
	 * adds the given value to the association attribute {@link Wheel::getScrew() $screw}
	 * @generated	adder method for the multi-valued association attribute from association to {@link Screw}
	 * @param	Screw	$toAdd	the value to add
	 * @see		Wheel::getScrew()
	 */
	private function insertInScrew(Screw $toAdd) {
		self::$screw[] = $toAdd;
	}
	/**
	 * removes the given value from the association attribute {@link Wheel::getScrew() $screw}
	 * @generated	method to remove values from the multi-valued association attribute from association to {@link Screw}
	 * @param	Screw	$toRemove	the value to remove
	 * @see		Wheel::getScrew()
	 */
	private function removeFromScrew(Screw $toRemove) {
		$entry = array_search($toRemove, $screw);
		if ($entry !== FALSE) {
			unset(self::$screw[$entry]);
		}
	}
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter method of the attribute {@link Wheel::$diameter}
	 * @generated	accessor to get the value of the attribute {@link Wheel::$diameter}
	 * @return	float	the value of {@link Wheel::$diameter}		 */
	private function getDiameter() {
		return $diameter;
	}
	/**
	 * setter method of the attribute {@link Wheel::getDiameter() $diameter}
	 * @generated	setter method for the attribute {@link Wheel::getDiameter() $diameter}
	 * @param	float	$diameter	the value to set
	 * @see		Wheel::getDiameter()
	 */
	private function setDiameter(float $diameter) {
		self::$diameter = $diameter;
	}
	/**
	 * getter method of the attribute {@link Wheel::$specification}
	 * @generated	accessor to get the value of the attribute {@link Wheel::$specification}
	 * @return	array	the value of {@link Wheel::$specification} as an array of type {@link string}
	 */
	private function getSpecification() {
		return array_values($specification);
	}
	/**
	 * adds the given value to the attribute {@link Wheel::getSpecification() $specification}
	 * @generated	adder method for the multi-valued attribute {@link Wheel::getSpecification() $specification}
	 * @param	string	$toAdd	the value to add
	 * @see		Wheel::getSpecification()
	 */
	private function insertInSpecification(string $toAdd) {
		self::$specification[] = $toAdd;
	}
	/**
	 * removes the given value from the attribute {@link Wheel::getSpecification() $specification}
	 * @generated	method to remove values from the multi-valued attribute {@link Wheel::getSpecification() $specification}
	 * @param	string	$toRemove	the value to remove
	 * @see		Wheel::getSpecification()
	 */
	private function removeFromSpecification(string $toRemove) {
		$entry = array_search($toRemove, $specification);
		if ($entry !== FALSE) {
			unset(self::$specification[$entry]);
		}
	}
	/**
	 * getter method of the attribute {@link Wheel::$durability}
	 * @generated	accessor to get the value of the attribute {@link Wheel::$durability}
	 * @return	int	the value of {@link Wheel::$durability}		 */
	private function getDurability() {
		return $durability;
	}
	/**
	 * setter method of the attribute {@link Wheel::getDurability() $durability}
	 * @generated	setter method for the attribute {@link Wheel::getDurability() $durability}
	 * @param	int	$durability	the value to set
	 * @see		Wheel::getDurability()
	 */
	private function setDurability(int $durability) {
		self::$durability = $durability;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */
	// TODO: put your further code implementations for class 'Wheel' here
	/* PROTECTED REGION END */
}
?>
