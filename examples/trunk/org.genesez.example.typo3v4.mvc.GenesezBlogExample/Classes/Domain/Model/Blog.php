<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
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
 * A blog
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Model_Blog extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * The blog's title.
	 *
	 * @var string
	 * @validate StringLength(minimum = 1, maximum = 80)
	 */
	protected $title = '';
	
	/**
	 * A short description of the blog
	 *
	 * @var string
	 * @validate StringLength(maximum = 150)
	 */
	protected $description = '';
	
	/**
	 * A relative path to a logo image
	 *
	 * @var string
	 */
	protected $logo;
	
	/**
	 * The posts of this blog
	 *
	 * @var Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post>
	 * @cascade remove
	 * @lazy
	 */
	protected $posts;
	
	/**
	 * The blog's administrator
	 *
	 * @var Tx_GszBlogExample_Domain_Model_Administrator
	 * @lazy
	 */
	protected $administrator;
	
	/**
	 * Constructs a new Blog
	 *
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_9_8a7027a_1297195581704_789426_2608) ENABLED START */
		$this->posts = new Tx_Extbase_Persistence_ObjectStorage();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Remove all posts from this blog
	 *
	 * @return void
	 */
	public function removeAllPosts() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314212429824_842410_2427) ENABLED START */
		$this->posts = new Tx_Extbase_Persistence_ObjectStorage();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for title
	 *
	 * @return string The blog's title.
	 */
	public function getTitle() {
		return $this->title;
	}
	
	/**
	 * Setter for title
	 *
	 * @param string $title The blog's title.
	 * @return void
	 */
	public function setTitle($title) {
		$this->title = $title;
	}

	/**
	 * Getter for description
	 *
	 * @return string A short description of the blog
	 */
	public function getDescription() {
		return $this->description;
	}
	
	/**
	 * Setter for description
	 *
	 * @param string $description A short description of the blog
	 * @return void
	 */
	public function setDescription($description) {
		$this->description = $description;
	}

	/**
	 * Getter for logo
	 *
	 * @return string A relative path to a logo image
	 */
	public function getLogo() {
		return $this->logo;
	}
	
	/**
	 * Setter for logo
	 *
	 * @param string $logo A relative path to a logo image
	 * @return void
	 */
	public function setLogo($logo) {
		$this->logo = $logo;
	}

	/**
	 * Getter for posts
	 *
	 * @return Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post> The posts of this blog
	 */
	public function getPosts() {
		return $this->posts;
	}
	
	/**
	 * Setter for posts
	 *
	 * @param Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post> $posts The posts of this blog
	 * @return void
	 */
	public function setPosts(Tx_Extbase_Persistence_ObjectStorage $posts) {
		$this->posts = $posts;
	}
	
	/**
	 * InsertIn for posts
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $toAdd The posts of this blog
	 * @return void
	 */
	public function addPosts(Tx_GszBlogExample_Domain_Model_Post $toAdd) {
		$this->posts->attach($toAdd);
	}
	
	/**
	 * RemoveFrom for posts
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $toRemove The posts of this blog
	 * @return void
	 */
	public function removePosts(Tx_GszBlogExample_Domain_Model_Post $toRemove) {
		$this->posts->detach($toRemove);
	}
	
	/**
	 * Getter for administrator
	 *
	 * @return Tx_GszBlogExample_Domain_Model_Administrator The blog's administrator
	 */
	public function getAdministrator() {
		return $this->administrator;
	}
	
	/**
	 * Setter for administrator
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Administrator $administrator The blog's administrator
	 * @return void
	 */
	public function setAdministrator(Tx_GszBlogExample_Domain_Model_Administrator $administrator) {
		$this->administrator = $administrator;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
	/* PROTECTED REGION END */

}

?>
