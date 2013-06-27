<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszblogexample_domain_model_blog'] = array (
	'ctrl' => $TCA['tx_gszblogexample_domain_model_blog']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'title, description, logo, posts, administrator',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, title, description, logo, posts, administrator'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
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
				'foreign_table' => 'tx_gszblogexample_domain_model_blog',
				'foreign_table_where' => 'AND tx_gszblogexample_domain_model_blog.uid=###REC_FIELD_l10n_parent### AND tx_gszblogexample_domain_model_blog.sys_language_uid IN (-1,0)',
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
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog.title',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297194834410_672839_1711) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				'default' => '',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297194834410_672839_1711) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'description' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog.description',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297194839128_593558_1717) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 80,
				'rows' => 30,
				'eval' => 'required, trim',
				'default' => '',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297194839128_593558_1717) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'logo' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog.logo',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194671553_69571_1516._17_0_1_8a7027a_1302084578939_580833_3407) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'group',
				'internal_type' => 'file',
				'size' => 1,
				'minitems' => 0,
				'maxitems' => 1,
				'allowed' => 'gif,jpg,jpeg,tif,tiff,bmp,pcx,tga,png,pdf,ai',
				'disallowed' => '',
				'max_size' => 3000,
				'show_thumbs' => true,
				'uploadfolder' => 'uploads/pics',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194671553_69571_1516._17_0_1_8a7027a_1302084578939_580833_3407) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'posts' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog.posts',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297195059081_183628_1886) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'inline',
				'foreign_table' => 'tx_gszblogexample_domain_model_post',
				'foreign_field' => 'blog',

				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 0,
				'maxitems' => 999999,
				'multiple' => false,
				'appearance' => array(
					'collapse' => false,
					'levelLinksPosition' => 'top',
					'showSynchronizationLink' => true,
					'showPossibleLocalizationRecords' => true,
					'showAllLocalizationLink' => true
				),
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297195059081_183628_1886) ENABLED START */
				'appearance' => array(
					'collapseAll' => 1,
					'expandSingle' => 1,
				),
				/* PROTECTED REGION END */
			),
		),
		'administrator' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog.administrator',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297195121733_203336_1960) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'fe_users',
				'foreign_table_where' => 'AND sys_language_uid IN (-1,0)',
				'minitems' => 0,
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
							'table'=>'fe_users',
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
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194671553_69571_1516._16_9_8a7027a_1297195121733_203336_1960) ENABLED START */
				'foreign_table_where' => "AND fe_users.tx_extbase_type='Tx_GszBlogExample_Domain_Model_Administrator'",
				'items' => array(
					array('--none--', 0),
				),
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
/* PROTECTED REGION END */

?>
