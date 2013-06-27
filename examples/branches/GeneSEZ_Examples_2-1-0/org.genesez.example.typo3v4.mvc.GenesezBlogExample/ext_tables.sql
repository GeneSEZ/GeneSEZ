#
# Table structure for table 'tx_gszblogexample_domain_model_blog'
#
CREATE TABLE tx_gszblogexample_domain_model_blog (
	uid int(11) NOT NULL auto_increment,
	pid int(11) DEFAULT '0' NOT NULL,
	
	title varchar(255) DEFAULT '' NOT NULL,
	description text NOT NULL,
	logo tinyblob NOT NULL,
	posts int(11) unsigned DEFAULT '0' NOT NULL,
	administrator int(11) unsigned DEFAULT '0' NOT NULL,
	
	tstamp int(11) unsigned DEFAULT '0' NOT NULL,
	crdate int(11) unsigned DEFAULT '0' NOT NULL,
	deleted tinyint(4) unsigned DEFAULT '0' NOT NULL,
	hidden tinyint(4) unsigned DEFAULT '0' NOT NULL,
	
	sys_language_uid int(11) DEFAULT '0' NOT NULL,
	l10n_parent int(11) DEFAULT '0' NOT NULL,
	l10n_diffsource mediumblob NOT NULL,
	
	t3ver_oid int(11) DEFAULT '0' NOT NULL,
	t3ver_id int(11) DEFAULT '0' NOT NULL,
	t3ver_wsid int(11) DEFAULT '0' NOT NULL,
	t3ver_label varchar(30) DEFAULT '' NOT NULL,
	t3ver_state tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_stage tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_count int(11) DEFAULT '0' NOT NULL,
	t3ver_tstamp int(11) DEFAULT '0' NOT NULL,
	t3ver_move_id int(11) DEFAULT '0' NOT NULL,
	t3_origuid int(11) DEFAULT '0' NOT NULL,
	
	PRIMARY KEY (uid),
	KEY parent (pid),
	KEY t3ver_oid (t3ver_oid,t3ver_wsid),
);

#
# Table structure for table 'tx_gszblogexample_domain_model_comment'
#
CREATE TABLE tx_gszblogexample_domain_model_comment (
	uid int(11) NOT NULL auto_increment,
	pid int(11) DEFAULT '0' NOT NULL,
	
	date int(11) DEFAULT '0' NOT NULL,
	author varchar(255) DEFAULT '' NOT NULL,
	email varchar(255) DEFAULT '' NOT NULL,
	content text NOT NULL,
	
	tstamp int(11) unsigned DEFAULT '0' NOT NULL,
	crdate int(11) unsigned DEFAULT '0' NOT NULL,
	deleted tinyint(4) unsigned DEFAULT '0' NOT NULL,
	hidden tinyint(4) unsigned DEFAULT '0' NOT NULL,
	
	PRIMARY KEY (uid),
	KEY parent (pid),
);

#
# Table structure for table 'tx_gszblogexample_domain_model_person'
#
CREATE TABLE tx_gszblogexample_domain_model_person (
	uid int(11) NOT NULL auto_increment,
	pid int(11) DEFAULT '0' NOT NULL,
	
	firstname varchar(255) DEFAULT '' NOT NULL,
	lastname varchar(255) DEFAULT '' NOT NULL,
	email varchar(255) DEFAULT '' NOT NULL,
	
	tstamp int(11) unsigned DEFAULT '0' NOT NULL,
	crdate int(11) unsigned DEFAULT '0' NOT NULL,
	deleted tinyint(4) unsigned DEFAULT '0' NOT NULL,
	hidden tinyint(4) unsigned DEFAULT '0' NOT NULL,
	
	t3ver_oid int(11) DEFAULT '0' NOT NULL,
	t3ver_id int(11) DEFAULT '0' NOT NULL,
	t3ver_wsid int(11) DEFAULT '0' NOT NULL,
	t3ver_label varchar(30) DEFAULT '' NOT NULL,
	t3ver_state tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_stage tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_count int(11) DEFAULT '0' NOT NULL,
	t3ver_tstamp int(11) DEFAULT '0' NOT NULL,
	t3ver_move_id int(11) DEFAULT '0' NOT NULL,
	t3_origuid int(11) DEFAULT '0' NOT NULL,
	
	PRIMARY KEY (uid),
	KEY parent (pid),
	KEY t3ver_oid (t3ver_oid,t3ver_wsid),
);

#
# Table structure for table 'tx_gszblogexample_domain_model_post'
#
CREATE TABLE tx_gszblogexample_domain_model_post (
	uid int(11) NOT NULL auto_increment,
	pid int(11) DEFAULT '0' NOT NULL,
	
	title varchar(255) DEFAULT '' NOT NULL,
	date int(11) DEFAULT '0' NOT NULL,
	content text NOT NULL,
	blog int(11) unsigned DEFAULT '0' NOT NULL,
	author int(11) unsigned DEFAULT '0' NOT NULL,
	tags int(11) unsigned DEFAULT '0' NOT NULL,
	comments int(11) unsigned DEFAULT '0' NOT NULL,
	related_posts int(11) unsigned DEFAULT '0' NOT NULL,
	
	tstamp int(11) unsigned DEFAULT '0' NOT NULL,
	crdate int(11) unsigned DEFAULT '0' NOT NULL,
	deleted tinyint(4) unsigned DEFAULT '0' NOT NULL,
	hidden tinyint(4) unsigned DEFAULT '0' NOT NULL,
	
	sys_language_uid int(11) DEFAULT '0' NOT NULL,
	l10n_parent int(11) DEFAULT '0' NOT NULL,
	l10n_diffsource mediumblob NOT NULL,
	
	t3ver_oid int(11) DEFAULT '0' NOT NULL,
	t3ver_id int(11) DEFAULT '0' NOT NULL,
	t3ver_wsid int(11) DEFAULT '0' NOT NULL,
	t3ver_label varchar(30) DEFAULT '' NOT NULL,
	t3ver_state tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_stage tinyint(4) DEFAULT '0' NOT NULL,
	t3ver_count int(11) DEFAULT '0' NOT NULL,
	t3ver_tstamp int(11) DEFAULT '0' NOT NULL,
	t3ver_move_id int(11) DEFAULT '0' NOT NULL,
	t3_origuid int(11) DEFAULT '0' NOT NULL,
	
	PRIMARY KEY (uid),
	KEY parent (pid),
	KEY t3ver_oid (t3ver_oid,t3ver_wsid),
);

#
# Table structure for table 'tx_gszblogexample_domain_model_tag'
#
CREATE TABLE tx_gszblogexample_domain_model_tag (
	uid int(11) NOT NULL auto_increment,
	pid int(11) DEFAULT '0' NOT NULL,
	
	name varchar(255) DEFAULT '' NOT NULL,
	
	tstamp int(11) unsigned DEFAULT '0' NOT NULL,
	crdate int(11) unsigned DEFAULT '0' NOT NULL,
	deleted tinyint(4) unsigned DEFAULT '0' NOT NULL,
	hidden tinyint(4) unsigned DEFAULT '0' NOT NULL,
	
	PRIMARY KEY (uid),
	KEY parent (pid),
);

#
# Table structure for table 'tx_gszblogexample_domain_model_administrator'
#
CREATE TABLE fe_users (
	tx_extbase_type varchar(255) DEFAULT '' NOT NULL,
	
	
);

#
# Intermediate table structure for table 'tx_gszblogexample_post_tag_tags_mm'
#
CREATE TABLE tx_gszblogexample_post_tag_tags_mm (
	uid_local int(11) unsigned DEFAULT '0' NOT NULL,
	uid_foreign int(11) unsigned DEFAULT '0' NOT NULL,
	sorting int(11) unsigned DEFAULT '0' NOT NULL,
	
	KEY uid_local (uid_local),
	KEY uid_foreign (uid_foreign)
);

#
# Intermediate table structure for table 'tx_gszblogexample_post_comment_comments_mm'
#
CREATE TABLE tx_gszblogexample_post_comment_comments_mm (
	uid_local int(11) unsigned DEFAULT '0' NOT NULL,
	uid_foreign int(11) unsigned DEFAULT '0' NOT NULL,
	sorting int(11) unsigned DEFAULT '0' NOT NULL,
	
	KEY uid_local (uid_local),
	KEY uid_foreign (uid_foreign)
);

#
# Intermediate table structure for table 'tx_gszblogexample_post_post_related_posts_mm'
#
CREATE TABLE tx_gszblogexample_post_post_related_posts_mm (
	uid_local int(11) unsigned DEFAULT '0' NOT NULL,
	uid_foreign int(11) unsigned DEFAULT '0' NOT NULL,
	sorting int(11) unsigned DEFAULT '0' NOT NULL,
	
	KEY uid_local (uid_local),
	KEY uid_foreign (uid_foreign)
);

# PROTECTED REGION ID(ext_tables.sql.own.sql.declaration.eee_1045467100313_135436_1) ENABLED START
# PROTECTED REGION END
