<?php
require_once 's2container/S2Container.php';
require_once 'Mfw/SeasarPhpBuilder.php';

require_once 'SeasarTestClass.php';

spl_autoload_register(array('S2ContainerClassLoader', 'load'));
S2ContainerClassLoader::import(S2CONTAINER_PHP5);

class SeasarPhpBuilderTest extends PHPUnit_Framework_TestCase {
	
	private $builder;
	
	protected function setUp() {
		$this->builder = new Mfw_SeasarPhpBuilder();
	}
	
	/**
	 * Tests the construction of a container with three components, constructor and setter injection.
	 * - uses builder to construct a container with components
	 * - verifies if the definitions are set correctly
	 * - note: no components are instantiated and checked
	 * @see Mfw_SeasarPhpBuilder::newContainer()
	 * @see Mfw_SeasarPhpBuilder::newComponent()
	 * @see Mfw_SeasarPhpBuilder::newArgument()
	 * @see Mfw_SeasarPhpBuilder::newProperty()
	 */
	public function testInlineConstruction() {
		$container = $this->builder->newContainer(array(
			$this->builder->newComponent('SeasarTestClass', 'arg1', array(
				$this->builder->newArgument('"constructorArg1"'),
				$this->builder->newArgument('"constructorArg2"')
			), array(
				$this->builder->newProperty('seasarTestClass', '"setter1"')
			)),
			$this->builder->newComponent('SeasarTestClass', 'arg2'),
			$this->builder->newComponent('SeasarTestClass', 'setter1')
		));
		$this->assertNotNull($container, 'the container should not be null');
		$this->assertType('S2Container', $container);
		$this->assertEquals(3, $container->getComponentDefSize());
		// component 1
		$c1 = $container->getComponentDef('arg1');
		$this->assertType('S2Container_ComponentDef', $c1);
		$this->assertType('S2Container_ComponentDefImpl', $c1);
		$this->assertType('ReflectionClass', $c1->getComponentClass(), 'component class should be a reflection class instance');
		$this->assertEquals('SeasarTestClass', $c1->getComponentClass()->getName(), 'class name should be equal');
		$this->assertEquals('arg1', $c1->getComponentName(), 'component name should be equal');
		// constructor arguments
		$this->assertEquals(2, $c1->getArgDefSize(), 'component 1 should have 2 constructor arguments');
		$c1arg1 = $c1->getArgDef(0);
		$c1arg2 = $c1->getArgDef(1);
		$this->assertEquals('constructorArg1', $c1arg1->getValue(), 'constructor argument 1 should be equal');
		$this->assertEquals('constructorArg2', $c1arg2->getValue(), 'constructor argument 2 should be equal');
		// property
		$this->assertEquals(1, $c1->getPropertyDefSize(), 'component 1 should have 1 property');
		$c1prop1 = $c1->getPropertyDef(0);
		$this->assertEquals('seasarTestClass', $c1prop1->getPropertyName(), 'property name should be equal');
		$this->assertEquals('setter1', $c1prop1->getValue(), 'property value should be equal');
		// component 2 + 3
		$c2 = $container->getComponentDef('arg2');
		$this->assertEquals('SeasarTestClass', $c2->getComponentClass()->getName(), 'class name should be equal');
		$this->assertEquals('arg2', $c2->getComponentName(), 'component name should be equal');
		$c3 = $container->getComponentDef('setter1');
		$this->assertEquals('SeasarTestClass', $c3->getComponentClass()->getName(), 'class name should be equal');
		$this->assertEquals('setter1', $c3->getComponentName(), 'component name should be equal');
	}
}
?>