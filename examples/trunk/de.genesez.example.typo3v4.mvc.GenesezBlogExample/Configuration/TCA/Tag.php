<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszblogexample_domain_model_tag'] = array (
	'ctrl' => $TCA['tx_gszblogexample_domain_model_tag']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'name',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, name'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
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
		'name' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_tag.name',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._16_9_8a7027a_1297194795235_681189_1679._16_9_8a7027a_1297194910826_608649_1757) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'required, trim',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._16_9_8a7027a_1297194795235_681189_1679._16_9_8a7027a_1297194910826_608649_1757) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		/* PROTECTED REGION ID(tca.php.own.tca.columns.section.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
		/* PROTECTED REGION END */
	),
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
/* PROTECTED REGION END */

?>
