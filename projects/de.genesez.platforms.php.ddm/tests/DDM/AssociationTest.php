<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

if ( ! defined('TESTCONFIGURATION') ) {
	require_once 'tests/TestConfiguration.php';
}

// PHPUnit
require_once 'PHPUnit/Framework.php';

// Import DDM
require_once 'DDM.php';

class DDM_AssociationTest extends PHPUnit_Framework_TestCase
{

	private $classTable;
	
	protected function setUp()
	{
		$this->classTable = Doctrine::getTable("DDM_Class");
	}

	/**
	 * Test creating a new directed association
	 */
	public function testNewAssociation()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationClassRight';
		$right->save();
		
		$left->addAssociationTo('TestAssociation', $right);
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertFalse( $right->hasAssociation('TestAssociation') );

		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertNull( $right->getAssociation('TestAssociation') );
	}

	/**
	 * Test creating a new bidirectional association
	 */
	public function testNewBidirectionalAssociation()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestBAssociationClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestBAssociationClassRight';
		$right->save();
		
		$left->addAssociation('TestAssociation', $right);
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociation') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$reverse = $right->getAssociation('TestAssociation');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
	}
	
	/**
	 * Test creating a new one-to-one association
	 */
	public function testNewAssociationO2O()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationO2OClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationO2OClassRight';
		$right->save();
		
		$left->addAssociation('TestAssociation', $right, '1', '0..1');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociation') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( '1', $association->s_from_cardinality );
		$this->assertEquals( '0..1', $association->s_to_cardinality );
		$reverse = $right->getAssociation('TestAssociation');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( '0..1', $reverse->s_from_cardinality );
		$this->assertEquals( '1', $reverse->s_to_cardinality );
	}

	/**
	 * Test creating a new one-to-n association
	 */
	public function testNewAssociationO2N()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationO2NClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationO2NClassRight';
		$right->save();
		
		$left->addAssociation('TestAssociation', $right, '1', 'N');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociation') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( '1', $association->s_from_cardinality );
		$this->assertEquals( 'N', $association->s_to_cardinality );
		$reverse = $right->getAssociation('TestAssociation');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( 'N', $reverse->s_from_cardinality );
		$this->assertEquals( '1', $reverse->s_to_cardinality );
	}

	/**
	 * Test creating a new n-to-n association
	 */
	public function testNewAssociationN2N()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationN2NClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationN2NClassRight';
		$right->save();
		
		$left->addAssociation('TestAssociation', $right, 'N', 'N');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociation') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( 'N', $association->s_from_cardinality );
		$this->assertEquals( 'N', $association->s_to_cardinality );
		$reverse = $right->getAssociation('TestAssociation');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( 'N', $reverse->s_from_cardinality );
		$this->assertEquals( 'N', $reverse->s_to_cardinality );
	}
}

?>
