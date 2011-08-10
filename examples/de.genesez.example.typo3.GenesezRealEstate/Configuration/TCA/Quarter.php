<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezrealestate_domain_model_quarter'] = array (
	'ctrl' => $TCA['tx_genesezrealestate_domain_model_quarter']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'name,description',
	),
	'types' => array(
		'1' => array('showitem'	=> 'name,description'),
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
	),
	'columns' => array(
		'hidden' => array(
			'exclude' => 1,
			'label'	=> 'LLL:EXT:lang/locallang_general.xml:LGL.hidden',
			'config' => array(
				'type' => 'check',
			)
		),
		'starttime' => array(
			'exclude' => 1,
			'l10n_mode' => 'mergeIfNotBlank',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.starttime',
			'config' => array(
				'type' => 'input',
				'size' => 13,
				'max' => 20,
				'eval' => 'datetime',
				'checkbox' => 0,
				'default' => 0,
				'range' => array(
					'lower' => mktime(0, 0, 0, date('m'), date('d'), date('Y'))
				),
			),
		),
		'endtime' => array(
			'exclude' => 1,
			'l10n_mode' => 'mergeIfNotBlank',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.endtime',
			'config' => array(
				'type' => 'input',
				'size' => 13,
				'max' => 20,
				'eval' => 'datetime',
				'checkbox' => 0,
				'default' => 0,
				'range' => array(
					'lower' => mktime(0, 0, 0, date('m'), date('d'), date('Y'))
				),
			),
		),
		'sys_language_uid' => array(
			'exclude' => 1,
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
			'exclude' => 1,
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.l18n_parent',
			'config' => array(
				'type' => 'select',
				'items'	=> array(
					array('', 0),
				),
				'foreign_table' => 'tx_genesezrealestate_domain_model_quarter',
				'foreign_table_where' => 'AND tx_genesezrealestate_domain_model_quarter.uid=###REC_FIELD_l18n_parent### AND tx_genesezrealestate_domain_model_quarter.sys_language_uid IN (-1,0)',
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
		'name' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_quarter.name',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			)
		),
		'description' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezrealestate_domain_model_quarter.description',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_1_8a7027a_1306344032809_231995_2319) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
