<?php
class User extends Doctrine_Record {
	public function setTableDefinition() {
		$this->hasColumn('login', 'string');
		$this->hasColumn('password', 'string');
		$this->hasColumn('firstName', 'string');
		$this->hasColumn('lastName', 'string');
		$this->hasColumn('email', 'string');

		/* PROTECTED REGION ID(php.doctrine.record.definition._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: further table definitions for class 'User'
		/* PROTECTED REGION END */
	}
	
	public function setUp() {
		/* PROTECTED REGION ID(php.doctrine.record.setUp._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: further setups for class 'User'
		/* PROTECTED REGION END */
	}
}
?>
