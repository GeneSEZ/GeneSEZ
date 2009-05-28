<?php
require_once 'PHPUnit/Framework.php';
require_once 'MetaframeworkTestClass.php';

require_once 'TestPlugIn.php';
require_once 'DdmPlugIn.php';
require_once 'UtilitiesPlugIn.php';

require_once 'Mfw/DefaultCorePlugIn.php';


class MetaframeworkTest extends PHPUnit_Framework_TestCase {
	private $metafw;
	private $core;
	
	protected function setUp() {
		$this->core = new Mfw_DefaultCorePlugIn(array(
			'data.source' => 'pgsql://postgres:postgres@localhost/ddm',
			'smarty.template.dir' => 'view/templates',
			'smarty.compile.dir' => 'view/templates_compiled'
		));
		$this->metafw = new MetaframeworkTestClass($this->core);
	}
	
	public function testConstruction() {
		$this->assertNotNull($this->metafw, 'metafw object should not be null');
		$this->metafw->registerPlugIns(array(
			new UtilitiesPlugIn(),
			new DdmPlugIn()
		));
		$this->assertFalse($this->metafw->plugInRegistry->hasMissingDependencies(), 'there should be no missing dependency');
	}
	
	public function testContext() {
		$this->testConstruction();
		
		$ddm = $this->metafw->rootContext->nestedContext->getAll();
		$this->assertEquals(1, count($ddm), 'root context should have 1 nested context');
		$subs = $ddm[0]->nestedContext->getAll();
		$this->assertEquals(4, count($subs), 'ddm context should have 4 nested contexts');
	}
	
	public function testComponents() {
		$this->testConstruction();
		
		$this->assertTrue($this->metafw->serviceRegistry->hasComponent('dispatcher'), 'component dispatcher should exist');
		$this->assertTrue($this->metafw->serviceRegistry->hasComponent('smarty'), 'component smarty should exist');
		$this->assertTrue($this->metafw->serviceRegistry->hasComponent('renderer'), 'component renderer should exist');
		$this->assertTrue($this->metafw->serviceRegistry->hasComponent('notifier'), 'component flash notifier should exist');
		
		$this->assertTrue($this->metafw->serviceRegistry->hasComponent('classFormAdapter'), 'component classFormAdapter should exist');
	}
	
	public function testAutoloadDirs() {
		$mfw = new MetaframeworkTestClass($this->core, array('../de.genesez.platforms.php.metaframework.modules'));
		$dirs = $mfw->autoloadDirs;
//		print_r($dirs);
//		$this->assertContains('de.genesez.modules.ddm', $dirs, 'ddm module dir should be contained');
//		$this->assertContains('de.genesez.modules.util', $dirs, 'ddm module dir should be contained');
	}
}
?>