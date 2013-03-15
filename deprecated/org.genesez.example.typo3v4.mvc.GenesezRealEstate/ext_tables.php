<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

t3lib_div::loadTCA('tt_content');

// These dividers are a little trick to group these items in the plugin selector
$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('GszRealEstate', '--div--', t3lib_extMgm::extRelPath($_EXTKEY) . 'ext_icon.gif');

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'List',
	'Show List of Search'
);

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'Searchbox',
	'Show Searchbox'
);

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'Searchform',
	'Show Searchform'
);

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'Show',
	'Show Single'
);

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'ShowByQuarter',
	'Show by Quarter'
);

$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_excludelist']['gszrealestate_showbyquarter'] = 'select_key';
$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_addlist']['gszrealestate_showbyquarter'] = 'pi_flexform,recursive';
t3lib_extMgm::addPiFlexFormValue('gszrealestate_showbyquarter', 'FILE:EXT:gsz_real_estate/Configuration/FlexForms/flexform_showbyquarter.xml');

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'ShowByUid',
	'Show by Uid'
);

$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_excludelist']['gszrealestate_showbyuid'] = 'select_key';
$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_addlist']['gszrealestate_showbyuid'] = 'pi_flexform,recursive';
t3lib_extMgm::addPiFlexFormValue('gszrealestate_showbyuid', 'FILE:EXT:gsz_real_estate/Configuration/FlexForms/flexform_showbyuid.xml');

$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('', '--div--');

/* PROTECTED REGION ID(ext_tables.php.own.plugins.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_tables.php.own.modules.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GszRealEstate setup');

/* PROTECTED REGION ID(ext_tables.php.own.typoscript.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_demand', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_demand.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_demand');
$TCA['tx_gszrealestate_domain_model_demand'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand',
		'label'	=> 'max_rent_exclusive_of_heating',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Demand.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_demand.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_floortype', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_floortype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_floortype');
$TCA['tx_gszrealestate_domain_model_floortype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_floortype',
		'label'	=> 'specification',
		'sortby' => 'sorting',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/FloorType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_floortype.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_heatingtype', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_heatingtype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_heatingtype');
$TCA['tx_gszrealestate_domain_model_heatingtype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_heatingtype',
		'label'	=> 'specification',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/HeatingType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_heatingtype.gif',
		'default_sortby' => 'ORDER BY specification',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306344206865_332239_2422) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_quarter', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_quarter.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_quarter');
$TCA['tx_gszrealestate_domain_model_quarter'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_quarter',
		'label'	=> 'name',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Quarter.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_quarter.gif',
		'default_sortby' => 'ORDER BY name',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306344032809_231995_2319) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_realestate', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_realestate.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_realestate');
$TCA['tx_gszrealestate_domain_model_realestate'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate',
		'label'	=> 'id',
		'label_alt' => 'title',
		'label_alt_force' => true,
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/RealEstate.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_realestate.gif',
		'default_sortby' => 'ORDER BY id',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszrealestate_domain_model_roomtype', 'EXT:gsz_real_estate/Resources/Private/Language/locallang_csh_tx_gszrealestate_domain_model_roomtype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszrealestate_domain_model_roomtype');
$TCA['tx_gszrealestate_domain_model_roomtype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_roomtype',
		'label'	=> 'specification',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/RoomType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszrealestate_domain_model_roomtype.gif',
		'default_sortby' => 'ORDER BY specification',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._17_0_1_8a7027a_1306343834717_151292_2268) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
