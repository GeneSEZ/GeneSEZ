<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_person'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_person']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'firstname, lastname, email',
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, firstname, lastname, email'),
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
		't3ver_label' => array(
			'displayCond' => 'FIELD:t3ver_label:REQ:true',
			'label' => 'LLL:EXT:lang/locallang_general.php:LGL.versionLabel',
			'config' => array(
				'type' =>'none',
				'cols' => 27,
			)
		),
		'firstname' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_person.firstname',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'lastname' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_person.lastname',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'email' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_person.email',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
/* PROTECTED REGION END */

?>
