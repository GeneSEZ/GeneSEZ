<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
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
 * A class which represents a real real estate.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszRealEstate_Domain_Model_RealEstate extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * The internal id of the real estate.
	 *
	 * @var string
	 */
	protected $id;
	
	/**
	 * The title of the real estate.
	 *
	 * @var string
	 */
	protected $title;
	
	/**
	 * The description of the real estate.
	 *
	 * @var string
	 */
	protected $description;
	
	/**
	 * The facilities of the real estate.
	 *
	 * @var string
	 */
	protected $facility;
	
	/**
	 * The state of the real estate.
	 *
	 * @var string
	 */
	protected $state;
	
	/**
	 * The miscellaneous stuff for the real estate.
	 *
	 * @var string
	 */
	protected $miscellaneous;
	
	/**
	 * The street of the real estate.
	 *
	 * @var string
	 */
	protected $street;
	
	/**
	 * The post code of the real estate.
	 *
	 * @var string
	 */
	protected $postCode;
	
	/**
	 * The town of the real estate.
	 *
	 * @var string
	 */
	protected $town;
	
	/**
	 * The size in qm of the real estate.
	 *
	 * @var float
	 */
	protected $size;
	
	/**
	 * Sets if the real estate has a cellar.
	 *
	 * @var boolean
	 */
	protected $cellar;
	
	/**
	 * Sets if the real estate has a attic.
	 *
	 * @var boolean
	 */
	protected $attic;
	
	/**
	 * Sets if the real estate has a balcony.
	 *
	 * @var boolean
	 */
	protected $balcony;
	
	/**
	 * Sets when the real estate is free.
	 *
	 * @var string
	 */
	protected $freeFrom;
	
	/**
	 * The rent exclusive of heating for the real estate.
	 *
	 * @var float
	 */
	protected $rentExclusiveOfHeating;
	
	/**
	 * The extra charges for the real estate.
	 *
	 * @var float
	 */
	protected $extraCharges;
	
	/**
	 * The cooperative share for the real estate.
	 *
	 * @var float
	 */
	protected $cooperativeShare;
	
	/**
	 * The image files of the real estate.
	 *
	 * @var string
	 */
	protected $imageFiles;
	
	/**
	 * The image descriptions of the real estate.
	 *
	 * @var string
	 */
	protected $imageDescriptions;
	
	/**
	 * The plot file of the real estate.
	 *
	 * @var string
	 */
	protected $plotFile;
	
	/**
	 * Association for the heating type of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_HeatingType
	 */
	protected $heating;
	
	/**
	 * Association for the floor type of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_FloorType
	 */
	protected $floor;
	
	/**
	 * Association for the room type of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_RoomType
	 */
	protected $rooms;
	
	/**
	 * Association for the quarter of the real estate.
	 *
	 * @var Tx_GszRealEstate_Domain_Model_Quarter
	 */
	protected $quarter;
	
	/**
	 * Checks if the real estate has image files.
	 *
	 * @return boolean Return true if the real estate has images otherwise false.
	 */
	public function hasImgs() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315409366581_636072_1991) ENABLED START */
		return strlen($this->imageFiles) > 0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the real estate has image file descriptions.
	 *
	 * @return boolean Return true if the real estate has image file descriptions otherwise false.
	 */
	public function hasImgDescs() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315419450861_188134_2555) ENABLED START */
		return strlen($this->imageDescriptions) > 0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Get the real estate image files as array.
	 *
	 * @return array An array of real estate image files or an empty array.
	 */
	public function getImgs() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315409382233_871005_1997) ENABLED START */
		$images = array();
		
		if ($this->hasImgs()) {
			// split images by ',' delemiter to get an array of files
			$images = explode(',', $this->imageFiles);
		}
		return $images;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Get the real estate image file descriptions as array.
	 *
	 * @return array An array of real estate image file descriptions or an empty array.
	 */
	public function getImgDescs() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315409478099_835507_2019) ENABLED START */
		$descriptions = array();
		
		if ($this->hasImgDescs()) {
			// split images descriptions by the new line delemiter to get an array of descriptions
			$descriptions = explode(chr(10), $this->imageDescriptions);
		}
		return $descriptions;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for id
	 *
	 * @return string The internal id of the real estate.
	 */
	public function getId() {
		return $this->id;
	}
	
	/**
	 * Setter for id
	 *
	 * @param string $id The internal id of the real estate.
	 * @return void
	 */
	public function setId($id) {
		$this->id = $id;
	}

	/**
	 * Getter for title
	 *
	 * @return string The title of the real estate.
	 */
	public function getTitle() {
		return $this->title;
	}
	
	/**
	 * Setter for title
	 *
	 * @param string $title The title of the real estate.
	 * @return void
	 */
	public function setTitle($title) {
		$this->title = $title;
	}

	/**
	 * Getter for description
	 *
	 * @return string The description of the real estate.
	 */
	public function getDescription() {
		return $this->description;
	}
	
	/**
	 * Setter for description
	 *
	 * @param string $description The description of the real estate.
	 * @return void
	 */
	public function setDescription($description) {
		$this->description = $description;
	}

	/**
	 * Getter for facility
	 *
	 * @return string The facilities of the real estate.
	 */
	public function getFacility() {
		return $this->facility;
	}
	
	/**
	 * Setter for facility
	 *
	 * @param string $facility The facilities of the real estate.
	 * @return void
	 */
	public function setFacility($facility) {
		$this->facility = $facility;
	}

	/**
	 * Getter for state
	 *
	 * @return string The state of the real estate.
	 */
	public function getState() {
		return $this->state;
	}
	
	/**
	 * Setter for state
	 *
	 * @param string $state The state of the real estate.
	 * @return void
	 */
	public function setState($state) {
		$this->state = $state;
	}

	/**
	 * Getter for miscellaneous
	 *
	 * @return string The miscellaneous stuff for the real estate.
	 */
	public function getMiscellaneous() {
		return $this->miscellaneous;
	}
	
	/**
	 * Setter for miscellaneous
	 *
	 * @param string $miscellaneous The miscellaneous stuff for the real estate.
	 * @return void
	 */
	public function setMiscellaneous($miscellaneous) {
		$this->miscellaneous = $miscellaneous;
	}

	/**
	 * Getter for street
	 *
	 * @return string The street of the real estate.
	 */
	public function getStreet() {
		return $this->street;
	}
	
	/**
	 * Setter for street
	 *
	 * @param string $street The street of the real estate.
	 * @return void
	 */
	public function setStreet($street) {
		$this->street = $street;
	}

	/**
	 * Getter for postCode
	 *
	 * @return string The post code of the real estate.
	 */
	public function getPostCode() {
		return $this->postCode;
	}
	
	/**
	 * Setter for postCode
	 *
	 * @param string $postCode The post code of the real estate.
	 * @return void
	 */
	public function setPostCode($postCode) {
		$this->postCode = $postCode;
	}

	/**
	 * Getter for town
	 *
	 * @return string The town of the real estate.
	 */
	public function getTown() {
		return $this->town;
	}
	
	/**
	 * Setter for town
	 *
	 * @param string $town The town of the real estate.
	 * @return void
	 */
	public function setTown($town) {
		$this->town = $town;
	}

	/**
	 * Getter for size
	 *
	 * @return float The size in qm of the real estate.
	 */
	public function getSize() {
		return $this->size;
	}
	
	/**
	 * Setter for size
	 *
	 * @param float $size The size in qm of the real estate.
	 * @return void
	 */
	public function setSize($size) {
		$this->size = $size;
	}

	/**
	 * Getter for cellar
	 *
	 * @return boolean Sets if the real estate has a cellar.
	 */
	public function getCellar() {
		return $this->cellar;
	}
	
	/**
	 * Setter for cellar
	 *
	 * @param boolean $cellar Sets if the real estate has a cellar.
	 * @return void
	 */
	public function setCellar($cellar) {
		$this->cellar = $cellar;
	}

	/**
	 * Getter for attic
	 *
	 * @return boolean Sets if the real estate has a attic.
	 */
	public function getAttic() {
		return $this->attic;
	}
	
	/**
	 * Setter for attic
	 *
	 * @param boolean $attic Sets if the real estate has a attic.
	 * @return void
	 */
	public function setAttic($attic) {
		$this->attic = $attic;
	}

	/**
	 * Getter for balcony
	 *
	 * @return boolean Sets if the real estate has a balcony.
	 */
	public function getBalcony() {
		return $this->balcony;
	}
	
	/**
	 * Setter for balcony
	 *
	 * @param boolean $balcony Sets if the real estate has a balcony.
	 * @return void
	 */
	public function setBalcony($balcony) {
		$this->balcony = $balcony;
	}

	/**
	 * Getter for freeFrom
	 *
	 * @return string Sets when the real estate is free.
	 */
	public function getFreeFrom() {
		return $this->freeFrom;
	}
	
	/**
	 * Setter for freeFrom
	 *
	 * @param string $freeFrom Sets when the real estate is free.
	 * @return void
	 */
	public function setFreeFrom($freeFrom) {
		$this->freeFrom = $freeFrom;
	}

	/**
	 * Getter for rentExclusiveOfHeating
	 *
	 * @return float The rent exclusive of heating for the real estate.
	 */
	public function getRentExclusiveOfHeating() {
		return $this->rentExclusiveOfHeating;
	}
	
	/**
	 * Setter for rentExclusiveOfHeating
	 *
	 * @param float $rentExclusiveOfHeating The rent exclusive of heating for the real estate.
	 * @return void
	 */
	public function setRentExclusiveOfHeating($rentExclusiveOfHeating) {
		$this->rentExclusiveOfHeating = $rentExclusiveOfHeating;
	}

	/**
	 * Getter for extraCharges
	 *
	 * @return float The extra charges for the real estate.
	 */
	public function getExtraCharges() {
		return $this->extraCharges;
	}
	
	/**
	 * Setter for extraCharges
	 *
	 * @param float $extraCharges The extra charges for the real estate.
	 * @return void
	 */
	public function setExtraCharges($extraCharges) {
		$this->extraCharges = $extraCharges;
	}

	/**
	 * Getter for cooperativeShare
	 *
	 * @return float The cooperative share for the real estate.
	 */
	public function getCooperativeShare() {
		return $this->cooperativeShare;
	}
	
	/**
	 * Setter for cooperativeShare
	 *
	 * @param float $cooperativeShare The cooperative share for the real estate.
	 * @return void
	 */
	public function setCooperativeShare($cooperativeShare) {
		$this->cooperativeShare = $cooperativeShare;
	}

	/**
	 * Getter for imageFiles
	 *
	 * @return string The image files of the real estate.
	 */
	public function getImageFiles() {
		return $this->imageFiles;
	}
	
	/**
	 * Setter for imageFiles
	 *
	 * @param string $imageFiles The image files of the real estate.
	 * @return void
	 */
	public function setImageFiles($imageFiles) {
		$this->imageFiles = $imageFiles;
	}

	/**
	 * Getter for imageDescriptions
	 *
	 * @return string The image descriptions of the real estate.
	 */
	public function getImageDescriptions() {
		return $this->imageDescriptions;
	}
	
	/**
	 * Setter for imageDescriptions
	 *
	 * @param string $imageDescriptions The image descriptions of the real estate.
	 * @return void
	 */
	public function setImageDescriptions($imageDescriptions) {
		$this->imageDescriptions = $imageDescriptions;
	}

	/**
	 * Getter for plotFile
	 *
	 * @return string The plot file of the real estate.
	 */
	public function getPlotFile() {
		return $this->plotFile;
	}
	
	/**
	 * Setter for plotFile
	 *
	 * @param string $plotFile The plot file of the real estate.
	 * @return void
	 */
	public function setPlotFile($plotFile) {
		$this->plotFile = $plotFile;
	}

	/**
	 * Getter for heating
	 *
	 * @return Tx_GszRealEstate_Domain_Model_HeatingType Association for the heating type of the real estate.
	 */
	public function getHeating() {
		return $this->heating;
	}
	
	/**
	 * Setter for heating
	 *
	 * @param Tx_GszRealEstate_Domain_Model_HeatingType $heating Association for the heating type of the real estate.
	 * @return void
	 */
	public function setHeating(Tx_GszRealEstate_Domain_Model_HeatingType $heating) {
		$this->heating = $heating;
	}

	/**
	 * Getter for floor
	 *
	 * @return Tx_GszRealEstate_Domain_Model_FloorType Association for the floor type of the real estate.
	 */
	public function getFloor() {
		return $this->floor;
	}
	
	/**
	 * Setter for floor
	 *
	 * @param Tx_GszRealEstate_Domain_Model_FloorType $floor Association for the floor type of the real estate.
	 * @return void
	 */
	public function setFloor(Tx_GszRealEstate_Domain_Model_FloorType $floor) {
		$this->floor = $floor;
	}

	/**
	 * Getter for rooms
	 *
	 * @return Tx_GszRealEstate_Domain_Model_RoomType Association for the room type of the real estate.
	 */
	public function getRooms() {
		return $this->rooms;
	}
	
	/**
	 * Setter for rooms
	 *
	 * @param Tx_GszRealEstate_Domain_Model_RoomType $rooms Association for the room type of the real estate.
	 * @return void
	 */
	public function setRooms(Tx_GszRealEstate_Domain_Model_RoomType $rooms) {
		$this->rooms = $rooms;
	}

	/**
	 * Getter for quarter
	 *
	 * @return Tx_GszRealEstate_Domain_Model_Quarter Association for the quarter of the real estate.
	 */
	public function getQuarter() {
		return $this->quarter;
	}
	
	/**
	 * Setter for quarter
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Quarter $quarter Association for the quarter of the real estate.
	 * @return void
	 */
	public function setQuarter(Tx_GszRealEstate_Domain_Model_Quarter $quarter) {
		$this->quarter = $quarter;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
	/* PROTECTED REGION END */

}

?>
