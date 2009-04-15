<?php
class UML_SingleQualifiedOneAssociationUniTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related, $related2;
	
	/**
	 * initializes the instance variables needed for testing.
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->related = new Related();
		$this->related2 = new Related();
	}
	
	public function testInsert() {
		$related = $this->hub->unidiSingleQualifiedToOneRelated->insert('related', $this->related);
		$this->assertNotNull($related, 'inserted related object should not be null');
		$this->assertEquals($this->related, $related, 'inserted related object should be equal');
		$this->assertSame($this->related, $related, 'inserted related object should be the same');
	}
	
	public function testGet() {
		$this->assertNull($this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'link to related object should exist');
		$this->assertEquals($this->related, $this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'related object should be equal');
		$this->assertSame($this->related, $this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'related object should be the same');
	}
	
	public function testGetAll() {
		$this->assertNull($this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'no link to related object should exist');
		$this->assertEquals(0, count($this->hub->unidiSingleQualifiedToOneRelated->getAll('related')), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiSingleQualifiedToOneRelated->getAll('related'), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiSingleQualifiedToOneRelated->getAll('related')), 'should be exactly 1 related object');
		$related = $this->hub->unidiSingleQualifiedToOneRelated->getAll('related');
		$this->assertEquals($this->related, $related[0], 'related object should be equal');
		$this->assertSame($this->related, $related[0], 'related object should be the same');
	}
	
	public function testRemove() {
		$this->testGet();
		$related = $this->hub->unidiSingleQualifiedToOneRelated->remove('related', $this->related);
		$this->assertNotNull($related, 'returned object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
		$this->assertNull($this->hub->unidiSingleQualifiedToOneRelated->get('related'), 'there should be no related object');
		$this->assertEquals(0, count($this->hub->unidiSingleQualifiedToOneRelated->getAll('related')), 'should be exactly 0 related objects');
	}
	
	public function testRemoveNotLinked() {
		$this->testGet();
		// remove with different, non-existing qualifier
		$related = $this->hub->unidiSingleQualifiedToOneRelated->remove('key', $this->related2);
		$this->assertNull($related, 'returned object should be null');
		// remove with existing qualifier, but unlinked object
		$related = $this->hub->unidiSingleQualifiedToOneRelated->remove('related', $this->related2);
		$this->assertNull($related, 'returned object should be null');
		$related = $this->hub->unidiSingleQualifiedToOneRelated->get('related');
		$this->assertNotNull($related, 'the link to the related object should still exist');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
		$this->assertEquals(1, count($this->hub->unidiSingleQualifiedToOneRelated->getAll('related')), 'should be exactly 1 linked related objects');
	}
	
	public function testInsertAgain() {
		$related = $this->hub->unidiSingleQualifiedToOneRelated->insert('related', $this->related);
		$related = $this->hub->unidiSingleQualifiedToOneRelated->insert('related', $this->related2);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related2, $related, 'inserted object should be equal');
		$this->assertSame($this->related2, $related, 'inserted object should be the same');
		// test get
		$related = $this->hub->unidiSingleQualifiedToOneRelated->get('related');
		$this->assertNotNull($related, 'link to related object should exist');
		$this->assertEquals($this->related2, $related, 'related object should be equal');
		$this->assertSame($this->related2, $related, 'related object should be the same');
		// test getAll
		$this->assertNotNull($this->hub->unidiSingleQualifiedToOneRelated->getAll('related'), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiSingleQualifiedToOneRelated->getAll('related')), 'should be exactly 1 related object');
		$related = $this->hub->unidiSingleQualifiedToOneRelated->getAll('related');
		$this->assertEquals($this->related2, $related[0], 'related object should be equal');
		$this->assertSame($this->related2, $related[0], 'related object should be the same');
	}
}
?>