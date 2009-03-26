<?php

if ( ! defined('TESTCONFIGURATION') ) {
	require_once('tests/TestConfiguration.php');
}

// PHPUnit
require_once('PHPUnit/Framework.php');

// Import DDM
require_once('DDM.php');

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
		
		$association = new DDM_Association();
		$association->s_name = $method.'Association';
		$association->s_left = $left;
		$association->s_right = $right;
		$association->save();
		
		$oright = new DDM_Object();
		$oright->class = $right;
		$oright->save();

		$oleft = new DDM_Object();
		$oleft->class = $left;
		$oleft->TestCreatingAssociatedObjectsAssociation = $oright;
		$oleft->save();
		
		$query = new Doctrine_Query();
		$query->from('ddm_object');
		$objects = $query->execute();
		
		$found = null;
		foreach ($objects as $o) {
			if ($o->id === $oleft->id) {
				$found = $o;
			}
		}
		
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
		
		$association = new DDM_Association();
		$association->s_name = $method.'Association';
		$association->s_left = $left;
		$association->s_right = $right;
		$association->s_right_cardinality = 'N';
		$association->save();
		
		$oright = new DDM_Object();
		$oright->class = $right;
		$oright->save();

		$oleft = new DDM_Object();
		$oleft->class = $left;
		$oleft->TestCreatingAssociatedObjectsO2NAssociation = $oright;
		$oleft->save();
		
		$query = new Doctrine_Query();
		$query->from('ddm_object');
		$objects = $query->execute();
		
		$found = null;
		foreach ($objects as $o) {
			if ($o->id === $oleft->id) {
				$found = $o;
			}
		}
		
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
