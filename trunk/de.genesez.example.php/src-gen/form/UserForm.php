<?php

require_once 'HTML/QuickForm.php';
class UserForm {
	public static function buildForm( $defaultValues = array() ) {
		$form = new HTML_QuickForm('userForm');
		$form->setDefaults( $defaultValues );
		
		$form->addElement('hidden', 'id');
		$form->addElement('text', 'login', 'Enter the login');
		$form->addElement('password', 'password', 'Enter the password');
		$form->addElement('text', 'firstName', 'Enter the firstName');
		$form->addElement('text', 'lastName', 'Enter the lastName');
		$form->addElement('text', 'email', 'Enter the email');
		
		$form->applyFilter('login', 'trim');
		$form->applyFilter('password', 'trim');
		$form->applyFilter('firstName', 'trim');
		$form->applyFilter('lastName', 'trim');
		$form->applyFilter('email', 'trim');
		
		/* PROTECTED REGION ID(pear.quickform.buildform._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: further formular definitions for class 'UserForm'
		/* PROTECTED REGION END */
		
		$form->addElement('submit', 'save', 'save');
		
		return $form;
	}
}
?>
