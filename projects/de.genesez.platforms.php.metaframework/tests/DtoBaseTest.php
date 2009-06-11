<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/DtoBase.php';

class DtoBaseTest extends PHPUnit_Framework_TestCase {
	private $dto;
	
	public function testView() {
		$this->dto = new Mfw_DtoBase(array(), 'view');
		$this->assertEquals('view', $this->dto->view(), 'view should match');
	}
	
	public function testProperties() {
		$this->dto = new Mfw_DtoBase(array(
			'key' => 'value'
		), 'template');
		$this->assertEquals('template', $this->dto->view(), 'view should match');
		$this->assertEquals('value', $this->dto['key'], 'value should match');
		$this->assertEquals('value', $this->dto->key, 'value should match');
	}
}
?>