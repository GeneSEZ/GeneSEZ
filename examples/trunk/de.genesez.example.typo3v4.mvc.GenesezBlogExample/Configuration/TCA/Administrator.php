<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gzblogexample_domain_model_administrator'] = array (
	'ctrl' => $TCA['tx_gzblogexample_domain_model_administrator']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => '',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194766758_10455_1575) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, starttime, endtime, '),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194766758_10455_1575) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194766758_10455_1575) ENABLED START */
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
			)
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
				'foreign_table' => 'tx_gzblogexample_domain_model_administrator',
				'foreign_table_where' => 'AND tx_gzblogexample_domain_model_administrator.uid=###REC_FIELD_l10n_parent### AND tx_gzblogexample_domain_model_administrator.sys_language_uid IN (-1,0)',
			)
		),
		'l10n_diffsource' => array(
			'config' =>array(
				'type' =>'passthrough',
			)
		),
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
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			)
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194766758_10455_1575) ENABLED START */
		/* PROTECTED REGION END */
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194766758_10455_1575) ENABLED START */
/* PROTECTED REGION END */

?>
