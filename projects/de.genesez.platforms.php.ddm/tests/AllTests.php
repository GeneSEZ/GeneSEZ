<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

// PHPUnit
require_once('PHPUnit/Framework/TestSuite.php');
require_once('PHPUnit/TextUI/TestRunner.php');

// Test configuration
require_once('tests/TestConfiguration.php');

// Model tests
require_once('DDM/AllTests.php');

class AllTests
{
    public static function main()
    {
        PHPUnit_TextUI_TestRunner::run(self::suite());
    }

    public static function suite()
    {
        $suite = new PHPUnit_Framework_TestSuite('DDM');
        $suite->addTest(DDM_AllTests::suite());
        return $suite;
    }
}

if (PHPUnit_MAIN_METHOD == 'AllTests::main') {
    AllTests::main();
}

?>
