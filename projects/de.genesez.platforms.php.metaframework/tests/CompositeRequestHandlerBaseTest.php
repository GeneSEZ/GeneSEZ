<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/HandlerInfo.php';
require_once 'Mfw/CompositeRequestHandler.php';
require_once 'Mfw/CompositeRequestHandlerBase.php';
require_once 'Mfw/DtoBase.php';

/**
 * Tests the composite request handler to call 'handle' on all request handlers
 * and verifies the 'dto' returned.
 * @author dreamer
 */
class CompositeRequestHandlerBaseTest extends PHPUnit_Framework_TestCase {
	private $crh;
	private $rh1;
	private $rh2;
	private $crh2;
	private $dto1;
	private $dto2;
	private $dto3;
	
	protected function setUp() {
		$this->rh1 = $this->getMock('Mfw_RequestHandler');
		$this->rh2 = $this->getMock('Mfw_RequestHandler');
		$this->crh2 = $this->getMock('Mfw_CompositeRequestHandler');
		$this->dto1 = new Mfw_DtoBase(array('dto1' => 'value'), 'test');
		$this->dto2 = new Mfw_DtoBase(array('dto2' => 'value'), 'test');
		$this->dto3 = new Mfw_DtoBase(array('dto3' => 'value'), 'test');
	}
	
	public function testInstantiation() {
		$this->crh = new Mfw_CompositeRequestHandlerBase(array(
			'rh1' => $this->rh1, 'rh2' => $this->rh2, 'crh2' => $this->crh2
		));
		$this->assertEquals(3, count($this->crh->nestedRequestHandler->iterator()), 'there should be 3 nested request handlers');
	}
	
	public function testHandleCall() {
		$this->testInstantiation();
		$this->rh1->expects($this->once())->method('handle')->will($this->returnValue($this->dto1));
		$this->rh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto2));
		$this->crh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto3));
		$this->crh->handle(new Mfw_HandlerInfo(new Mfw_Context('/'), '/', '/'));
	}
	
	public function testHandleReturnValue() {
		$this->testInstantiation();
		$this->rh1->expects($this->once())->method('handle')->will($this->returnValue($this->dto1));
		$this->rh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto2));
		$this->crh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto3));
		$dto = $this->crh->handle(new Mfw_HandlerInfo(new Mfw_Context('/'), '/', '/'));
		$this->assertType('Mfw_DtoBase', $dto, 'dto should be an array');
		$this->assertEquals(3, count($dto), 'dto should have 3 values');
		$this->assertType('Mfw_DtoBase', $dto->rh1, 'dto should contain dto1');
		$this->assertType('Mfw_DtoBase', $dto->rh2, 'dto should contain dto2');
		$this->assertType('Mfw_DtoBase', $dto->crh2, 'dto should contain dto3');
		$this->assertSame($this->dto1, $dto->rh1, 'dto1 should be the same');
		$this->assertSame($this->dto2, $dto->rh2, 'dto2 should be the same');
		$this->assertSame($this->dto3, $dto->crh2, 'dto3 should be the same');
	}
}
?>