<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezblogexample_domain_model_tag'] = array (
	'ctrl' => $TCA['tx_genesezblogexample_domain_model_tag']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'name',
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, name'),
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
		'name' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_tag.name',
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'trim',
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
/* PROTECTED REGION END */

?>
