<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297251441697_732082_2744) ENABLED START */
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
 * The post controller for the BlogExample extension
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Controller_PostController extends Tx_GszBlogExample_Controller_AbstractController {

	/**
	 * @var Tx_GszBlogExample_Domain_Repository_PostRepository
	 */
	protected $postRepository;
	
	/**
	 * @var Tx_GszBlogExample_Domain_Repository_PersonRepository
	 */
	protected $personRepository;
	
	/**
	 * Displays a list of posts. If $tag is set only posts matching this tag are shown
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog to show the posts of
	 * @param string $tag The name of the tag to show the posts for
	 * @return void
	 */
	public function indexAction(Tx_GszBlogExample_Domain_Model_Blog $blog, $tag = null) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251570422_202575_2822) ENABLED START */
		if (empty($tag)) {
			$posts = $this->postRepository->findByBlog($blog);
		} else {
			$tag = urldecode($tag);
			$posts = $this->postRepository->findByTagAndBlog($tag, $blog);
			$this->view->assign('tag', $tag);
		}
		$this->view->assign('blog', $blog);
		$this->view->assign('posts', $posts);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays one single post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The post to display
	 * @param Tx_GszBlogExample_Domain_Model_Comment $newComment A new comment
	 * @return void
	 * @dontvalidate $newComment
	 */
	public function showAction(Tx_GszBlogExample_Domain_Model_Post $post, Tx_GszBlogExample_Domain_Model_Comment $newComment = null) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251652061_144721_2838) ENABLED START */
		$this->view->assign('post', $post);
		$this->view->assign('newComment', $newComment);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays a form for creating a new post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post belogs to
	 * @param Tx_GszBlogExample_Domain_Model_Post $newPost A fresh post object taken as a basis for the rendering
	 * @return void
	 * @dontvalidate $newPost
	 */
	public function newAction(Tx_GszBlogExample_Domain_Model_Blog $blog, Tx_GszBlogExample_Domain_Model_Post $newPost = null) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251722638_898873_2867) ENABLED START */
		$this->view->assign('authors', $this->personRepository->findAll());
		$this->view->assign('blog', $blog);
		$this->view->assign('newPost', $newPost);
		$this->view->assign('remainingPosts', $this->postRepository->findByBlog($blog));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a new post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post belogns to
	 * @param Tx_GszBlogExample_Domain_Model_Post $newPost A fresh Blog object which has not yet been added to the repository
	 * @return void
	 */
	public function createAction(Tx_GszBlogExample_Domain_Model_Blog $blog, Tx_GszBlogExample_Domain_Model_Post $newPost) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251748387_416366_2881) ENABLED START */
		$blog->addPost($newPost);
		$newPost->setBlog($blog);
		$this->addFlashMessage('created');
		$this->redirect('index', NULL, NULL, array('blog' => $blog));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays a form to edit an existing post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post belogs to
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The original post
	 * @return void
	 * @dontvalidate $post
	 */
	public function editAction(Tx_GszBlogExample_Domain_Model_Blog $blog, Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251769032_48598_2895) ENABLED START */
		$this->view->assign('authors', $this->personRepository->findAll());
		$this->view->assign('blog', $blog);
		$this->view->assign('post', $post);
		$this->view->assign('remainingPosts', $this->postRepository->findRemaining($post));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Updates an existing post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post belongs to
	 * @param Tx_GszBlogExample_Domain_Model_Post $post A clone of the original post with the updated values already applied
	 * @return void
	 */
	public function updateAction(Tx_GszBlogExample_Domain_Model_Blog $blog, Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251791676_169143_2909) ENABLED START */
		$this->postRepository->update($post);
		$this->addFlashMessage('updated');
		$this->redirect('show', NULL, NULL, array('post' => $post, 'blog' => $blog));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes an existing post
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog the post belongs to
	 * @param Tx_GszBlogExample_Domain_Model_Post $post The post to be deleted
	 * @return void
	 */
	public function deleteAction(Tx_GszBlogExample_Domain_Model_Blog $blog, Tx_GszBlogExample_Domain_Model_Post $post) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297251812164_716082_2923) ENABLED START */
		$this->postRepository->remove($post);
		$this->addFlashMessage('deleted', t3lib_FlashMessage::INFO);
		$this->redirect('index', NULL, NULL, array('blog' => $blog));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for postRepository
	 *
	 * @return Tx_GszBlogExample_Domain_Repository_PostRepository 
	 */
	public function getPostRepository() {
		return $this->postRepository;
	}
	
	/**
	 * Dependency injection for postRepository
	 *
	 * @param Tx_GszBlogExample_Domain_Repository_PostRepository $postRepository 
	 * @return void
	 */
	public function injectPostRepository(Tx_GszBlogExample_Domain_Repository_PostRepository $postRepository) {
		$this->postRepository = $postRepository;
	}
	
	/**
	 * Getter for personRepository
	 *
	 * @return Tx_GszBlogExample_Domain_Repository_PersonRepository 
	 */
	public function getPersonRepository() {
		return $this->personRepository;
	}
	
	/**
	 * Dependency injection for personRepository
	 *
	 * @param Tx_GszBlogExample_Domain_Repository_PersonRepository $personRepository 
	 * @return void
	 */
	public function injectPersonRepository(Tx_GszBlogExample_Domain_Repository_PersonRepository $personRepository) {
		$this->personRepository = $personRepository;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297251441697_732082_2744) ENABLED START */
	/* PROTECTED REGION END */

}

?>
