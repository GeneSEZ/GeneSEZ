<?php
class UML_MultiQualifiedOneAssociationUniTest extends PHPUnit_Framework_TestCase {
	
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
		$related = $this->hub->unidiMultiQualifiedToOneRelated->insert('related', $this->related);
		$this->assertNotNull($related, 'inserted related object should not be null');
		$this->assertEquals($this->related, $related, 'inserted related object should be equal');
		$this->assertSame($this->related, $related, 'inserted related object should be the same');
		// another qualifier
		$related2 = $this->hub->unidiMultiQualifiedToOneRelated->insert('related2', $this->related2);
		$this->assertNotNull($related2, 'inserted related object should not be null');
		$this->assertEquals($this->related2, $related2, 'inserted related object should be equal');
		$this->assertSame($this->related2, $related2, 'inserted related object should be the same');
	}
	
	public function testGet() {
		$this->assertNull($this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'link to related object should exist');
		$this->assertEquals($this->related, $this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'related object should be equal');
		$this->assertSame($this->related, $this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'related object should be the same');
		$this->assertSame($this->related2, $this->hub->unidiMultiQualifiedToOneRelated->get('related2'), 'related object should be the same');
	}
	
	public function testGetAll() {
		$this->assertNull($this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'no link to related object should exist');
		$this->assertEquals(0, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related')), 'no link to related object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiMultiQualifiedToOneRelated->getAll('related'), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related')), 'should be exactly 1 related object');
		$related = $this->hub->unidiMultiQualifiedToOneRelated->getAll('related');
		$this->assertEquals($this->related, $related[0], 'related object should be equal');
		$this->assertSame($this->related, $related[0], 'related object should be the same');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related2')), 'should be exactly 1 related object');
		$related2 = $this->hub->unidiMultiQualifiedToOneRelated->getAll('related2');
		$this->assertSame($this->related2, $related2[0], 'related object should be the same');
	}
	
	public function testRemove() {
		$this->testGet();
		$related = $this->hub->unidiMultiQualifiedToOneRelated->remove('related', $this->related);
		$this->assertNotNull($related, 'returned object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
		$this->assertNull($this->hub->unidiMultiQualifiedToOneRelated->get('related'), 'there should be no related object');
		$this->assertEquals(0, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related')), 'should be exactly 0 related objects');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related2')), 'should be exactly 1 related object');
	}
	
	public function testRemoveNotLinked() {
		$this->testGet();
		// remove with different, non-existing qualifier
		$related = $this->hub->unidiMultiQualifiedToOneRelated->remove('key', $this->related2);
		$this->assertNull($related, 'returned object should be null');
		// remove with existing qualifier, but unlinked object
		$related = $this->hub->unidiMultiQualifiedToOneRelated->remove('related', $this->related2);
		$this->assertNull($related, 'returned object should be null');
		$related = $this->hub->unidiMultiQualifiedToOneRelated->get('related');
		$this->assertNotNull($related, 'the link to the related object should still exist');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related')), 'should be exactly 1 linked related objects');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related2')), 'should be exactly 1 linked related objects');
	}
	
	public function testInsertAgain() {
		$related = $this->hub->unidiMultiQualifiedToOneRelated->insert('related', $this->related);
		$related = $this->hub->unidiMultiQualifiedToOneRelated->insert('related', $this->related2);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related2, $related, 'inserted object should be equal');
		$this->assertSame($this->related2, $related, 'inserted object should be the same');
		// test get
		$related = $this->hub->unidiMultiQualifiedToOneRelated->get('related');
		$this->assertNotNull($related, 'link to related object should exist');
		$this->assertEquals($this->related2, $related, 'related object should be equal');
		$this->assertSame($this->related2, $related, 'related object should be the same');
		// test getAll
		$this->assertNotNull($this->hub->unidiMultiQualifiedToOneRelated->getAll('related'), 'link to related object should exist');
		$this->assertEquals(1, count($this->hub->unidiMultiQualifiedToOneRelated->getAll('related')), 'should be exactly 1 related object');
		$related = $this->hub->unidiMultiQualifiedToOneRelated->getAll('related');
		$this->assertEquals($this->related2, $related[0], 'related object should be equal');
		$this->assertSame($this->related2, $related[0], 'related object should be the same');
	}
}
?>