
<?php
require_once '../../Bootstrap.php';
/* PROTECTED REGION ID(php.action.list.includes._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
// TODO: put your further includes for class 'UserListAction' here
/* PROTECTED REGION END */

class UserListAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.list.main.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: put your implementation for 'UserListAction::main()' here
		
		$query = new Doctrine_Query();
		$query->from('User t');
		$users = $query->execute();
		Bootstrap::$SMARTY->assign('users', $users);
		Bootstrap::$SMARTY->assign('createAction', Bootstrap::CONTEXT_PATH . 'user/create.php');
		Bootstrap::$SMARTY->assign('editAction', Bootstrap::CONTEXT_PATH . 'user/edit.php');
		Bootstrap::$SMARTY->assign('deleteAction', Bootstrap::CONTEXT_PATH . 'user/delete.php');
		Bootstrap::$SMARTY->display('user/list.tpl');
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.list.own.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
	// TODO: put your further implementations for the 'UserListAction' here
	/* PROTECTED REGION END */
}
UserListAction::main();
?>
