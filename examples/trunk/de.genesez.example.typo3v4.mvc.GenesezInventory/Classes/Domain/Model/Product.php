<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2012 Nico Herbig, Jochen Rau
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
class Tx_GszInventory_Domain_Model_Product extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * @var string
	 */
	protected $name = '';
	
	/**
	 * @var string
	 */
	protected $description = '';
	
	/**
	 * @var int
	 */
	protected $quantity = 0;
	
	/**
	 * @param string $name 
	 * @param string $description 
	 * @param int $quantity 
	 */
	public function __construct($name = '', $description = '', $quantity = 0) {
		/* PROTECTED REGION ID(php.constructor._17_0_2_8a7027a_1314363787787_15072_2350) ENABLED START */
		$this->setName($name);
		$this->setDescription($description);
		$this->setQuantity($quantity);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for name
	 *
	 * @return string 
	 */
	public function getName() {
		return $this->name;
	}
	
	/**
	 * Setter for name
	 *
	 * @param string $name 
	 * @return void
	 */
	public function setName($name) {
		$this->name = $name;
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
	 * Getter for quantity
	 *
	 * @return int 
	 */
	public function getQuantity() {
		return $this->quantity;
	}
	
	/**
	 * Setter for quantity
	 *
	 * @param int $quantity 
	 * @return void
	 */
	public function setQuantity($quantity) {
		$this->quantity = $quantity;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
	/* PROTECTED REGION END */

}

?>
