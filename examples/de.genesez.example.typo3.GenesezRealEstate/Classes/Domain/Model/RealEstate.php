<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2011 nicher
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
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GenesezRealEstate_Domain_Model_RealEstate extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * 
	 * @var string
	 */
	protected $id;
	/**
	 * 
	 * @var string
	 */
	protected $title;
	/**
	 * 
	 * @var string
	 */
	protected $description;
	/**
	 * 
	 * @var string
	 */
	protected $facility;
	/**
	 * 
	 * @var string
	 */
	protected $state;
	/**
	 * 
	 * @var string
	 */
	protected $miscellaneous;
	/**
	 * 
	 * @var string
	 */
	protected $street;
	/**
	 * 
	 * @var string
	 */
	protected $postCode;
	/**
	 * 
	 * @var string
	 */
	protected $town;
	/**
	 * 
	 * @var float
	 */
	protected $size;
	/**
	 * 
	 * @var boolean
	 */
	protected $cellar;
	/**
	 * 
	 * @var boolean
	 */
	protected $attic;
	/**
	 * 
	 * @var boolean
	 */
	protected $balcony;
	/**
	 * 
	 * @var string
	 */
	protected $freeFrom;
	/**
	 * 
	 * @var float
	 */
	protected $rentExclusiveOfHeating;
	/**
	 * 
	 * @var float
	 */
	protected $extraCharges;
	/**
	 * 
	 * @var float
	 */
	protected $cooperativeShare;
	/**
	 * 
	 * @var string
	 */
	protected $imageFiles;
	/**
	 * 
	 * @var string
	 */
	protected $imageDescriptions;
	/**
	 * 
	 * @var string
	 */
	protected $plotFile;
	/**
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Model_HeatingType
	 */
	protected $heating;
	/**
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Model_RoomType
	 */
	protected $rooms;
	/**
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Model_FloorType
	 */
	protected $floor;
	/**
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Model_Quarter
	 */
	protected $quarter;


	

	
	/**
	 * Getter for id
	 *
	 * @return string 
	 */
	public function getId() {
		return $this->id;
	}
	/**
	 * Setter for id
	 *
	 * @param string $id 
	 * @return void
	 */
	public function setId($id) {
		$this->id = $id;
	}
	/**
	 * Getter for title
	 *
	 * @return string 
	 */
	public function getTitle() {
		return $this->title;
	}
	/**
	 * Setter for title
	 *
	 * @param string $title 
	 * @return void
	 */
	public function setTitle($title) {
		$this->title = $title;
	}
	/**
	 * Getter for description
	 *
	 * @return string 
	 */
	public function getDescription() {
		return $this->description;
	}
	/**
	 * Setter for description
	 *
	 * @param string $description 
	 * @return void
	 */
	public function setDescription($description) {
		$this->description = $description;
	}
	/**
	 * Getter for facility
	 *
	 * @return string 
	 */
	public function getFacility() {
		return $this->facility;
	}
	/**
	 * Setter for facility
	 *
	 * @param string $facility 
	 * @return void
	 */
	public function setFacility($facility) {
		$this->facility = $facility;
	}
	/**
	 * Getter for state
	 *
	 * @return string 
	 */
	public function getState() {
		return $this->state;
	}
	/**
	 * Setter for state
	 *
	 * @param string $state 
	 * @return void
	 */
	public function setState($state) {
		$this->state = $state;
	}
	/**
	 * Getter for miscellaneous
	 *
	 * @return string 
	 */
	public function getMiscellaneous() {
		return $this->miscellaneous;
	}
	/**
	 * Setter for miscellaneous
	 *
	 * @param string $miscellaneous 
	 * @return void
	 */
	public function setMiscellaneous($miscellaneous) {
		$this->miscellaneous = $miscellaneous;
	}
	/**
	 * Getter for street
	 *
	 * @return string 
	 */
	public function getStreet() {
		return $this->street;
	}
	/**
	 * Setter for street
	 *
	 * @param string $street 
	 * @return void
	 */
	public function setStreet($street) {
		$this->street = $street;
	}
	/**
	 * Getter for postCode
	 *
	 * @return string 
	 */
	public function getPostCode() {
		return $this->postCode;
	}
	/**
	 * Setter for postCode
	 *
	 * @param string $postCode 
	 * @return void
	 */
	public function setPostCode($postCode) {
		$this->postCode = $postCode;
	}
	/**
	 * Getter for town
	 *
	 * @return string 
	 */
	public function getTown() {
		return $this->town;
	}
	/**
	 * Setter for town
	 *
	 * @param string $town 
	 * @return void
	 */
	public function setTown($town) {
		$this->town = $town;
	}
	/**
	 * Getter for size
	 *
	 * @return float 
	 */
	public function getSize() {
		return $this->size;
	}
	/**
	 * Setter for size
	 *
	 * @param float $size 
	 * @return void
	 */
	public function setSize($size) {
		$this->size = $size;
	}
	/**
	 * Getter for cellar
	 *
	 * @return boolean 
	 */
	public function getCellar() {
		return $this->cellar;
	}
	/**
	 * Setter for cellar
	 *
	 * @param boolean $cellar 
	 * @return void
	 */
	public function setCellar($cellar) {
		$this->cellar = $cellar;
	}
	/**
	 * Getter for attic
	 *
	 * @return boolean 
	 */
	public function getAttic() {
		return $this->attic;
	}
	/**
	 * Setter for attic
	 *
	 * @param boolean $attic 
	 * @return void
	 */
	public function setAttic($attic) {
		$this->attic = $attic;
	}
	/**
	 * Getter for balcony
	 *
	 * @return boolean 
	 */
	public function getBalcony() {
		return $this->balcony;
	}
	/**
	 * Setter for balcony
	 *
	 * @param boolean $balcony 
	 * @return void
	 */
	public function setBalcony($balcony) {
		$this->balcony = $balcony;
	}
	/**
	 * Getter for freeFrom
	 *
	 * @return string 
	 */
	public function getFreeFrom() {
		return $this->freeFrom;
	}
	/**
	 * Setter for freeFrom
	 *
	 * @param string $freeFrom 
	 * @return void
	 */
	public function setFreeFrom($freeFrom) {
		$this->freeFrom = $freeFrom;
	}
	/**
	 * Getter for rentExclusiveOfHeating
	 *
	 * @return float 
	 */
	public function getRentExclusiveOfHeating() {
		return $this->rentExclusiveOfHeating;
	}
	/**
	 * Setter for rentExclusiveOfHeating
	 *
	 * @param float $rentExclusiveOfHeating 
	 * @return void
	 */
	public function setRentExclusiveOfHeating($rentExclusiveOfHeating) {
		$this->rentExclusiveOfHeating = $rentExclusiveOfHeating;
	}
	/**
	 * Getter for extraCharges
	 *
	 * @return float 
	 */
	public function getExtraCharges() {
		return $this->extraCharges;
	}
	/**
	 * Setter for extraCharges
	 *
	 * @param float $extraCharges 
	 * @return void
	 */
	public function setExtraCharges($extraCharges) {
		$this->extraCharges = $extraCharges;
	}
	/**
	 * Getter for cooperativeShare
	 *
	 * @return float 
	 */
	public function getCooperativeShare() {
		return $this->cooperativeShare;
	}
	/**
	 * Setter for cooperativeShare
	 *
	 * @param float $cooperativeShare 
	 * @return void
	 */
	public function setCooperativeShare($cooperativeShare) {
		$this->cooperativeShare = $cooperativeShare;
	}
	/**
	 * Getter for imageFiles
	 *
	 * @return string 
	 */
	public function getImageFiles() {
		return $this->imageFiles;
	}
	/**
	 * Setter for imageFiles
	 *
	 * @param string $imageFiles 
	 * @return void
	 */
	public function setImageFiles($imageFiles) {
		$this->imageFiles = $imageFiles;
	}
	/**
	 * Getter for imageDescriptions
	 *
	 * @return string 
	 */
	public function getImageDescriptions() {
		return $this->imageDescriptions;
	}
	/**
	 * Setter for imageDescriptions
	 *
	 * @param string $imageDescriptions 
	 * @return void
	 */
	public function setImageDescriptions($imageDescriptions) {
		$this->imageDescriptions = $imageDescriptions;
	}
	/**
	 * Getter for plotFile
	 *
	 * @return string 
	 */
	public function getPlotFile() {
		return $this->plotFile;
	}
	/**
	 * Setter for plotFile
	 *
	 * @param string $plotFile 
	 * @return void
	 */
	public function setPlotFile($plotFile) {
		$this->plotFile = $plotFile;
	}
	/**
	 * Getter for heating
	 *
	 * @return Tx_GenesezRealEstate_Domain_Model_HeatingType 
	 */
	public function getHeating() {
		return $this->heating;
	}
	/**
	 * Setter for heating
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_HeatingType $heating 
	 * @return void
	 */
	public function setHeating(Tx_GenesezRealEstate_Domain_Model_HeatingType $heating) {
		$this->heating = $heating;
	}
	/**
	 * Getter for rooms
	 *
	 * @return Tx_GenesezRealEstate_Domain_Model_RoomType 
	 */
	public function getRooms() {
		return $this->rooms;
	}
	/**
	 * Setter for rooms
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RoomType $rooms 
	 * @return void
	 */
	public function setRooms(Tx_GenesezRealEstate_Domain_Model_RoomType $rooms) {
		$this->rooms = $rooms;
	}
	/**
	 * Getter for floor
	 *
	 * @return Tx_GenesezRealEstate_Domain_Model_FloorType 
	 */
	public function getFloor() {
		return $this->floor;
	}
	/**
	 * Setter for floor
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_FloorType $floor 
	 * @return void
	 */
	public function setFloor(Tx_GenesezRealEstate_Domain_Model_FloorType $floor) {
		$this->floor = $floor;
	}
	/**
	 * Getter for quarter
	 *
	 * @return Tx_GenesezRealEstate_Domain_Model_Quarter 
	 */
	public function getQuarter() {
		return $this->quarter;
	}
	/**
	 * Setter for quarter
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_Quarter $quarter 
	 * @return void
	 */
	public function setQuarter(Tx_GenesezRealEstate_Domain_Model_Quarter $quarter) {
		$this->quarter = $quarter;
	}

	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
	/* PROTECTED REGION END */

}
?>
