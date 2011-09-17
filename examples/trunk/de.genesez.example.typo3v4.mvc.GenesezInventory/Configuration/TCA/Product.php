<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_gszinventory_domain_model_product'] = array (
	'ctrl' => $TCA['tx_gszinventory_domain_model_product']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'name, description, quantity',
		/* PROTECTED REGION ID(tca.php.own.tca.interface.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
	'types' => array(
		'1' => array('showitem'	=> 'name, description, quantity'),
		/* PROTECTED REGION ID(tca.php.own.tca.types.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
	'palettes' => array(
		'1' => array('showitem'	=> ''),
		/* PROTECTED REGION ID(tca.php.own.tca.palettes.section.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
		/* PROTECTED REGION END */
	),
	'columns' => array(
		'name' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_db.xml:tx_gszinventory_domain_model_product.name',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363700126_91538_2293) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 20,
				'eval' => 'required, trim',
				'default' => '',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363700126_91538_2293) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'description' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_db.xml:tx_gszinventory_domain_model_product.description',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363708261_140463_2300) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'text',
				'cols' => 40,
				'rows' => 15,
				'eval' => 'trim',
				'default' => '',
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363708261_140463_2300) ENABLED START */
				/* PROTECTED REGION END */
			),
		),
		'quantity' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_db.xml:tx_gszinventory_domain_model_product.quantity',
			/* PROTECTED REGION ID(tca.php.own.tca.column.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363722856_936956_2307) ENABLED START */
			/* PROTECTED REGION END */
			'config' => array(
				'type' => 'input',
				'size' => 30,
				'eval' => 'int',
				'default' => 0,
				/* PROTECTED REGION ID(tca.php.own.tca.column.config.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363722856_936956_2307) ENABLED START */
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
