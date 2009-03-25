<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

if ( ! defined('TESTCONFIGURATION') ) {
	require_once('tests/TestConfiguration.php');
}

// PHPUnit
require_once('PHPUnit/Framework.php');

// Import DDM
require_once('DDM.php');

class AssociationTest extends PHPUnit_Framework_TestCase
{

	private $classTable;
	
	protected function setUp()
	{
		$this->classTable = Doctrine::getTable("DDM_Class");
	}

	public function testNewAssociation()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationClassRight';
		$right->save();
		
		$association = new DDM_Association();
		$association->s_name = 'TestAssociation';
		$association->s_left = $left;
		$association->s_right = $right;
		$association->save();
	}

	public function testNewAssociationO2O()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationO2OClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationO2OClassRight';
		$right->save();
		
		$association = new DDM_Association();
		$association->s_name = 'TestAssociationO2O';
		$association->s_left = $left;
		$association->s_left_cardinality = '1';
		$association->s_right = $right;
		$association->s_right_cardinality = '0..1';
		$association->save();
	}

	public function testNewAssociationO2N()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationO2NClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationO2NClassRight';
		$right->save();
		
		$association = new DDM_Association();
		$association->s_name = 'TestAssociationO2N';
		$association->s_left = $left;
		$association->s_left_cardinality = '1';
		$association->s_right = $right;
		$association->s_right_cardinality = 'N';
		$association->save();
	}

	public function testNewAssociationN2N()
	{
		$left = new DDM_Class();
		$left->c_name = 'TestAssociationN2NClassLeft';
		$left->save();

		$right = new DDM_Class();
		$right->c_name = 'TestAssociationN2NClassRight';
		$right->save();
		
		$association = new DDM_Association();
		$association->s_name = 'TestAssociationN2N';
		$association->s_left = $left;
		$association->s_left_cardinality = 'N';
		$association->s_right = $right;
		$association->s_right_cardinality = 'N';
		$association->save();
	}
}

?>
