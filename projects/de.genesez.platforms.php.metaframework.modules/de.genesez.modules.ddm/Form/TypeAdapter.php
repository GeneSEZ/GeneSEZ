<?php
class Form_TypeAdapter extends Form_BaseAdapter {
	
	public function __construct($object = null, $action = null) {
		parent::__construct('typeForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$basetype = $this->form->addElement('select', 'basetype', 'basetype:');
		$basetypeValues = array('INTEGER' => 'integer', 'BOOLEAN' => 'boolean', 'STRING' => 'string');
		foreach ($basetypeValues as $key => $value) {
			$basetype->addOption($value, $key);
		}
		$this->form->addElement('text', 'constraint', 'constraint:');
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($type = null) {
		if ($type === null) {
			$type = new DDM_Type();
		}
		$type->t_name = $form->exportValue('name');
		$type->t_basetype = $form->exportValue('basetype');
		$type->t_constraint = $form->exportValue('constraint');
		$type = $this->customObject($form, $type);
		return $type;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['basetype'] = $this->form->getElementError('basetype');
		$errors['constraint'] = $this->form->getElementError('constraint');
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $type->id,
				'name' => $type->t_name,
				'basetype' => $type->t_basetype,
				'constraint' => $type->t_constraint
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>