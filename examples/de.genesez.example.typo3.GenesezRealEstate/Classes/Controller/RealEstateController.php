<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1306344238376_116675_2466.controller) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2011 nicher
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
 * Controller for a domain object.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GenesezRealEstate_Controller_RealEstateController extends Tx_Extbase_MVC_Controller_ActionController {
	
	/**
	 * Repository for a domain objects
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository
	 */
	protected $realEstateRepository;


	
	/**
	 * Displays a list of domain objects
	 *
	 * @return string The rendered view for this action.
	 */
	protected function listAction() {
		$list = $this->realEstateRepository->findAll();
		$this->view->assign('list', $list);
	}
	/**
	 * Displays one single domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate 
	 * @return string The rendered view for this action.
	 */
	protected function showAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate) {
		$this->view->assign('realEstate', $realEstate);
	}
	/**
	 * Displays a form for creating a new domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $newRealEstate A fresh domain object to display.
	 * @return string The rendered view for this action.
	 */
	protected function newAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $newRealEstate = NULL) {
		$this->view->assign('newRealEstate', $newRealEstate);
	}
	/**
	 * Creates a new domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $newRealEstate The new domain object to create.
	 * @return string The rendered view for this action.
	 */
	protected function createAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $newRealEstate) {
		$this->realEstateRepository->add($newRealEstate);
		$this->flashMessageContainer->add('Your new domain object was created.');
		$this->redirect('list');
	}
	/**
	 * Displays a form for editing an existing domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate The existing domain object to display.
	 * @return string The rendered view for this action.
	 */
	protected function editAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate) {
		$this->view->assign('realEstate', $realEstate);
	}
	/**
	 * Updates an existing domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate The existing domain object to update
	 * @return string The rendered view for this action.
	 */
	protected function updateAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate) {
		$this->realEstateRepository->update($realEstate);
		$this->flashMessageContainer->add('Your existing domain object was updated.');
		$this->redirect('list');
	}
	/**
	 * Deletes an existing domain object.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate The existing domain object to update
	 * @return string The rendered view for this action.
	 */
	protected function deleteAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate) {
		$this->realEstateRepository->remove($realEstate);
		$this->flashMessageContainer->add('Your existing domain object was removed.');
		$this->redirect('list');
	}

	
	/**
	 * Getter for realEstateRepository
	 *
	 * @return Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository Repository for a domain objects
	 */
	public function getRealEstateRepository() {
		return $this->realEstateRepository;
	}
	/**
	 * Dependency injection for realEstateRepository
	 *
	 * @param Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository $realEstateRepository Repository for a domain objects
	 * @return void
	 */
	public function injectRealEstateRepository(Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository $realEstateRepository) {
		$this->realEstateRepository = $realEstateRepository;
	}

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466.controller) ENABLED START */
	// TODO: put your further code implementations here
	/* PROTECTED REGION END */
}
?>
