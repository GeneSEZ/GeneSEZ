<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

/**
 */
Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'Searchbox',
	array(
		'RealEstate' => 'showSearchbox, searchSearchbox'
	),
	array(
		'RealEstate' => 'searchSearchbox'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

/**
 */
Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'Searchform',
	array(
		'RealEstate' => 'showSearchform'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

/**
 */
Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'ShowByQuarter',
	array(
		'RealEstate' => 'showByQuarter'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

/**
 */
Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'ShowByUid',
	array(
		'RealEstate' => 'showByUid'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);


/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
