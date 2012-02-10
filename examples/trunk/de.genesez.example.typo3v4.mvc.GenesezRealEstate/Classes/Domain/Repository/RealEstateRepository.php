<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1314918939457_992931_2302) ENABLED START */
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
 * A repository for real estates.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszRealEstate_Domain_Repository_RealEstateRepository extends Tx_Extbase_Persistence_Repository {

	/**
	 * Finds all real estates which matches the given demand.
	 *
	 * @param Tx_GszRealEstate_Domain_Model_Demand $demand The given demand.
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszRealEstate_Domain_Model_RealEstate> A list of real estates or an empty list.
	 */
	public function findAllByDemand(Tx_GszRealEstate_Domain_Model_Demand $demand) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315237292891_470931_1984) ENABLED START */
		// create a new query object
		$query = $this->createQuery();

		// define an array to store all the constraints
		$contraints = array();
		
		if ($demand !== null) {
			// check if maximum of rent is set
			if ($demand->getMaxRentExclusiveOfHeating() !== null && $demand->getMaxRentExclusiveOfHeating() !== '') {
				$contraints[] = $query->lessThanOrEqual('rentExclusiveOfHeating', $demand->getMaxRentExclusiveOfHeating());
			}
			// check if minimal size is set
			if ($demand->getMinSize() !== null && $demand->getMinSize() !== '') {
				$contraints[] = $query->greaterThanOrEqual('size', $demand->getMinSize());
			}
			// check if town is set
			if ($demand->getTown() !== null && $demand->getTown() !== '') {
				$contraints[] = $query->like('town', '%' . $demand->getTown() . '%');
			}
			// check if balcony is set
			if ($demand->getBalcony() !== null && $demand->getBalcony() !== '') {
				$contraints[] = $query->equals('balcony', $demand->getBalcony());
			}
			// check if minimal rooms is set
			if ($demand->getMinRooms() !== null) {
				$contraints[] = $query->greaterThanOrEqual('rooms.specification', $demand->getMinRooms()->getSpecification());
			}
			// check if floor is set
			if ($demand->getFloor() !== null) {
				$contraints[] = $query->equals('floor.specification', $demand->getFloor()->getSpecification());
			}
			// check if quarter is set
			if ($demand->getQuarter() !== null) {
				$contraints[] = $query->equals('quarter.name', $demand->getQuarter()->getName());
			}
			// check if any constraint is set
			if (count($contraints) != 0) {
				// connect all constrains with an logical AND
				$query->matching($query->logicalAnd($contraints));
			}
			return $query->execute();
		}
		return $this->findAll();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Gets all real estates by the given uids.
	 *
	 * @param array $uids The given uids.
	 * @return Tx_Extbase_Persistence_QueryResultInterface<Tx_GszRealEstate_Domain_Model_RealEstate> 
	 */
	public function getAllByUids(array $uids) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315405542958_541761_2595) ENABLED START */
		$query = $this->createQuery();
		return $query
			->matching(
				$query->equals('uid', $uids)
			)
			->execute();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1314918939457_992931_2302) ENABLED START */
	/* PROTECTED REGION END */

}

?>
