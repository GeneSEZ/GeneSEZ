<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

require_once 'PHPUnit/Framework/TestSuite.php';
 
class DDM_TestSuite extends PHPUnit_Framework_TestSuite
{
	protected function setUp()
	{
		$manager = Doctrine_Manager::getInstance();
		$conn = $manager->getCurrentConnection();
		$conn->execute('DELETE FROM ddm_reference_o2o');
		$conn->execute('DELETE FROM ddm_reference_o2n');
		$conn->execute('DELETE FROM ddm_value_boolean');
		$conn->execute('DELETE FROM ddm_value_integer');
		$conn->execute('DELETE FROM ddm_value_string');
		$conn->execute('DELETE FROM ddm_object');
		$conn->execute('DELETE FROM ddm_association');
		$conn->execute('DELETE FROM ddm_attribute');
		$conn->execute('DELETE FROM ddm_class');
		$conn->execute('DELETE FROM ddm_type');
	}

	protected function tearDown()
	{
	}
}
?>
