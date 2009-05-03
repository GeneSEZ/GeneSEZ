<?php
class UML_MultiQualifiedOneAssociationBidiTest extends PHPUnit_Framework_TestCase {
	
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
		$related = $this->hub->bidiMultiQualifiedOneToOneRelated->insert('related', $this->related);
		$this->assertNotNull($related, 'inserted object should not be null');
		$this->assertEquals($this->related, $related, 'inserted object should be equal');
		$this->assertSame($this->related, $related, 'inserted object should be the same');
	}
	
	public function testGet() {
		$this->assertNull($this->hub->bidiMultiQualifiedOneToOneRelated->get('related'), 'no linked related object should exist');
		$this->assertNull($this->related->bidiOneToMultiQualifiedOneHub->get(), 'no linked hub object should exist');
		$this->testInsert();
		$this->assertNotNull($this->hub->bidiMultiQualifiedOneToOneRelated->get('related'), 'link to related object should exist');
		$this->assertNotNull($this->related->bidiOneToMultiQualifiedOneHub->get(), 'link to hub object should exist');
		$this->assertEquals($this->related, $this->hub->bidiMultiQualifiedOneToOneRelated->get('related'), 'linked related object should be equal');
		$this->assertEquals($this->hub, $this->related->bidiOneToMultiQualifiedOneHub->get(), 'linked hub object should be equal');
		$this->assertSame($this->related, $this->hub->bidiMultiQualifiedOneToOneRelated->get('related'), 'linked related object should be the same');
		$this->assertSame($this->hub, $this->related->bidiOneToMultiQualifiedOneHub->get(), 'linked hub object should be the same');
	}
}
?>