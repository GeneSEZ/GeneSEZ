
<?php
require_once '../../Bootstrap.php';
/* PROTECTED REGION ID(php.action.delete.includes._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
// TODO: put your further includes for class 'UserDeleteAction' here
/* PROTECTED REGION END */

class UserDeleteAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.delete.main.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: put your implementation for 'UserDeleteAction::main()' here
		
		// check request parameters
		$id = isset($_REQUEST['id']) ? $_REQUEST['id'] : HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		$table = Doctrine::getTable('User');
		$user = $table->find($id);
		
		if ($user === false) {
			HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		} else {
			$user->delete();
		}
		HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.delete.own.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
	// TODO: put your further implementations for the 'UserDeleteAction' here
	/* PROTECTED REGION END */
}
UserDeleteAction::main();
?>
