<?php
require_once 'Hub.php';
require_once 'Related.php';

/**
 * Tests the <b>unidirectional to one association</b> from the class {@link Hub} to the class {@link Related}.
 * The dynamic creation and destruction of links between objects of both classes is subject to test.
 * 
 * @see UML_OneAssociation
 * @author toh
 * @version 2009-03-08
 */
class OneAssociationUniTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related, $related2;
	
	/**
	 * initializes the instance variables needed for testing.
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
		$related = $this->hub->unidiToOneRelated->insert($this->related);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::get()} method to get the linked object participating within an association.
	 * - checks unlinked object state
	 * - establishes a link between 2 objects using {@link testInsert()}
	 * - checks using {@link UML_OneAssociation::get()} if the link was successfully 
	 *   established and the linked object is the same
	 * @see UML_OneAssociation::get()
	 */
	public function testGet() {
		$this->assertNull($this->hub->unidiToOneRelated->get(), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiToOneRelated->get(), 'link to related object should exist');
		$this->assertEquals($this->related, $this->hub->unidiToOneRelated->get(), 'related object should be equal');
		$this->assertSame($this->related, $this->hub->unidiToOneRelated->get(), 'related object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::getAll()} method to get all linked/referenced objects.
	 * - checks the unlinked object state
	 * - establishes a link between 2 objects using {@link testInsert()}
	 * - checks using {@link UML_OneAssociation::getAll()} if the link was successfully 
	 *   established and the linked object is the same
	 * @see UML_OneAssociation::getAll()
	 */
	public function testGetAll() {
		$this->assertNull($this->hub->unidiToOneRelated->get(), 'no link to related object should exist');
		$this->assertEquals(0, count($this->hub->unidiToOneRelated->getAll()), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiToOneRelated->getAll(), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiToOneRelated->getAll()), 'should be exactly 1 related object');
		$related = $this->hub->unidiToOneRelated->getAll();
		$this->assertEquals($this->related, $related[0], 'related object should be equal');
		$this->assertSame($this->related, $related[0], 'related object should be the same');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::remove()} method to unlink a linked object
	 * - establishes a link between 2 objects using {@link testGet()}
	 * - unlinks the established link using {@link UML_OneAssociation::remove()}
	 * - checks using {@link UML_OneAssociation::get()} and {@link UML_OneAssociation::getAll()} if the unlink 
	 *   was successfully 
	 * @see UML_OneAssociation::remove()
	 */
	public function testRemove() {
		$this->testGet();
		$related = $this->hub->unidiToOneRelated->remove($this->related);
		$this->assertNotNull($related, 'returned object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
		$this->assertNull($this->hub->unidiToOneRelated->get(), 'there should be no related object');
		$this->assertEquals(0, count($this->hub->unidiToOneRelated->getAll()), 'should be exactly 0 related objects');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::remove()} method to unlink a not linked object
	 * - establishes a link between 2 objects using {@link testGet()}
	 * - tries to unlink another unlinked object using {@link UML_OneAssociation::remove()}
	 * - checks the correct return value of {@link UML_OneAssociation::remove()}
	 * - checks using {@link UML_OneAssociation::get()} and {@link UML_OneAssociation::getAll()} 
	 *   that the established link still exists
	 * @see UML_OneAssociation::remove()
	 */
	public function testRemoveNotLinked() {
		$this->testGet();
		$related = $this->hub->unidiToOneRelated->remove($this->related2);
		$this->assertNull($related, 'returned object should be null');
		$this->assertNotNull($this->hub->unidiToOneRelated->get(), 'the link to the related object should still exist');
		$this->assertEquals(1, count($this->hub->unidiToOneRelated->getAll()), 'should be exactly 1 linked related objects');
	}
	
	/**
	 * Tests the {@link UML_OneAssociation::insert()} method to link an object with an object which
	 * is already linked with another one (the object on which {@link UML_OneAssociation::insert()} is called
	 * is already linked)
	 * - establishes the link between 2 objects
	 * - inserts another object into the association
	 * - verifies the return value of the {@link UML_OneAssociation::insert()} method
	 * - verifies the linked object state using {@link UML_OneAssociation::get()} and 
	 *   {@link UML_OneAssociation::getAll()}
	 * @see UML_OneAssociation::insert()
	 */
	public function testInsertAgain() {
		$related = $this->hub->unidiToOneRelated->insert($this->related);
		$related = $this->hub->unidiToOneRelated->insert($this->related2);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related2, $related, 'inserted object should be equal');
		$this->assertSame($this->related2, $related, 'inserted object should be the same');
		// test get
		$this->assertNotNull($this->hub->unidiToOneRelated->get(), 'link to related object should exist');
		$this->assertEquals($this->related2, $this->hub->unidiToOneRelated->get(), 'related object should be equal');
		$this->assertSame($this->related2, $this->hub->unidiToOneRelated->get(), 'related object should be the same');
		// test getAll
		$this->assertNotNull($this->hub->unidiToOneRelated->getAll(), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiToOneRelated->getAll()), 'should be exactly 1 related object');
		$related = $this->hub->unidiToOneRelated->getAll();
		$this->assertEquals($this->related2, $related[0], 'related object should be equal');
		$this->assertSame($this->related2, $related[0], 'related object should be the same');
	}
}
?>
