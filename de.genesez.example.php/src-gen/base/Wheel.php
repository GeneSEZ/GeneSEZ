<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._11_5_6340215_1177945943625_542159_161) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
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
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._11_5_6340215_1177945943625_542159_161) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base
 */
 class Wheel  implements Changeable {
	
	// -- attributes --------------------------------------------------------
	
	/**
	 * @var		float	$diameter	
	 * @see		Wheel::getDiameter()
	 */
	private $diameter;
	
	/**
	 * @var		string	$specification	
	 * @see		Wheel::getSpecification()
	 */
	private $specification = array();
	
	/**
	 * @var		int	$durability	
	 * @see		Wheel::getDurability()
	 */
	private $durability = 100000;
	
	// -- associations ------------------------------------------------------
	
	/**
	 * @var		Car	$mycar	
	 * @see		Wheel::getMycar()
	 */
	private $mycar;
	
	/**
	 * @var		Screw	$screw	
	 * @see		Wheel::getScrew()
	 */
	private $screw = array();
	
	// -- constructors + destructors ----------------------------------------
	
	// -- method declarations -----------------------------------------------
	
	// -- method implementations --------------------------------------------
	/**
	 * @internal <!-- PROTECTED REGION ID(php.own.operation.comment._11_5_6340215_1179139054625_520706_1) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @param	Changeable	$newWheel	
	 * @return	boolean	
	 */
	public function change(Changeable $newWheel) {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.implementation._11_5_6340215_1179139054625_520706_1) ENABLED START */
		// TODO: implementation of method 'Wheel.change(...)'
		/* PROTECTED REGION END */
		return returnValue;
	}
	/**
	 * @internal <!-- PROTECTED REGION ID(php.own.operation.comment._11_5_6340215_1179238960437_25222_122) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * 
	 * the operation may throw the following exceptions:
	 * {@link FlatTireException FlatTireException}
	 * @see		FlatTireException
	 * 
	 * @return	NULL	
	 */
	public function roll() {
		
		/* PROTECTED REGION ID(php.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		/* PROTECTED REGION END */
		
	}
	
	// -- methods for derived attributes ------------------------------------
	
	// -- association accessors ---------------------------------------------
	
	/**
	 * getter for the association attribute $mycar
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._11_5_6340215_1177945988421_335383_193) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	Car	the value of $mycar
	 */
	private function getMycar() {
		return $mycar;
	}
	
	/**
	 * setter for the association attribute $mycar
	 * @param	Car	$mycar	the value to set
	 * @see		Wheel::getMycar()
	 */
	private function setMycar(Car $mycar) {
		self::$mycar = $mycar;
	}
	
	/**
	 * getter for the association attribute $screw
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.association.comment._11_5_6340215_1178037495031_331770_169) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	array	the value of $screw as an array of type Screw
	 */
	private function getScrew() {
		return array_values($screw);
	}
	
	/**
	 * adds the given value to the association attribute $screw
	 * @param	Screw	$toAdd	the value to add
	 * @see		Wheel::getScrew()
	 */
	private function insertInScrew(Screw $toAdd) {
		self::$screw[] = $toAdd;
	}
	
	/**
	 * removes the given value from the association attribute $screw
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
	 * getter for the attribute $diameter
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._11_5_6340215_1177945958000_326546_182) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	float	the value of $diameter
	 */
	private function getDiameter() {
		return $diameter;
	}
	
	/**
	 * setter for the attribute $diameter
	 * @param	float	$diameter	the value to set
	 * @see		Wheel::getDiameter()
	 */
	private function setDiameter(float $diameter) {
		self::$diameter = $diameter;
	}
	
	/**
	 * getter for the attribute $specification
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._11_5_6340215_1178785354859_924284_117) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	array	the value of $specification as an array of type string
	 */
	private function getSpecification() {
		return array_values($specification);
	}
	
	/**
	 * adds the given value to the attribute $specification
	 * @param	string	$toAdd	the value to add
	 * @see		Wheel::getSpecification()
	 */
	private function insertInSpecification(string $toAdd) {
		self::$specification[] = $toAdd;
	}
	
	/**
	 * removes the given value from the attribute $specification
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
	 * getter for the attribute $durability
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._12_5_b6f02e1_1204100686109_604917_680) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	int	the value of $durability
	 */
	private function getDurability() {
		return $durability;
	}
	
	/**
	 * setter for the attribute $durability
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
