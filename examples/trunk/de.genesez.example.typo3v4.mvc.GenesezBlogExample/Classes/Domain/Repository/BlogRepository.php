<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1302020870850_802851_3552) ENABLED START */
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
 * A repository for blogs
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Repository_BlogRepository extends Tx_Extbase_Persistence_Repository {

	/**
	 * Life cycle method.
	 *
	 * @return void
	 */
	public function initalizeObject() {
		/* PROTECTED REGION ID(php.implementation._17_0_1_8a7027a_1302020870850_802851_3552.initalizeObject) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1302020870850_802851_3552) ENABLED START */
	protected $defaultOrderings = array(
			'crdate' => Tx_Extbase_Persistence_QueryInterface::ORDER_DESCENDING,
			'uid' => Tx_Extbase_Persistence_QueryInterface::ORDER_DESCENDING
	);
	/* PROTECTED REGION END */

}

?>
