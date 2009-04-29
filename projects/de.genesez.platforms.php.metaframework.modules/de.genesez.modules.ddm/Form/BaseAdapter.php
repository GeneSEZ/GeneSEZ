<?php
require_once 'HTML/QuickForm.php';
require_once 'HTML/QuickForm/Renderer/ArraySmarty.php';
abstract class Form_BaseAdapter {
	
	protected $form;
	
	public function __construct($object = null) {
		$this->createForm($object);
	}
	
	protected abstract function createForm($object = null);
	
	public function isValid() {
		return $this->form->validate();
	}
	
	public function dto() {
		// we use the smarty array renderer because it provides a nicer array
		// as output as the common array renderer
		// instead of a smarty object, we pass this (the smarty object is not needed)
		$renderer = new HTML_QuickForm_Renderer_ArraySmarty($this, true);
		$this->form->accept($renderer);
		$dto = $renderer->toArray();
		return $dto;
	}
	
	protected function customFormElements() {
		// overwrite to add custom form elements
	}
	
	protected function customObject($object) {
		return $type;
	}
	
	protected function customErrors($errors = array()) {
		return $errors;
	}
}
?>