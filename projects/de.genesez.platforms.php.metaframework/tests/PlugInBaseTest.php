<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/PlugInBase.php';

/**
 * Just test the default implementation of the plug-in interface
 * @author dreamer
 */
class PlugInBaseTest extends PHPUnit_Framework_TestCase {
	private $plugin;
	
	protected function setUp() {
		$this->plugin = $this->getMock('Mfw_PlugInBase', array('getId'));
		$this->plugin->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.test'));
	}
	
	public function testDefaultImpl() {
		$this->assertEquals('de.genesez.metaframework.test', $this->plugin->getId(), 'id must match');
		$this->assertEquals(0, count($this->plugin->getComponents()), 'no components');
		$this->assertEquals(null, $this->plugin->getContext(), 'no context');
		$this->assertEquals(0, count($this->plugin->getDependencies()), 'no dependencies');
		$this->assertEquals(0, count($this->plugin->getExtensions()), 'no extensions');
		$this->assertEquals(0, count($this->plugin->getInterceptors()), 'no interceptors');
	}
}
?>