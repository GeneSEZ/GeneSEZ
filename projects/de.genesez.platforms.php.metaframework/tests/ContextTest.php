<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/Context.php';

class ContextTest extends PHPUnit_Framework_TestCase {
	
	private $root;
	private $context1;
	private $context2;
	private $context1Sub1;
	
	public function testInlineConstruct() {
		$this->root = new Mfw_Context('root', 'roothandler', array(
			new Mfw_Context('s1', 's1h', array(
				new Mfw_Context('s1s1', 's1s1h', array(
					new Mfw_Context('s1s1s1', 's1s1s1h')
				))
			)),
			new Mfw_Context('s2', 's2h')
		));
		$this->assertEquals('root', $this->root->name, 'root context name should be equal');
		$this->assertEquals('roothandler', $this->root->handler, 'root context handler should be equal');
		$this->assertNotNull($this->root->nestedContext, 'association should be accessible');
		$this->assertEquals(2, count($this->root->nestedContext->getAll()), 'root context should have 2 nested contexts');
		$s1 = $this->root->nestedContext->get();
		$s2 = $this->root->nestedContext->get();
		$s12 = $this->root->nestedContext->get();
		$this->assertEquals(1, count($s1->nestedContext->getAll()), 's1 should have 1 nested context');
		$this->assertSame($s1, $s12, 's2 should be every time the same');
		$this->assertSame($this->root, $s1->parent->get(), 'root context should be the same');
		// just 4 info
		$this->assertSame($this->root->nestedContext, $this->root->nestedContext, 'association management object should be the same');
	}
	
	/**
	 * tests the construction of the following url paths:
	 * -> '/', '/context1', '/context2', '/context1/sub1'
	 */
	public function testConstruct() {
		// building contexts
		$this->context1Sub1 = new Mfw_Context('sub1');
		$this->context1 = new Mfw_Context('context1', 'root.context1', array($this->context1Sub1));
		$this->context2 = new Mfw_Context('context2');
		$this->root = new Mfw_Context('', 'root', array(
			$this->context1, $this->context2
		));
		// assigning handlers not assigned in constructor
		$this->context2->handler = 'root.context2';
		// context structure is automatically build by association library
	}
	
	/**
	 * tests access to the root context
	 */
	public function testRootContext() {
		$this->testConstruct();
		$context = $this->root->resolveContext(array());
		$this->assertEquals('root', $context->handler, 'root context not found!');
	}
	/**
	 * tests access to a context directly below root context
	 */
	public function testSubContext() {
		$this->testConstruct();
		$ch = $this->root->resolveContext(array('context1'));
		$this->assertEquals('root.context1', $ch->handler, '/context1 not found!');
	}
	/**
	 * tests access to a second context directly below root context
	 */
	public function testTwoSubContexts() {
		$this->testConstruct();
		$ch = $this->root->resolveContext(array('context2'));
		$this->assertEquals('root.context2', $ch->handler, '/context2 not found!');
	}
	/**
	 * tests access to a sub context
	 */
	public function testSubSubContext() {
		$this->testConstruct();
		$this->context1Sub1->handler = 'root.context1.sub1';
		$ch = $this->root->resolveContext(array('context1', 'sub1'));
		$this->assertEquals('root.context1.sub1', $ch->handler, '/context1/sub1 not found!');
	}
	/**
	 * tests access to a sub context with handler fallback
	 */
	public function testSubSubContextFallback() {
		$this->testConstruct();
		$ch = $this->root->resolveContext(array('context1', 'sub1'));
		$this->assertEquals('root.context1', $ch->handler, '/context1/sub1 fallback not found!');
	}
	/**
	 * tests access to an invalid context
	 */
	public function testInvalidSubContext() {
		$this->testConstruct();
		$ch = $this->root->resolveContext(array('blub'));
		$this->assertEquals('root', $ch->handler, 'invalid context check!');
	}
	/**
	 * tests access to an invalid sub context
	 */
	public function testInvalidSubSubContext() {
		$this->testConstruct();
		$ch = $this->root->resolveContext(array('context1', 'blub'));
		$this->assertEquals('root.context1', $ch->handler, 'invalid sub context not found!');
	}
	/**
	 * tests access to a context with a same name but different location
	 */
	public function testSameContextName() {
		$this->testConstruct();
		$test = new Mfw_Context('sub1');
		$test->handler = 'root.context1.sub1.sub1';
		$this->context1Sub1->nestedContext->insert($test);
		$ch = $this->root->resolveContext(array('context1', 'sub1', 'sub1'));
		$this->assertEquals('root.context1.sub1.sub1', $ch->handler, 'context with same name + different location not found!');
	}
	
	public function testToString() {
		$this->testConstruct();
		$this->assertEquals('/', $this->root->__toString(), 'root toString() should be /');
		$this->assertEquals('/context1', $this->context1->__toString(), '/context1 toString() should match');
		$this->assertEquals('/context2', $this->context2->__toString(), '/context2 toString() should match');
		$this->assertEquals('/context1/sub1', $this->context1Sub1->__toString(), '/context1/sub1 should match');
	}
}
?>