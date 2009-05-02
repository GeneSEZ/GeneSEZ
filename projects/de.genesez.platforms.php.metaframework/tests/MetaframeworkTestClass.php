<?php
require_once 'Metaframework.php';

class MetaframeworkTestClass extends Metaframework {
	public function buildContainer() {
		parent::buildContainer();
	}
	public function checkPlugIns() {
		parent::checkPlugIns();
	}
	public function __get($name) {
		switch ($name) {
			case 'container' : return $this->container;
			case 'modules' : return $this->modules;
			case 'rootContext' : return $this->rootContext;
			case 'autoloadDirs' : return self::$autoloadDirs;
		}
	}
}
?>