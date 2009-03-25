<?php
require_once 'core/Context.php';
class ContextTest extends PHPUnit_Framework_TestCase {
	private $context;
	
	public function testConstruction() {
		$this->context = new Core_Context('root', 'roothandler', array(
			new Core_Context('s1', 's1h', array(
				new Core_Context('s1s1', 's1s1h', array(
					new Core_Context('s1s1s1', 's1s1s1h')
				))
			)),
			new Core_Context('s2', 's2h')
		));
//		$this->assertEquals('root', $this->context->name, 'root context name should be equal');
		$this->assertEquals('roothandler', $this->context->handler, 'root context handler should be equal');
		$this->assertEquals(2, count($this->context->nestedContext->getAll()), 'root context should have 2 nested contexts');
		$s1 = $this->context->nestedContext->get();
		$s2 = $this->context->nestedContext->get();
		$s12 = $this->context->nestedContext->get();
		$this->assertEquals(1, count($s1->nestedContext->getAll()), 's1 should have 1 nested context');
		$this->assertSame($s1, $s12, 's2 should be every time the same');
		$this->assertSame($this->context, $s1->parent->get(), 'root context should be the same');
		// just 4 info
		$this->assertSame($this->context->nestedContext, $this->context->nestedContext, 'association management object should be the same');
	}
}
?>