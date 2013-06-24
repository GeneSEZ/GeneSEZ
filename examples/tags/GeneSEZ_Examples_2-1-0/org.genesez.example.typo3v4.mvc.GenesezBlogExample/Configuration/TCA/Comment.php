<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszblogexample_domain_model_comment'] = array (
	'ctrl' => $TCA['tx_gszblogexample_domain_model_comment']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'date, author, email, content',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, date, author, email, content'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
		/* PROTECTED REGION END */
	),
	'columns' => array(
		'hidden' => array(
			'exclude' => true,
			'label'	=> 'LLL:EXT:lang/locallang_general.xml:LGL.hidden',
			'config' => array(
				'type' => 'check',
			),
		),
		'date' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_comment.date',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194777757_325505_1605._16_9_8a7027a_1297194923795_300153_1767) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 12,
				'eval' => 'required, datetime',
				'default' => time(),
				'checkbox' => 1,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194777757_325505_1605._16_9_8a7027a_1297194923795_300153_1767) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'author' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_comment.author',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194777757_325505_1605._17_0_1_8a7027a_1302084243420_785018_3332) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194777757_325505_1605._17_0_1_8a7027a_1302084243420_785018_3332) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'email' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_comment.email',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194777757_325505_1605._17_0_1_8a7027a_1302084262597_392423_3338) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194777757_325505_1605._17_0_1_8a7027a_1302084262597_392423_3338) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'content' => array(
			'exclude' => true,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_comment.content',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194777757_325505_1605._16_9_8a7027a_1297194945347_857717_1785) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 80,
				'rows' => 30,
				'eval' => 'trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194777757_325505_1605._16_9_8a7027a_1297194945347_857717_1785) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
/* PROTECTED REGION END */

?>
