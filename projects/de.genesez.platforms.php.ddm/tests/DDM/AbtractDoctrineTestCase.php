<?php

abstract class AbstractDoctrineTestCase extends PHPUnit_Framework_TestCase
{

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
}

?>