<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2012 Nico Herbig
 *  All rights reserved
 *
 *  This script is part of the TYPO3 project. The TYPO3 project is
 *  free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  The GNU General Public License can be found at
 *  http://www.gnu.org/copyleft/gpl.html.
 *
 *  This script is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  This copyright notice MUST APPEAR in all copies of the script!
 **************************************************************/

/**
 * A class for searching stuff.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszRealEstate_Domain_Model_Demand extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * Stores the maximal rent eclusive of heating for the real estate.
	 *
	 * @var string
	 * @validate Tx_GszRealEstate_Domain_Validator_NumberNotEmptyValidator
	 */
	protected $maxRentExclusiveOfHeating;
	
	/**
	 * Stores the minimal size of the real estate.
	 *
	 * @var string
	 * @validate Tx_GszRealEstate_Domain_Validator_NumberNotEmptyValidator
	 */
	protected $minSize;
	
	/**
	 * Stores the town of the real estate.
	 *
	 * @var string
	 * @validate Text
	 */
	protected $town;
	
	/**
	 * Stores if a balcony is needed for the real estate.
	 *
	 * @var string
	 */
	protected $balcony;
	
	/**
	 * Stores the quarter of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_Quarter
	 */
	protected $quarter = null;
	
	/**
	 * Stores the minimal count of rooms for the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_RoomType
	 */
	protected $minRooms = null;
	
	/**
	 * Stores the floor of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_FloorType
	 */
	protected $floor = null;
	
	/**
	 * Getter for maxRentExclusiveOfHeating
	 *
	 * @return string Stores the maximal rent eclusive of heating for the real estate.
	 */
	public function getMaxRentExclusiveOfHeating() {
		return $this->maxRentExclusiveOfHeating;
	}
	
	/**
	 * Setter for maxRentExclusiveOfHeating
	 *
	 * @param string $maxRentExclusiveOfHeating Stores the maximal rent eclusive of heating for the real estate.
	 * @return void
	 */
	public function setMaxRentExclusiveOfHeating($maxRentExclusiveOfHeating) {
		$this->maxRentExclusiveOfHeating = $maxRentExclusiveOfHeating;
	}
	
	/**
	 * Getter for minSize
	 *
	 * @return string Stores the minimal size of the real estate.
	 */
	public function getMinSize() {
		return $this->minSize;
	}
	
	/**
	 * Setter for minSize
	 *
	 * @param string $minSize Stores the minimal size of the real estate.
	 * @return void
	 */
	public function setMinSize($minSize) {
		$this->minSize = $minSize;
	}
	
	/**
	 * Getter for town
	 *
	 * @return string Stores the town of the real estate.
	 */
	public function getTown() {
		return $this->town;
	}
	
	/**
	 * Setter for town
	 *
	 * @param string $town Stores the town of the real estate.
	 * @return void
	 */
	public function setTown($town) {
		$this->town = $town;
	}
	
	/**
	 * Getter for balcony
	 *
	 * @return string Stores if a balcony is needed for the real estate.
	 */
	public function getBalcony() {
		return $this->balcony;
	}
	
	/**
	 * Setter for balcony
	 *
	 * @param string $balcony Stores if a balcony is needed for the real estate.
	 * @return void
	 */
	public function setBalcony($balcony) {
		$this->balcony = $balcony;
	}
	
	/**
	 * Getter for quarter
	 *
	 * @return Tx_GszRealEstate_Domain_Model_Quarter Stores the quarter of the real estate.
	 */
	public function getQuarter() {
		return $this->quarter;
	}
	
	/**
	 * Setter for quarter
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Quarter $quarter Stores the quarter of the real estate.
	 * @return void
	 */
	public function setQuarter(Tx_GszRealEstate_Domain_Model_Quarter $quarter) {
		$this->quarter = $quarter;
	}
	
	/**
	 * Getter for minRooms
	 *
	 * @return Tx_GszRealEstate_Domain_Model_RoomType Stores the minimal count of rooms for the real estate.
	 */
	public function getMinRooms() {
		return $this->minRooms;
	}
	
	/**
	 * Setter for minRooms
	 *
	 * @param Tx_GszRealEstate_Domain_Model_RoomType $minRooms Stores the minimal count of rooms for the real estate.
	 * @return void
	 */
	public function setMinRooms(Tx_GszRealEstate_Domain_Model_RoomType $minRooms) {
		$this->minRooms = $minRooms;
	}
	
	/**
	 * Getter for floor
	 *
	 * @return Tx_GszRealEstate_Domain_Model_FloorType Stores the floor of the real estate.
	 */
	public function getFloor() {
		return $this->floor;
	}
	
	/**
	 * Setter for floor
	 *
	 * @param Tx_GszRealEstate_Domain_Model_FloorType $floor Stores the floor of the real estate.
	 * @return void
	 */
	public function setFloor(Tx_GszRealEstate_Domain_Model_FloorType $floor) {
		$this->floor = $floor;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
	/* PROTECTED REGION END */

}

?>
