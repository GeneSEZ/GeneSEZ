<?php
/**
 * Created on 13.07.2008
 *
 * @author Gerrit Beine
 */

define('TESTCONFIGURATION', 1);

# Add the tests directory to the include_path
$include_path = ini_get('include_path');
ini_set('include_path', $include_path . ':./tests:..');

# Load and initialize Doctrine
require_once('Doctrine/Doctrine.php');
spl_autoload_register(array('Doctrine', 'autoload'));
Doctrine_Manager::connection('pgsql://postgres@localhost/de_emnis_ddm_test');

?>
