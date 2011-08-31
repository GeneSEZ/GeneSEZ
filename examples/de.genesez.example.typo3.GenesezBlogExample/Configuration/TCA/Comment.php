<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_comment'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_comment']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'date, author, email, content',
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, date, author, email, content'),
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
		'date' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_comment.date',
			'config' => array(
			)
		),
		'author' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_comment.author',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'email' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_comment.email',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
		'content' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_comment.content',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
/* PROTECTED REGION END */

?>
