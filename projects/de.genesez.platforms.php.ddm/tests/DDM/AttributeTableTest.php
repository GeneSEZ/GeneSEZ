<?php

/**
 * Created on 27.04.2009
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

class DDM_AttributeTableTest extends AbstractDoctrineTestCase
{
	/**
	 * Test fetching an attribute by its id
	 */
	public function testFetch()
	{
		$type = new DDM_Type();
		$type->t_name = 'testFetchType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->save();
		$class = new DDM_Class();
		$class->c_name = 'testFetchClass';
		$class->save();
		$attribute = new DDM_Attribute();
		$attribute->a_name = 'testFetch';
		$attribute->class = $class;
		$attribute->type = $type;
		$attribute->save();
		$t = Doctrine::getTable('DDM_Attribute');
		$r = $t->fetch($attribute->id);
		$this->assertEquals($attribute, $r);
	}

	/**
	 * Test fetching all attributes
	 */
	public function testFetchAll() {
		$type = new DDM_Type();
		$type->t_name = 'testFetchAllType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->save();
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllClass' . $i;
			$class->save();
			$attribute = new DDM_Attribute();
			$attribute->a_name = 'testFetchAll' . $i;
			$attribute->class = $class;
			$attribute->type = $type;
			$attribute->save();
		}
		$t = Doctrine::getTable('DDM_Attribute');
		$r = $t->fetchAll();
		$this->assertEquals(10, $r->count());
	}

	/**
	 * Test fetching a limited amount of attributes
	 */
	public function testFetchAllMax() {
		$type = new DDM_Type();
		$type->t_name = 'testFetchAllMaxType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->save();
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllMaxClass' . $i;
			$class->save();
			$attribute = new DDM_Attribute();
			$attribute->a_name = 'testFetchAllMax' . $i;
			$attribute->class = $class;
			$attribute->type = $type;
			$attribute->save();
		}
		$t = Doctrine::getTable('DDM_Attribute');
		$r = $t->fetchAll(1);
		$this->assertEquals(1, $r->count());
		$r = $t->fetchAll(9);
		$this->assertEquals(9, $r->count());
		$r = $t->fetchAll(10);
		$this->assertEquals(10, $r->count());
		$r = $t->fetchAll(11);
		$this->assertEquals(10, $r->count());
	}

	/**
	 * Test fetching a limited amount of attributes
	 * beginning at a specified offset
	 */
	public function testFetchAllMaxOffset() {
		$type = new DDM_Type();
		$type->t_name = 'testFetchAllMaxOffsetType';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->save();
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllMaxOffsetClass' . $i;
			$class->save();
			$attribute = new DDM_Attribute();
			$attribute->a_name = 'testFetchAllMaxOffset' . $i;
			$attribute->class = $class;
			$attribute->type = $type;
			$attribute->save();
		}
		$t = Doctrine::getTable('DDM_Attribute');
		$r = $t->fetchAll(1, 5);
		$this->assertEquals(1, $r->count());
		$r = $t->fetchAll(4, 5);
		$this->assertEquals(4, $r->count());
		$r = $t->fetchAll(9, 5);
		$this->assertEquals(5, $r->count());
		$r = $t->fetchAll(10, 5);
		$this->assertEquals(5, $r->count());
		$r = $t->fetchAll(11, 10);
		$this->assertEquals(0, $r->count());
	}
}

?>