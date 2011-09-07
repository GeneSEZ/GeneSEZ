<?php
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
class Tx_GenesezRealEstate_ViewHelpers_ImageViewHelper extends Tx_Fluid_Core_ViewHelper_AbstractViewHelper {

	/**
	 * Render the real estate images.
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate The real estate
	 * @param boolean $showSingle true or false if one image should be shown
	 * @return string The rendered image or images
	 */
	public function render(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate, $showSingle = false) {
		$realEstateImages = $this->getRealEstateImages($realEstate);
		
		if ($showSingle == true && count($realEstateImages) > 0) {
			$realEstateImages = array_slice($realEstateImages, 0, 1);
		}
		
		$retVal = '';
		foreach ($realEstateImages as $image => $description) {
			$retVal .= $this->renderImage($image, $description);
		}
		return $retVal;		
	}
	
	private function renderImage($image, $description) {
		return '<dl class="csc-textpic-image csc-textpic-firstcol csc-textpic-lastcol" style="width: 175px;">
					<dt>
						<a href="uploads/tx_systemmacherrealestate/'. $image .'" title="'. $description .'" class="rzcolorbox" rel="rzcolorbox[cb453]"><img src="uploads/tx_systemmacherrealestate/'. $image .'" width="175" alt="'. $description .'" longdesc="'. $description .'" /></a>
					</dt>
					<dd class="csc-textpic-caption">'. $description .'</dd>
				</dl>';
	}
	
	private function getRealEstateImages(Tx_SystemmacherRealEstate_Domain_Model_RealEstate $realEstate) {
		if (strlen($realEstate->getImageFiles()) > 0) {
			// split images by , delemiter to get an array of files 
			$images = explode(',', $realEstate->getImageFiles());
			// split images by the new line delemiter to get an array of descriptions
			$descriptions = explode(chr(10), $realEstate->getImageDescriptions());
			
			// create a new array where the image files are the keys 
			// and the descriptions are the values
			$realEstateImages = array();
			
			$i = 0;
			foreach ($images as $image) {
				$realEstateImages["$image"] = $descriptions[$i];
				$i++;
			}
		} else {
			$realEstateImages = array();
		}
		return $realEstateImages;
	}
}


?>