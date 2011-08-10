<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

/**
 * Plugin for a domain object.
 */
Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'RealEstate',
	array(
		'RealEstate' => 'list, show, new, create, edit, update, delete'
	),
	array(
		'RealEstate' => 'create, update, delete'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);


/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
