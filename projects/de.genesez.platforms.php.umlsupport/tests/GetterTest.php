<?php
require_once 'tests/Hub.php';
require_once 'tests/Related.php';

/**
 * Tests the getter accessor methods {@link Hub::__get()} and {@link Related::__get()}
 * which are used to obtain the association handling objects
 * 
 * @author toh
 * @version 2009-03-08
 */
class GetterTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related;
	
	/**
	 * initializes the instance variables for testing
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->related = new Related();
	}
	
	/**
	 * Test method for {@link Hub::__get()}
	 * 
	 * Tests the getter accessor of the class {@link Hub} for 
	 * the <b>unidirectional to one association</b> to class {@link Related}
	 * @see Hub::$unidiToOneRelated
	 */
	public function testHubUniDiToOneAssociation() {
		$object = $this->hub->unidiToOneRelated;
		$this->assertNotNull($object, 'association object should not be null');
		$this->assertTrue($object instanceof UML_Association, 'association object should be an instance of the Association interface');
		$this->assertEquals('UML_OneAssociation', get_class($object), 'association object should be an OneAssociation');
	}
	
	/**
	 * Test method for {@link Hub::__get()}
	 * 
	 * Tests the getter accessor of the class {@link Hub} for
	 * the <b>bidirectional to one association</b> to class {@link Related}
	 * @see Hub::$bidiOneToOneRelated
	 */
	public function testHubBiDiOneToOneAssociation() {
		$object = $this->hub->bidiOneToOneRelated;
		$this->assertNotNull($object, 'association object should not be null');
		$this->assertTrue($object instanceof UML_Association, 'association object should be an instance of the Association interface');
		$this->assertEquals('UML_OneAssociation', get_class($object), 'association object should be an OneAssociation');
	}
	
	/**
	 * Test method for {@link Hub::__get()}
	 * 
	 * Tests the getter accessor of the class {@link Hub} for an <b>non existing or inaccessible</b> property
	 */
	public function testHubNonExistingAssociation() {
		$this->setExpectedException('Exception');
		$object = $this->hub->notExistingAssociation;
	}
	
	/**
	 * Test method for {@link Related::__get()}
	 * 
	 * Tests the getter accessor of the class {@link Related} for
	 * the <b>bidirectional to one association</b> to class {@link Hub}
	 * @see Related::$bidiOneToOneHub
	 */
	public function testRelatedBiDiOneToOneAssociation() {
		$object = $this->related->bidiOneToOneHub;
		$this->assertNotNull($object, 'association object should not be null');
		$this->assertTrue($object instanceof UML_Association, 'association object should be an instance of the Association interface');
		$this->assertEquals('UML_OneAssociation', get_class($object), 'association object should be an OneAssociation');
	}
	
	/**
	 * Test method for {@link Related::__get()}
	 * 
	 * Tests the getter accessor of the class {@link Related} for <b>an non existing or inaccessible</b> property
	 */
	public function testRelatedNonExistingAssociation() {
		$this->setExpectedException('Exception');
		$object = $this->related->notExistingAssociation;
	}
}
?>