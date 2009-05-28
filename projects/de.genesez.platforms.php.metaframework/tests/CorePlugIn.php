<?php
require_once 'Mfw/CorePlugin.php';
require_once 'Mfw/PluginBase.php';

class CorePlugIn extends Mfw_PlugInBase implements Mfw_CorePlugIn {
	public function getId() {
		return 'de.genesez.metaframework.core';
	}
	public function getComponents() {
		return array();
	}
	public function getServiceRegistry() {
		return null;
	}
}
?>