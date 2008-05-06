
<?php
/* PROTECTED REGION ID(php.action.includes._14_0_b6f02e1_1208769447796_773548_222) ENABLED START */
// TODO: put your further includes for class 'LogoutAction' here
require_once '../../Bootstrap.php';
/* PROTECTED REGION END */

class LogoutAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.main.impl._14_0_b6f02e1_1208769447796_773548_222) ENABLED START */
		// TODO: put your implementation for 'LogoutAction::main()' here
		
		Bootstrap::$AUTH->logout();
		HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.own.impl._14_0_b6f02e1_1208769447796_773548_222) ENABLED START */
	// TODO: put your further implementations for the 'LogoutAction' here
	/* PROTECTED REGION END */
}
/* PROTECTED REGION ID(php.action.own.script._14_0_b6f02e1_1208769447796_773548_222) ENABLED START */
LogoutAction::main();
/* PROTECTED REGION END */
?>
