<?php

if ( ! defined('TESTCONFIGURATION') ) {
	require_once 'tests/TestConfiguration.php';
}

// PHPUnit
require_once 'PHPUnit/Framework.php';

// Import DDM
require_once 'DDM.php';

class DDM_InheritanceTest extends AbstractDoctrineTestCase
{

	/**
	 * Test if attributes are inherited
	 */
	public function testInheritance() {
		$parent = new DDM_Class();
		$parent->c_name = 'TestInheritanceParent';
		$parent->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestInheritanceType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestInheritanceAttribute';
		$attribute->class = $parent;
		$attribute->type = $type;
		$attribute->save();

		$child = new DDM_Class();
		$child->c_name = 'TestInheritanceChild';
		$child->parent = $parent;
		$child->save();
		
		$this->assertTrue($child->hasAttribute('TestInheritanceAttribute'));
	}

	/**
	 * Test for exception if parent class has attribute
	 */
	public function testDoubledAttributesInChild() {
		$parent = new DDM_Class();
		$parent->c_name = 'TestDoubledAttributesInChildParent';
		$parent->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestDoubledAttributesInChildType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestDoubledAttributesInChildAttribute';
		$attribute->class = $parent;
		$attribute->type = $type;
		$attribute->save();

		$child = new DDM_Class();
		$child->c_name = 'TestDoubledAttributesInChildChild';
		$child->parent = $parent;
		$child->save();
		
		try {
			$attribute = new DDM_Attribute();
			$attribute->a_name = 'TestDoubledAttributesInChildAttribute';
			$attribute->class = $child;
			$attribute->type = $type;
			$attribute->save();
		} catch (Doctrine_Connection_Exception $expected) {
			return;
		}
		$this->fail('An expected exception has not been raised.');
	}

	/**
	 * Test for exception if child class has attribute
	 */
	public function testDoubledAttributesInParent() {
		$parent = new DDM_Class();
		$parent->c_name = 'TestDoubledAttributesInParentParent';
		$parent->save();
	
		$type = new DDM_Type();
		$type->t_name = 'TestDoubledAttributesInParentType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->t_editable = true;
		$type->save();   	

		$child = new DDM_Class();
		$child->c_name = 'TestDoubledAttributesInParentChild';
		$child->parent = $parent;
		$child->save();
		
		$attribute = new DDM_Attribute();
		$attribute->a_name = 'TestDoubledAttributesInParentAttribute';
		$attribute->class = $child;
		$attribute->type = $type;
		$attribute->save();

		try {
			$attribute = new DDM_Attribute();
			$attribute->a_name = 'TestDoubledAttributesInParentAttribute';
			$attribute->class = $parent;
			$attribute->type = $type;
			$attribute->save();
		} catch (Doctrine_Connection_Exception $expected) {
			return;
		}
		$this->fail('An expected exception has not been raised.');
	}
}

?>