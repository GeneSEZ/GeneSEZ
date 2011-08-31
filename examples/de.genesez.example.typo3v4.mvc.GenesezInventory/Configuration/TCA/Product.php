<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

$TCA['tx_genesezinventory_domain_model_product'] = array (
	'ctrl' => $TCA['tx_genesezinventory_domain_model_product']['ctrl'],
	'interface' => array(
		'showRecordFieldList' => 'name, description, quantity',
	),
	'types' => array(
		'1' => array('showitem'	=> 'hidden, name, description, quantity'),
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
			'label' => 'LLL:EXT:genesez_inventory/Resources/Private/Language/locallang_db.xml:tx_genesezinventory_domain_model_product.name',
			'config' => array(
				'type' => 'input',
				'size' => 20,
				'eval' => 'trim, required',
			)
		),
		'description' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_inventory/Resources/Private/Language/locallang_db.xml:tx_genesezinventory_domain_model_product.description',
			'config' => array(
				'type' => 'text',
				'cols' => 30,
				'rows' => 5,
				'eval' => 'trim',
			)
		),
		'quantity' => array(
			'exclude' => false,
			'label' => 'LLL:EXT:genesez_inventory/Resources/Private/Language/locallang_db.xml:tx_genesezinventory_domain_model_product.quantity',
			'config' => array(
				'type' => 'input',
				'size' => 4,
				'eval' => 'int',
			)
		),
	)
);

/* PROTECTED REGION ID(tca.php.own.code.implementation._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
/* PROTECTED REGION END */

?>
