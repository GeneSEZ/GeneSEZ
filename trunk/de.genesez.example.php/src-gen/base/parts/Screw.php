<?php
/**
 * @internal <!-- PROTECTED REGION ID(php.own.file.comment._11_5_6340215_1178034133828_951385_16) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base.parts
 */


/* PROTECTED REGION ID(php.own.imports._11_5_6340215_1178034133828_951385_16) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @internal <!-- PROTECTED REGION ID(php.own.type.comment._11_5_6340215_1178034133828_951385_16) ENABLED START -->
 * @internal <!-- TODO: put your own comments here -->
 * @internal <!-- PROTECTED REGION END -->
 * @author	dreamer
 * @package	base.parts
 */
class Screw   {
	
	// -- attributes --------------------------------------------------------
	/**
	 * @var		float	$length	describes the length of a screw
	 * @see		Screw::getLength()
	 */
	private $length;
	/**
	 * @var		float	$diameter	
	 * @see		Screw::getDiameter()
	 */
	private $diameter;
	/**
	 * @var		boolean	$metric	
	 * @see		Screw::getMetric()
	 */
	private $metric;
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @internal <!-- PROTECTED REGION ID(php.own.operation.comment._12_5_8a7027a_1183038841674_975104_475) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @param	int	$count	
	 * @return	NULL	
	 */
	public function screwOn($count) {
		
		/* PROTECTED REGION ID(php.implementation._12_5_8a7027a_1183038841674_975104_475) ENABLED START */
		// TODO: implementation of method 'Screw.screwOn(...)'
		/* PROTECTED REGION END */
		
	}
	
	
	
	// -- attribute accessors -----------------------------------------------
	/**
	 * getter for the attribute $length
	 * 
	 * describes the length of a screw
	 * @return	float	the value of $length
	 */
	private function getLength() {
		return $length;
	}
	/**
	 * setter for the attribute $length
	 * @param	float	$length	the value to set
	 * @see		Screw::getLength()
	 */
	private function setLength(float $length) {
		self::$length = $length;
	}
	/**
	 * getter for the attribute $diameter
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._11_5_6340215_1178034174218_253052_39) ENABLED START -->
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
	 * @see		Screw::getDiameter()
	 */
	private function setDiameter(float $diameter) {
		self::$diameter = $diameter;
	}
	/**
	 * getter for the attribute $metric
	 * 
	 * @internal <!-- PROTECTED REGION ID(php.own.attribute.comment._11_5_6340215_1178034186171_435038_41) ENABLED START -->
	 * @internal <!-- TODO: put your own comments here -->
	 * @internal <!-- PROTECTED REGION END -->
	 * @return	boolean	the value of $metric
	 */
	private function getMetric() {
		return $metric;
	}
	/**
	 * setter for the attribute $metric
	 * @param	boolean	$metric	the value to set
	 * @see		Screw::getMetric()
	 */
	private function setMetric(boolean $metric) {
		self::$metric = $metric;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._11_5_6340215_1178034133828_951385_16) ENABLED START */
	// TODO: put your further code implementations for class 'Screw' here
	/* PROTECTED REGION END */
}
?>
