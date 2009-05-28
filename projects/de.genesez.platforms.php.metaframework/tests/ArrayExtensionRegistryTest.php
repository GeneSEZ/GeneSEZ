<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/ArrayExtensionRegistry.php';

class ArrayExtensionRegistryTest extends PHPUnit_Framework_TestCase {
	private $registry;
	private $simpleContribution;
	private $arrayContribution;
	private $objectContribution;
	
	protected function setUp() {
		$this->registry = new Mfw_ArrayExtensionRegistry();
		$this->simpleContribution = 'contribution';
		$this->arrayContribution = array('one', 'two' => 'two', 'three');
		$this->objectContribution = new Mfw_ArrayExtensionRegistry();
	}
	
	public function testEmptyRegistry() {
		$this->assertFalse($this->registry->hasContributions('bla'), 'registry should have no contribution');
	}
	
	public function testWrongContributionName() {
		$this->assertFalse($this->registry->hasContributions(null), 'null contribution should not exist');
		$this->assertFalse($this->registry->hasContributions(''), 'empty contribution should not exist');
	}
	
	public function testSimpleContribution() {
		$this->registry->register('bla', $this->simpleContribution);
		$this->assertTrue($this->registry->hasContributions('bla'), 'contribution should exist');
		$contrib = $this->registry->getContributions('bla');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testArrayContribution() {
		$this->registry->register('bla', $this->arrayContribution);
		$this->assertTrue($this->registry->hasContributions('bla'), 'contribution should exist');
		$contrib = $this->registry->getContributions('bla');
		$this->assertSame($this->arrayContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testObjectContribution() {
		$this->registry->register('bla', $this->objectContribution);
		$this->assertTrue($this->registry->hasContributions('bla'), 'contribution should exist');
		$contrib = $this->registry->getContributions('bla');
		$this->assertSame($this->objectContribution, $contrib[0], 'contribution should be the same');
	}
	
	public function testContributions() {
		$this->registry->register('bla', $this->simpleContribution);
		$this->registry->register('bla', $this->objectContribution);
		$this->registry->register('bla', $this->arrayContribution);
		$this->registry->register('simple', $this->simpleContribution);
		$this->registry->register('object', $this->objectContribution);
		$this->registry->register('array', $this->arrayContribution);
		$this->assertTrue($this->registry->hasContributions('bla'), 'contribution should exist');
		$this->assertTrue($this->registry->hasContributions('simple'), 'simple contribution should exist');
		$this->assertTrue($this->registry->hasContributions('object'), 'object contribution should exist');
		$this->assertTrue($this->registry->hasContributions('array'), 'array contribution should exist');
		$contrib = $this->registry->getContributions('bla');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
		$this->assertSame($this->objectContribution, $contrib[1], 'contribution should be the same');
		$this->assertSame($this->arrayContribution, $contrib[2], 'contribution should be the same');
		$contrib = $this->registry->getContributions('simple');
		$this->assertSame($this->simpleContribution, $contrib[0], 'contribution should be the same');
		$contrib = $this->registry->getContributions('object');
		$this->assertSame($this->objectContribution, $contrib[0], 'contribution should be the same');
		$contrib = $this->registry->getContributions('array');
		$this->assertSame($this->arrayContribution, $contrib[0], 'contribution should be the same');
	}
}
?>