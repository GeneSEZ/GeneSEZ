
<?php
/* PROTECTED REGION ID(php.action.includes._14_0_b6f02e1_1208769441109_839226_219) ENABLED START */
// TODO: put your further includes for class 'LoginAction' here
require_once '../../Bootstrap.php';
/* PROTECTED REGION END */

class LoginAction {
	public static function main() {
		/* PROTECTED REGION ID(php.action.main.impl._14_0_b6f02e1_1208769441109_839226_219) ENABLED START */
		// TODO: put your implementation for 'LoginAction::main()' here
		
		$form = new HTML_QuickForm('loginForm');
		$form->addElement('text', 'username', 'Enter your login');
		$form->addElement('password', 'password', 'Enter your password');
		
		$form->applyFilter('username', 'trim');
		$form->applyFilter('password', 'trim');
		
		$form->addElement('submit', 'login', 'login');
		
		$renderer = new HTML_QuickForm_Renderer_ArraySmarty(Bootstrap::$SMARTY, true);
		$form->accept($renderer);
		Bootstrap::$SMARTY->assign('form', $renderer->toArray());
		Bootstrap::$SMARTY->assign('error', Bootstrap::$AUTH->getStatus());
		Bootstrap::$SMARTY->display('login/login.tpl');
		
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(php.action.own.impl._14_0_b6f02e1_1208769441109_839226_219) ENABLED START */
	// TODO: put your further implementations for the 'LoginAction' here
	/* PROTECTED REGION END */
}
/* PROTECTED REGION ID(php.action.own.script._14_0_b6f02e1_1208769441109_839226_219) ENABLED START */
/* PROTECTED REGION END */
?>
