<?php
class UML_SingleQualifiedOneAssociationBidiTest extends PHPUnit_Framework_TestCase {
	
	private $hub, $related, $related2;
	
	
	/**
	 * initializes the instance variables needed for testing
	 */
	protected function setUp() {
		$this->hub = new Hub();
		$this->related = new Related();
		$this->related2 = new Related();
	}
	
	public function testInsert() {
		$related = $this->hub->bidiSingleQualifiedOneToOneRelated->insert('related', $this->related);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
	}
	
	public function testGet() {
		$this->assertNull($this->hub->bidiSingleQualifiedOneToOneRelated->get('related'), 'no linked related object should exist');
		$this->assertNull($this->related->bidiOneToSingleQualifiedOneHub->get(), 'no linked hub object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->bidiSingleQualifiedOneToOneRelated->get('related'), 'link to related object should exist');
		$this->assertNotNull($this->related->bidiOneToSingleQualifiedOneHub->get(), 'link to hub object should exist');
		$this->assertEquals($this->related, $this->hub->bidiSingleQualifiedOneToOneRelated->get('related'), 'linked related object should be equal');
		$this->assertEquals($this->hub, $this->related->bidiOneToSingleQualifiedOneHub->get(), 'linked hub object should be equal');
		$this->assertSame($this->related, $this->hub->bidiSingleQualifiedOneToOneRelated->get('related'), 'linked related object should be the same');
		$this->assertSame($this->hub, $this->related->bidiOneToSingleQualifiedOneHub->get(), 'linked hub object should be the same');
	}
}
?>