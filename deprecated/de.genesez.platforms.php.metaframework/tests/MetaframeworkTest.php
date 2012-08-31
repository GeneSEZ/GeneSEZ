<?php
require_once 'PHPUnit/Framework.php';

require_once 'Metaframework.php';
require_once 'Mfw/CorePlugIn.php';
require_once 'Mfw/PlugInBase.php';
require_once 'Mfw/ServiceRegistry.php';
require_once 'Mfw/ArrayServiceRegistry.php';
require_once 'Mfw/ArrayPlugInRegistry.php';
require_once 'Mfw/ArrayExtensionRegistry.php';
require_once 'Mfw/ArrayInterceptorRegistry.php';
require_once 'Mfw/ServiceRegistryLocator.php';
require_once 'Mfw/UrlResolver.php';
require_once 'Mfw/Rendering.php';
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/DtoBase.php';


class MetaframeworkTestClass extends Metaframework {
	public function proceed() {
		parent::proceed();
	}
	public function __get($name) {
		switch ($name) {
			case 'rootContext' : return $this->rootContext;
			case 'plugInRegistry' : return $this->plugInRegistry;
			case 'serviceRegistry' : return $this->serviceRegistry;
			case 'autoloadDirs' : return self::$autoloadDirs;
		}
	}
}

/**
 * Tests the complete request-response cycle by just mocking:
 * - plug-ins and core plug-in
 * - request handlers
 * - rendering to validate dto
 * - url resolver 'pathInfo' method to adjust path info
 * @author dreamer
 */
class MetaframeworkTest extends PHPUnit_Framework_TestCase {
	private $metafw;
	private $core;
	private $plugin1;
	private $plugin2;
	private $serviceRegistry;
	private $plugInRegistry;
	private $extensionRegistry;
	private $interceptorRegistry;
	private $resolver;
	private $locator;
	private $rendering;
	private $rootHandler;
	private $rootDto;
	private $ddmHandler;
	private $ddmDto;
	private $contribution1;
	private $contribution2;
	private $interceptor1;
	private $interceptor2;
	
	protected function setUp() {
		$this->plugInRegistry = new Mfw_ArrayPlugInRegistry();
		$this->extensionRegistry = new Mfw_ArrayExtensionRegistry();
		$this->interceptorRegistry = new Mfw_ArrayInterceptorRegistry();
		$this->locator = new Mfw_ServiceRegistryLocator();
		
		$this->resolver = $this->getMock('Mfw_UrlResolver', array('pathInfo'));
		$this->rendering = $this->getMock('Mfw_Rendering', array('render'));
		$this->rootHandler = $this->getMock('Mfw_RequestHandler');
		$this->rootDto = new Mfw_DtoBase(array('rootDto' => 'root dto value'), 'view');
		
		$this->serviceRegistry = new Mfw_ArrayServiceRegistry();
		$this->serviceRegistry->register('serviceRegistry', $this->serviceRegistry);
		$this->serviceRegistry->register('plugInRegistry', $this->plugInRegistry);
		$this->serviceRegistry->register('extensionRegistry', $this->extensionRegistry);
		$this->serviceRegistry->register('interceptorRegistry', $this->interceptorRegistry);
		$this->serviceRegistry->register('resolver', $this->resolver);
		$this->serviceRegistry->register('locator', $this->locator);
		$this->serviceRegistry->register('rendering', $this->rendering);
		$this->serviceRegistry->register('root.handler', $this->rootHandler);
		
		$this->locator->setServiceRegistry($this->serviceRegistry);
		
		$this->core = $this->getMock('Mfw_CorePlugIn');
		$this->plugin1 = $this->getMock('Mfw_PlugInBase');
		$this->plugin2 = $this->getMock('Mfw_PlugInBase');
		
		$this->ddmHandler = $this->getMock('Mfw_RequestHandler');
		$this->ddmDto = new Mfw_DtoBase(array('ddmDto' => 'ddm dto value'), 'ddm view');
		
		$this->contribution1 = array('one', 'two', 'three');
		$this->contribution2 = array('ddm');
		$this->interceptor1 = $this->getMock('Mfw_Interceptor', array('intercept'));
		$this->interceptor2 = $this->getMock('Mfw_Interceptor', array('intercept'));
		$this->serviceRegistry->register('interceptor1', $this->interceptor1);
		$this->serviceRegistry->register('interceptor2', $this->interceptor2);
	}
	
	/**
	 * Tests the construction using additional plug-in directories.
	 * - asserts that the plug-in directories of the plug-in direcotry are in the autoload directories
	 */
	public function testConstruction() {
		$this->metafw = new MetaframeworkTestClass(array(
			'../de.genesez.platforms.php.metaframework.plugins'
		));
		$this->assertContains(
			'../de.genesez.platforms.php.metaframework.plugins/de.genesez.metaframework.core',
			$this->metafw->autoloadDirs, 'core plugin should be in autoload directory');
		$this->assertContains(
			'../de.genesez.platforms.php.metaframework.plugins/de.genesez.metaframework.ddm',
			$this->metafw->autoloadDirs, 'ddm plugin should be in autoload directory');
		$this->assertContains(
			'../de.genesez.platforms.php.metaframework.plugins/de.genesez.metaframework.util',
			$this->metafw->autoloadDirs, 'util plugin should be in autoload directory');
	}
	
	/**
	 * Tests the initialization of the core plug-in
	 * - ensures method calls on the plug-in
	 */
	public function testInitialization() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', $this->rootHandler)));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		$this->metafw->initialize($this->core);
	}
	
	/**
	 * Tests the initialization of the core plug-in and registration of further plug-ins
	 * - ensures method calls on the plug-ins
	 * - ensures components in service registry
	 * - ensures contributions in extension registry
	 * - ensures interceptors in interceptor registry
	 */
	public function testRegisterPlugIns() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->plugin1->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.util'));
		$this->plugin1->expects($this->once())->method('getContext')->will($this->returnValue(null));
		$this->plugin1->expects($this->once())->method('getComponents')->will($this->returnValue(array()));
		$this->plugin1->expects($this->once())->method('getExtensions')->will($this->returnValue(
			array('de.genesez.metaframework.core.menu' => $this->contribution1)));
		$this->plugin1->expects($this->once())->method('getInterceptors')->will($this->returnValue(
			array('/*/' => 'interceptor1')));
		
		$this->plugin2->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.ddm'));
		$this->plugin2->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/ddm', 'ddm.handler')));
		$this->plugin2->expects($this->once())->method('getComponents')->will($this->returnValue(
			array('ddm.handler' => $this->ddmHandler)));
		$this->plugin2->expects($this->once())->method('getExtensions')->will($this->returnValue(
			array('de.genesez.metaframework.core.menu' => $this->contribution2)));
		$this->plugin2->expects($this->once())->method('getInterceptors')->will($this->returnValue(
			array('#/ddm#' => 'interceptor2')));
		
		$this->metafw->initialize($this->core);
		$this->metafw->registerPlugIn($this->plugin1);
		$this->metafw->registerPlugIn($this->plugin2);
		
		$this->assertTrue($this->serviceRegistry->hasComponent('ddm.handler'), 'ddm handler should be registered');
		
		$this->assertTrue($this->extensionRegistry->hasContributions('de.genesez.metaframework.core.menu'), 'contribution should exist');
		$contrib = $this->extensionRegistry->getContributions('de.genesez.metaframework.core.menu');
		$this->assertNotNull($contrib, 'contribution should be not null');
		$this->assertType('array', $contrib, 'contribution should be an array');
		$this->assertEquals(2, count($contrib), 'there should be 2 contributions');
		$this->assertSame($this->contribution1, $contrib[0], 'contribution 1 must match');
		$this->assertSame($this->contribution2, $contrib[1], 'contribution 2 must match');
		
		$it = $this->interceptorRegistry->getIterator();
		$this->assertNotNull($it, 'interceptor iterator should be not null');
		$this->assertType('Iterator', $it, 'interceptor iterator should be an iterator');
		$this->assertEquals(2, count($it), 'there should be 2 interceptors');
		$i1 = $it->current();
		$this->assertSame('/*/', key($i1), 'interceptor pattern 1 should match');
		$this->assertSame('interceptor1', current($i1), 'interceptor 1 should match');
		$it->next();
		
		$this->assertTrue($it->valid(), 'interceptor iterator should be valid');
		$i2 = $it->current();
		$this->assertSame('#/ddm#', key($i2), 'interceptor pattern 1 should match');
		$this->assertSame('interceptor2', current($i2), 'interceptor 2 should match');
	}
	
	/**
	 * Tests the plug-in dependencies after the initialization of the core plug-in and further registration of plug-ins
	 * - ensures method calls on the plug-ins
	 * - ensures components in service registry
	 * - ensures no missing dependencies
	 */
	public function testPlugInDependencies() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->plugin1->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.util'));
		$this->plugin1->expects($this->once())->method('getDependencies')->will($this->returnValue(array('de.genesez.metaframework.core')));
		$this->plugin1->expects($this->once())->method('getContext')->will($this->returnValue(null));
		$this->plugin1->expects($this->once())->method('getComponents')->will($this->returnValue(array()));
		$this->plugin1->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->plugin1->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->plugin2->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.ddm'));
		$this->plugin2->expects($this->once())->method('getDependencies')->will($this->returnValue(array('de.genesez.metaframework.core', 'de.genesez.metaframework.util')));
		$this->plugin2->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/ddm', 'ddm.handler')));
		$this->plugin2->expects($this->once())->method('getComponents')->will($this->returnValue(array('ddm.handler', $this->ddmHandler)));
		$this->plugin2->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->plugin2->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->metafw->initialize($this->core);
		$this->metafw->registerPlugIn($this->plugin1);
		$this->metafw->registerPlugIn($this->plugin2);
		
		$this->assertFalse($this->plugInRegistry->hasMissingDependencies(), 'there should be no missing dependencies');
	}
	
	/**
	 * Tests the call of the root request handler without rendering
	 */
	public function testDefaultHandler() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->core->expects($this->once())->method('finishInitialization');
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$this->rootHandler->expects($this->once())->method('handle')->will($this->returnValue(true));
		$this->rendering->expects($this->never())->method('render');
		
		$this->metafw->initialize($this->core);
		$this->metafw->proceed();
	}
	
	/**
	 * Tests the root request handler with rendering a response
	 */
	public function testDefaultHandlerRendering() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array()));
		
		$this->core->expects($this->once())->method('finishInitialization');
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$this->rootHandler->expects($this->once())->method('handle')->will($this->returnValue($this->rootDto));
		$this->rendering->expects($this->once())->method('render')->with($this->equalTo($this->rootDto));
		
		$this->metafw->initialize($this->core);
		$this->metafw->proceed();
	}
	
	/**
	 * Tests intercepting and proceeding with the root request handler and suppressing the rendering
	 */
	public function testInterceptorDefaultHandler() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array('/.*/' => 'interceptor1')));
		
		$this->core->expects($this->once())->method('finishInitialization');
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$this->interceptor1->expects($this->once())->method('intercept')->will($this->returnValue(false));
		$this->rootHandler->expects($this->once())->method('handle')->will($this->returnValue($this->rootDto));
		$this->rendering->expects($this->once())->method('render')->with($this->equalTo($this->rootDto));
		
		$this->metafw->initialize($this->core);
		$this->metafw->proceed();
	}
	
	/**
	 * Tests intercepting and proceeding with the root request handler and rendering a resonse
	 */
	public function testInterceptorDefaultHandlerRendering() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(
			array('/.*/' => 'interceptor1', '/ddm(.)*/' => 'interceptor2')));
		
		$this->core->expects($this->once())->method('finishInitialization');
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$this->interceptor1->expects($this->once())->method('intercept')->will($this->returnValue(false));
		$this->interceptor2->expects($this->never())->method('intercept');
		$this->rootHandler->expects($this->once())->method('handle')->will($this->returnValue(true));
		$this->rendering->expects($this->never())->method('render');
		
		$this->metafw->initialize($this->core);
		$this->metafw->proceed();
	}
	
	/**
	 * Tests intercepting and aborting the request
	 */
	public function testInterceptorAndAbort() {
		$this->testConstruction();
		$this->core->expects($this->once())->method('getId')->will($this->returnValue('de.genesez.metaframework.core'));
		$this->core->expects($this->once())->method('getDependencies')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getServiceRegistry')->will($this->returnValue($this->serviceRegistry));
		$this->core->expects($this->once())->method('getContext')->will($this->returnValue(new Mfw_Context('/', 'root.handler')));
		$this->core->expects($this->once())->method('getExtensions')->will($this->returnValue(array()));
		$this->core->expects($this->once())->method('getInterceptors')->will($this->returnValue(array('/.*/' => 'interceptor1')));
		
		$this->core->expects($this->once())->method('finishInitialization');
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$this->interceptor1->expects($this->once())->method('intercept')->will($this->returnValue(true));
		$this->rootHandler->expects($this->never())->method('handle');
		$this->rendering->expects($this->never())->method('render');
		
		$this->metafw->initialize($this->core);
		$this->metafw->proceed();
	}
}
?>