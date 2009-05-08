<?php
class Form_TypeAdapter extends Form_BaseAdapter {
	
	public function __construct($object = null, $action = null) {
		parent::__construct('typeForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$this->form->addElement('text', 'description', 'description:');
		$basetype = $this->form->addElement('select', 'basetype', 'basetype:');
		$basetypeValues = array('INTEGER' => 'integer', 'BOOLEAN' => 'boolean', 'STRING' => 'string');
		foreach ($basetypeValues as $key => $value) {
			$basetype->addOption($value, $key);
		}
		$this->form->addElement('text', 'constraint', 'constraint:');
		$this->form->addElement('checkbox', 'editable', 'editable:');
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($type = null) {
		if ($type === null) {
			$type = new DDM_Type();
		}
		$type->t_name = $this->form->exportValue('name');
		$type->t_description = $this->form->exportValue('description');
		$type->t_basetype = $this->form->exportValue('basetype');
		$type->t_constraint = $this->form->exportValue('constraint');
		if ($this->form->exportValue('editable')) {
			$type->t_editable = true;
		} else {
			$type->t_editable = false;
		}
		$type = $this->customObject($type);
		return $type;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['description'] = $this->form->getElementError('description');
		$errors['basetype'] = $this->form->getElementError('basetype');
		$errors['constraint'] = $this->form->getElementError('constraint');
		$errors['editable'] = $this->form->getElementError('editable');
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $this->object->id,
				'name' => $this->object->t_name,
				'description' => $this->object->t_description,
				'basetype' => $this->object->t_basetype,
				'constraint' => $this->object->t_constraint,
				'editable' => $this->object->t_editable,
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>