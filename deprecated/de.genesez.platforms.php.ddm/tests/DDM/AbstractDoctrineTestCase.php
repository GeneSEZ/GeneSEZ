<?php

abstract class AbstractDoctrineTestCase extends PHPUnit_Framework_TestCase
{

	protected function setUp()
	{
		$manager = Doctrine_Manager::getInstance();
		$conn = $manager->getCurrentConnection();
		$conn->execute('DELETE FROM ddm_reference_o2o CASCADE');
		$conn->execute('DELETE FROM ddm_reference_o2n CASCADE');
		$conn->execute('DELETE FROM ddm_reference_n2o CASCADE');
		$conn->execute('DELETE FROM ddm_reference_n2n CASCADE');
		$conn->execute('DELETE FROM ddm_value_boolean CASCADE');
		$conn->execute('DELETE FROM ddm_value_integer CASCADE');
		$conn->execute('DELETE FROM ddm_value_string CASCADE');
		$conn->execute('DELETE FROM ddm_object CASCADE');
		$conn->execute('DELETE FROM ddm_attribute CASCADE');
		$conn->execute('DELETE FROM ddm_reverse_association CASCADE');
		$conn->execute('DELETE FROM ddm_association CASCADE');
		$conn->execute('DELETE FROM ddm_class CASCADE');
		$conn->execute('DELETE FROM ddm_type CASCADE');
	}
	
	public static function assertContains(Doctrine_Record $r, Doctrine_Collection $c, $message = null) {
		$found = false;
		foreach ($c as $e) {
			if ( $e->id === $r->id ) {
				$found = true;
			}
		}
		parent::assertTrue($found, $message);
	}

	public static function assertNotContains(Doctrine_Record $r, Doctrine_Collection $c, $message = null) {
		$found = false;
		foreach ($c as $e) {
			if ( $e->id === $r->id ) {
				$found = true;
			}
		}
		parent::assertFalse($found, $message);
	}
	
	public static function assertIsA($name, $object) {
		return parent::assertEquals($name, get_class($object));
	}
}

?>