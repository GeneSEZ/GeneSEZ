<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszrealestate_domain_model_demand'] = array (
	'ctrl' => $TCA['tx_gszrealestate_domain_model_demand']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'max_rent_exclusive_of_heating, min_size, town, balcony, quarter, min_rooms, floor',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, starttime, endtime, max_rent_exclusive_of_heating, min_size, town, balcony, quarter, min_rooms, floor'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
		/* PROTECTED REGION END */
	),
	'columns' => array(
		'sys_language_uid' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.language',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'sys_language',
				'foreign_table_where' => 'ORDER BY sys_language.title',
				'items' => array(
					array('LLL:EXT:lang/locallang_general.php:LGL.allLanguages', -1),
					array('LLL:EXT:lang/locallang_general.php:LGL.default_value', 0)
				),
			),
		),
		'l10n_parent' => array(
			'displayCond' => 'FIELD:sys_language_uid:>:0',
			'exclude' => true,
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.l18n_parent',
			'config' => array(
				'type' => 'select',
				'items'	=> array(
					array('', 0),
				),
				'foreign_table' => 'tx_gszrealestate_domain_model_demand',
				'foreign_table_where' => 'AND tx_gszrealestate_domain_model_demand.uid=###REC_FIELD_l10n_parent### AND tx_gszrealestate_domain_model_demand.sys_language_uid IN (-1,0)',
			),
		),
		'l10n_diffsource' => array(
			'config' =>array(
				'type' =>'passthrough',
			),
		),
		'hidden' => array(
			'exclude' => true,
			'label'	=> 'LLL:EXT:lang/locallang_general.xml:LGL.hidden',
			'config' => array(
				'type' => 'check',
			),
		),
		'starttime' => array(
			'exclude' => true,
			'l10n_mode' => 'mergeIfNotBlank',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.starttime',
			'config' => array(
				'type' => 'input',
				'size' => 13,
				'max' => 20,
				'eval' => 'datetime',
				'checkbox' => false,
				'default' => 0,
				'range' => array(
					'lower' => mktime(0, 0, 0, date('m'), date('d'), date('Y'))
				),
			),
		),
		'endtime' => array(
			'exclude' => true,
			'l10n_mode' => 'mergeIfNotBlank',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.endtime',
			'config' => array(
				'type' => 'input',
				'size' => 13,
				'max' => 20,
				'eval' => 'datetime',
				'checkbox' => false,
				'default' => 0,
				'range' => array(
					'lower' => mktime(0, 0, 0, date('m'), date('d'), date('Y'))
				),
			),
		),
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			),
		),
		'max_rent_exclusive_of_heating' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.max_rent_exclusive_of_heating',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315357061736_368482_2991) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315357061736_368482_2991) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'min_size' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.min_size',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356472952_664173_2812) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356472952_664173_2812) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'town' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.town',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356528388_493787_2841) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356528388_493787_2841) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'balcony' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.balcony',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356564684_645364_2863) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356564684_645364_2863) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'quarter' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.quarter',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356591775_883174_2870) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_quarter',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 0,
				'maxitems' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356591775_883174_2870) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'min_rooms' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.min_rooms',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356493767_742745_2820) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_roomtype',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 0,
				'maxitems' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356493767_742745_2820) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'floor' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_demand.floor',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356517000_852132_2833) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_floortype',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 0,
				'maxitems' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760._17_0_2_8a7027a_1315356517000_852132_2833) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_2_8a7027a_1315356442660_474299_2760) ENABLED START */
/* PROTECTED REGION END */

?>
