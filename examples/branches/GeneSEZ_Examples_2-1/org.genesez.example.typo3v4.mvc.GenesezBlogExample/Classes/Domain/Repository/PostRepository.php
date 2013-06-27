<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297250863949_852308_2394) ENABLED START */
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
 * A repository for blog posts
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Repository_PostRepository extends Tx_Extbase_Persistence_Repository {

	/**
	 * Finds all posts by the specified blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post must refer to
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszBlogExample_Domain_Model_Post> The posts
	 */
	public function findAllByBlog(Tx_GszBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297250908862_209782_2440) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->equals('blog', $blog)
			)
			->execute();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Finds posts by the specified tag and blog
	 *
	 * @param string $tag 
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post must refer to
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszBlogExample_Domain_Model_Post> The posts
	 */
	public function findByTagAndBlog($tag, Tx_GszBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297250952847_309532_2458) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->logicalAnd(
					$query->equals('blog', $blog),
					$query->equals('tags.name', $tag)
				)
			)
			->execute();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Finds all remaining posts of the blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The reference post
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszBlogExample_Domain_Model_Post> The posts
	 */
	public function findByRemaining(Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251045982_475934_2503) ENABLED START */
		$blog = $post->getBlog();
		$query = $this->createQuery();
		return $query
			->matching(
				$query->logicalAnd(
					$query->equals('blog', $blog),
					$query->logicalNot(
						$query->equals('uid', $post->getUid())
					)
				)
			)
			->execute();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Finds the previous of the given post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The reference post
	 * @return Tx_GszBlogExample_Domain_Model_Post 
	 */
	public function findPrevious(Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251131408_430169_2532) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->lessThan('date', $post->getDate())
			)
			->execute()
			->getFirst();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Finds the post next to the given post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The reference post
	 * @return Tx_GszBlogExample_Domain_Model_Post 
	 */
	public function findNext(Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251164032_279760_2551) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->greaterThan('date', $post->getDate())
			)
			->execute()
			->getFirst();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Finds most recent posts by the specified blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post must refer to
	 * @param integer $limit The number of posts to return at max
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszBlogExample_Domain_Model_Post> The posts
	 */
	public function findRecentByBlog(Tx_GszBlogExample_Domain_Model_Blog $blog, $limit = 5) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251180788_324969_2565) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->equals('blog', $blog)
			)
			->setLimit((integer)$limit)
			->execute();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297250863949_852308_2394) ENABLED START */
	protected $defaultOrderings = array(
		'date' => Tx_Extbase_Persistence_QueryInterface::ORDER_DESCENDING
	);
	/* PROTECTED REGION END */

}

?>
