<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/ArrayPlugInRegistry.php';
require_once 'Mfw/CorePlugIn.php';
require_once 'Mfw/PlugInBase.php';

/**
 * Tests the array based plug-in registry
 * - verifies the (simple) algorithm to determine missing dependencies
 * @author dreamer
 */
class ArrayPlugInRegistryTest extends PHPUnit_Framework_TestCase {
	private $registry;
	private $corePlugIn;
	private $ddmPlugIn;
	private $utilPlugIn;
	private $testPlugIn;
	private $nonExistingPlugIn;
	
	protected function setUp() {
		$this->registry = new Mfw_ArrayPlugInRegistry();
		$this->corePlugIn = $this->getMock('Mfw_CorePlugIn');
		$this->ddmPlugIn = $this->getMock('Mfw_PlugInBase');
		$this->utilPlugIn = $this->getMock('Mfw_PlugInBase');
		$this->nonExistingPlugIn = $this->getMock('Mfw_PlugInBase');
		$this->testPlugIn = $this->getMock('Mfw_PlugInBase');
	}
	
	public function testNoMissingDependencies() {
		$this->corePlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->corePlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->ddmPlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.ddm'));
		$this->ddmPlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array(
			'de.genesez.metaframework.core',
			'de.genesez.metaframework.util'
		)));
		$this->utilPlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.util'));
		$this->utilPlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		
		$this->registry->register($this->utilPlugIn);
		$this->registry->register($this->corePlugIn);
		$this->registry->register($this->ddmPlugIn);
		
		$this->assertFalse($this->registry->hasMissingDependencies(), 'there should be no missing dependency');
	}
	
	public function testMissingDependencies() {
		$this->testPlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframeowork.test'));
		$this->testPlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array(
			'non.existing.plugin'
		)));
		
		$this->registry->register($this->testPlugIn);
		$this->assertTrue($this->registry->hasMissingDependencies(), 'there should be a missing dependency');
		$missing = $this->registry->getMissingDependencies();
		$this->assertEquals(1, count($missing), 'exactly one dependency should be missed');
		$this->assertEquals('non.existing.plugin', key($missing), 'missing plugin should be non.exising.plugin');
		$dependants = current($missing);
		$this->assertEquals(1, count($dependants), 'exactly one dependant should exist');
		$this->assertEquals('de.genesez.metaframeowork.test', $dependants[0], 'dependant shoul be de.genesez.metaframeowork.test');
	}
	
	public function testReCheckPlugIns() {
		$this->testPlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframeowork.test'));
		$this->testPlugIn->expects($this->exactly(2))->method('getDependencies')->will($this->returnValue(array(
			'non.existing.plugin'
		)));
		$this->nonExistingPlugIn->expects($this->once())->method('getId')->will($this->returnValue('non.existing.plugin'));
		$this->nonExistingPlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		
		$this->registry->register($this->testPlugIn);
		$this->assertTrue($this->registry->hasMissingDependencies(), 'there should be a missing dependency');
		
		$this->registry->register($this->nonExistingPlugIn);
		$this->assertFalse($this->registry->hasMissingDependencies(), 'there should be no missing dependency');
	}
	
	public function testReCheckPlugInsWithoutHas() {
		$this->testPlugIn->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframeowork.test'));
		$this->testPlugIn->expects($this->exactly(2))->method('getDependencies')->will($this->returnValue(array(
			'non.existing.plugin'
		)));
		$this->nonExistingPlugIn->expects($this->once())->method('getId')->will($this->returnValue('non.existing.plugin'));
		$this->nonExistingPlugIn->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		
		$this->registry->register($this->testPlugIn);
		$this->assertTrue($this->registry->hasMissingDependencies(), 'there should be a missing dependency');
		
		$this->registry->register($this->nonExistingPlugIn);
		$missing = $this->registry->getMissingDependencies();
		$this->assertEquals(0, count($missing), 'there should be no missing dependency');
	}
}
?>