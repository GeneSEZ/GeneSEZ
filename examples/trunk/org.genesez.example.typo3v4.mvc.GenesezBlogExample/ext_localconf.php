<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'BlogAdmin',
	array(
		'Blog' => 'new, create, delete, deleteAll, edit, update, populate', 
		'Post' => 'new, create, delete, edit, update', 
		'Comment' => 'delete'
	),
	array(
		'Blog' => 'create, delete, deleteAll, edit, update, populate', 
		'Post' => 'create, delete, update', 
		'Comment' => 'delete'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'BlogList',
	array(
		'Blog' => 'index'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'PostList',
	array(
		'Post' => 'index'
	),
	array(
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

Tx_Extbase_Utility_Extension::configurePlugin(
	$_EXTKEY,
	'PostSingle',
	array(
		'Post' => 'show', 
		'Comment' => 'create'
	),
	array(
		'Comment' => 'create'
	),
	Tx_Extbase_Utility_Extension::PLUGIN_TYPE_PLUGIN
);

if (TYPO3_MODE === 'BE') {
	/* PROTECTED REGION ID(ext_localconf.php.own.command.controller.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	// TODO: put your further command controller code implementations here
	/* PROTECTED REGION END */
}

/* PROTECTED REGION ID(ext_localconf.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

?>
