<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'List',
	array(
		'Inventory' => 'list'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_localconf.php.own.command.controller.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
