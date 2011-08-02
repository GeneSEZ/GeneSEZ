<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297251368580_84265_2660) ENABLED START */
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
 * An exemplary Blog validator
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GenesezBlogExample_Domain_Validator_BlogValidator extends Tx_Extbase_Validation_Validator_AbstractValidator {
	


	
	/**
	 * Checks whether the given blog is valid
	 *
	 * @param Tx_GenesezBlogExample_Domain_Model_Blog $blog The blog
	 * @return boolean TRUE if blog could be validated, otherwise FALSE
	 */
	public function isValid(Tx_GenesezBlogExample_Domain_Model_Blog $blog) {
		/* PROTECTED REGION ID(php.implementation._17_0_1_8a7027a_1310052749779_236836_2370) ENABLED START */
		
		if (strtolower($blog->getTitle()) === 'extbase') {
			$this->addError(Tx_Extbase_Utility_Localization::translate('error.Blog.invalidTitle', 'BlogExample'), 1297418974);
			return FALSE;
		}
		return TRUE;
		
		/* PROTECTED REGION END */
	}

	

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297251368580_84265_2660) ENABLED START */
	// TODO: put your further code implementations here
	/* PROTECTED REGION END */
}
?>
