
<?php
/* PROTECTED REGION ID(bootstap.includes) ENABLED START */
// TODO: put your includes for class 'Bootstrap' here
require_once 'Doctrine.php';
require_once 'Smarty.class.php';
require_once 'Auth.php';
require_once 'HTTP.php';
require_once 'HTML/QuickForm.php';
require_once 'HTML/QuickForm/Renderer/ArraySmarty.php';
require_once 'form/UserForm.php';
require_once 'util/DoctrineAuthProvider.php';
require_once 'priv/login/login.php';
/* PROTECTED REGION END */

class Bootstrap {
	
	/* PROTECTED REGION ID(bootstap.members) ENABLED START */
	/* TODO: put your constants and variables here */
	
	// base url of the application when running on the webserver
	const CONTEXT_PATH = "/fh3/de.genesez.example.php/pub/";
	
	// base file system path of the application (path of bootstrap file)
	public static $BASE_PATH = "";
	// smarty instance for the application
	public static $SMARTY = NULL;
	public static $AUTH = NULL;
	
	/* PROTECTED REGION END */
	
	public static function main() {
		/* PROTECTED REGION ID(bootstap.main) ENABLED START */
		/* TODO: put your initialization code here */
		
		// set base path
		self::$BASE_PATH = dirname(__FILE__) . '/';
		
		// -- init phpdoctrine ----------------------------------------------
		// register the autoloader
		spl_autoload_register(array('Doctrine', 'autoload'));
		
		Doctrine::loadModels(self::$BASE_PATH . 'core');
		Doctrine_Manager::connection('mysql://root@localhost/phptest');
		Doctrine_Manager::getInstance()->setAttribute('model_loading', 'conservative');
		
		// export the classes
		Doctrine::createTablesFromArray(array('User'));
		
		
		// -- init smarty ---------------------------------------------------
		self::$SMARTY = new Smarty();
		self::$SMARTY->template_dir = self::$BASE_PATH . 'smarty/templates';
		self::$SMARTY->config_dir = self::$BASE_PATH . 'smarty/config';
		self::$SMARTY->compile_dir = self::$BASE_PATH . 'smarty/compile';
		self::$SMARTY->cache_dir = self::$BASE_PATH . 'smarty/cache';
		
		
		// -- bootstrap authentication --------------------------------------
		$authProvider = new DoctrineAuthProvider();
		self::$AUTH = new Auth($authProvider, array(), array('LoginAction', 'main'));
		//self::$AUTH = new Auth($authProvider);
		self::$AUTH->setExpire(60);
		self::$AUTH->start();
		
		// if not authenticated, redirect to login page
		if (!self::$AUTH->checkAuth()) {
			// display login page
			exit;
		}
		
		//print_r($_SESSION['_authsession']);
		
		/* PROTECTED REGION END */
	}
}
Bootstrap::main();
?>
