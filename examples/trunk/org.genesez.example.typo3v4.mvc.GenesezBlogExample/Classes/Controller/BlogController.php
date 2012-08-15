<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297251427732_349974_2692) ENABLED START */
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
 * The blog controller for the BlogExample extension
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Controller_BlogController extends Tx_GszBlogExample_Controller_AbstractController {

	/**
	 * @var Tx_GszBlogExample_Domain_Repository_BlogRepository
	 * @inject
	 */
	protected $blogRepository;
	
	/**
	 * @var Tx_GszBlogExample_Domain_Repository_AdministratorRepository
	 * @inject
	 */
	protected $administratorRepository;
	
	/**
	 * Index action for this controller. Displays a list of blogs.
	 *
	 * @return void
	 */
	public function indexAction() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252176013_209023_3136) ENABLED START */
		$this->view->assign('blogs', $this->blogRepository->findAll());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays a form for creating a new blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $newBlog A fresh blog object taken as a basis for the rendering
	 * @return void
	 * @dontvalidate $newBlog
	 */
	public function newAction(Tx_GszBlogExample_Domain_Model_Blog $newBlog = null) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252181185_462277_3144) ENABLED START */
		$this->view->assign('newBlog', $newBlog);
		$this->view->assign('administrators', $this->administratorRepository->findAll());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a new blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $newBlog A fresh Blog object which has not yet been added to the repository
	 * @return void
	 */
	public function createAction(Tx_GszBlogExample_Domain_Model_Blog $newBlog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252206393_658245_3158) ENABLED START */
		$this->blogRepository->add($newBlog);
		$this->addFlashMessage('created');
		$this->redirect('index');
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays a form for editing an existing blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog to be edited. This might also be a clone of the original blog already containing modifications if the edit form has been submitted, contained errors and therefore ended up in this action again.
	 * @return void
	 * @dontvalidate $blog
	 */
	public function editAction(Tx_GszBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252235402_679130_3171) ENABLED START */
		$this->view->assign('blog', $blog);
		$this->view->assign('administrators', $this->administratorRepository->findAll());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Updates an existing blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog A not yet persisted clone of the original blog containing the modifications
	 * @return void
	 */
	public function updateAction(Tx_GszBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252258980_463056_3185) ENABLED START */
		$this->blogRepository->update($blog);
		$this->addFlashMessage('updated');
		$this->redirect('index');
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes an existing blog
	 *
	 * @param Tx_GszBlogExample_Domain_Model_Blog $blog The blog to delete
	 * @return void
	 */
	public function deleteAction(Tx_GszBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252273193_659963_3203) ENABLED START */
		$this->blogRepository->remove($blog);
		$this->addFlashMessage('deleted', t3lib_FlashMessage::INFO);
		$this->redirect('index');
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes all existing blogs
	 *
	 * @return void
	 */
	public function deleteAllAction() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252284431_137062_3216) ENABLED START */
		$this->blogRepository->removeAll();
		$this->redirect('index');
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a several new blogs
	 *
	 * @return void
	 */
	public function populateAction() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252298300_76853_3229) ENABLED START */
		$numberOfExistingBlogs = $this->blogRepository->countAll();
		$blogFactory = $this->objectManager->get('Tx_GszBlogExample_Domain_Service_BlogFactory');
		for ($blogNumber = $numberOfExistingBlogs + 1; $blogNumber < ($numberOfExistingBlogs + 5); $blogNumber++) {
			$blog = $blogFactory->createBlog($blogNumber);
			$this->blogRepository->add($blog);
		}
		$this->addFlashMessage('populated');
		$this->redirect('index');
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for blogRepository
	 *
	 * @return Tx_GszBlogExample_Domain_Repository_BlogRepository 
	 */
	public function getBlogRepository() {
		return $this->blogRepository;
	}
	
	/**
	 * Getter for administratorRepository
	 *
	 * @return Tx_GszBlogExample_Domain_Repository_AdministratorRepository 
	 */
	public function getAdministratorRepository() {
		return $this->administratorRepository;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297251427732_349974_2692) ENABLED START */
	/* PROTECTED REGION END */

}

?>
