<?php
require_once 'UriResolverTestClass.php';

class UrlResolverTest extends PHPUnit_Framework_TestCase {
	private $resolver;
	private $dispatcher;
	
	private $root;
	private $context1;
	private $context2;
	private $context1Sub1;	
	
	protected function setUp() {
		$this->dispatcher = $this->getMock('Core_Dispatcher', array('dispatch'));
		// building contexts
		$this->context1Sub1 = new Core_Context('sub1');
		$this->context1 = new Core_Context('context1', 'root.context1', array($this->context1Sub1));
		$this->context2 = new Core_Context('context2');
		$this->root = new Core_Context('', 'root', array(
			$this->context1, $this->context2
		));
		$this->resolver = new UriResolverTestClass();
		$this->resolver->setDispatcher($this->dispatcher);
	}
	
	public function testRootContext() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), 'root context path incorrect');
	}
	public function testSubContext() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context1');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), '/context1 path incorrect');
	}
	public function testTwoSubContexts() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context2');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('context2', $handlerinfo[0], '/context2 path incorrect');
	}
	public function testSubSubContextFallback() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context1/sub1');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('sub1', $handlerinfo[0], '/context1/sub1 path incorrect');
	}
	public function testInvalidSubContext() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/blub');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('blub', $handlerinfo[0], '/blub path incorrect');
	}
	public function testInvalidSubSubContext() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context1/blub');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('blub', $handlerinfo[0], '/context1/blub path incorrect');
	}
	public function testSameContextName() {
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context1/sub1/sub1');
		$test = new Core_Context('sub1');
		$test->handler = 'root.context1.sub1.sub1';
		$this->context1Sub1->nestedContext->insert($test);
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), '/context1/sub1/sub1 path incorrect');
	}
	public function testUnresolvablePath() {
		$this->root->handler = null;
		$this->dispatcher->expects($this->once())->method('dispatch');
		$this->resolver->setPathInfo('/context2/sub1/sub1');
		$handlerinfo = $this->resolver->resolveHandler($this->root);
		$this->assertEquals(3, count($handlerinfo->pathInfo), '/context1/sub1/sub1 path incorrect');
		$this->assertEquals($this->root, $handlerinfo->context, 'in case of unresolvable paths, the handler info should contain the root context');
	}
}
?>