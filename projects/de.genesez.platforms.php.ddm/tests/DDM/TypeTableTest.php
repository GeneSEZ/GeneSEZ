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

class DDM_TypeTableTest extends AbstractDoctrineTestCase
{

	/**
	 * Test fetching a type by its id
	 */
	public function testFetch()
	{
		$type = new DDM_Type();
		$type->t_name = 'testFetch';
		$type->t_basetype = 'STRING';
		$type->t_constraint = '';
		$type->save();
		$t = Doctrine::getTable('DDM_Type');
		$r = $t->fetch($type->id);
		$this->assertEquals($type, $r);
	}

	/**
	 * Test fetching all types
	 */
	public function testFetchAll() {
		for ($i = 0; $i < 10; $i++) {
			$type = new DDM_Type();
			$type->t_name = 'testFetchAll' . $i;
			$type->t_basetype = 'STRING';
			$type->t_constraint = '';
			$type->save();
		}
		$t = Doctrine::getTable('DDM_Type');
		$r = $t->fetchAll();
		$this->assertEquals(10, $r->count());
	}

	/**
	 * Test fetching a limited amount of types
	 */
	public function testFetchAllMax() {
		for ($i = 0; $i < 10; $i++) {
			$type = new DDM_Type();
			$type->t_name = 'testFetchAll' . $i;
			$type->t_basetype = 'STRING';
			$type->t_constraint = '';
			$type->save();
		}
		$t = Doctrine::getTable('DDM_Type');
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
	 * Test fetching a limited amount of types
	 * beginning at a specified offset
	 */
	public function testFetchAllMaxOffset() {
		for ($i = 0; $i < 10; $i++) {
			$type = new DDM_Type();
			$type->t_name = 'testFetchAll' . $i;
			$type->t_basetype = 'STRING';
			$type->t_constraint = '';
			$type->save();
		}
		$t = Doctrine::getTable('DDM_Type');
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