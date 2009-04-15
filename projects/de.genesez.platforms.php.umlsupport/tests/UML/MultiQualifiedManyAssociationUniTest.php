<?php
class UML_SingleQualifiedManyAssociationUniTest extends PHPUnit_Framework_TestCase {
	
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
	
	public function testInsert() {
		$linked = $this->hub->unidiSingleQualifiedToManyRelated->insert('related', $this->related);
		$this->assertNotNull($linked, 'inserted object should not be null');
		$this->assertEquals($this->related, $linked, 'inserted object should be equal');
		$this->assertSame($this->related, $linked, 'inserted object should be the same');
		$linked = $this->hub->unidiSingleQualifiedToManyRelated->insert('related', $this->related2);
		$this->assertNotNull($linked, 'second inserted object should not be null');
		$this->assertEquals($this->related2, $linked, 'second inserted object should be equal');
		$this->assertSame($this->related2, $linked, 'second inserted object should be the same');
	}
	
	public function testGet() {
		$this->assertNull($this->hub->unidiSingleQualifiedToManyRelated->get('related'), 'there should not exist any linked related object');
		$this->testInsert();
		$linked1 = $this->hub->unidiSingleQualifiedToManyRelated->get('related');
		$this->assertNotNull($linked1, 'the 1st linked object should not be null');
		$this->assertSame($this->related, $linked1, 'the 1st linked object should be the same as the 1st inserted');
		$linked2 = $this->hub->unidiSingleQualifiedToManyRelated->get('related');
		$this->assertNotNull($linked2, 'the 2nd linked object should not be null');
		$this->assertSame($this->related2, $linked2, 'the 2nd linked object should be the same as the 2nd inserted');
		// again, the 1st linked object should be returned
		$linked1 = $this->hub->unidiSingleQualifiedToManyRelated->get('related');
		$this->assertNotNull($linked1, 'the 1st linked object should be returned again');
		$this->assertSame($this->related, $linked1, 'the 1st linked object returned again should be the same as the 1st inserted');
	}
	
	public function testGetAll() {
		$this->assertNotNull($this->hub->unidiSingleQualifiedToManyRelated->getAll('related'), 'the return value should not be null');
		$this->assertEquals(0, count($this->hub->unidiSingleQualifiedToManyRelated->getAll('related')), 'the number of linked related objects should be 0 (zero)');
		$this->testInsert();
		$this->assertNotNull($this->hub->unidiSingleQualifiedToManyRelated->getAll('related'), 'the return value should not be null');
		$this->assertEquals(2, count($this->hub->unidiSingleQualifiedToManyRelated->getAll('related')), 'the number of linked related objects should be 2');
		$linked = $this->hub->unidiSingleQualifiedToManyRelated->getAll('related');
		$this->assertEquals($this->related, $linked[0], 'the 1st linked related object should be equal');
		$this->assertSame($this->related, $linked[0], 'the 1st linked related object should be the same');
		$this->assertSame($this->related2, $linked[1], 'the 2nd linked related object should be the same');
	}
	
	public function testRemove() {
		$this->testInsert();
		$linked = $this->hub->unidiSingleQualifiedToManyRelated->remove('related', $this->related);
		$this->assertNotNull($linked, 'returned object should not be null');
		$this->assertSame($this->related, $linked, 'removed object should be the same as the inserted');
		$this->assertSame($this->related2, $this->hub->unidiSingleQualifiedToManyRelated->get('related'), 'the linked object should be the same as the inserted');
		$this->assertSame($this->related2, $this->hub->unidiSingleQualifiedToManyRelated->get('related'), 'subsequent calls should always return the only linked object');
		$this->assertEquals(1, count($this->hub->unidiSingleQualifiedToManyRelated->getAll('related')), 'there should be exactly 1 linked object');
	}
	
	public function testRemoveNotLinked() {
		$this->testInsert();
		$unlinked = $this->hub->unidiSingleQualifiedToManyRelated->remove('related', $this->unrelated);
		$this->assertNull($unlinked, 'returned object should be null');
		$this->assertEquals(2, count($this->hub->unidiSingleQualifiedToManyRelated->getAll('related')), 'there should be still exactly 2 linked objects');
		$this->assertSame($this->related, $this->hub->unidiSingleQualifiedToManyRelated->get('related'), 'the 1st linked object should be the same as the 1st inserted');
		$this->assertSame($this->related2, $this->hub->unidiSingleQualifiedToManyRelated->get('related'), 'the 2nd linked object should be the same as the 2nd inserted');
	}
}
?>