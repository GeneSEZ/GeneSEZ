<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
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
 * A blog post comment
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Model_Comment extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * @var DateTime
	 */
	protected $date;
	
	/**
	 * @var string
	 * @validate NotEmpty
	 */
	protected $author;
	
	/**
	 * @var string
	 * @validate EmailAddress
	 */
	protected $email;
	
	/**
	 * @var string
	 * @validate StringLength(maximum = 500)
	 */
	protected $content;
	
	/**
	 * Constructs this comment
	 *
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_9_8a7027a_1297195950535_896855_2808) ENABLED START */
		$this->date = new DateTime();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns this comment as a formatted string
	 *
	 * @return string 
	 */
	public function __toString() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297195977073_836868_2825) ENABLED START */
		return $this->author . ' (' . $this->email . ') said on ' . $this->date->format('Y-m-d') . ':' . chr(10) . $this->content . chr(10);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for date
	 *
	 * @return DateTime 
	 */
	public function getDate() {
		return $this->date;
	}
	
	/**
	 * Setter for date
	 *
	 * @param DateTime $date 
	 * @return void
	 */
	public function setDate(DateTime $date) {
		$this->date = $date;
	}
	
	/**
	 * Getter for author
	 *
	 * @return string 
	 */
	public function getAuthor() {
		return $this->author;
	}
	
	/**
	 * Setter for author
	 *
	 * @param string $author 
	 * @return void
	 */
	public function setAuthor($author) {
		$this->author = $author;
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
	
	/**
	 * Getter for content
	 *
	 * @return string 
	 */
	public function getContent() {
		return $this->content;
	}
	
	/**
	 * Setter for content
	 *
	 * @param string $content 
	 * @return void
	 */
	public function setContent($content) {
		$this->content = $content;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
	/* PROTECTED REGION END */

}

?>
