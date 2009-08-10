
<?php
require_once '../../Bootstrap.php';
/* PROTECTED REGION ID(php.action.edit.includes._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
// TODO: put your further includes for class 'UserEditAction' here
/* PROTECTED REGION END */

class UserEditAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.edit.main.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: put your implementation for 'UserEditAction::main()' here
		
		// check request parameters
		$id = isset($_REQUEST['id']) ? $_REQUEST['id'] : 0;
		$table = Doctrine::getTable('User');
		$user = $table->find($id);
		
		$defaults = array(
			'id' => $user->id,
			'login' => $user->login,
			'firstName' => $user->firstName,
			'lastName' => $user->lastName,
			'email' => $user->email
		);
		
		// build user edit form
		$form = UserForm::create($defaults);
		
		if ($form->validate()) {
			$user = UserForm::buildUser($form, $user);
			$user->save();
			
			HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		} else {
			//$form->display();
			$renderer = new HTML_QuickForm_Renderer_ArraySmarty(Bootstrap::$SMARTY, true);
			$form->accept($renderer);
			Bootstrap::$SMARTY->assign('form', $renderer->toArray());
			Bootstrap::$SMARTY->display('user/edit.tpl');
		}
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.edit.own.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
	// TODO: put your further implementations for the 'UserCreateAction' here
	/* PROTECTED REGION END */
}
UserEditAction::main();
?>
