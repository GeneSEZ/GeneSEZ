<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297194671553_69571_1516.validator) ENABLED START */
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
 * Validator for object, property or parameter.
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_Domain_Validator_BlogValidator extends Tx_Extbase_Validation_Validator_AbstractValidator {

	/**
	 * Checks if the given value is valid according to the validator.
	 *
	 * @param mixed $value The value that should be validated
	 * @return boolean TRUE if the value is valid, FALSE if an error occured
	 */
	public function isValid($value) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297194671553_69571_1516.validator.isValid) ENABLED START */
		if (strtolower($value->getTitle()) === 'extbase') {
			$this->addError(Tx_Extbase_Utility_Localization::translate('error.Blog.invalidTitle', 'BlogExample'), 1297418974);
			return FALSE;
		}
		return TRUE;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297194671553_69571_1516.validator) ENABLED START */
	/* PROTECTED REGION END */

}

?>
