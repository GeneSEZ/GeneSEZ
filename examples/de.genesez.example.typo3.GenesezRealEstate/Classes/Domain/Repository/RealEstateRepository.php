<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1314918939457_992931_2302) ENABLED START */
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
class Tx_GenesezRealEstate_Domain_Repository_RealEstateRepository extends Tx_Extbase_Persistence_Repository {



	
	/**
	 * Find real estates matching the given quarter.
	 *
	 * @param int $quarterUid 
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GenesezRealEstate_Domain_Model_RealEstate> Find real estates matching the given quarter.
	 */
	public function findAllByQuarter($quarterUid) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1314918955883_553083_2329) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->equals('quarter.uid', $quarterUid)
			)
			->execute();
		/* PROTECTED REGION END */
	}

	

	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1314918939457_992931_2302) ENABLED START */
	/* PROTECTED REGION END */

}
?>
