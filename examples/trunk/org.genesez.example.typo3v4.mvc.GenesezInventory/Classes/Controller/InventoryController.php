<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1314624300500_289907_2202) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2012 Nico Herbig, Jochen Rau
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
class Tx_GszInventory_Controller_InventoryController extends Tx_Extbase_MVC_Controller_ActionController {

	/**
	 * @return void
	 */
	public function listAction() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314624316079_160741_2229) ENABLED START */
		$productRepository = t3lib_div::makeInstance('Tx_GszInventory_Domain_Repository_ProductRepository');
		$products = $productRepository->findAll();
		$this->view->assign('products', $products);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1314624300500_289907_2202) ENABLED START */
	/* PROTECTED REGION END */

}

?>
