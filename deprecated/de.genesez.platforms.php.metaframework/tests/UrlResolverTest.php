<?php
/**
 * Verifies the implementation of the URL resolver.
 * - it creates a context structure
 * - resolves an handler by an url path
 * - verifies the additional path info passed to the handler
 * 
 * @todo	test the check regexp to verify if a url part is valid
 * @author	dreamer
 */
class UrlResolverTest extends PHPUnit_Framework_TestCase {
	private $resolver;
	
	private $root;
	private $context1;
	private $context2;
	private $context1Sub1;	
	
	protected function setUp() {
		// building contexts
		$this->context1Sub1 = new Mfw_Context('sub1');
		$this->context1 = new Mfw_Context('context1', 'root.context1', array($this->context1Sub1));
		$this->context2 = new Mfw_Context('context2');
		$this->root = new Mfw_Context('', 'root', array(
			$this->context1, $this->context2
		));
		$this->resolver = $this->getMock('Mfw_UrlResolver', array('pathInfo'));
	}
	
	public function testRootContext() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), 'root context path incorrect');
	}
	public function testSubContext() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context1'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), '/context1 path incorrect');
	}
	public function testTwoSubContexts() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context2'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('context2', $handlerinfo[0], '/context2 path incorrect');
	}
	public function testSubSubContextFallback() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context1/sub1'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('sub1', $handlerinfo[0], '/context1/sub1 path incorrect');
	}
	public function testInvalidSubContext() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/blub'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('blub', $handlerinfo[0], '/blub path incorrect');
	}
	public function testInvalidSubSubContext() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context1/blub'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(1, count($handlerinfo->pathInfo), 'should contain 1 entry');
		$this->assertEquals('blub', $handlerinfo[0], '/context1/blub path incorrect');
	}
	public function testSameContextName() {
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context1/sub1/sub1'));
		$test = new Mfw_Context('sub1');
		$test->handler = 'root.context1.sub1.sub1';
		$this->context1Sub1->nestedContext->insert($test);
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(0, count($handlerinfo->pathInfo), '/context1/sub1/sub1 path incorrect');
	}
	public function testUnresolvablePath() {
		$this->root->handler = null;
		$this->resolver->expects($this->once())->method('pathInfo')->will($this->returnValue('/context2/sub1/sub1'));
		$handlerinfo = $this->resolver->resolve($this->root);
		$this->assertEquals(3, count($handlerinfo->pathInfo), '/context1/sub1/sub1 path incorrect');
		$this->assertEquals($this->root, $handlerinfo->context, 'in case of unresolvable paths, the handler info should contain the root context');
	}
}
?>