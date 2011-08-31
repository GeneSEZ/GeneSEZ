<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_post'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_post']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'title, date, content, blog, author, tags, comments, related_posts',
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, title, date, content, blog, author, tags, comments, related_posts'),
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
				'foreign_table' => 'tx_genesezblogexample_domain_model_post',
				'foreign_table_where' => 'AND tx_genesezblogexample_domain_model_post.uid=###REC_FIELD_l10n_parent### AND tx_genesezblogexample_domain_model_post.sys_language_uid IN (-1,0)',
			)
		),
		'l10n_diffsource' => array(
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
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.title',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'date' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.date',
			'config' => array(
			)
		),
		'content' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.content',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'blog' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.blog',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezblogexample_domain_model_blog',
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
		'author' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.author',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezblogexample_domain_model_person',
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
		'tags' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.tags',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezblogexample_domain_model_tag',
				'foreign_sortby' => 'sorting',
				'MM' => 'tx_genesezblogexample_post_tag_tags_mm',
				'minitems' => 0,
				'maxitems' => 99999,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
		'comments' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.comments',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezblogexample_domain_model_comment',
				'foreign_sortby' => 'sorting',
				'MM' => 'tx_genesezblogexample_comment_comments_post_mm',
				'minitems' => 0,
				'maxitems' => 99999,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				)
			)
		),
		'related_posts' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post.related_posts',
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_genesezblogexample_domain_model_post',
				'foreign_sortby' => 'sorting',
				'MM' => 'tx_genesezblogexample_post_related_posts_post_mm',
				'minitems' => 0,
				'maxitems' => 99999,
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

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
/* PROTECTED REGION END */

?>
