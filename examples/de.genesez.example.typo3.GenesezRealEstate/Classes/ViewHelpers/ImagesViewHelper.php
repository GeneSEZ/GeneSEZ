<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1315420126069_595943_2606) ENABLED START */
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
class Tx_GenesezRealEstate_ViewHelpers_ImagesViewHelper extends Tx_Fluid_ViewHelpers_ImageViewHelper {



	
	/**
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate 
	 * @param boolean $showSingleImage 
	 * @param boolean $showDescriptions 
	 * @param string $width 
	 * @param string $height 
	 * @return string 
	 */
	public function render(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate, $showSingleImage = true, $showDescriptions = true, $width = null, $height = null) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315420271916_725303_2728) ENABLED START */
		$renderImages = "";
		
		if ($realEstate->hasImgs()) {
			$images = $realEstate->getImgs();
			$descriptions = $realEstate->getImgDescs();

			// if only one image should be shown,
			// then slice to image array to get only the first image
			if ($showSingleImage) 
				$images = array_slice($images, 0, 1);
			
			// render images
			foreach ($images as $i => $image) {
				$description = $descriptions[$i];
				$renderImages .= $this->renderSingleImage($realEstate->getUid(), $image, $description, $showDescriptions, $width, $height);
			}
		}
		return $renderImages;
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @param int $realEstateId 
	 * @param string $imageFile 
	 * @param string $imageDescription 
	 * @param boolean $showDescriptions 
	 * @param string $width 
	 * @param string $height 
	 * @return string 
	 */
	protected function renderSingleImage($realEstateId, $imageFile, $imageDescription, $showDescriptions = true, $width = null, $height = null) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424095066_757130_2008) ENABLED START */
		$this->tag->addAttribute('alt', $imageDescription);
		
		$renderImage = "";
		$renderImage .=	'<dl class="csc-textpic-image csc-textpic-firstcol csc-textpic-lastcol" style="width: 175px;">';
		$renderImage .=		'<dt>';
		$renderImage .=			'<a href="' . $this->getUploadfolder() . $imageFile .'" title="'. $imageDescription .'" ' . $this->getColorBoxInclusion($realEstateId) .' >';
		$renderImage .=				parent::render($this->getUploadfolder() . $imageFile, $width, $height);
		$renderImage .=			'</a>';
		$renderImage .=		'</dt>';
		if ($showDescriptions)
			$renderImage .=		'<dd class="csc-textpic-caption">' . $imageDescription . '</dd>';
		$renderImage .=	'</dl>';
		
		return $renderImage;
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @param int $realEstateId 
	 * @return string 
	 */
	protected function getColorBoxInclusion($realEstateId) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424182004_903409_2395) ENABLED START */
		return 'class="rzcolorbox" rel="rzcolorbox[cbre' . $realEstateId . ']"';
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	protected function getUploadfolder() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424657504_832779_2011) ENABLED START */
		return 'uploads/tx_genesezrealestate/'; 
		/* PROTECTED REGION END */
	}

	

	/* PROTECTED REGION ID(php.class.own.code.implementation._17_0_2_8a7027a_1315420126069_595943_2606) ENABLED START */
	/* PROTECTED REGION END */

}
?>
