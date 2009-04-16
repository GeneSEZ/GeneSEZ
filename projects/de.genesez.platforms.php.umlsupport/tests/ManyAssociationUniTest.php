<?php
require_once 'Hub.php';
require_once 'Related.php';

/**
 * Tests the <b>unidirectional to many association</b> from the class {@link Hub} to the class {@link Related}.
 * The dynamic creation and destruction of links between objects of both classes is subject to test.
 * 
 * @see UML_ManyAssociation
 * @author toh
 * @version 2009-03-09
 */
class ManyAssociationUniTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related, $related2, $unrelated;
	
	/**
	 * initializes the instance variables needed for testing
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->related = new Related();
		$this->related2 = new Related();
		$this->unrelated = new Related();
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::insert()} method to insert objects into an association.
	 * - checks the return value of the {@link UML_ManyAssociation::insert()} method
	 * @see UML_ManyAssociation::insert()
	 */
	public function testInsert() {
		$linked = $this->hub->unidiToManyRelated->insert($this->related);
		$this->assertNotNull($linked, 'inserted object should not be null');
		$this->assertEquals($this->related, $linked, 'inserted object should be equal');
		$this->assertSame($this->related, $linked, 'inserted object should be the same');
		$linked = $this->hub->unidiToManyRelated->insert($this->related2);
		$this->assertNotNull($linked, 'second inserted object should not be null');
		$this->assertEquals($this->related2, $linked, 'second inserted object should be equal');
		$this->assertSame($this->related2, $linked, 'second inserted object should be the same');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::get()} method to get the linked object participating within an association.
	 * - checks the unlinked object state
	 * - creates a link to an associated object using {@link testInsert()}
	 * - verifies using {@link UML_ManyAssociation::get()} if the link was successfully created and
	 *   the linked object is the same as the inserted
	 * - verifies that consequent {@link UML_ManyAssociation::get()} calls rewind the iteration over
	 *   the linked objects
	 * @see UML_ManyAssociation::get()
	 */
	public function testGet() {
		$this->assertNull($this->hub->unidiToManyRelated->get(), 'there should not exist any linked related object');
		$this->testInsert();
		$linked1 = $this->hub->unidiToManyRelated->get();
		$this->assertNotNull($linked1, 'the 1st linked object should not be null');
		$this->assertSame($this->related, $linked1, 'the 1st linked object should be the same as the 1st inserted');
		$linked2 = $this->hub->unidiToManyRelated->get();
		$this->assertNotNull($linked2, 'the 2nd linked object should not be null');
		$this->assertSame($this->related2, $linked2, 'the 2nd linked object should be the same as the 2nd inserted');
		// again, the 1st linked object should be returned
		$linked1 = $this->hub->unidiToManyRelated->get();
		$this->assertNotNull($linked1, 'the 1st linked object should be returned again');
		$this->assertSame($this->related, $linked1, 'the 1st linked object returned again should be the same as the 1st inserted');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::getAll()} method to get all linked objects.
	 * - verifies the unlinked object state
	 * - creates two unidirectional links to two objects using {@link testInsert()}
	 * - verifies the successful creation of the links using {@link UML_OneAssociation::getAll()}
	 * - verifies that the linked objects are the same as the inserted
	 * @see UML_ManyAssociation::getAll()
	 */
	public function testGetAll() {
		$this->assertNotNull($this->hub->unidiToManyRelated->getAll(), 'the return value should not be null');
		$this->assertEquals(0, count($this->hub->unidiToManyRelated->getAll()), 'the number of linked related objects should be 0 (zero)');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiToManyRelated->getAll(), 'the return value should not be null');
		$this->assertEquals(2, count($this->hub->unidiToManyRelated->getAll()), 'the number of linked related objects should be 2');
		$linked = $this->hub->unidiToManyRelated->getAll();
		$this->assertEquals($this->related, $linked[0], 'the 1st linked related object should be equal');
		$this->assertSame($this->related, $linked[0], 'the 1st linked related object should be the same');
		$this->assertSame($this->related2, $linked[1], 'the 2nd linked related object should be the same');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::remove()} method to unlink linked objects
	 * - creates two links to two objects using {@link testInsert()}
	 * - removes one link using {@link UML_ManyAssociation::remove()}
	 * - verifies the return value
	 * - verifies using {@link UML_ManyAssociation::get()} and {@link UML_ManyAssociation::getAll()} if
	 *   the unlink was successfully and only the other link exist
	 * - verifies if subsequent calls of the method {@link UML_ManyAssociation::get()} return always
	 *   the only linked object
	 * @see UML_ManyAssociation::remove()
	 */
	public function testRemove() {
		$this->testInsert();
		$linked = $this->hub->unidiToManyRelated->remove($this->related);
		$this->assertNotNull($linked, 'returned object should not be null');
		$this->assertSame($this->related, $linked, 'removed object should be the same as the inserted');
		$this->assertSame($this->related2, $this->hub->unidiToManyRelated->get(), 'the linked object should be the same as the inserted');
		$this->assertSame($this->related2, $this->hub->unidiToManyRelated->get(), 'subsequent calls should always return the only linked object');
		$this->assertEquals(1, count($this->hub->unidiToManyRelated->getAll()), 'there should be exactly 1 linked object');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::remove()} method to unlink an unlinked object
	 * - creates a link to an object using {@link testInsert()}
	 * - tries to unlink another object using {@link UML_ManyAssociation::remove()}
	 * - verifies the correct return value
	 * - verifies with {@link UML_ManyAssociation::get()} and {@link UML_ManyAssociation::getAll()}
	 *   that the created link still exist
	 * @see UML_ManyAssociation::remove()
	 */
	public function testRemoveNotLinked() {
		$this->testInsert();
		$unlinked = $this->hub->unidiToManyRelated->remove($this->unrelated);
		$this->assertNull($unlinked, 'returned object should be null');
		$this->assertEquals(2, count($this->hub->unidiToManyRelated->getAll()), 'there should be still exactly 2 linked objects');
		$this->assertSame($this->related, $this->hub->unidiToManyRelated->get(), 'the 1st linked object should be the same as the 1st inserted');
		$this->assertSame($this->related2, $this->hub->unidiToManyRelated->get(), 'the 2nd linked object should be the same as the 2nd inserted');
	}
}
?>