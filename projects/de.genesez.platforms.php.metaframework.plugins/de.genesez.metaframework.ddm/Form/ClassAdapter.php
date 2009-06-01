<?php
class Form_ClassAdapter extends Form_BaseAdapter {
	protected $classDao;
	
	public function create($object = null, $action = null) {
		parent::create('classForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:', array('size' => 80));
		$this->form->addRule('name', 'the name is required', 'required', null, 'client');
		$this->form->addElement('text', 'view', 'view:', array('size' => 80));
		$this->form->addElement('textarea', 'description', 'description:', array('cols' => 80, 'rows' => 2));
		$this->form->addElement('checkbox', 'editable', 'editable:');
		$parent = $this->form->addElement('select', 'parent', 'parent:');
		$parent->addOption('', '');
		$classes;
		if (array_key_exists('id', $this->defaults)) {
			$classes = $this->classDao->fetchAllExcept($this->defaults['id']);
		} else {
			$classes = $this->classDao->fetchAll();
		}
		foreach ($classes as $key => $value) {
			$parent->addOption($value->c_name, $value->id);
		}
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($class = null) {
		if ($class === null) {
			$class = new DDM_Class();
		}
		$class->c_name = $this->form->exportValue('name');
		$view = $this->form->exportValue('view');
		if ($view == '') {
			$class->c_view = $this->form->exportValue('name');
		} else {
			$class->c_view = $this->form->exportValue('view');
		}
		$class->c_description = $this->form->exportValue('description');
		$parent = $this->form->exportValue('parent');
		if ($parent != '') {
			$class->c_parent = $parent;
		}
		if ($this->form->exportValue('editable') == '1') {
			$class->c_editable = true;
		} else {
			$class->c_editable = false;
		}
		return $class;
	}
	
	public function errors() {
		$errors = array();
		$fields = array('name', 'view', 'description', 'editable', 'parent');
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
				'name' => $this->object->c_name,
				'view' => $this->object->c_view,
				'description' => $this->object->c_description,
				'editable' => $this->object->c_editable,
				'parent' => $this->object->c_parent
			);
		}
		return array();
	}
	
	public function setClassDao($classDao) {
		$this->classDao = $classDao;
	}
}
?>