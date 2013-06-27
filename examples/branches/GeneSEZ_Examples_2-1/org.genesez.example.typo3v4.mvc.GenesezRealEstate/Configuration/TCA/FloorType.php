<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszrealestate_domain_model_floortype'] = array (
	'ctrl' => $TCA['tx_gszrealestate_domain_model_floortype']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'specification',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, specification'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
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
				'foreign_table' => 'tx_gszrealestate_domain_model_floortype',
				'foreign_table_where' => 'AND tx_gszrealestate_domain_model_floortype.uid=###REC_FIELD_l10n_parent### AND tx_gszrealestate_domain_model_floortype.sys_language_uid IN (-1,0)',
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
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			),
		),
		'specification' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_floortype.specification',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362._17_0_1_8a7027a_1306344127418_734768_2390) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362._17_0_1_8a7027a_1306344127418_734768_2390) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_1_8a7027a_1306344122287_504979_2362) ENABLED START */
/* PROTECTED REGION END */

?>
