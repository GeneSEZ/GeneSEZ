<?php

if ( ! defined('TESTCONFIGURATION') ) {
	require_once 'tests/TestConfiguration.php';
}

// PHPUnit
require_once 'PHPUnit/Framework.php';

// Import DDM
require_once 'DDM.php';

// TODO: Implement Tests with variable Class Names
class DDM_CreatingAssociatedObjectsTest extends PHPUnit_Framework_TestCase
{

	/**
	 * Test creating one-to-one associated objects 
	 */
	public function testCreatingAssociatedObjects()
	{
		$method = ucfirst('testCreatingAssociatedObjects');

		$left = new DDM_Class();
		$left->c_name = $method.'LeftClass';
		$left->save();
		
		$right = new DDM_Class();
		$right->c_name = $method.'RightClass';
		$right->save();
		
		$left->addAssociationTo( $method . 'Association', $right);
		
		$oright = $right->createObject();
		$oright->save();

		$oleft = $left->createObject();
		$oleft->TestCreatingAssociatedObjectsAssociation = $oright;
		$oleft->save();
		
		$t = Doctrine::getTable('DDM_Object');
		$found = $t->fetch($oleft->id);
		
		$this->assertNotNull($found);
		$this->assertEquals($oleft->id, $found->id);
		$this->assertEquals($oright->id, $oleft->TestCreatingAssociatedObjectsAssociation->id);
		$this->assertEquals($oright->id, $found->TestCreatingAssociatedObjectsAssociation->id);
		$this->assertEquals($oleft->TestCreatingAssociatedObjectsAssociation->id, $found->TestCreatingAssociatedObjectsAssociation->id);
	}

	/**
	 * Test creating one-to-n associated objects 
	 */
	public function testCreatingAssociatedObjectsO2N()
	{
		$method = ucfirst('testCreatingAssociatedObjectsO2N');

		$left = new DDM_Class();
		$left->c_name = $method.'LeftClass';
		$left->save();
		
		$right = new DDM_Class();
		$right->c_name = $method.'RightClass';
		$right->save();
		
		$left->addAssociationTo( $method . 'Association', $right, 1, 'N');
		
		$oright = $right->createObject();
		$oright->save();

		$oleft = $left->createObject();
		$oleft->TestCreatingAssociatedObjectsO2NAssociation = $oright;
		$oleft->save();
		
		$t = Doctrine::getTable('DDM_Object');
		$found = $t->fetch($oleft->id);
				
		$this->assertNotNull($found);
		$this->assertEquals($oleft->id, $found->id);

		# Test if oright is contained in association of oleft
		$contained = false;
		$iterator = $oleft->TestCreatingAssociatedObjectsO2NAssociation->getIterator();
		for ($c = $iterator->current(); $iterator->valid(); $iterator->next()) {
			if ($oright->id == $c->id) {
				$contained = true;
			}
		}
		$this->assertTrue($contained);
		
		# Test if oright is contained in association of found
		$contained = false;
		$iterator = $found->TestCreatingAssociatedObjectsO2NAssociation->getIterator();
		for ($c = $iterator->current(); $iterator->valid(); $iterator->next()) {
			if ($oright->id == $c->id) {
				$contained = true;
			}
		}
		$this->assertTrue($contained);
	}
	
}

?>
