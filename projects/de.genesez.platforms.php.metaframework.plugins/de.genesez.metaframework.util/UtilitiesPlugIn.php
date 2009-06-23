<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240324483359_514108_877) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_PlugInBase
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
class UtilitiesPlugIn extends Mfw_PlugInBase  {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	string
	 */
	public function getId() {
		return 'de.genesez.metaframework.util';
	}

	/**
	 * @generated	method stub for implementation
	 * @return	array of S2Container_ComponentDef
	 */
	public function getComponents() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1240324545343_620417_920) ENABLED START */
		return array(
			Mfw_SeasarPhpBuilder::newComponent('Msg_FlashNotifier', 'notifier')
		);
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240324483359_514108_877) ENABLED START */
	/* PROTECTED REGION END */
}
?>
