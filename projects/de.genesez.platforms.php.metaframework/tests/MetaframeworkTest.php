<?php
require_once 'Loader/CoreModuleLoader.php';

require_once 'MetaframeworkTestClass.php';
require_once 'TestModuleLoader.php';
require_once 'DdmModuleLoader.php';
require_once 'UtilitiesModuleLoader.php';

class MetaframeworkTest extends PHPUnit_Framework_TestCase {
	private $metafw;
	
	protected function setUp() {
		$this->metafw = new MetaframeworkTestClass();
	}
	
	public function testConstruction() {
		$this->assertNotNull($this->metafw, 'metafw object should not be null');
		$this->assertEquals(0, count($this->metafw->modules), 'there should be no registered module');
		$this->metafw->registerModuleLoaders(array(
			'de.genesez.platforms.php.metaframework.core' => new Loader_CoreModuleLoader(array(
				'data.source' => 'pgsql://postgres:postgres@localhost/ddm',
				'smarty.template.dir' => 'view/templates',
				'smarty.compile.dir' => 'view/templates_compiled'
			)),
			'de.genesez.platforms.php.metaframework.util' => new UtilitiesModuleLoader(),
			'de.genesez.platforms.php.ddm' => new DdmModuleLoader()
		));
		$this->assertEquals(3, count($this->metafw->modules), 'there should be 3 registered modules');
		$this->assertTrue(array_key_exists('de.genesez.platforms.php.metaframework.core', $this->metafw->modules), 'core plug-in should be registered');
		$this->assertTrue(array_key_exists('de.genesez.platforms.php.metaframework.util', $this->metafw->modules), 'util plug-in should be registered');
		$this->assertTrue(array_key_exists('de.genesez.platforms.php.ddm', $this->metafw->modules), 'ddm plug-in should be registered');
	}
	
	public function testContext() {
		$this->testConstruction();
		$this->metafw->buildContainer();
		
		$ddm = $this->metafw->rootContext->nestedContext->getAll();
		$this->assertEquals(1, count($ddm), 'root context should have 1 nested context');
		$subs = $ddm[0]->nestedContext->getAll();
		$this->assertEquals(4, count($subs), 'ddm context should have 4 nested contexts');
	}
	
	public function testComponents() {
		$this->testConstruction();
		$this->metafw->buildContainer();
		
		$this->assertTrue($this->metafw->container->hasComponent('dispatcher'), 'component dispatcher should exist');
		$this->assertTrue($this->metafw->container->hasComponent('smarty'), 'component smarty should exist');
		$this->assertTrue($this->metafw->container->hasComponent('renderer'), 'component renderer should exist');
		$this->assertTrue($this->metafw->container->hasComponent('notifier'), 'component flash notifier should exist');
		
		$this->assertTrue($this->metafw->container->hasComponent('classFormAdapter'), 'component classFormAdapter should exist');
	}
	
	public function testModuleDependenciesFail() {
		$this->testConstruction();
		$this->metafw->registerModuleLoader('test.module.loader', new TestModuleLoader());
		$this->setExpectedException('Exception');
		$this->metafw->checkPlugIns();
	}
}
?>