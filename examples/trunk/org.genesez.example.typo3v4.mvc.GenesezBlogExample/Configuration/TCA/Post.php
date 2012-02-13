<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszblogexample_domain_model_post'] = array (
	'ctrl' => $TCA['tx_gszblogexample_domain_model_post']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'title, date, content, blog, author, tags, comments, related_posts',
		'maxDBListItems' => 100,
		'maxSingleDBListItems' => 500,
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, title, date, content, blog, author, tags, comments, related_posts'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
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
				'foreign_table' => 'tx_gszblogexample_domain_model_post',
				'foreign_table_where' => 'AND tx_gszblogexample_domain_model_post.uid=###REC_FIELD_l10n_parent### AND tx_gszblogexample_domain_model_post.sys_language_uid IN (-1,0)',
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
		'title' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.title',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194882955_681374_1735) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194882955_681374_1735) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'date' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.date',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194886910_832299_1741) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 12,
				'eval' => 'required, datetime',
				'default' => time(),
				'checkbox' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194886910_832299_1741) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'content' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.content',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194888091_417284_1747) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 80,
				'rows' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297194888091_417284_1747) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'blog' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.blog',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195059082_239030_1887) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszblogexample_domain_model_blog',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 1,
				'maxitems' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195059082_239030_1887) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'author' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.author',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195253147_828265_2388) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszblogexample_domain_model_person',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 1,
				'maxitems' => 1,
				'wizards' => array(
					'_PADDING' => 1,
					'_VERTICAL' => 1,
					'add' => array(
						'type' => 'script',
						'title' => 'Create new',
						'icon' => 'add.gif',
						'script' => 'wizard_add.php',
						'params' => array(
							'table'=>'tx_gszblogexample_domain_model_person',
							'pid' => '###CURRENT_PID###',
							'setValue' => 'prepend'
						),
					),
					'edit' => array(
						'type' => 'popup',
						'title' => 'Edit',
						'icon' => 'edit2.gif',
						'script' => 'wizard_edit.php',
						'popup_onlyOpenIfSelected' => 1,
						'JSopenParams' => 'height=350,width=580,status=0,menubar=0,scrollbars=1',
					),
				),
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195253147_828265_2388) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'tags' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.tags',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195352189_179879_2445) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_gszblogexample_domain_model_tag',
				'foreign_sortby' => 'sorting',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'MM' => 'tx_gszblogexample_post_tag_tags_mm',
				'minitems' => 0,
				'maxitems' => 9999,
				'multiple' => false,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				),
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195352189_179879_2445) ENABLED START */
				'appearance' => array(
					'useCombination' => 1,
					'useSortable' => 1,
					'collapseAll' => 1,
					'expandSingle' => 1,
				)
				/* PROTECTED REGION END */
			),
		),
		'comments' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.comments',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195402378_449726_2482) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_gszblogexample_domain_model_comment',
				'foreign_sortby' => 'sorting',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'MM' => 'tx_gszblogexample_post_comment_comments_mm',
				'minitems' => 0,
				'maxitems' => 9999,
				'multiple' => false,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				),
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195402378_449726_2482) ENABLED START */
				'appearance' => array(
					'collapseAll' => 1,
					'expandSingle' => 1,
				),
				'size' => 10,
				'autoSizeMax' => 30,
				/* PROTECTED REGION END */
			),
		),
		'related_posts' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post.related_posts',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195445317_889803_2527) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszblogexample_domain_model_post',
				'foreign_sortby' => 'sorting',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'MM' => 'tx_gszblogexample_post_post_related_posts_mm',
				'minitems' => 0,
				'maxitems' => 9999,
				'multiple' => false,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194790786_915555_1655._16_9_8a7027a_1297195445317_889803_2527) ENABLED START */
				'foreign_table_where' => 'AND ###THIS_UID### != tx_gszblogexample_domain_model_post.uid',
				'size' => 10,
				'autoSizeMax' => 30,
				'multiple' => 0,
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
/* PROTECTED REGION END */

?>
