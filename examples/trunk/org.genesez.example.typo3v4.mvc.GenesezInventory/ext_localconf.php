<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::configurePlugin(
	'GeneSEZ.' . $_EXTKEY,
	'List',
	array(
		'Inventory' => 'list'
	),
	array(
	),
	\TYPO3\CMS\Extbase\Utility\ExtensionUtility::PLUGIN_TYPE_PLUGIN
);

/* PROTECTED REGION ID(ext_localconf.php.own.plugin.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_localconf.php.own.command.controller.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
