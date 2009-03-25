<?php
require_once 'tests/Hub.php';
require_once 'tests/Related.php';

/**
 * Tests the <b>bidirectional one to one association</b> from the class {@link Hub} to the class {@link Related}.
 * The dynamic creation and destruction of links between objects of both classes is subject to test.
 * @see UML_OneAssociation
 * @author toh
 * @version 2009-03-09
 */
class OneAssociationBidiTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related, $related2;
	
	/**
	 * initializes the instance variables needed for testing
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->related = new Related();
		$this->related2 = new Related();
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::insert()} method to insert objects into an association.
	 * - checks the return value of the {@link UML_OneAssociation::insert()} method
	 * @see UML_OneAssociation::insert()
	 */
	public function testInsert() {
		$related = $this->hub->bidiOneToOneRelated->insert($this->related);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::get()} method to get the linked object participating within an association.
	 * - checks the unlinked object states of both objects
	 * - establishes a link between 2 objects using {@link testInsert()}
	 * - checks on both objects using {@link UML_OneAssociation::get()} if the bidirectional link was successfully 
	 *   created and the linked objects are the same
	 * @see UML_OneAssociation::get()
	 */
	public function testGet() {
		$this->assertNull($this->hub->bidiOneToOneRelated->get(), 'no linked related object should exist');
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'no linked hub object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->bidiOneToOneRelated->get(), 'link to related object should exist');
		$this->assertNotNull($this->related->bidiOneToOneHub->get(), 'link to hub object should exist');
		$this->assertEquals($this->related, $this->hub->bidiOneToOneRelated->get(), 'linked related object should be equal');
		$this->assertEquals($this->hub, $this->related->bidiOneToOneHub->get(), 'linked hub object should be equal');
		$this->assertSame($this->related, $this->hub->bidiOneToOneRelated->get(), 'linked related object should be the same');
		$this->assertSame($this->hub, $this->related->bidiOneToOneHub->get(), 'linked hub object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::getAll()} method to get all linked objects
	 * - checks the unlinked object states of both objects
	 * - creates a link between 2 objects using {@link testInsert()}
	 * - checks on both objects using {@link UML_OneAssociation::getAll()} if the bidirectional link was successfully
	 *   created and the linked objects are the same
	 * @see UML_OneAssociation::getAll()
	 */
	public function testGetAll() {
		$this->assertNull($this->hub->bidiOneToOneRelated->get(), 'no linked related object should exist');
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'no linked hub object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->bidiOneToOneRelated->getAll(), 'link to related object should exist');
		$this->assertNotNull($this->related->bidiOneToOneHub->getAll(), 'link to hub object should exist');
		$this->assertEquals(1, count($this->hub->bidiOneToOneRelated->getAll()), 'should be exactly 1 linked related object');
		$this->assertEquals(1, count($this->related->bidiOneToOneHub->getAll()), 'should be exactly 1 linked hub object');
		$related = $this->hub->bidiOneToOneRelated->getAll();
		$this->assertEquals($this->related, $related[0], 'related object should be equal');
		$this->assertSame($this->related, $related[0], 'related object should be the same');
		$hub = $this->related->bidiOneToOneHub->getAll();
		$this->assertEquals($this->hub, $hub[0], 'hub object should be equal');
		$this->assertSame($this->hub, $hub[0], 'hub object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::remove()} method to unlink linked objects
	 * - establishes a bidirectional link between 2 objects using {@link testGet()}
	 * - unlinks the created link using {@link UML_OneAssociation::remove()}
	 * - verifies the return value of {@link UML_OneAssociation::remove()}
	 * - verifies both unlinked object states using {@link UML_OneAssociation::get()} and 
	 *   {@link UML_OneAssociation::getAll()}
	 * @see UML_OneAssociation::remove()
	 */
	public function testRemove() {
		$this->testGet();
		$related = $this->hub->bidiOneToOneRelated->remove($this->related);
		$this->assertNotNull($related, 'returned object should not be null');
		$this->assertEquals($this->related, $related, 'removed object should be equal');
		$this->assertSame($this->related, $related, 'removed object should be the same');
		$this->assertNull($this->hub->bidiOneToOneRelated->get(), 'there should be no linked related object');
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'there should be no linked hub object');
		$this->assertEquals(0, count($this->hub->bidiOneToOneRelated->getAll()), 'should be exactly 0 linked related objects');
		$this->assertEquals(0, count($this->related->bidiOneToOneHub->getAll()), 'should be exactly 0 linked hub objects');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::insert()} method to link an object with an object which
	 * is already linked with another one
	 * - ensures both unlinked object states
	 * - creates a link between 2 objects
	 * - inserts another object into the association of one of the linked objects
	 * - verifies the return value of the {@link UML_OneAssociation::insert()} method
	 * - verifies both linked object states using using {@link UML_OneAssociation::get()} and 
	 *   {@link UML_OneAssociation::getAll()}
	 * - verifies the unlinked object state of the object which was unlinked during {@link UML_OneAssociation::insert()}
	 * @see UML_OneAssociation::insert()
	 */
	public function testInsertAgain() {
		$this->assertNull($this->hub->bidiOneToOneRelated->get(), 'no linked related object should exist');
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'no linked hub object should exist');
		$related = $this->hub->bidiOneToOneRelated->insert($this->related);
		$related = $this->hub->bidiOneToOneRelated->insert($this->related2);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related2, $related, 'inserted object should be equal');
		$this->assertSame($this->related2, $related, 'inserted object should be the same');
		// test get
		$this->assertNotNull($this->hub->bidiOneToOneRelated->get(), 'link to related object should exist');
		$this->assertEquals($this->related2, $this->hub->bidiOneToOneRelated->get(), 'related object should be equal');
		$this->assertSame($this->related2, $this->hub->bidiOneToOneRelated->get(), 'related object should be the same');
		$this->assertNotNull($this->related2->bidiOneToOneHub->get(), 'link to hub object should exist');
		$this->assertEquals($this->hub, $this->related2->bidiOneToOneHub->get(), 'linked hub object should be equal');
		$this->assertSame($this->hub, $this->related2->bidiOneToOneHub->get(), 'linked hub object should be the same');
		// test getAll
		$this->assertNotNull($this->hub->bidiOneToOneRelated->getAll(), 'link to related object should exist');
		$this->assertNotNull($this->related->bidiOneToOneHub->getAll(), 'link to hub object should exist');
		$this->assertEquals(1, count($this->hub->bidiOneToOneRelated->getAll()), 'should be exactly 1 linked related object');
		$this->assertEquals(1, count($this->related2->bidiOneToOneHub->getAll()), 'should be exactly 1 linked hub object');
		$related = $this->hub->bidiOneToOneRelated->getAll();
		$this->assertEquals($this->related2, $related[0], 'related object should be equal');
		$this->assertSame($this->related2, $related[0], 'related object should be the same');
		$hub = $this->related2->bidiOneToOneHub->getAll();
		$this->assertEquals($this->hub, $hub[0], 'hub object should be equal');
		$this->assertSame($this->hub, $hub[0], 'hub object should be the same');
		// check old link
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'no linked hub object should exist anymore');
		$this->assertEquals(0, count($this->related->bidiOneToOneHub->getAll()), 'there should be no linked hub object');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::insert()} method to link an object with an already linked object
	 * (the object which is the parameter of the {@link UML_OneAssociation::insert()} method is already linked).
	 * - creates a bidirectional link between 2 objects
	 * - inserts one of the linked object into the association of an unlinked object
	 * - verfifies the return value of the {@link UML_OneAssociation::insert()} method
	 * - verfifies the unlinked object state of the <i>third</i> object
	 * - verfifies the linked object states of the two other objects
	 * @see UML_OneAssociation::insert()
	 */
	public function testInsertLinked() {
		$related = $this->hub->bidiOneToOneRelated->insert($this->related);
		$hub = $this->related2->bidiOneToOneHub->insert($this->hub);
		$this->assertNotNull($hub, 'inserted hub object should not be null');
		$this->assertSame($this->hub, $hub, 'inserted hub object should be the same');
		$this->assertNull($this->related->bidiOneToOneHub->get(), 'previously linked related object should not have a link');
		$this->assertSame($this->hub, $this->related2->bidiOneToOneHub->get(), 'linked hub object should be the same');
		$this->assertSame($this->related2, $this->hub->bidiOneToOneRelated->get(), 'linked related object should be the same');
	}
}
?>