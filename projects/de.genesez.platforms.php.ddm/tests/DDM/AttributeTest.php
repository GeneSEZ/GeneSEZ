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

class DDM_AttributeTest extends AbstractDoctrineTestCase
{

	private $typeTable;
	private $classTable;
	
	protected function setUp()
	{
		$this->typeTable = Doctrine::getTable("DDM_Type");
		$this->classTable = Doctrine::getTable("DDM_Class");
		parent::setUp();
	}

	/**
	 * Test creating a new attribute
	 */
	public function testNewAttribute()
	{
		$class = new DDM_Class();
		$class->c_name = 'TestAttributeClass';
		$class->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestAttributeType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestAttribute';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();
	}
 
	/**
	 * Test toString method of attribute
	 */
	public function testAttributeToString()
	{
		$class = new DDM_Class();
		$class->c_name = 'TestAttributeToStringClass';
		$class->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestAttributeToStringType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'Test Attribute To String';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();
		
		$this->assertEquals('Name: Test Attribute To String, Column: TestAttributeToString', $attribute->__toString());
	}

	/**
	 * Test setting a wrong attribute column name
	 */
	public function testAttributesWrongColumnName()
	{
		$class = new DDM_Class();
		$class->c_name = 'TestAttributeWrongColumnNameClass';
		$class->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestAttributeWrongColumnNameType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'Test Attribute Wrong Column';
		$attribute->class = $class;
		$attribute->type = $type;

		try {
			$attribute->a_column = 'Test Attribute Wrong Column';
			$attribute->save();
		} catch (DDM_Exception $expected) {
			return;
		}
		$this->fail('An expected exception has not been raised.');
	}

	/**
	 * Test creating two class attributes from same type
	 */
	public function testTwoAttributes()
	{
		$class = new DDM_Class();
		$class->c_name = 'TestTwoAttributesClass';
		$class->save();

		$type = new DDM_Type();
		$type->t_name = 'TestTwoAttributesType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestTwoAttributes1';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();

		$attribute2 = new DDM_Attribute();
		$attribute2->a_name = 'TestTwoAttributes2';
		$attribute2->class = $class;
		$attribute2->type = $type;
		$attribute2->save();
    }

	/**
	 * Test creating two class attributes with different types
	 */
        public function testTwoDifferentAttributes()
	{
		$class = new DDM_Class();
		$class->c_name = 'TestTwoDifferentAttributesClass';
		$class->save();

		$type = new DDM_Type();
		$type->t_name = 'TestTwoDifferentAttributesTypeString';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();

		$type_i = new DDM_Type();
		$type_i->t_name = 'TestTwoDifferentAttributesTypeInteger';
		$type_i->t_basetype = 'INTEGER';
		$type_i->t_constraint = '';
		$type_i->t_editable = true;
		$type_i->save();

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestTwoDifferentAttributes1';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();

		$attribute2 = new DDM_Attribute();
		$attribute2->a_name = 'TestTwoDifferentAttributes2';
		$attribute2->a_class = $class;
		$attribute2->a_type = $type_i;
		$attribute2->save();
    }

	/**
	 * Test creating two attributes with the same name
	 */
    public function testTwoAttributesSameName()
	{
		$method = ucfirst('testTwoAttributesSameName');

		$class = new DDM_Class();
		$class->c_name = $method.'Class';
		$class->save();
	
		$type = new DDM_Type();
		$type->t_name = $method.'Type';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();
		
		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestTwoAttributes3';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();

		$attribute2 = new DDM_Attribute();
		$attribute2->a_name = 'TestTwoAttributes3';
		$attribute2->class = $class;
		$attribute2->type = $type;

		try {
			$attribute2->save();
		} catch (Doctrine_Connection_Exception $expected) {
			return;
		}
		$this->fail('An expected exception has not been raised.');
	}

}

?>
