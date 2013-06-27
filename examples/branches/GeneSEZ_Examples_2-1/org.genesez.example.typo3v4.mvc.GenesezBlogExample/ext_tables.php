<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

t3lib_div::loadTCA('tt_content');

// These dividers are a little trick to group these items in the plugin selector
$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('GszBlogExample', '--div--', t3lib_extMgm::extRelPath($_EXTKEY) . 'ext_icon.gif');

/**
 * Blog admin plugin
 */
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'BlogAdmin',
	'Admin Plugin (GeneSEZ Blog Example)'
);

/**
 * Blog list plugin
 */
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'BlogList',
	'List of Blogs (GeneSEZ Blog Example)',
	t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/blogList.gif'
);

$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_excludelist']['gszblogexample_bloglist'] = 'select_key';
$GLOBALS['TCA']['tt_content']['types']['list']['subtypes_addlist']['gszblogexample_bloglist'] = 'pi_flexform,recursive';
t3lib_extMgm::addPiFlexFormValue('gszblogexample_bloglist', 'FILE:EXT:gsz_blog_example/Configuration/FlexForms/flexform_bloglist.xml');

/**
 * Post list plugin
 */
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'PostList',
	'List of Posts (GeneSEZ Blog Example)'
);

/**
 * Post single plugin
 */
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'PostSingle',
	'Single Post (GeneSEZ Blog Example)'
);

$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('', '--div--');

/* PROTECTED REGION ID(ext_tables.php.own.plugins.code.implementation.eee_1045467100313_135436_1) ENABLED START */
/* PROTECTED REGION END */

if (TYPO3_MODE === 'BE') {
	
	/**
	 * Register a backend module
	 */
	Tx_Extbase_Utility_Extension::registerModule(
		$_EXTKEY,
		'web',
		'tx_gszblogexample_m1',
		'',
		array(
			'Blog' => 'index, new, create, delete, deleteAll, edit, update, populate', 
			'Post' => 'index, show, new, create, delete, edit, update', 
			'Comment' => 'create, delete, deleteAll'
		),
		array(
			'access' => 'user, group',
			'icon' => 'EXT:gsz_blog_example/ext_icon.gif',
			'labels' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_mod_m1.xml',
			/* PROTECTED REGION ID(ext_tables.php.own.module.configuration.code.implementation._17_0_1_8a7027a_1311230284135_564264_2275) ENABLED START */
			/* PROTECTED REGION END */
		)
	);
	
	/* PROTECTED REGION ID(ext_tables.php.own.modules.code.implementation.eee_1045467100313_135436_1) ENABLED START */
	/* PROTECTED REGION END */
}

t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GszBlogExample setup');

/* PROTECTED REGION ID(ext_tables.php.own.typoscript.code.implementation.eee_1045467100313_135436_1) ENABLED START */
t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript/DefaultStyles', 'GszBlogExample CSS Styles (optional)');
/* PROTECTED REGION END */

t3lib_extMgm::addLLrefForTCAdescr('tx_gszblogexample_domain_model_blog', 'EXT:gsz_blog_example/Resources/Private/Language/locallang_csh_tx_gszblogexample_domain_model_blog.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszblogexample_domain_model_blog');
$TCA['tx_gszblogexample_domain_model_blog'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_blog',
		'label'	=> 'title',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Blog.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszblogexample_domain_model_blog.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._16_9_8a7027a_1297194671553_69571_1516) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszblogexample_domain_model_comment', 'EXT:gsz_blog_example/Resources/Private/Language/locallang_csh_tx_gszblogexample_domain_model_comment.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszblogexample_domain_model_comment');
$TCA['tx_gszblogexample_domain_model_comment'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_comment',
		'label'	=> 'date',
		'label_alt' => 'author',
		'label_alt_force' => true,
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Comment.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszblogexample_domain_model_comment.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._16_9_8a7027a_1297194777757_325505_1605) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszblogexample_domain_model_person', 'EXT:gsz_blog_example/Resources/Private/Language/locallang_csh_tx_gszblogexample_domain_model_person.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszblogexample_domain_model_person');
$TCA['tx_gszblogexample_domain_model_person'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_person',
		'label'	=> 'lastname',
		'label_alt' => 'firstname',
		'label_alt_force' => true,
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Person.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszblogexample_domain_model_person.gif',
		'prependAtCopy' => 'LLL:EXT:lang/locallang_general.xml:LGL.prependAtCopy',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._16_9_8a7027a_1297194783571_373089_1631) ENABLED START */
		// You can define the 'prependAtCopy' setting as alternative here, if you do not like to define it inside the model.
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszblogexample_domain_model_post', 'EXT:gsz_blog_example/Resources/Private/Language/locallang_csh_tx_gszblogexample_domain_model_post.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszblogexample_domain_model_post');
$TCA['tx_gszblogexample_domain_model_post'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_post',
		'label'	=> 'title',
		'label_alt' => 'author',
		'label_alt_force' => true,
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'versioningWS' => 2,
		'versioning_followPages' => true,
		'origUid' => 't3_origuid',
		'languageField'	=> 'sys_language_uid',
		'transOrigPointerField' => 'l10n_parent',
		'transOrigDiffSourceField' => 'l10n_diffsource',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Post.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszblogexample_domain_model_post.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._16_9_8a7027a_1297194790786_915555_1655) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
t3lib_extMgm::addLLrefForTCAdescr('tx_gszblogexample_domain_model_tag', 'EXT:gsz_blog_example/Resources/Private/Language/locallang_csh_tx_gszblogexample_domain_model_tag.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_gszblogexample_domain_model_tag');
$TCA['tx_gszblogexample_domain_model_tag'] = array (
	'ctrl' => array (
		'title' => 'LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:tx_gszblogexample_domain_model_tag',
		'label'	=> 'name',
		'tstamp' => 'tstamp',
		'crdate' => 'crdate',
		'delete' => 'deleted',
		'enablecolumns' => array(
			'disabled' => 'hidden',
		),
		'dynamicConfigFile' => t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Tag.php',
		'iconfile' => t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_gszblogexample_domain_model_tag.gif',
		/* PROTECTED REGION ID(ext_tables.php.own.tca.ctrl.section.code.implementation._16_9_8a7027a_1297194795235_681189_1679) ENABLED START */
		/* PROTECTED REGION END */
	)
);
	
/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
t3lib_div::loadTCA('fe_users');
if (is_array($TCA['fe_users']['columns']['tx_extbase_type'])) {
	$TCA['fe_users']['types']['Tx_GszBlogExample_Domain_Model_Administrator'] = $TCA['fe_users']['types']['0'];
	array_push($TCA['fe_users']['columns']['tx_extbase_type']['config']['items'], array('LLL:EXT:gsz_blog_example/Resources/Private/Language/locallang_db.xml:fe_users.tx_extbase_type.Tx_GszBlogExample_Domain_Model_Administrator', 'Tx_GszBlogExample_Domain_Model_Administrator'));
}
/* PROTECTED REGION END */

?>
