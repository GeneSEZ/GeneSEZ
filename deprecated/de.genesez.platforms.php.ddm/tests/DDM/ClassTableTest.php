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

class DDM_ClassTableTest extends AbstractDoctrineTestCase
{

	/**
	 * Test fetching a class by its id
	 */
	public function testFetch()
	{
		$class = new DDM_Class();
		$class->c_name = 'testFetch';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetch($class->id);
		$this->assertEquals($class, $r);
	}

	/**
	 * Test fetching a class by its name
	 */
	public function testFetchByName() {
		$class = new DDM_Class();
		$class->c_name = 'testFetchByName';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetchByName('testFetchByName');
		$this->assertEquals($class, $r);
	}
	
	/**
	 * Test checking existance of a class by its name 
	 */
	public function testExist() {
		$class = new DDM_Class();
		$class->c_name = 'testExist';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$this->assertTrue( $r = $t->exist('testExist') );
		$this->assertFalse( $r = $t->exist('Die_Kuh_lief_um_den_Teich_Class') );
	}

	/**
	 * Test fetching all classes
	 */
	public function testFetchAll() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAll' . $i;
			$class->save();
		}
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetchAll();
		$this->assertEquals(10, $r->count());
	}

	/**
	 * Test fetching a limited amount of classes
	 */
	public function testFetchAllMax() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllMax' . $i;
			$class->save();
		}
		$t = Doctrine::getTable('DDM_Class');
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
	 * Test fetching a limited amount of classes
	 * beginning at a specified offset
	 */
	public function testFetchAllMaxOffset() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllMaxOffset' . $i;
			$class->save();
		}
		$t = Doctrine::getTable('DDM_Class');
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

	/**
	 * Test fetching all classes except the given
	 */
	public function testFetchAllExcept() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllExcept' . $i;
			$class->save();
		}
		$class = new DDM_Class();
		$class->c_name = 'testFetchAllExcept';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetchAll();
		$this->assertEquals(11, $r->count());
		$this->assertContains($class, $r);
		$r = $t->fetchAllExcept($class->id);
		$this->assertEquals(10, $r->count());
		$this->assertNotContains($class, $r);
	}

	/**
	 * Test fetching a limited amount of classes except the given
	 */
	public function testFetchAllExceptMax() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllExcept' . $i;
			$class->save();
		}
		$class = new DDM_Class();
		$class->c_name = 'testFetchAllExcept';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetchAll();
		$this->assertEquals(11, $r->count());
		$this->assertContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 9);
		$this->assertEquals(9, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 10);
		$this->assertEquals(10, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 11);
		$this->assertEquals(10, $r->count());
		$this->assertNotContains($class, $r);
	}

	/**
	 * Test fetching a limited amount of classes
	 * except the given beginning at a specified offset
	 */
	public function testFetchAllExceptMaxOffset() {
		for ($i = 0; $i < 10; $i++) {
			$class = new DDM_Class();
			$class->c_name = 'testFetchAllExcept' . $i;
			$class->save();
		}
		$class = new DDM_Class();
		$class->c_name = 'testFetchAllExcept';
		$class->save();
		$t = Doctrine::getTable('DDM_Class');
		$r = $t->fetchAll();
		$this->assertEquals(11, $r->count());
		$this->assertContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 1, 5);
		$this->assertEquals(1, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 4, 5);
		$this->assertEquals(4, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 9, 5);
		$this->assertEquals(5, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 10, 5);
		$this->assertEquals(5, $r->count());
		$this->assertNotContains($class, $r);
		$r = $t->fetchAllExcept($class->id, 11, 10);
		$this->assertEquals(0, $r->count());
		$this->assertNotContains($class, $r);
	}
}

?>
