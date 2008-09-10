<?php
require_once 'HTML/QuickForm.php';
/**
 * Support class for dealing with QuickForm form definitions
 * 
 * It provides two methods for converting an object into a form definition and vise versa. 
 * An additional method is used to add some custom definitions to the form object.
 * 
 * @see		http://pear.php.net/manual/en/package.html.html-quickform.php
 * @author	dreamer
 */
class UserForm {
	/**
	 * creates a QuickForm form definition for a User
	 * @param	array	$defaultValues	default form values
	 * @return	HTML_QuickForm	form definition for a User
	 * @see		http://pear.php.net/manual/en/package.html.html-quickform.html-quickform.setdefaults.php
	 */
	public static function create($defaultValues = array()) {
		$form = new HTML_QuickForm('userForm');
		$form->setDefaults($defaultValues);
		$form->addElement('hidden', 'id');
		$form->addElement('text', 'login', 'login:');
		$form->addElement('password', 'password', 'password:');
		$form->addElement('password', 'passwordRepeat', 'Repeat password:');
		$form->addElement('text', 'firstName', 'firstName:');
		$form->addElement('text', 'lastName', 'lastName:');
		$form->addElement('text', 'email', 'email:');
		$form->addElement('submit', 'save', 'save');
		$form->addRule(
			array('password', 'passwordRepeat'),
			'The passwords you entered do not match!', 'compare'); 
		$form->applyFilter('login', 'trim');
		$form->applyFilter('password', 'trim');
		$form->applyFilter('firstName', 'trim');
		$form->applyFilter('lastName', 'trim');
		$form->applyFilter('email', 'trim');
		self::addCustomDefinition($form);
		return $form;
	}
	/**
	 * sets the values of the form object to the User object
	 * if the User object is obmitted, a new instance is created
	 * @param	HTML_QuickForm	a form, submitted by the user
	 * @param	User	an object to which the values of the form are set
	 * @return	User	the object with the submitted values
	 */
	public static function buildUser($form, $user = null) {
		if ($user === null) {
			$user = new User();
		}
		$user->login = $form->exportValue('login');
		if ($form->exportValue('password') != "") {
		$user->password = $form->exportValue('password');
		}
		$user->firstName = $form->exportValue('firstName');
		$user->lastName = $form->exportValue('lastName');
		$user->email = $form->exportValue('email');
		return $user;
	}
	/**
	 * method to add custom definitions to the form object
	 * @generated	method stub for further implementation
	 * @param	HTML_QuickForm	the created form for further adjustments
	 * @see		create()
	 */
	private static function addCustomDefinition($form) {
		/* PROTECTED REGION ID(pear.quickform.custom.definitions._14_0_b6f02e1_1206538020843_168097_254) ENABLED START */
		// TODO: further form definitions for class 'UserForm'
		/* PROTECTED REGION END */
	}
}
?>
