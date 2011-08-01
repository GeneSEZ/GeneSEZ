<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_post'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_post']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'title,date,content,blog,author,tags,comments,related_posts',
	),
	'types' => array(
		'1' => array('showitem'	=> 'title,date,content,blog,author,tags,comments,related_posts'),
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
				'foreign_table' => 'tx_genesezblogexample_domain_model_post',
				'foreign_table_where' => 'AND tx_genesezblogexample_domain_model_post.uid=###REC_FIELD_l18n_parent### AND tx_genesezblogexample_domain_model_post.sys_language_uid IN (-1,0)',
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
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.title',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			),
		),
		'date' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.date',
			'config' => array(
			),
		),
		'content' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.content',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim'
			),
		),
		'blog' => Array (
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.blog',
			'config' => Array (
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_blog',
				'minitems' => 0,
				'maxitems' => 1,
				'appearance' => array(
					'collapse' => 0,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => 1,
					'showPossibleLocalizationRecords' => 1,
					'showAllLocalizationLink' => 1
				)
			)
		),
		'author' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.author',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_person',
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
		'tags' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.tags',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_tag',
				'MM' => 'tx_genesezblogexample_post_tag_tags_mm',
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
		'comments' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.comments',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_comment',
				'MM' => 'tx_genesezblogexample_post_comment_comments_mm',
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
		'related_posts' => array(
			'exclude' => 0,
			'label' => 'LLL:EXT:Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.related_posts',
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_genesezblogexample_domain_model_post',
				'MM' => 'tx_genesezblogexample_post_post_related_posts_mm',
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
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
