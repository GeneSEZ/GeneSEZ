<?php

defined('TYPO3_MODE') or die();

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

/* PROTECTED REGION ID(ext_localconf.php.own.plugin.code.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further plugin code here
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
    /* PROTECTED REGION ID(ext_localconf.php.own.command.controller.code.eee_1045467100313_135436_1) ENABLED START */
    // TODO: put your further command controller code here
    /* PROTECTED REGION END */
}

/* PROTECTED REGION ID(ext_localconf.php.own.code.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code here
/* PROTECTED REGION END */
