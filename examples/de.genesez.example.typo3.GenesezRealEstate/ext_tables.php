<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

t3lib_div::loadTCA('tt_content');

// These dividers are a little trick to group these items in the plugin selector
$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('GenesezRealEstate', '--div--', t3lib_extMgm::extRelPath($_EXTKEY) . 'ext_icon.gif');

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'RealEstate',
	'Plugin'
);

$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('', '--div--');


t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GenesezRealEstate setup');

t3lib_extMgm::addLLrefForTCAdescr('tx_genesezrealestate_domain_model_floortype', 'EXT:genesez_real_estate/Resources/Private/Language/locallang_csh_tx_genesezrealestate_domain_model_floortype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezrealestate_domain_model_floortype');
$TCA['tx_genesezrealestate_domain_model_floortype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:genesez_real_estate/Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_floortype',
		'label'	=> 'specification',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l18n_parent',
		'transOrigDiffSourceField' => 'l18n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/FloorType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezrealestate_domain_model_floortype.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezrealestate_domain_model_heatingtype', 'EXT:genesez_real_estate/Resources/Private/Language/locallang_csh_tx_genesezrealestate_domain_model_heatingtype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezrealestate_domain_model_heatingtype');
$TCA['tx_genesezrealestate_domain_model_heatingtype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:genesez_real_estate/Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_heatingtype',
		'label'	=> 'specification',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l18n_parent',
		'transOrigDiffSourceField' => 'l18n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/HeatingType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezrealestate_domain_model_heatingtype.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezrealestate_domain_model_quarter', 'EXT:genesez_real_estate/Resources/Private/Language/locallang_csh_tx_genesezrealestate_domain_model_quarter.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezrealestate_domain_model_quarter');
$TCA['tx_genesezrealestate_domain_model_quarter'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:genesez_real_estate/Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_quarter',
		'label'	=> 'name',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l18n_parent',
		'transOrigDiffSourceField' => 'l18n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Quarter.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezrealestate_domain_model_quarter.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezrealestate_domain_model_realestate', 'EXT:genesez_real_estate/Resources/Private/Language/locallang_csh_tx_genesezrealestate_domain_model_realestate.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezrealestate_domain_model_realestate');
$TCA['tx_genesezrealestate_domain_model_realestate'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:genesez_real_estate/Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate',
		'label'	=> 'id',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l18n_parent',
		'transOrigDiffSourceField' => 'l18n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/RealEstate.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezrealestate_domain_model_realestate.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezrealestate_domain_model_realestatesizetype', 'EXT:genesez_real_estate/Resources/Private/Language/locallang_csh_tx_genesezrealestate_domain_model_realestatesizetype.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezrealestate_domain_model_realestatesizetype');
$TCA['tx_genesezrealestate_domain_model_realestatesizetype'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:genesez_real_estate/Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestatesizetype',
		'label'	=> 'specification',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l18n_parent',
		'transOrigDiffSourceField' => 'l18n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
			'starttime' => 'starttime',
			'endtime' => 'endtime',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/RealEstateSizeType.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezrealestate_domain_model_realestatesizetype.gif'
	)
);


/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
