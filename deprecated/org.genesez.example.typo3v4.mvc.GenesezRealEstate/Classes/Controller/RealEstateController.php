<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1314919357827_141495_2375) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2012 Nico Herbig
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
 * The real estate controller for the real estate extension.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszRealEstate_Controller_RealEstateController extends Tx_Extbase_MVC_Controller_ActionController {

	/**
	 * A reference of the real estate repository.
	 *
	 * @var Tx_GszRealEstate_Domain_Repository_RealEstateRepository
	 * @inject
	 */
	private $realEstateRepository;
	
	/**
	 * A reference of the quarter repository.
	 *
	 * @var Tx_GszRealEstate_Domain_Repository_QuarterRepository
	 * @inject
	 */
	private $quaterRepository;
	
	/**
	 * A reference of the floor type repository.
	 *
	 * @var Tx_GszRealEstate_Domain_Repository_FloorTypeRepository
	 * @inject
	 */
	private $floorTypeRepository;
	
	/**
	 * A reference of the room type repository.
	 *
	 * @var Tx_GszRealEstate_Domain_Repository_RoomTypeRepository
	 * @inject
	 */
	private $roomTypeRepository;
	
	/**
	 * Shows a summary for a single real estate. The real estate is set inside the flexform of the plugin.
	 *
	 * @return string The rendered view for this action.
	 */
	public function showByUidAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314920948577_433681_2860) ENABLED START */
		$realEstateUid = $this->getFlexformUid($this->settings['real_estate']);
		$realEstate = $this->realEstateRepository->findByUid($realEstateUid);
		
		$this->view->assign('realEstate', $realEstate);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Shows all real estates for a given quarter. The quarter is set inside the flexform of the plugin.
	 *
	 * @return string The rendered view for this action.
	 */
	public function showByQuarterAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919652753_836062_2466) ENABLED START */
		$quarterUid = $this->getFlexformUid($this->settings['quarter']);
		$quarter = $this->quaterRepository->findByUid($quarterUid);
		
		$realEstates = $this->realEstateRepository->findByQuarter($quarter);

		$this->view->assign('realEstates', $realEstates);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Displays a search box which can be add to a sidebar.
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Demand $demand A fresh demand object taken as a basis for the rendering.
	 * @return string The rendered view for this action.
	 * @dontvalidate $demand
	 */
	public function showSearchboxAction(Tx_GszRealEstate_Domain_Model_Demand $demand = null) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919842588_568660_2521) ENABLED START */
		$this->view->assign('demand', $demand);
		
		$this->view->assign('roomTypes',
			array_merge(
				array(0 => '---'),
				$this->roomTypeRepository->findAll()->toArray()
			)
		);
		
		$this->view->assign('floorTypes',
			array_merge(
				array(0 => '---'),
				$this->floorTypeRepository->findAll()->toArray()
			)
		);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Shows a search form with more configuration options as the search box.
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Demand $demand A fresh demand object taken as a basis for the rendering.
	 * @return string The rendered view for this action.
	 * @dontvalidate $demand
	 */
	public function showSearchformAction(Tx_GszRealEstate_Domain_Model_Demand $demand = null) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919858358_221947_2529) ENABLED START */
		$this->view->assign('demand', $demand);
		
		$this->view->assign('quarters',
			array_merge(
				array(0 => '---'),
				$this->quaterRepository->findAll()->toArray()
			)
		);
		
		$optionYes = Tx_Extbase_Utility_Localization::translate('tx_gszrealestate.yes', 'GszRealEstate');
		$optionNo = Tx_Extbase_Utility_Localization::translate('tx_gszrealestate.no', 'GszRealEstate');
		$this->view->assign('balcony', array('' => '---', '1' => $optionYes, '0' => $optionNo));
	
		$this->view->assign('floorTypes',
			array_merge(
				array(0 => '---'),
				$this->floorTypeRepository->findAll()->toArray()
			)
		);
		$this->view->assign('roomTypes',
			array_merge(
				array(0 => '---'),
				$this->roomTypeRepository->findAll()->toArray()
			)
		);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Search action which gets a demand object where all search informations are stores and redirect to the list action.
	 * 
	 * This method is only needed because I can not call the list action from searchbox or searchform directly.
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Demand $demand The rendered view for this action.
	 * @return string 
	 */
	public function searchAction(Tx_GszRealEstate_Domain_Model_Demand $demand) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315231403518_321166_1973) ENABLED START */
		$realEstates = $this->realEstateRepository->findAllByDemand($demand);
		$realEstateUids = $realEstates->toArray();
		
		// I don't know why I can no directly call the 'listAction' from the search forms.
		$this->redirect('list', null, null, array('realEstateUids' => $realEstateUids), $this->settings['listViewPid']);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Lists the real estates which matches the demand.
	 *
	 * @param array $realEstateUids 
	 * @return string 
	 */
	public function listAction(array $realEstateUids = null) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315373671137_940448_1987) ENABLED START */
		if (!is_null($realEstateUids)) {
			$realEstates = $this->realEstateRepository->getAllByUids($realEstateUids);
		}
		$this->view->assign('realEstates', $realEstates);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Shows a single real estate with all details.
	 *
	 * @param Tx_GszRealEstate_Domain_Model_RealEstate $realEstate 
	 * @return string The rendered view for this action.
	 */
	public function showAction(Tx_GszRealEstate_Domain_Model_RealEstate $realEstate) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314919481995_230589_2439) ENABLED START */
		$this->view->assign('realEstate', $realEstate);
		$this->view->assign('realEstates', $realEstates);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Converts the reference stored inside the flexform of the plugin to a uid.
	 *
	 * @param string $item The flexform uid.
	 * @return int The uid.
	 */
	private function getFlexformUid($item) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315211896999_497886_1973) ENABLED START */
		return preg_replace( '/\D/', '', $item);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for realEstateRepository
	 *
	 * @return Tx_GszRealEstate_Domain_Repository_RealEstateRepository A reference of the real estate repository.
	 */
	public function getRealEstateRepository() {
		return $this->realEstateRepository;
	}
	
	/**
	 * Getter for quaterRepository
	 *
	 * @return Tx_GszRealEstate_Domain_Repository_QuarterRepository A reference of the quarter repository.
	 */
	public function getQuaterRepository() {
		return $this->quaterRepository;
	}
	
	/**
	 * Getter for floorTypeRepository
	 *
	 * @return Tx_GszRealEstate_Domain_Repository_FloorTypeRepository A reference of the floor type repository.
	 */
	public function getFloorTypeRepository() {
		return $this->floorTypeRepository;
	}
	
	/**
	 * Getter for roomTypeRepository
	 *
	 * @return Tx_GszRealEstate_Domain_Repository_RoomTypeRepository A reference of the room type repository.
	 */
	public function getRoomTypeRepository() {
		return $this->roomTypeRepository;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1314919357827_141495_2375) ENABLED START */
	/* PROTECTED REGION END */

}

?>
