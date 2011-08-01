<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_blog'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_blog']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'title,description,logo,posts,administrator',
	),
	'types' => array(
		'1' => array('showitem'	=> 'title,description,logo,posts,administrator'),
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
				'foreign_table' => 'tx_genesezblogexample_domain_model_blog',
				'foreign_table_where' => 'AND tx_genesezblogexample_domain_model_blog.uid=###REC_FIELD_l18n_parent### AND tx_genesezblogexample_domain_model_blog.sys_language_uid IN (-1,0)',
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
		'title' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog.title',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			),
		),
		'description' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog.description',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			),
		),
		'logo' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog.logo',
			'config' => array(
				'type' => 'group',
				'internal_type' => 'file',
				'uploadfolder' => 'uploads/tx_genesezblogexample',
				'show_thumbs' => 1,
				'size' => 5,
				'allowed' => 'gif,jpg,jpeg,tif,tiff,bmp,pcx,tga,png,pdf,ai',
				'disallowed' => ''
			),
		),
		'posts' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog.posts',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_post',
				'foreign_field' => 'blog',
				'foreign_sortby' => 'sorting',
				'minitems' => 0,
				'maxitems' => 9999,
				'appearance' => array(
					'collapse' => 0,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => 1,
					'showPossibleLocalizationRecords' => 1,
					'showAllLocalizationLink' => 1
				)
			)
		),
		'administrator' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog.administrator',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_administrator',
				'minitems' => 0,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => 0,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => 1,
					'showPossibleLocalizationRecords' => 1,
					'showAllLocalizationLink' => 1
				),
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
