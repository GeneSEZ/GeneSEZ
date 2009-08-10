<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/RequestHandler.php';
require_once 'Mfw/DecorateRequestHandler.php';
require_once 'Mfw/DtoBase.php';

/**
 * Helper class implementing abstract method 'decorate' to test decorate request handler
 * @author dreamer
 */
class DecorateRequestHandler extends Mfw_DecorateRequestHandler {
	public function decorate(Mfw_Dto $dto, Mfw_HandlerInfo $handlerInfo) {
		$dto->test = 'testing decoration';
		return $dto;
	}
}

/**
 * Tests the decorate request handler to call 'handle' on all delegate request handlers
 * and verifies the 'dto' returned.
 * @author dreamer
 */
class DecorateRequestHandlerTest extends PHPUnit_Framework_TestCase {
	private $drh;
	private $rh;
	private $rh1;
	private $rh2;
	private $rh3;
	private $dto;
	private $dto1;
	private $dto2;
	private $dto3;
	
	protected function setUp() {
		$this->rh = $this->getMock('Mfw_RequestHandler');
		$this->rh1 = $this->getMock('Mfw_RequestHandler');
		$this->rh2 = $this->getMock('Mfw_RequestHandler');
		$this->rh3 = $this->getMock('Mfw_RequestHandler');
		$this->dto = new Mfw_DtoBase(array('dto' => 'value'), 'test');
		$this->dto1 = new Mfw_DtoBase(array('dto1' => 'value'), 'test');
		$this->dto2 = new Mfw_DtoBase(array('dto2' => 'value'), 'test');
		$this->dto3 = new Mfw_DtoBase(array('dto3' => 'value'), 'test');
	}
	
	public function testInstantiation() {
		$this->drh = new DecorateRequestHandler($this->rh, array(
			'rh1' => $this->rh1, 'rh2' => $this->rh2, 'rh3' => $this->rh3
		));
		$this->assertEquals(3, count($this->drh->nestedRequestHandler->iterator()), 'there should be 3 nested request handlers');
	}
	
	public function testHandleCall() {
		$this->testInstantiation();
		$this->rh->expects($this->once())->method('handle')->will($this->returnValue($this->dto));
		$this->rh1->expects($this->once())->method('handle')->will($this->returnValue($this->dto1));
		$this->rh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto2));
		$this->rh3->expects($this->once())->method('handle')->will($this->returnValue($this->dto3));
		$this->drh->handle(new Mfw_HandlerInfo(new Mfw_Context('/'), '/', '/'));
	}
	
	public function testDecoration() {
		$this->testInstantiation();
		$this->rh->expects($this->once())->method('handle')->will($this->returnValue($this->dto));
		$this->rh1->expects($this->once())->method('handle')->will($this->returnValue($this->dto1));
		$this->rh2->expects($this->once())->method('handle')->will($this->returnValue($this->dto2));
		$this->rh3->expects($this->once())->method('handle')->will($this->returnValue($this->dto3));
		$dto = $this->drh->handle(new Mfw_HandlerInfo(new Mfw_Context('/'), '/', '/'));
		$this->assertEquals(5, count($dto), 'dto should have 5 values');
		
		// check if it is the handler dto
		$this->assertType('Mfw_DtoBase', $dto, 'dto should be an array');
		$this->assertSame($this->dto, $dto, 'dto should be the same');
		
		// check delegate dto's
		$this->assertType('Mfw_DtoBase', $dto->rh1, 'dto should contain dto1');
		$this->assertType('Mfw_DtoBase', $dto->rh2, 'dto should contain dto2');
		$this->assertType('Mfw_DtoBase', $dto->rh3, 'dto should contain dto3');
		$this->assertSame($this->dto1, $dto->rh1, 'dto1 should be the same');
		$this->assertSame($this->dto2, $dto->rh2, 'dto2 should be the same');
		$this->assertSame($this->dto3, $dto->rh3, 'dto3 should be the same');
		
		// check decoration
		$this->assertNotNull($dto->test, 'dto should contain decorated entry');
		$this->assertType('string', $dto->test, 'decorated entry should be a string');
		$this->assertEquals('testing decoration', $dto->test, 'decorated entry should match');
	}
}
?>