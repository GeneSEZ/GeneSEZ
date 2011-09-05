<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1314919357827_141495_2375) ENABLED START */
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
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GenesezRealEstate_Controller_RealEstateController extends Tx_Extbase_MVC_Controller_ActionController {

	/**
	 * 
	 * @var Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository
	 */
	private $realEstateRepository;


	
	/**
	 *
	 * @return string 
	 */
	public function showSearchboxAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919842588_568660_2521) ENABLED START */
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	public function showSearchformAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919858358_221947_2529) ENABLED START */
		return "Searchform called";
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	public function showByUidAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314920948577_433681_2860) ENABLED START */
		$realEstateUid = $this->getFlexformUid($this->settings['realEstate']);
		$realEstate = $this->realEstateRepository->findByUid($realEstateUid);
		
		$this->view->assign('realEstate', $realEstate);
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	public function showByQuarterAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919652753_836062_2466) ENABLED START */
		$quarterUid = $this->getFlexformUid($this->settings['quarter']);
		$realEstates = $this->realEstateRepository->findAllByQuarter($quarterUid);
		print_r($realEstates->getFirst());
		$this->view->assign('realEstates', $realEstates);
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @param string $search 
	 * @return string 
	 */
	public function searchSearchboxAction($search) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315231403518_321166_1973) ENABLED START */
		// TODO: implementation of method searchSearchbox for class Tx_GenesezRealEstate_Controller_RealEstateController
		throw new Exception('The implementation of the method searchSearchboxAction for class Tx_GenesezRealEstate_Controller_RealEstateController is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	public function previousAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919749209_572446_2503) ENABLED START */
		// TODO: implementation of method previous for class Tx_GenesezRealEstate_Controller_RealEstateController
		throw new Exception('The implementation of the method previousAction for class Tx_GenesezRealEstate_Controller_RealEstateController is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 * Shows a single real estate with all details.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate The real estate to show.
	 * @return string The rendered view for this action.
	 */
	public function showAction(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919481995_230589_2439) ENABLED START */
		// TODO: implementation of method show for class Tx_GenesezRealEstate_Controller_RealEstateController
		throw new Exception('The implementation of the method showAction for class Tx_GenesezRealEstate_Controller_RealEstateController is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	public function nextAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919740231_303253_2495) ENABLED START */
		// TODO: implementation of method next for class Tx_GenesezRealEstate_Controller_RealEstateController
		throw new Exception('The implementation of the method nextAction for class Tx_GenesezRealEstate_Controller_RealEstateController is missing !');
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @param string $item 
	 * @return int 
	 */
	private function getFlexformUid($item) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315211896999_497886_1973) ENABLED START */
		return preg_replace( '/\D/', '', $item);
		/* PROTECTED REGION END */
	}

	
	/**
	 * Getter for realEstateRepository
	 *
	 * @return Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository 
	 */
	public function getRealEstateRepository() {
		return $this->realEstateRepository;
	}
	/**
	 * Dependency injection for realEstateRepository
	 *
	 * @param Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository $realEstateRepository 
	 * @return void
	 */
	public function injectRealEstateRepository(Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository $realEstateRepository) {
		$this->realEstateRepository = $realEstateRepository;
	}

	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1314919357827_141495_2375) ENABLED START */
	// TODO: put your further code implementations here
	/* PROTECTED REGION END */

}
?>
