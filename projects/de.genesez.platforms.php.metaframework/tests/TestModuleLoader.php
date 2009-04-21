<?php
require_once 'Loader/InvisibleModuleLoader.php';

class TestModuleLoader extends Loader_InvisibleModuleLoader {
	public function getComponents() {
		return array();
	}
	public function hasModuleDependencies() {
		return true;
	}
	public function getModuleDependencies() {
		return array('non.existing.module');
	}
}
?>