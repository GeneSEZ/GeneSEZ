
<?php
require_once '../../Bootstrap.php';
/* PROTECTED REGION ID(php.action.create.includes._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
// TODO: put your further includes for class 'UserCreateAction' here
/* PROTECTED REGION END */

class UserCreateAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.create.main.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: put your implementation for 'UserCreateAction::main()' here
		
		// build user edit form
		$form = UserForm::buildForm();
		
		if ($form->validate()) {
			$user = new User();
			$user->login = $form->exportValue('login');
			$user->password = $form->exportValue('password');
			$user->firstName = $form->exportValue('firstName');
			$user->lastName = $form->exportValue('lastName');
			$user->email = $form->exportValue('email');
			
			// stores the user in db
			$user->save();
			
			// redirect to user list view
			HTTP::redirect(Bootstrap::CONTEXT_PATH . "user/list.php");
		} else {
			// display the form to edit an user
			//$form->display();
			
			$renderer = new HTML_QuickForm_Renderer_ArraySmarty(Bootstrap::$SMARTY, true);
			$form->accept($renderer);
			Bootstrap::$SMARTY->assign('form', $renderer->toArray());
			Bootstrap::$SMARTY->display('user/edit.tpl');
		}
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.create.own.impl._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
	// TODO: put your further implementations for the 'UserCreateAction' here
	/* PROTECTED REGION END */
}
UserCreateAction::main();
?>
