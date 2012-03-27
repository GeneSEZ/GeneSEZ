<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
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
 * A person - acting as author
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Model_Person extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * @var string
	 */
	protected $firstname;
	
	/**
	 * @var string
	 */
	protected $lastname;
	
	/**
	 * @var string
	 * @validate EmailAddress
	 */
	protected $email;
	
	/**
	 * Constructs a new Person
	 *
	 * @param string $firstname 
	 * @param string $lastname 
	 * @param string $email 
	 */
	public function __construct($firstname, $lastname, $email) {
		/* PROTECTED REGION ID(php.constructor._16_9_8a7027a_1297195987831_804563_2831) ENABLED START */
		$this->setFirstname($firstname);
		$this->setLastname($lastname);
		$this->setEmail($email);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for fullName
	 *
	 * @return string Returns the person's full name
	 */
	public function getFullName() {
		/* PROTECTED REGION ID(php.derived.attribute.implementation._17_0_1_8a7027a_1303834035630_196217_2127) ENABLED START */
		return $this->firstname . ' ' . $this->lastname;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for firstname
	 *
	 * @return string 
	 */
	public function getFirstname() {
		return $this->firstname;
	}
	
	/**
	 * Setter for firstname
	 *
	 * @param string $firstname 
	 * @return void
	 */
	public function setFirstname($firstname) {
		$this->firstname = $firstname;
	}
	
	/**
	 * Getter for lastname
	 *
	 * @return string 
	 */
	public function getLastname() {
		return $this->lastname;
	}
	
	/**
	 * Setter for lastname
	 *
	 * @param string $lastname 
	 * @return void
	 */
	public function setLastname($lastname) {
		$this->lastname = $lastname;
	}
	
	/**
	 * Getter for email
	 *
	 * @return string 
	 */
	public function getEmail() {
		return $this->email;
	}
	
	/**
	 * Setter for email
	 *
	 * @param string $email 
	 * @return void
	 */
	public function setEmail($email) {
		$this->email = $email;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
	/* PROTECTED REGION END */

}

?>
