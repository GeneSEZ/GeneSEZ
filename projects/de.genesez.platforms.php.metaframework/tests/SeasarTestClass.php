<?php
class SeasarTestClass {
	private $constructorArgument1;
	private $constructorArgument2;
	private $setterArgument1;
	
	public function __construct(SeasarTestClass $arg1, SeasarTestClass $arg2) {
		$this->constructorArgument1 = $arg1;
		$this->constructorArgument2 = $arg2;
	}
	
	public function setSeasarTestClass(SeasarTestClass $arg1) {
		$this->setterArgument1 = $arg1;
	}
	
	public function getConstructorArgument1() {
		return $this->constructorArgument1;
	}
	public function getConstructorArgument2() {
		return $this->constructorArgument2;
	}
	public function getSetterArgument1() {
		return $this->setterArgument1;
	}
}
?>