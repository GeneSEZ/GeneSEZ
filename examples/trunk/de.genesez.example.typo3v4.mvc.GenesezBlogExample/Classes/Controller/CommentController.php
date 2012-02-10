<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297251433473_555088_2718) ENABLED START */
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
 * The comment controller for the BlogExample extension
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Controller_CommentController extends Tx_GszBlogExample_Controller_AbstractController {

	/**
	 * Adds a comment to a blog post and redirects to single view
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The post the comment is related to
	 * @param Tx_GszBlogExample_Domain_Model_Comment $newComment The comment to create
	 * @return void
	 */
	public function createAction(Tx_GszBlogExample_Domain_Model_Post $post, Tx_GszBlogExample_Domain_Model_Comment $newComment) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251980107_45183_2985) ENABLED START */
		$post->addComments($newComment);
		$this->addFlashMessage('created');
		$this->redirect('show', 'Post', NULL, array('post' => $post));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes an existing comment
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The post the comment is related to
	 * @param Tx_GszBlogExample_Domain_Model_Comment $comment The comment to be deleted
	 * @return void
	 */
	public function deleteAction(Tx_GszBlogExample_Domain_Model_Post $post, Tx_GszBlogExample_Domain_Model_Comment $comment) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252002140_334308_2995) ENABLED START */
		$post->removeComment($comment);
		$this->addFlashMessage('deleted', t3lib_FlashMessage::INFO);
		$this->redirect('show', 'Post', NULL, array('post' => $post));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes all comments of the given post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The post the comment is related to
	 * @return void
	 */
	public function deleteAllAction(Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252021351_287202_3009) ENABLED START */
		$post->removeAllComments();
		$this->addFlashMessage('deletedAll', t3lib_FlashMessage::INFO);
		$this->redirect('edit', 'Post', NULL, array('post' => $post, 'blog' => $post->getBlog()));
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297251433473_555088_2718) ENABLED START */
	/* PROTECTED REGION END */

}

?>
