<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/ArrayPlugInRegistry.php';

require_once 'Mfw/DefaultCorePlugIn.php';
require_once 'TestPlugIn.php';
require_once 'DdmPlugIn.php';
require_once 'UtilitiesPlugIn.php';


class ArrayPlugInRegistryTest extends PHPUnit_Framework_TestCase {
	private $registry;
	
	protected function setUp() {
		$this->registry = new Mfw_ArrayPlugInRegistry();
	}
	
	public function testNoMissingDependencies() {
		$this->registry->register(new Mfw_DefaultCorePlugIn(array(
				'data.source' => 'pgsql://postgres:postgres@localhost/ddm',
				'smarty.template.dir' => 'view/templates',
				'smarty.compile.dir' => 'view/templates_compiled'
		)));
		$this->registry->register(new UtilitiesPlugIn());
		$this->registry->register(new DdmPlugIn());
		
		$this->assertFalse($this->registry->hasMissingDependencies(), 'there should be no missing dependency');
	}
	
	public function testMissingDependencies() {
		$this->registry->register(new TestPlugIn());
		$this->assertTrue($this->registry->hasMissingDependencies(), 'there should be a missing dependency');
		$missing = $this->registry->getMissingDependencies();
		$this->assertEquals(1, count($missing), 'exactly one dependency should be missed');
		$this->assertEquals('non.existing.plugin', key($missing), 'missing plugin should be non.exising.plugin');
		$dependants = current($missing);
		$this->assertEquals(1, count($dependants), 'exactly one dependant should exist');
		$this->assertEquals('de.genesez.metaframeowork.test', $dependants[0], 'dependant shoul be de.genesez.metaframeowork.test');
	}
	
	public function testBoth() {
		$this->testNoMissingDependencies();
		$this->testMissingDependencies();
	}
}
?>