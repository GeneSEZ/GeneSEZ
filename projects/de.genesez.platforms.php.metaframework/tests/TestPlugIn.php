<?php
require_once 'Mfw/PluginBase.php';

class TestPlugIn extends Mfw_PlugInBase {
	public function getId() {
		return 'de.genesez.metaframeowork.test';
	}
	public function getComponents() {
		return array();
	}
	public function hasDependencies() {
		return true;
	}
	public function getDependencies() {
		return array('non.existing.plugin');
	}
}
?>