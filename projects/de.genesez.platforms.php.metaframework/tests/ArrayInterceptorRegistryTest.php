<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/ArrayInterceptorRegistry.php';

class ArrayInterceptorRegistryTest extends PHPUnit_Framework_TestCase {
	private $registry;
	private $interceptor1;
	private $interceptor2;
	
	protected function setUp() {
		$this->registry = new Mfw_ArrayInterceptorRegistry();
		$this->interceptor1 = $this->getMock('Mfw_Interceptor');
		$this->interceptor2 = $this->getMock('Mfw_Interceptor');
	}
	
	public function testRegister() {
		$this->registry->register('bla', $this->interceptor1);
		$this->registry->register('blabla', $this->interceptor2);
		$it = $this->registry->getIterator();
		$pi1 = $it->current();
		$this->assertType('array', $pi1);
		$this->assertEquals('bla', key($pi1), 'pattern should match');
		$this->assertSame($this->interceptor1, current($pi1), 'interceptor should be the same');
		$it->next();
		$pi2 = $it->current();
		$this->assertType('array', $pi2);
		$this->assertEquals('blabla', key($pi2), 'pattern should match');
		$this->assertSame($this->interceptor2, current($pi2), 'interceptor should be the same');
		$it->next();
		$this->assertFalse($it->valid(), 'iterator should be no longer valid');
	}
}
?>