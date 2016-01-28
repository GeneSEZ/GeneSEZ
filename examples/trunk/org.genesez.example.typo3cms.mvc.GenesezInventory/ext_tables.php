<?php

defined('TYPO3_MODE') or die();

\TYPO3\CMS\Extbase\Utility\ExtensionUtility::registerPlugin(
    $_EXTKEY,
    'List',
    'List'
);

/* PROTECTED REGION ID(ext_tables.php.own.plugin.code.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further plugin code here
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
    /* PROTECTED REGION ID(ext_tables.php.own.module.code.eee_1045467100313_135436_1) ENABLED START */
    // TODO: put your further module code here
    /* PROTECTED REGION END */
}

\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GeneSEZ GszInventory Setup');

/* PROTECTED REGION ID(ext_tables.php.own.typoscript.code.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further TypoScript code here
/* PROTECTED REGION END */

\TYPO3\CMS\Core\Utility\ExtensionManagementUtility::addLLrefForTCAdescr('tx_gszinventory_domain_model_product', 'EXT:' . $_EXTKEY . '/Resources/Private/Language/locallang_csh_tx_gszinventory_domain_model_product.xlf');

/* PROTECTED REGION ID(ext_tables.php.own.code.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code here
/* PROTECTED REGION END */
