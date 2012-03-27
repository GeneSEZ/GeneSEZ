<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

t3lib_div::loadTCA('tt_content');

// These dividers are a little trick to group these items in the plugin selector
$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('GszInventory', '--div--', t3lib_extMgm::extRelPath($_EXTKEY) . 'ext_icon.gif');

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'List',
	'List'
);

$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('', '--div--');

/* PROTECTED REGION ID(ext_tables.php.own.plugins.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_tables.php.own.modules.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GszInventory setup');

/* PROTECTED REGION ID(ext_tables.php.own.typoscript.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

t3lib_extMgm::addLLrefForTCAdescr('tx_gszinventory_domain_model_product', 'EXT:gsz_inventory/Resources/Private/Language/locallang_csh_tx_gszinventory_domain_model_product.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszinventory_domain_model_product');
$TCA['tx_gszinventory_domain_model_product'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_db.xml:tx_gszinventory_domain_model_product',
		'label'	=> 'name',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'delete' => 'deleted',
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Product.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszinventory_domain_model_product.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
