<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

require_once('PHPUnit/TextUI/TestRunner.php');

if (!defined('PHPUnit_MAIN_METHOD')) {
    define('PHPUnit_MAIN_METHOD', 'Model_AllTests::main');
    chdir(dirname(dirname(__FILE__)));
}

require_once('DDM/TestSuite.php');
require_once('DDM/ClassTest.php');
require_once('DDM/TypeTest.php');
require_once('DDM/AttributeTest.php');
require_once('DDM/AssociationTest.php');
require_once('DDM/ChangingObjectsTest.php');
require_once('DDM/DeletingObjectsTest.php');
require_once('DDM/CreatingObjectsTest.php');
require_once('DDM/CreatingAssociatedObjectsTest.php');

class Model_AllTests
{
	public static function main()
	{
		PHPUnit_TextUI_TestRunner::run(self::suite());
	}

	public static function suite()
	{
		$suite = new DDM_TestSuite('DDM_Model');

		$suite->addTestSuite('TypeTest');
		$suite->addTestSuite('ClassTest');
		$suite->addTestSuite('AttributeTest');
		$suite->addTestSuite('AssociationTest');
		$suite->addTestSuite('CreatingObjectsTest');
		$suite->addTestSuite('ChangingObjectsTest');
		$suite->addTestSuite('DeletingObjectsTest');
		$suite->addTestSuite('CreatingAssociatedObjectsTest');
		
		return $suite;
	}
}

if (PHPUnit_MAIN_METHOD == 'Model_AllTests::main') {
	Model_AllTests::main();
}

?>
