<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2012 Nico Herbig, TYPO3 core team
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
 * A blog post tag
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Model_Tag extends Tx_Extbase_DomainObject_AbstractValueObject {

	/**
	 * @var string
	 */
	protected $name;
	
	/**
	 * Constructs this tag
	 *
	 * @param string $name 
	 */
	public function __construct($name) {
		/* PROTECTED REGION ID(php.constructor._16_9_8a7027a_1297195903251_537901_2772) ENABLED START */
		$this->name = $name;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns this tag as a formatted string
	 *
	 * @return string 
	 */
	public function __toString() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297195931919_746658_2792) ENABLED START */
		return $this->getName();
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

	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
	/* PROTECTED REGION END */

}

?>
