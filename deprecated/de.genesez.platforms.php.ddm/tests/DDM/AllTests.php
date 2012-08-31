<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

require_once 'PHPUnit/TextUI/TestRunner.php';

if (!defined('PHPUnit_MAIN_METHOD')) {
    define('PHPUnit_MAIN_METHOD', 'DDM_AllTests::main');
    chdir(dirname(dirname(__FILE__)));
}

require_once 'DDM/TestSuite.php';
require_once 'DDM/ClassTest.php';
require_once 'DDM/ClassTableTest.php';
require_once 'DDM/TypeTest.php';
require_once 'DDM/TypeTableTest.php';
require_once 'DDM/AttributeTest.php';
require_once 'DDM/AttributeTableTest.php';
require_once 'DDM/AssociationTest.php';
require_once 'DDM/InheritanceTest.php';
require_once 'DDM/ChangingObjectsTest.php';
require_once 'DDM/DeletingObjectsTest.php';
require_once 'DDM/CreatingObjectsTest.php';
require_once 'DDM/CreatingAssociatedObjectsTest.php';

class DDM_AllTests
{
	/**
	 * Run DDM_AllTests 
	 */
	public static function main()
	{
		PHPUnit_TextUI_TestRunner::run(self::suite());
	}

	/**
	 * Create TestSuite for DDM_AllTests 
	 */
	public static function suite()
	{
		$suite = new DDM_TestSuite('DDM_Model');

		$suite->addTestSuite('DDM_TypeTest');
		$suite->addTestSuite('DDM_TypeTableTest');
		$suite->addTestSuite('DDM_ClassTest');
		$suite->addTestSuite('DDM_ClassTableTest');
		$suite->addTestSuite('DDM_AttributeTest');
		$suite->addTestSuite('DDM_AttributeTableTest');
		$suite->addTestSuite('DDM_AssociationTest');
		$suite->addTestSuite('DDM_InheritanceTest');
		$suite->addTestSuite('DDM_CreatingObjectsTest');
		$suite->addTestSuite('DDM_ChangingObjectsTest');
		$suite->addTestSuite('DDM_DeletingObjectsTest');
		$suite->addTestSuite('DDM_CreatingAssociatedObjectsTest');
		
		return $suite;
	}
}

if (PHPUnit_MAIN_METHOD == 'DDM_AllTests::main') {
	DDM_AllTests::main();
}

?>
