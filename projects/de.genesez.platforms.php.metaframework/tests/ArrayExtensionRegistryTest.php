<?php
require_once 'PHPUnit/Framework.php';
require_once 'Core/ArrayExtensionRegistry.php';

class ArrayExtensionRegistryTest extends PHPUnit_Framework_TestCase {
	private $registry;
	private $simpleContribution;
	private $arrayContribution;
	private $objectContribution;
	
	protected function setUp() {
		$this->registry = new Core_ArrayExtensionRegistry();
		$this->simpleContribution = 'contribution';
		$this->arrayContribution = array('one', 'two' => 'two', 'three');
		$this->objectContribution = new Core_ArrayExtensionRegistry();
	}
	
	public function testEmptyRegistry() {
		$this->assertFalse($this->registry->hasContribution('bla'), 'registry should have no contribution');
	}
	
	public function testWrongContributionName() {
		$this->assertFalse($this->registry->hasContribution(null), 'null contribution should not exist');
		$this->assertFalse($this->registry->hasContribution(''), 'empty contribution should not exist');
	}
	
	public function testSimpleContribution() {
		$this->registry->registerContribution('bla', $this->simpleContribution);
		$this->assertTrue($this->registry->hasContribution('bla'), 'contribution should exist');
		$contrib = $this->registry->getContribution('bla');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testArrayContribution() {
		$this->registry->registerContribution('bla', $this->arrayContribution);
		$this->assertTrue($this->registry->hasContribution('bla'), 'contribution should exist');
		$contrib = $this->registry->getContribution('bla');
		$this->assertSame($this->arrayContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testObjectContribution() {
		$this->registry->registerContribution('bla', $this->objectContribution);
		$this->assertTrue($this->registry->hasContribution('bla'), 'contribution should exist');
		$contrib = $this->registry->getContribution('bla');
		$this->assertSame($this->objectContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testContributions() {
		$this->registry->registerContribution('bla', $this->simpleContribution);
		$this->registry->registerContribution('bla', $this->objectContribution);
		$this->registry->registerContribution('bla', $this->arrayContribution);
		$this->registry->registerContribution('simple', $this->simpleContribution);
		$this->registry->registerContribution('object', $this->objectContribution);
		$this->registry->registerContribution('array', $this->arrayContribution);
		$this->assertTrue($this->registry->hasContribution('bla'), 'contribution should exist');
		$this->assertTrue($this->registry->hasContribution('simple'), 'simple contribution should exist');
		$this->assertTrue($this->registry->hasContribution('object'), 'object contribution should exist');
		$this->assertTrue($this->registry->hasContribution('array'), 'array contribution should exist');
		$contrib = $this->registry->getContribution('bla');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
		$this->assertSame($this->objectContribution, $contrib[1], 'contribution should be the same');
		$this->assertSame($this->arrayContribution, $contrib[2], 'contribution should be the same');
		$contrib = $this->registry->getContribution('simple');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
		$contrib = $this->registry->getContribution('object');
		$this->assertSame($this->objectContribution, $contrib[0], 'contribution should be the same');
		$contrib = $this->registry->getContribution('array');
		$this->assertSame($this->arrayContribution, $contrib[0], 'contribution should be the same');
	}
}
?>