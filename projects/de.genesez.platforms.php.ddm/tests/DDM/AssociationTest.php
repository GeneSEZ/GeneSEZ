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

class DDM_AssociationTest extends AbstractDoctrineTestCase
{

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
		$this->assertTrue( $association->cardinality(1, 1) );
		
		$link = $association->createLink();
		$this->assertIsA('DDM_O2OReference', $link);
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
		$this->assertTrue( $right->hasAssociation('TestBAssociationClassLeft') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertTrue( $association->cardinality(1, 1) );
		$reverse = $right->getAssociation('TestBAssociationClassLeft');
		$this->assertIsA('DDM_Reverse_Association', $reverse);
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( $association, $reverse->association );
		$this->assertEquals( 'TestBAssociationClassLeft', $reverse->s_name );
		$this->assertTrue( $reverse->cardinality(1, 1) );

		$link = $association->createLink();
		$this->assertIsA('DDM_O2OReference', $link);
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
		
		$left->addAssociation('TestAssociation', $right, '0..1');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociationO2OClassLeft') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( '1', $association->s_from_cardinality );
		$this->assertEquals( '0..1', $association->s_to_cardinality );
		$this->assertTrue( $association->cardinality(1, 1) );
		$this->assertTrue( $association->cardinality(1, '0..1') );
		$reverse = $right->getAssociation('TestAssociationO2OClassLeft');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( '0..1', $reverse->s_from_cardinality );
		$this->assertEquals( '1', $reverse->s_to_cardinality );
		$this->assertTrue( $reverse->cardinality(1, 1) );
		$this->assertTrue( $reverse->cardinality('0..1', 1) );

		$link = $association->createLink();
		$this->assertIsA('DDM_O2OReference', $link);
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
		
		$left->addAssociation('TestAssociation', $right, 'N');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociationO2NClassLeft') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( '1', $association->s_from_cardinality );
		$this->assertEquals( 'N', $association->s_to_cardinality );
		$this->assertTrue( $association->cardinality(1, 'N') );
		$reverse = $right->getAssociation('TestAssociationO2NClassLeft');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( 'N', $reverse->s_from_cardinality );
		$this->assertEquals( '1', $reverse->s_to_cardinality );
		$this->assertTrue( $reverse->cardinality('N', 1) );

		$link = $association->createLink();
		$this->assertIsA('DDM_O2NReference', $link);
	}

	/**
	 * Test creating a new n-to-n association
	 */
	public function testNewAssociationN2O()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationN2OClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationN2OClassRight';
		$right->save();
		
		$left->addAssociation('TestAssociation', $right, 1, 'N');
		$left->save();

		$this->assertTrue( $left->hasAssociation('TestAssociation') );
		$this->assertTrue( $right->hasAssociation('TestAssociationN2OClassLeft') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( 'N', $association->s_from_cardinality );
		$this->assertEquals( 1, $association->s_to_cardinality );
		$this->assertTrue( $association->cardinality('N', 1) );
		$reverse = $right->getAssociation('TestAssociationN2OClassLeft');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( 1, $reverse->s_from_cardinality );
		$this->assertEquals( 'N', $reverse->s_to_cardinality );
		$this->assertTrue( $reverse->cardinality(1, 'N') );
		
		$link = $association->createLink();
		$this->assertIsA('DDM_N2OReference', $link);
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
		$this->assertTrue( $right->hasAssociation('TestAssociationN2NClassLeft') );
		
		$association = $left->getAssociation('TestAssociation');
		$this->assertEquals( $left, $association->from );
		$this->assertEquals( $right, $association->to );
		$this->assertEquals( 'N', $association->s_from_cardinality );
		$this->assertEquals( 'N', $association->s_to_cardinality );
		$this->assertTrue( $association->cardinality('N', 'N') );
		$reverse = $right->getAssociation('TestAssociationN2NClassLeft');
		$this->assertEquals( $left, $reverse->to );
		$this->assertEquals( $right, $reverse->from );
		$this->assertEquals( 'N', $reverse->s_from_cardinality );
		$this->assertEquals( 'N', $reverse->s_to_cardinality );
		$this->assertTrue( $reverse->cardinality('N', 'N') );
		$link = $association->createLink();
		$this->assertIsA('DDM_N2NReference', $link);
	}
}

?>
