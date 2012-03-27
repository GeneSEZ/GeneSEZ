<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszblogexample_domain_model_person'] = array (
	'ctrl' => $TCA['tx_gszblogexample_domain_model_person']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'firstname, lastname, email',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, firstname, lastname, email'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
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
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			),
		),
		'firstname' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_person.firstname',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195018250_223483_1822) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195018250_223483_1822) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'lastname' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_person.lastname',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195022106_236274_1828) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195022106_236274_1828) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'email' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_person.email',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195023966_726243_1834) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194783571_373089_1631._16_9_8a7027a_1297195023966_726243_1834) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
/* PROTECTED REGION END */

?>
