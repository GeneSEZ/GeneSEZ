<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1306344206865_332239_2422) ENABLED START */
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
 * A class which represents a real heating type.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszRealEstate_Domain_Model_HeatingType extends Tx_Extbase_DomainObject_AbstractValueObject {

	/**
	 * The specification of the heating type.
	 *
	 * @var string
	 */
	protected $specification;
	
	/**
	 * Getter for specification
	 *
	 * @return string The specification of the heating type.
	 */
	public function getSpecification() {
		return $this->specification;
	}
	
	/**
	 * Setter for specification
	 *
	 * @param string $specification The specification of the heating type.
	 * @return void
	 */
	public function setSpecification($specification) {
		$this->specification = $specification;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1306344206865_332239_2422) ENABLED START */
	/* PROTECTED REGION END */

}

?>
