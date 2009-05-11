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


class DDM_ClassTest extends AbstractDoctrineTestCase
{

	/**
	 * Test creating a new class
	 */
	public function testNewClass()
	{
		$method = ucfirst('testNewClass');

		$class = new DDM_Class();
		$class->c_name = $method;
		$class->save();
	}

	/**
	 * Test creating a parent and child class
	 */
	public function testParentClass()
	{
		$method = ucfirst('testParentClass');

		$parent = new DDM_Class();
		$parent->c_name = $method.'Parent';
		$parent->save();

		$class = new DDM_Class();
		$class->c_name = $method;
    	$class->c_parent = $parent;
		$class->save();
	}

	/**
	 * Test creating child classes
	 */
	public function testChildrenClass()
	{
		$method = ucfirst('testChildrenClass');

		$manager = Doctrine_Manager::getInstance();
		$conn = $manager->getCurrentConnection();

		$parent = new DDM_Class();
		$parent->c_name = $method.'Parent';

		$class1 = new DDM_Class();
		$class1->c_name = $method.'1';
		$parent->children[] = $class1;

		$class2 = new DDM_Class();
		$class2->c_name = $method.'2';
		$parent->children[] = $class2;

		$class3 = new DDM_Class();
		$class3->c_name = $method.'3';
		$parent->children[] = $class3;

		$parent->save();

		$this->assertEquals(3, count($parent->children));
	}

	/**
	 * Test toString method of class
	 */
	public function testClassToString()
	{
		$class = new DDM_Class();
		$class->c_name = 'Test Class To String';
		$class->save();
		
		$this->assertEquals('Name: Test Class To String, View: TestClassToString', $class->__toString());
	}

	/**
	 * Test setting a bad name for class view
	 */
	public function testClassWrongViewName()
	{
		$class = new DDM_Class();
		$class->c_name = 'Test Class Wrong View Class';

		try {
			$class->c_view = 'Test Class Wrong View Class';
			$class->save();
		} catch (DDM_Exception $expected) {
			return;
		}
		$this->fail('An expected exception has not been raised.');
	}

}

?>
