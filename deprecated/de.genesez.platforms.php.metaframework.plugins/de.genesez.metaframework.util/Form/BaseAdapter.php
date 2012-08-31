<?php
require_once 'HTML/QuickForm.php';
require_once 'HTML/QuickForm/Renderer/ArraySmarty.php';

abstract class Form_BaseAdapter {
	
	protected $form;
	protected $defaults;
	protected $object;
	protected $action;
	
	public function create($name, $object = null, $action = null) {
		$this->object = $object;
		$this->action = $action;
		if ($action !== null) {
			$this->form = new HTML_QuickForm($name, 'post', $action);
		} else {
			$this->form = new HTML_QuickForm($name);
		}
		$this->defaults = $this->defaults();
		$this->form->setDefaults($this->defaults);
		$this->fillForm();
	}
	
	protected abstract function defaults();
	
	protected abstract function fillForm();
	
	public function isValid() {
		return $this->form->validate();
	}
	
	public function dto() {
		// we use the smarty array rendering because it provides a nicer array
		// as output as the common array rendering
		// instead of a smarty object, we pass this (the smarty object is not needed)
		$rendering = new HTML_QuickForm_Renderer_ArraySmarty($this, true);
		$this->form->accept($rendering);
		$dto = $rendering->toArray();
		return $dto;
	}
}
?>