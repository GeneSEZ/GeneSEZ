<?php
class Form_TypeAdapter extends Form_BaseAdapter {
	
	public function create($object = null, $action = null) {
		parent::create('typeForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:', array('size' => 80));
		$this->form->addRule('name', 'the name is required', 'required', null, 'client');
		$this->form->addElement('textarea', 'description', 'description:', array('cols' => 80, 'rows' => 2));
		$basetype = $this->form->addElement('select', 'basetype', 'basetype:');
		$basetypeValues = array('INTEGER' => 'integer', 'BOOLEAN' => 'boolean', 'STRING' => 'string');
		foreach ($basetypeValues as $key => $value) {
			$basetype->addOption($value, $key);
		}
		$this->form->addElement('text', 'constraint', 'constraint:', array('size' => 80));
		$this->form->addElement('checkbox', 'editable', 'editable:');
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($type = null) {
		if ($type === null) {
			$type = new DDM_Type();
		}
		$type->t_name = $this->form->exportValue('name');
		$type->t_description = $this->form->exportValue('description');
		$type->t_basetype = $this->form->exportValue('basetype');
		$type->t_constraint = $this->form->exportValue('constraint');
		if ($this->form->exportValue('editable') == '1') {
			$type->t_editable = true;
		} else {
			$type->t_editable = false;
		}
		return $type;
	}
	
	public function errors() {
		$errors = array();
		$fields = array('name', 'description', 'basetype', 'constraint', 'editable');
		foreach ($fields as $field) {
			$error = $this->form->getElementError($field);
			if ($error != '') {
				$errors[$field] = $error;
			}
		}
		return $errors;
	}
	
	protected function defaults() {
		if ($this->object !== null) {
			return array(
				'id' => $this->object->id,
				'name' => $this->object->t_name,
				'description' => $this->object->t_description,
				'basetype' => $this->object->t_basetype,
				'constraint' => $this->object->t_constraint,
				'editable' => $this->object->t_editable,
			);
		}
		return array();
	}
}
?>