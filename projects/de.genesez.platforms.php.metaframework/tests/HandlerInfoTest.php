<?php
require_once 'Mfw/HandlerInfo.php';

class HandlerInfoTest extends PHPUnit_Framework_TestCase {
	private $context;
	private $handlerinfo;
	
	protected function setUp() {
		$this->context = new Mfw_Context('root', 'roothandler', array(
			new Mfw_Context('s1', 's1h', array(
				new Mfw_Context('s1s1', 's1s1h', array(
					new Mfw_Context('s1s1s1', 's1s1s1h')
				))
			)),
			new Mfw_Context('s2', 's2h')
		));
		
		$this->handlerinfo = new Mfw_HandlerInfo($this->context, '/path/info', '');
	}
	
	public function testContext() {
		$this->assertSame($this->context, $this->handlerinfo->context, 'context should be the same');
	}
	
	public function testHandler() {
		$this->assertSame($this->context->handler, $this->handlerinfo->handler, 'handler should be the same');
	}
	
	public function testPathInfo() {
		$pathparts = $this->handlerinfo->pathInfo;
		$this->assertEquals(2, count($pathparts), 'there should be 2 path parts');
		$this->assertEquals('path', $pathparts[0], '1st entry should be: path');
		$this->assertEquals('info', $pathparts[1], '2nd entry should be: info');
	}
	
	public function testArrayAccess() {
		$this->assertEquals('path', $this->handlerinfo[0], '1st entry should be: path');
		$this->assertEquals('info', $this->handlerinfo[1], '2nd entry should be: info');
	}
}
?>