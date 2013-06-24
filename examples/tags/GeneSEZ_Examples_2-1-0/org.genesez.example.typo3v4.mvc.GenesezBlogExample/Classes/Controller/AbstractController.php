<?php

/* PROTECTED REGION ID(php.own.imports._17_0_1_8a7027a_1302081259525_708656_2063) ENABLED START */
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
 * Abstract base controller for the BlogExample extension
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
abstract class Tx_GszBlogExample_Controller_AbstractController extends Tx_Extbase_MVC_Controller_ActionController {

	/**
	 * helper function to render localized flashmessages
	 *
	 * @param string $action 
	 * @param integer $severity optional severity code. One of the t3lib_FlashMessage constants
	 * @return void
	 */
	protected function addFlashMessage($action, $severity = t3lib_FlashMessage::OK) {
		/* PROTECTED REGION ID(php.implementation._17_0_1_8a7027a_1302081575397_839592_2100) ENABLED START */
		$messageLocallangKey = sprintf('flashmessage.%s.%s', $this->request->getControllerName(), $action);
		$localizedMessage = $this->translate($messageLocallangKey, '[' . $messageLocallangKey . ']');
		$titleLocallangKey = sprintf('%s.title', $messageLocallangKey);
		$localizedTitle = $this->translate($titleLocallangKey, '[' . $titleLocallangKey . ']');
		$this->flashMessageContainer->add($localizedMessage, $localizedTitle, $severity);
		/* PROTECTED REGION END */
	}
	
	/**
	 * helper function to use localized strings in BlogExample controllers
	 *
	 * @param string $key locallang key
	 * @param string $defaultMessage the default message to show if key was not found
	 * @return string 
	 */
	protected function translate($key, $defaultMessage = '') {
		/* PROTECTED REGION ID(php.implementation._17_0_1_8a7027a_1302081746177_170309_2158) ENABLED START */
		$message = Tx_Extbase_Utility_Localization::translate($key, 'GszBlogExample');
		if ($message === NULL) {
			$message = $defaultMessage;
		}
		return $message;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Override getErrorFlashMessage to customize the flash message.
	 *
	 * @return string The flash message
	 */
	protected function getErrorFlashMessage() {
		/* PROTECTED REGION ID(php.implementation._17_0_1_8a7027a_1302081259525_708656_2063.getErrorFlashMessage) ENABLED START */
		$defaultFlashMessage = parent::getErrorFlashMessage();
		$locallangKey = sprintf('error.%s.%s', $this->request->getControllerName(), $this->actionMethodName);
		return $this->translate($locallangKey, $defaultFlashMessage);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_1_8a7027a_1302081259525_708656_2063) ENABLED START */
	/* PROTECTED REGION END */

}

?>
