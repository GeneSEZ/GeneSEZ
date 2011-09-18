<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'List',
	array(
		'RealEstate' => 'list'
	),
	array(
		'RealEstate' => 'list'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'Searchbox',
	array(
		'RealEstate' => 'showSearchbox, search'
	),
	array(
		'RealEstate' => 'showSearchbox, search'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'Searchform',
	array(
		'RealEstate' => 'showSearchform, search'
	),
	array(
		'RealEstate' => 'showSearchform, search'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'Show',
	array(
		'RealEstate' => 'show'
	),
	array(
		'RealEstate' => 'show'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'ShowByQuarter',
	array(
		'RealEstate' => 'showByQuarter'
	),
	array(
		'RealEstate' => 'showByQuarter'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'ShowByUid',
	array(
		'RealEstate' => 'showByUid'
	),
	array(
		'RealEstate' => 'showByUid'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
