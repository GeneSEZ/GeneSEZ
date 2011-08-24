<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezrealestate_domain_model_realestate'] = array (
	'ctrl' => $TCA['tx_genesezrealestate_domain_model_realestate']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'id,title,description,facility,state,miscellaneous,street,post_code,town,size,cellar,attic,balcony,free_from,rent_exclusive_of_heating,extra_charges,cooperative_share,image_files,image_descriptions,plot_file,heating,real_estate_size,floor,quarter',
	),
	'types' => array(
		'1' => array('showitem'	=> 'id,title,description,facility,state,miscellaneous,street,post_code,town,size,cellar,attic,balcony,free_from,rent_exclusive_of_heating,extra_charges,cooperative_share,image_files,image_descriptions,plot_file,heating,real_estate_size,floor,quarter'),
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
	),
	'columns' => array(
		'hidden' => array(
			'exclude' => true,
			'label'	=> 'LLL:EXT:lang/locallang_general.xml:LGL.hidden',
			'config' => array(
				'type' => 'check',
			)
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
			)
		),
		'l18n_parent' => array(
			'displayCond' => 'FIELD:sys_language_uid:>:0',
			'exclude' => true,
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.l18n_parent',
			'config' => array(
				'type' => 'select',
				'items'	=> array(
					array('', 0),
				),
				'foreign_table' => 'tx_genesezrealestate_domain_model_realestate',
				'foreign_table_where' => 'AND tx_genesezrealestate_domain_model_realestate.uid=###REC_FIELD_l18n_parent### AND tx_genesezrealestate_domain_model_realestate.sys_language_uid IN (-1,0)',
			)
		),
		'l18n_diffsource' => array(
			'config' =>array(
				'type' =>'passthrough',
			)
		),
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			)
		),
		'id' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.id',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'title' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.title',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'description' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.description',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'facility' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.facility',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'state' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.state',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'miscellaneous' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.miscellaneous',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'street' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.street',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'post_code' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.post_code',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'town' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.town',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'size' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.size',
			'config' => array(
			)
		),
		'cellar' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.cellar',
			'config' => array(
				'type' => 'check',
				'default' => 0
			)
		),
		'attic' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.attic',
			'config' => array(
				'type' => 'check',
				'default' => 0
			)
		),
		'balcony' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.balcony',
			'config' => array(
				'type' => 'check',
				'default' => 0
			)
		),
		'free_from' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.free_from',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'rent_exclusive_of_heating' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.rent_exclusive_of_heating',
			'config' => array(
			)
		),
		'extra_charges' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.extra_charges',
			'config' => array(
			)
		),
		'cooperative_share' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.cooperative_share',
			'config' => array(
			)
		),
		'image_files' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.image_files',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'image_descriptions' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.image_descriptions',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'plot_file' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.plot_file',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'heating' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.heating',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezrealestate_domain_model_heatingtype',
				'minitems' => 1,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
		'real_estate_size' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.real_estate_size',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezrealestate_domain_model_realestatesizetype',
				'minitems' => 1,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
		'floor' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.floor',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezrealestate_domain_model_floortype',
				'minitems' => 1,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
		'quarter' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_realestate.quarter',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezrealestate_domain_model_quarter',
				'minitems' => 1,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
