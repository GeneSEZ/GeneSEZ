<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
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
 * A blog post
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Model_Post extends Tx_Extbase_DomainObject_AbstractEntity {

	/**
	 * @var string
	 * @validate StringLength(minimum = 3, maximum = 50)
	 */
	protected $title;
	
	/**
	 * @var DateTime
	 */
	protected $date;
	
	/**
	 * @var string
	 * @validate StringLength(minimum = 3)
	 */
	protected $content;
	
	/**
	 * @var Tx_GszBlogExample_Domain_Model_Blog
	 */
	protected $blog;
	
	/**
	 * @var Tx_GszBlogExample_Domain_Model_Person
	 */
	protected $author;
	
	/**
	 * @var Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Tag>
	 */
	protected $tags;
	
	/**
	 * @var Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Comment>
	 * @cascade remove
	 * @lazy
	 */
	protected $comments;
	
	/**
	 * @var Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post>
	 * @lazy
	 */
	protected $relatedPosts;
	
	/**
	 * Constructs this post
	 *
	 */
	public function __construct() {
		/* PROTECTED REGION ID(php.constructor._16_9_8a7027a_1297195698522_381397_2648) ENABLED START */
		$this->tags = new Tx_Extbase_Persistence_ObjectStorage();
		$this->comments = new Tx_Extbase_Persistence_ObjectStorage();
		$this->relatedPosts = new Tx_Extbase_Persistence_ObjectStorage();
		$this->date = new DateTime();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns this post as a formatted string
	 *
	 * @return string 
	 */
	public function __toString() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297195845978_528794_2747) ENABLED START */
		return $this->title . chr(10) .
			' written on ' . $this->date->format('Y-m-d') . chr(10) .
			' by ' . $this->author->getFullName() . chr(10) .
			wordwrap($this->content, 70, chr(10)) . chr(10) .
			implode(', ', $this->tags->toArray());
		/* PROTECTED REGION END */
	}
	
	/**
	 * @return void
	 */
	public function removeAllTags() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314213504516_360568_2445) ENABLED START */
		$this->tags = new Tx_Extbase_Persistence_ObjectStorage();
		/* PROTECTED REGION END */
	}
	
	/**
	 * @return void
	 */
	public function removeAllComments() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314213547677_788291_2458) ENABLED START */
		$comments = clone $this->comments;
		foreach($comments as $comment) {
			$this->comments->detach($comment);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * @return void
	 */
	public function removeAllRelatedPosts() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314213620686_588633_2471) ENABLED START */
		$relatedPosts = clone $this->relatedPosts;
		foreach($relatedPosts as $relatedPost) {
			$this->relatedPosts->detach($relatedPost);
		}
		/* PROTECTED REGION END */
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

	/**
	 * Getter for blog
	 *
	 * @return Tx_GszBlogExample_Domain_Model_Blog 
	 */
	public function getBlog() {
		return $this->blog;
	}
	
	/**
	 * Setter for blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog 
	 * @return void
	 */
	public function setBlog(Tx_GszBlogExample_Domain_Model_Blog $blog) {
		$this->blog = $blog;
	}
	
	/**
	 * Getter for author
	 *
	 * @return Tx_GszBlogExample_Domain_Model_Person 
	 */
	public function getAuthor() {
		return $this->author;
	}
	
	/**
	 * Setter for author
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Person $author 
	 * @return void
	 */
	public function setAuthor(Tx_GszBlogExample_Domain_Model_Person $author) {
		$this->author = $author;
	}
	
	/**
	 * Getter for tags
	 *
	 * @return Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Tag> 
	 */
	public function getTags() {
		return $this->tags;
	}
	
	/**
	 * Setter for tags
	 *
	 * @param Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Tag> $tags 
	 * @return void
	 */
	public function setTags(Tx_Extbase_Persistence_ObjectStorage $tags) {
		$this->tags = $tags;
	}
	
	/**
	 * InsertIn for tags
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Tag $toAdd 
	 * @return void
	 */
	public function addTags(Tx_GszBlogExample_Domain_Model_Tag $toAdd) {
		$this->tags->attach($toAdd);
	}
	
	/**
	 * RemoveFrom for tags
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Tag $toRemove 
	 * @return void
	 */
	public function removeTags(Tx_GszBlogExample_Domain_Model_Tag $toRemove) {
		$this->tags->detach($toRemove);
	}
	
	/**
	 * Getter for comments
	 *
	 * @return Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Comment> 
	 */
	public function getComments() {
		return $this->comments;
	}
	
	/**
	 * Setter for comments
	 *
	 * @param Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Comment> $comments 
	 * @return void
	 */
	public function setComments(Tx_Extbase_Persistence_ObjectStorage $comments) {
		$this->comments = $comments;
	}
	
	/**
	 * InsertIn for comments
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Comment $toAdd 
	 * @return void
	 */
	public function addComments(Tx_GszBlogExample_Domain_Model_Comment $toAdd) {
		$this->comments->attach($toAdd);
	}
	
	/**
	 * RemoveFrom for comments
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Comment $toRemove 
	 * @return void
	 */
	public function removeComments(Tx_GszBlogExample_Domain_Model_Comment $toRemove) {
		$this->comments->detach($toRemove);
	}
	
	/**
	 * Getter for relatedPosts
	 *
	 * @return Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post> 
	 */
	public function getRelatedPosts() {
		return $this->relatedPosts;
	}
	
	/**
	 * Setter for relatedPosts
	 *
	 * @param Tx_Extbase_Persistence_ObjectStorage<Tx_GszBlogExample_Domain_Model_Post> $relatedPosts 
	 * @return void
	 */
	public function setRelatedPosts(Tx_Extbase_Persistence_ObjectStorage $relatedPosts) {
		$this->relatedPosts = $relatedPosts;
	}
	
	/**
	 * InsertIn for relatedPosts
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $toAdd 
	 * @return void
	 */
	public function addRelatedPosts(Tx_GszBlogExample_Domain_Model_Post $toAdd) {
		$this->relatedPosts->attach($toAdd);
	}
	
	/**
	 * RemoveFrom for relatedPosts
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $toRemove 
	 * @return void
	 */
	public function removeRelatedPosts(Tx_GszBlogExample_Domain_Model_Post $toRemove) {
		$this->relatedPosts->detach($toRemove);
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
	/* PROTECTED REGION END */

}

?>
