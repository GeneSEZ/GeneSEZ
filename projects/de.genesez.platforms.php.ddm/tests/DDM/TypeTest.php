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

class DDM_TypeTest extends AbstractDoctrineTestCase
{

	/**
	 * Test creating a new type 
	 */
	public function testNewType()
	{
		$method = ucfirst(__METHOD__);
		$type = new DDM_Type();
		$type->t_name = $method;
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();
    }
    
	/**
	 * Test creating a new type with empty name
	 */
    public function testEmptyName()
	{
		$this->setExpectedException('Doctrine_Connection_Exception');

		$type = new DDM_Type();
		$type->t_basetype = 'STRING';
		$type->t_constraint = 'lenght<10';
		$type->t_editable = true;
		$type->save();
	}

	/**
	 * Test creating a new type with empty basetype 
	 */
	public function testEmptyBasetype()
	{
		$method = ucfirst(__METHOD__);
		$this->setExpectedException('Doctrine_Connection_Exception');

		$type = new DDM_Type();
		$type->t_name = $method;
		$type->t_constraint = 'lenght<10';
   		$type->t_editable = true;
   		$type->save();
	}

	/**
	 * Test creating a new type with empty constraint
	 */
	public function testEmptyConstraint()
	{
   		$method = ucfirst(__METHOD__);
   		$this->setExpectedException('Doctrine_Connection_Exception');

   		$type = new DDM_Type();
   		$type->t_name = $method;
   		$type->t_basetype = 'STRING';
   		$type->t_editable = true;
   		$type->save();
	}

	/**
	 * Test creating two types with same names  
	 */
	public function testDuplicateType()
	{
   		$method = ucfirst(__METHOD__);
   		$this->setExpectedException('Doctrine_Connection_Exception');

   		$type = new DDM_Type();
   		$type->t_name = $method;
   		$type->t_basetype = 'STRING';
   		$type->t_constraint = '';
   		$type->save();

   		$type2 = new DDM_Type();
   		$type2->t_name = $method;
   		$type2->t_basetype = 'STRING';
   		$type2->t_constraint = '';
		$type2->save();
	}

}
?>
