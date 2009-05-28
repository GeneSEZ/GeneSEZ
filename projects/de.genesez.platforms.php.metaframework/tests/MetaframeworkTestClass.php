<?php
require_once 'Metaframework.php';

class MetaframeworkTestClass extends Metaframework {
	public function proceed() {
		parent::proceed();
	}
	public function __get($name) {
		switch ($name) {
			case 'rootContext' : return $this->rootContext;
			case 'plugInRegistry' : return $this->plugInRegistry;
			case 'serviceRegistry' : return $this->serviceRegistry;
			case 'autoloadDirs' : return self::$autoloadDirs;
		}
	}
}
?>