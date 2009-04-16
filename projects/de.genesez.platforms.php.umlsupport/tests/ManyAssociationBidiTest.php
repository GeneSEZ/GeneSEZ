<?php
require_once 'Hub.php';
require_once 'Related.php';

/**
 * Tests the <b>bidirectional many to many association</b> from the class {@link Hub} to the class {@link Related}.
 * The dynamic creation and destruction of links between objects of both classes is subject to test.
 * @see UML_ManyAssociation
 * @author toh
 * @version 2009-03-09
 */
class ManyAssociationBidiTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $hub2, $related, $related2, $unrelated;
	
	/**
	 * initializes the instance variables needed for testing
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->hub2 = new Hub();
		$this->related = new Related();
		$this->related2 = new Related();
		$this->unrelated = new Related();
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::insert()} method to insert objects into an association.
	 * - verifies the return value
	 * @see UML_ManyAssociation::insert()
	 */
	public function testInsert() {
		$linked = $this->hub->bidiManyToManyRelated->insert($this->related);
		$this->assertNotNull($linked, '1st inserted object should not be null');
		$this->assertSame($this->related, $linked, 'returned object should be the same as the inserted');
		$linked = $this->hub->bidiManyToManyRelated->insert($this->related2);
		$this->assertNotNull($linked, '2nd inserted object should not be null');
		$this->assertSame($this->related2, $linked, 'returned object should be the same as the inserted');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::get()} method to get the linked object participating within an association.
	 * - verifies the unlinked object states
	 * - creates the links between 3 objects using {@link testInsert()}
	 * - verifies on all objects using {@link UML_ManyAssociation::get()} if the bidirectional links were
	 *   successfully created and the linked objects are the same as the inserted
	 * - verifies the iteration of linked object on subsequent call using {@link UML_ManyAssociation::get()}
	 * @see UML_ManyAssociation::get()
	 */
	public function testGet() {
		$this->assertNull($this->hub->bidiManyToManyRelated->get(), 'no linked related object should exist');
		$this->assertNull($this->related->bidiManyToManyHub->get(), 'no linked hub object should exist');
		$this->assertNull($this->related2->bidiManyToManyHub->get(), 'no linked hub object should exist');
		$this->testInsert();
		// hub
		$linked = $this->hub->bidiManyToManyRelated->get();
		$this->assertNotNull($linked, 'link to 1st related object should exist');
		$this->assertSame($this->related, $linked, '1st linked related object should be the same as the 1st inserted');
		$linked = $this->hub->bidiManyToManyRelated->get();
		$this->assertNotNull($linked, 'link to 2nd related object should exist');
		$this->assertSame($this->related2, $linked, '2nd linked related object should be the same as the 2nd inserted');
		$linked = $this->hub->bidiManyToManyRelated->get();
		$this->assertNotNull($linked, 'subsequent get calls should iterate over the linked related objects');
		$this->assertSame($this->related, $linked, 'subsequent call should return the 1st inserted related object again');
		// related
		$linked = $this->related->bidiManyToManyHub->get();
		$this->assertNotNull($linked, 'link to 1st hub object should exist');
		$this->assertSame($this->hub, $linked, '1st linked hub object should be the same as the 1st inserted');
		$linked = $this->related->bidiManyToManyHub->get();
		$this->assertNotNull($linked, 'subsequent get calls should iterate over the linked hub objects');
		$this->assertSame($this->hub, $linked, 'subsequent get call should return the 1st inserted hub object again');
		// related2
		$linked = $this->related2->bidiManyToManyHub->get();
		$this->assertNotNull($linked, 'link to 1st hub object should exist');
		$this->assertSame($this->hub, $linked, '1st linked hub object should be the same as the 1st inserted');
		$linked = $this->related2->bidiManyToManyHub->get();
		$this->assertNotNull($linked, 'subsequent get calls should iterate over the linked hub objects');
		$this->assertSame($this->hub, $linked, 'subsequent get call should return the 1st inserted hub object again');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::getAll()} method to get all linked objects
	 * - verifies the unlinked object states of all three objects
	 * - creates the bidirectional links between the objects using {@testInsert()}
	 * - verifies on all objects using {@link UML_ManyAssociation::getAll()} if the bidirectional link
	 *   was successfully created and the linked objects are the same as the inserted
	 * @see UML_ManyAssociation::getAll()
	 */
	public function testGetAll() {
		$this->assertEquals(0, count($this->hub->bidiManyToManyRelated->get()), 'no linked related object should exist');
		$this->assertEquals(0, count($this->related->bidiManyToManyHub->get()), 'no linked hub object should exist');
		$this->assertEquals(0, count($this->related2->bidiManyToManyHub->get()), 'no linked hub object should exist');
		$this->testInsert();
		// hub
		$linked = $this->hub->bidiManyToManyRelated->getAll();
		$this->assertNotNull($linked, 'links to related objects should exist');
		$this->assertEquals(2, count($linked), 'there should be exactly 2 linked related objects');
		$this->assertSame($this->related, $linked[0], '1st linked related object should be the same as the 1st inserted');
		$this->assertSame($this->related2, $linked[1], '2nd linked related object should be the same as the 2nd inserted');
		// related
		$linked = $this->related->bidiManyToManyHub->getAll();
		$this->assertNotNull($linked, 'link to hub object should exist');
		$this->assertEquals(1, count($linked), 'there should be exactly 1 linked hub object');
		$this->assertSame($this->hub, $linked[0], '1st linked hub object should be the same as the 1st inserted');
		// related
		$linked = $this->related2->bidiManyToManyHub->getAll();
		$this->assertNotNull($linked, 'link to hub object should exist');
		$this->assertEquals(1, count($linked), 'there should be exactly 1 linked hub object');
		$this->assertSame($this->hub, $linked[0], '1st linked hub object should be the same as the 1st inserted');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::remove()} method to unlink linked objects
	 * - creates bidirectional links between 4 objects
	 * - unlinks on link using {@link UML_ManyAssociation::remove()}
	 * - verifies the return value
	 * - verifies all unlinked object and linked object states using {@link UML_ManyAssociation::get()} and
	 *   {@link UML_ManyAssociation::getAll()}
	 * @see UML_ManyAssociation::remove()
	 */
	public function testRemove() {
		$this->hub->bidiManyToManyRelated->insert($this->related);
		$this->hub->bidiManyToManyRelated->insert($this->related2);
		$this->hub2->bidiManyToManyRelated->insert($this->related);
		$this->hub2->bidiManyToManyRelated->insert($this->related2);
		$unlinked = $this->hub2->bidiManyToManyRelated->remove($this->related2);
		// check count of links
		$this->assertEquals(2, count($this->hub->bidiManyToManyRelated->getAll()), 'hub object should have 2 links to related objects');
		$this->assertEquals(1, count($this->hub2->bidiManyToManyRelated->getAll()), 'hub2 object should have 1 link to a related object');
		$this->assertEquals(2, count($this->related->bidiManyToManyHub->getAll()), 'related object should have 2 links to hub objects');
		$this->assertEquals(1, count($this->related2->bidiManyToManyHub->getAll()), 'related2 object should have 1 link to a hub object');
		// check objects references
		$this->assertSame($this->related, $this->hub->bidiManyToManyRelated->get(), '1st returned related object should be the same as the inserted');
		$this->assertSame($this->related2, $this->hub->bidiManyToManyRelated->get(), '2nd returned related object should be the same as the inserted');
		$this->assertSame($this->related, $this->hub2->bidiManyToManyRelated->get(), '1st returned related object should be the same as the inserted');
		$this->assertSame($this->hub, $this->related->bidiManyToManyHub->get(), '1st returned hub object should be the same as the inserted');
		$this->assertSame($this->hub2, $this->related->bidiManyToManyHub->get(), '2nd returned hub object should be the same as the inserted');
		$this->assertSame($this->hub, $this->related2->bidiManyToManyHub->get(), '1st returned hub object should be the same as the inserted');
	}
	
	/**
	 * Tests the {@link UML_ManyAssociation::insert()} method to link an object with an already linked object
	 * (the object which is the parameter of the {@link UML_ManyAssociation::insert()} method is already linked).
	 * - creates a bidirectional link between 2 objects
	 * - creates a bidirectional link between an unlinked and an already linked object
	 * - verifies the return value of the {@link UML_ManyAssociation::insert()} method
	 * - verifies the linked object states using {@link UML_ManyAssociation::getAll()}
	 * @see UML_ManyAssociation::insert()
	 */
	public function testInsertLinked() {
		$related = $this->hub->bidiManyToManyRelated->insert($this->related);
		$hub = $this->related2->bidiManyToManyHub->insert($this->hub);
		$this->assertSame($this->related, $related, 'linked related object should be the same as the inserted');
		$this->assertSame($this->hub, $hub, 'linked hub object should be the same as the inserted');
		$this->assertEquals(2, count($this->hub->bidiManyToManyRelated->getAll()), 'hub object should have 2 links to related objects');
		$this->assertEquals(1, count($this->related->bidiManyToManyHub->getAll()), 'related object should have one link a hub object');
		$this->assertEquals(1, count($this->related2->bidiManyToManyHub->getAll()), 'related2 object should have one link a hub object');
	}
}
?>