<?php

/* PROTECTED REGION ID(php.own.imports._17_0_2_8a7027a_1315420126069_595943_2606) ENABLED START */
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
 * 
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Tx_GenesezRealEstate_ViewHelpers_ImagesViewHelper extends Tx_Fluid_ViewHelpers_ImageViewHelper {



	
	/**
	 *
	 * @param Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate 
	 * @param boolean $singleImage 
	 * @return string 
	 */
	public function render(Tx_GenesezRealEstate_Domain_Model_RealEstate $realEstate, $singleImage = true) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315420271916_725303_2728) ENABLED START */
		$renderedImages = "";
		
		if ($realEstate->hasImgs()) {
			$images = $realEstate->getImgs();
			//$descriptions = $realEstate->getImgDescs();
			
			if ($singleImage) {
				$renderedImages .= $this->renderSingleImage($images[0], "");
			} else {
				foreach ($images as $image) {
					$renderedImages.= $this->renderSingleImage($image, "");
				}
			}
		}
		return $renderedImages;
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @param string $imageFile 
	 * @param string $imageDescription 
	 * @return string 
	 */
	protected function renderSingleImage($imageFile, $imageDescription) {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424095066_757130_2008) ENABLED START */
		$this->tag->addAttribute('alt', $imageDescription);
		
		$renderImage = "";
		$renderImage .=	'<dl class="csc-textpic-image csc-textpic-firstcol csc-textpic-lastcol" style="width: 175px;">';
		$renderImage .=		'<dt>';
		$renderImage .=			'<a href="' . $this->getUploadfolder() . $imageFile .'" title="'. $imageDescription .'" ' . $this->getColorBoxInclusion() .' >';
		$renderImage .=				parent::render($this->getUploadfolder() . $imageFile, $this->getImageWidth(), $this->getImageHeight());
		$renderImage .=			'</a>';
		$renderImage .=		'</dt>';
		$renderImage .=		'<dd class="csc-textpic-caption">' . $imageDescription . '</dd>';
		$renderImage .=	'</dl>';
		
		return $renderImage;
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	protected function getColorBoxInclusion() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424182004_903409_2395) ENABLED START */
		return 'class="rzcolorbox" rel="rzcolorbox[cb453]"';
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	protected function getImageWidth() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424253320_170868_2431) ENABLED START */
		return '175c';
		/* PROTECTED REGION END */
	}
	/**
	 *
	 * @return string 
	 */
	protected function getImageHeight() {
		/* PROTECTED REGION ID(php.implementation._17_0_2_8a7027a_1315424266358_465790_2439) ENABLED START */
		return '175c';
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
