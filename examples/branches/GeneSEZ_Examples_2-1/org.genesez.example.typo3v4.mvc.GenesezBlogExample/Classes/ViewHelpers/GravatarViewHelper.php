<?php

/* PROTECTED REGION ID(php.own.imports._16_9_8a7027a_1297252449390_374572_3319) ENABLED START */
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
 * View helper for rendering gravatar images.
 * See http://www.gravatar.com
 * 
 * = Examples =
 * 
 * <code>
 * <blog:gravatar emailAddress="foo@bar.com" size="40" defaultImageUri="someDefaultImage" />
 * </code>
 * 
 * <output>
 * <img src="http://www.gravatar.com/avatar/4a28b782cade3dbcd6e306fa4757849d?d=someDefaultImage&s=40" />
 * </output>
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GszBlogExample_ViewHelpers_GravatarViewHelper extends Tx_Fluid_Core_ViewHelper_AbstractTagBasedViewHelper {

	/**
	 * @var string
	 */
	protected $tagName = 'img';
	
	/**
	 * Initialize arguments
	 *
	 * @return void
	 */
	public function initializeArguments() {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252698260_127341_3371) ENABLED START */
		parent::initializeArguments();
		$this->registerUniversalTagAttributes();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Render the gravatar image
	 *
	 * @param string $emailAddress Gravataer email address
	 * @param integer $size Size of the gravatar image
	 * @param string $defaultImageUri absolute URI of the image to be shown if no gravatar was found
	 * @return string The rendered image tag
	 */
	public function render($emailAddress, $size = null, $defaultImageUri = null) {
		/* PROTECTED REGION ID(php.implementation._16_9_8a7027a_1297252704043_6615_3384) ENABLED START */
		$gravatarUri = 'http://www.gravatar.com/avatar/' . md5($emailAddress);
		$uriParts = array();
		if ($defaultImageUri !== NULL) {
			$uriParts[] = 'd=' . urlencode($defaultImageUri);
		}
		if ($size !== NULL) {
			$uriParts[] = 's=' . urlencode($size);
		}
		if (count($uriParts) > 0) {
			$gravatarUri .= '?' . implode('&', $uriParts);
		}
		
		$this->tag->addAttribute('src', $gravatarUri);
		return $this->tag->render();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for tagName
	 *
	 * @return string 
	 */
	public function getTagName() {
		return $this->tagName;
	}
	
	/**
	 * Setter for tagName
	 *
	 * @param string $tagName 
	 * @return void
	 */
	public function setTagName($tagName) {
		$this->tagName = $tagName;
	}
	
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_9_8a7027a_1297252449390_374572_3319) ENABLED START */
	/* PROTECTED REGION END */

}

?>
