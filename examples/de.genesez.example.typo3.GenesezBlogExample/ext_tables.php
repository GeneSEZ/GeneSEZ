<?php

if (!defined ('TYPO3_MODE')) {
	die ('Access denied.');
}

t3lib_div::loadTCA('tt_content');

// These dividers are a little trick to group these items in the plugin selector
$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('GenesezBlogExample', '--div--', t3lib_extMgm::extRelPath($_EXTKEY) . 'ext_icon.gif');

Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'BlogAdmin',
	'Admin Plugin (BlogExample)',
	t3lib_extMgm::extRelPath($_EXTKEY) . ''
);
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'BlogList',
	'List of Blogs (BlogExample)',
	t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/blogList.gif'
);
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'PostList',
	'List of Posts (BlogExample)',
	t3lib_extMgm::extRelPath($_EXTKEY) . ''
);
Tx_Extbase_Utility_Extension::registerPlugin(
	$_EXTKEY,
	'PostSingle',
	'Single Post (BlogExample)',
	t3lib_extMgm::extRelPath($_EXTKEY) . ''
);

$TCA['tt_content']['columns']['list_type']['config']['items'][] = array('', '--div--');

if (TYPO3_MODE === 'BE') {
}

t3lib_extMgm::addStaticFile($_EXTKEY, 'Configuration/TypoScript', 'GenesezBlogExample setup');

t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_administrator', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_administrator.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_administrator');
$TCA['tx_genesezblogexample_domain_model_administrator'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_administrator',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Administrator.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_administrator.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_blog', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_blog.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_blog');
$TCA['tx_genesezblogexample_domain_model_blog'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_blog',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Blog.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_blog.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_comment', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_comment.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_comment');
$TCA['tx_genesezblogexample_domain_model_comment'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_comment',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Comment.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_comment.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_person', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_person.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_person');
$TCA['tx_genesezblogexample_domain_model_person'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_person',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Person.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_person.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_post', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_post.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_post');
$TCA['tx_genesezblogexample_domain_model_post'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_post',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Post.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_post.gif'
	)
);
t3lib_extMgm::addLLrefForTCAdescr('tx_genesezblogexample_domain_model_tag', 'EXT:genesez_blog_example/Resources/Private/Language/locallang_csh_tx_genesezblogexample_domain_model_tag.xml');
t3lib_extMgm::allowTableOnStandardPages('tx_genesezblogexample_domain_model_tag');
$TCA['tx_genesezblogexample_domain_model_tag'] = array (
	'ctrl' => array (
		'title'						=> 'LLL:EXT:genesez_blog_example/Resources/Private/Language/locallang_db.xml:tx_genesezblogexample_domain_model_tag',
		'label'						=> 'uid',
		'tstamp'					=> 'tstamp',
		'crdate'					=> 'crdate',
		'versioningWS'				=> 2,
		'versioning_followPages'	=> true,
		'origUid'					=> 't3_origuid',
		'languageField'				=> 'sys_language_uid',
		'transOrigPointerField'		=> 'l18n_parent',
		'transOrigDiffSourceField'	=> 'l18n_diffsource',
		'delete'					=> 'deleted',
		'enablecolumns'				=> array(
			'disabled'				=> 'hidden',
			'starttime'				=> 'starttime',
			'endtime'				=> 'endtime',
			),
		'dynamicConfigFile' 		=> t3lib_extMgm::extPath($_EXTKEY) . 'Configuration/TCA/Tag.php',
		'iconfile' 					=> t3lib_extMgm::extRelPath($_EXTKEY) . 'Resources/Public/Icons/tx_genesezblogexample_domain_model_tag.gif'
	)
);


/* PROTECTED REGION ID(ext_tables.php.own.code.implementation.eee_1045467100313_135436_1) ENABLED START */
// TODO: put your further code implementations here
/* PROTECTED REGION END */

?>
