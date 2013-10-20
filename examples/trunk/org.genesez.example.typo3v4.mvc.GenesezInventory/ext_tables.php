<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::registerPlugin(
	$_EXTKEY,
	'List',
	'List'
);

/* PROTECTED REGION ID(ext_tables.php.own.plugin.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_tables.php.own.module.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GeneSEZ GszInventory Setup');

/* PROTECTED REGION ID(ext_tables.php.own.typoscript.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::addLLrefForTCAdescr('tx_gszinventory_domain_model_product', 'EXT:' . $_EXTKEY . '/Resources/Private/Language/.locallang_csh_tx_gszinventory_domain_model_product.xlf');
\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::allowTableOnStandardPages('tx_gszinventory_domain_model_product');
	
/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
