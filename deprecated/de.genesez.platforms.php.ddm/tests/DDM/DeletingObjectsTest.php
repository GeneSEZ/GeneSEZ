<?php

if ( ! defined('TESTCONFIGURATION') ) {
	require_once 'tests/TestConfiguration.php';
}

// PHPUnit
require_once 'PHPUnit/Framework.php';

// Import DDM
require_once 'DDM.php';


class DDM_DeletingObjectsTest extends AbstractDoctrineTestCase
{
	/**
	 * Test deleting objects 
	 */
	public function testDeletingObjects()
	{
		$method = ucfirst('testDeletingObjects');

		$class = new DDM_Class();
		$class->c_name = $method.'Class';
		$class->save();
		
		$type_string = new DDM_Type();
		$type_string ->t_name = $method.'String';
		$type_string ->t_basetype = 'STRING';
		$type_string ->t_constraint = '';
		$type_string ->t_editable = true;
		$type_string ->save();

		$type_integer = new DDM_Type();
		$type_integer->t_name = $method.'Integer';
		$type_integer->t_basetype = 'INTEGER';
		$type_integer->t_constraint = '';
		$type_integer->t_editable = true;
		$type_integer->save();

		$attribute_string = new DDM_Attribute();
		$attribute_string->a_name = $method.'String';
		$attribute_string->class = $class;
		$attribute_string->type = $type_string;
		$attribute_string->save();

		$attribute_integer = new DDM_Attribute();
		$attribute_integer->a_name = $method.'Integer';
		$attribute_integer->class = $class;
		$attribute_integer->type = $type_integer;
		$attribute_integer->save();

		$object = new DDM_Object();
		$object->class = $class;
		$object->TestCreatingObjectsInteger = 2;
		$object->TestCreatingObjectsString = "Test deleting objects";
		$object->save();

		$query = new Doctrine_Query();
		$query->from('ddm_object');
		$objects = $query->execute();
		
		$found = null;
		foreach ($objects as $o) {
			if ($o->id === $object->id) {
				$found = $o;
			}
		}
		
		$this->assertNotNull($found);
		$this->assertEquals($object->id, $found->id);
		$this->assertEquals($object->TestCreatingObjectsInteger, $found->TestCreatingObjectsInteger);
		$this->assertEquals($object->TestCreatingObjectsString, $found->TestCreatingObjectsString);
		
		$found->delete();

		$this->assertNotNull($found);
		
		$query = new Doctrine_Query();
		$query->from('ddm_object');
		$objects = $query->execute();
		
		$found = null;
		foreach ($objects as $o) {
			if ($o->id === $object->id) {
				$found = $o;
			}
		}
		
		$this->assertNull($found);
	}

}

?>