<?php
require_once 'PHPUnit/Framework.php';
require_once 'Mfw/Dto.php';
require_once 'Msg/FlashNotifier.php';
require_once 'Mfw/DtoBase.php';
require_once 'Msg/Message.php';

class FlashNotifierTest extends PHPUnit_Framework_TestCase {
	private $notifier;
	private $container;
	private $message;
	
	protected function setUp() {
		$this->container = new ArrayObject();
		$this->message = new Msg_Message('an important test message');
	}
	
	public function testInitialization() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(0, $this->notifier->count(), 'initial count of messages should be zero');
		foreach ($this->notifier as $key) {
			$this->fail('initial count of messages should be zero');
		}
	}
	
	public function testOneMessageExpire() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->notifier->add($this->message, 0);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message');
		
		// test iteration
		$count = 0;
		foreach ($this->notifier as $key) {
			$count++;
		}
		$this->assertEquals(1, $count, 'iteration should be possible over 1 message');
		$this->assertEquals($this->message->message, $this->notifier->offsetGet(0)->message, 'message should be equal');
		
		// test second construction
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(0, $this->notifier->count(), 'notifier should NOT contain a message');
		foreach ($this->notifier as $key) {
			$this->fail('iteration over messages should NOT be possible');
		}
	}
	
	public function testOneMessageNotExpire() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->notifier->add('an important test message', 1);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message');
		
		// test iteration
		$count = 0;
		foreach ($this->notifier as $key) {
			$count++;
		}
		$this->assertEquals(1, $count, 'iteration should be possible over 1 message');
		
		// test second construction
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message');
	}
	
	public function testTwoMessagesSameExpiration() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->notifier->add('an important test message', 0);
		$this->notifier->add('a second message', 0);
		$this->assertEquals(2, $this->notifier->count(), 'notifier should contain 2 message');
		
		// test iteration
		$count = 0;
		foreach ($this->notifier as $key) {
			$count++;
		}
		$this->assertEquals(2, $count, 'iteration should be possible over 2 message');
		
		// test second construction
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(0, $this->notifier->count(), 'notifier should NOT contain a message');
		foreach ($this->notifier as $key) {
			$this->fail('iteration over messages should NOT be possible');
		}
	}
	
	public function testTwoMessagesDifferentExpiration() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$message = 'an important test message';
		$this->notifier->add('an important test message', 1);
		$this->notifier->add('a second message', 0);
		$this->assertEquals(2, $this->notifier->count(), 'notifier should contain 2 message');
		
		// test iteration
		$count = 0;
		foreach ($this->notifier as $key) {
			$count++;
		}
		$this->assertEquals(2, $count, 'iteration should be possible over 2 message');
		
		// test second construction
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message');
		$count = 0;
		foreach ($this->notifier as $key => $value) {
			$count++;
			// check if the one message is the one which should be preserved
			$this->assertEquals($message, $value, 'message text should be equal');
		}
		$this->assertEquals(1, $count, 'iteration should be possible over 1 message');
	}
	
	public function testMessageExpiresLater() {
		$this->notifier = new Msg_FlashNotifier($this->container);
		$message = 'an important test message';
		$this->notifier->add('an important test message', 2);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message with expiration 3');
		
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message with expiration 2');
		
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(1, $this->notifier->count(), 'notifier should contain 1 message with expiration 1');
		
		$this->notifier = new Msg_FlashNotifier($this->container);
		$this->assertEquals(0, $this->notifier->count(), 'message should be removed');
	}
}
?>