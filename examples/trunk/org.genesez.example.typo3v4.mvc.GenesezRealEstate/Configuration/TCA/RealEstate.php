<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszrealestate_domain_model_realestate'] = array (
	'ctrl' => $TCA['tx_gszrealestate_domain_model_realestate']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'id, title, description, facility, state, miscellaneous, street, post_code, town, size, cellar, attic, balcony, free_from, rent_exclusive_of_heating, extra_charges, cooperative_share, image_files, image_descriptions, plot_file, heating, floor, rooms, quarter',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'sys_language_uid, hidden, starttime, endtime, id, title, description, facility, state, miscellaneous, street, post_code, town, size, cellar, attic, balcony, free_from, rent_exclusive_of_heating, extra_charges, cooperative_share, image_files, image_descriptions, plot_file, heating, floor, rooms, quarter'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
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
				'foreign_table' => 'tx_gszrealestate_domain_model_realestate',
				'foreign_table_where' => 'AND tx_gszrealestate_domain_model_realestate.uid=###REC_FIELD_l10n_parent### AND tx_gszrealestate_domain_model_realestate.sys_language_uid IN (-1,0)',
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
		'id' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.id',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344311023_125369_2516) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344311023_125369_2516) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'title' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.title',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344329234_724244_2528) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344329234_724244_2528) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'description' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.description',
			'defaultExtras' => 'richtext',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344338260_54760_2540) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 40,
				'rows' => 15,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344338260_54760_2540) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'facility' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.facility',
			'defaultExtras' => 'richtext',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344346620_23744_2546) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 40,
				'rows' => 15,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344346620_23744_2546) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'state' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.state',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344853713_942081_2662) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344853713_942081_2662) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'miscellaneous' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.miscellaneous',
			'defaultExtras' => 'richtext',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344537579_307823_2572) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 40,
				'rows' => 15,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344537579_307823_2572) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'street' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.street',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345662515_198376_2780) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345662515_198376_2780) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'post_code' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.post_code',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345679126_180874_2794) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345679126_180874_2794) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'town' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.town',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345685255_706531_2800) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345685255_706531_2800) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'size' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.size',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344573020_305929_2584) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'double2',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344573020_305929_2584) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'cellar' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.cellar',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344705425_251719_2648) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'check',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344705425_251719_2648) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'attic' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.attic',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1307459446558_564136_1703) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'check',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1307459446558_564136_1703) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'balcony' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.balcony',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344718799_502755_2654) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'check',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306344718799_502755_2654) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'free_from' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.free_from',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345020231_382102_2675) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345020231_382102_2675) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'rent_exclusive_of_heating' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.rent_exclusive_of_heating',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345383803_875220_2687) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'double2',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345383803_875220_2687) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'extra_charges' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.extra_charges',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345447811_920827_2701) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'double2',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345447811_920827_2701) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'cooperative_share' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.cooperative_share',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345512395_979506_2711) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'double2',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345512395_979506_2711) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'image_files' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.image_files',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345601685_339237_2746) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'group',
				'internal_type' => 'file',
				'size' => 5,
				'minitems' => 0,
				'maxitems' => 20,
				'allowed' => 'gif,jpg,jpeg,tif,tiff,bmp,pcx,tga,png,pdf,ai',
				'disallowed' => '',
				'show_thumbs' => true,
				'uploadfolder' => 'uploads/tx_gszrealestate',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345601685_339237_2746) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'image_descriptions' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.image_descriptions',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345609242_759487_2752) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 40,
				'rows' => 5,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345609242_759487_2752) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'plot_file' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.plot_file',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345642374_803727_2769) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'group',
				'internal_type' => 'file_reference',
				'size' => 1,
				'minitems' => 0,
				'maxitems' => 1,
				'allowed' => 'pdf',
				'disallowed' => 'php',
				'show_thumbs' => true,
				'uploadfolder' => 'uploads/tx_gszrealestate',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345642374_803727_2769) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'heating' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.heating',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812558337_418332_2175) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_heatingtype',
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
							'table'=>'tx_gszrealestate_domain_model_heatingtype',
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
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812558337_418332_2175) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'floor' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.floor',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812570157_801267_2183) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_floortype',
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
							'table'=>'tx_gszrealestate_domain_model_floortype',
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
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812570157_801267_2183) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'rooms' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.rooms',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812581356_61946_2191) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_roomtype',
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
							'table'=>'tx_gszrealestate_domain_model_roomtype',
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
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_3_8a7027a_1331812581356_61946_2191) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'quarter' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_real_estate/Resources/Private/Language/locallang_db.xml:tx_gszrealestate_domain_model_realestate.quarter',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345972681_339929_3020) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'select',
				'foreign_table' => 'tx_gszrealestate_domain_model_quarter',
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
							'table'=>'tx_gszrealestate_domain_model_quarter',
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
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_1_8a7027a_1306345972681_339929_3020) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
/* PROTECTED REGION END */

?>
