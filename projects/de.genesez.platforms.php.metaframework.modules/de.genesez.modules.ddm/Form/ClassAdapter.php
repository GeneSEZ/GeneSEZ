<?php
class Form_ClassAdapter extends Form_BaseAdapter {
	protected $classDao;
	
	public function __construct($object = null, $action = null) {
		parent::__construct('classForm', $object, $action);
		$this->classDao = Doctrine::getTable('ddm_class');
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$editable = $form->addElement('checkbox', 'editable', 'editable:');
		$parent = $form->addElement('select', 'parent', 'parent:');
		$parent->addOption('', '');
		$classes;
		$dao = Doctrine::getTable('ddm_class');
		if (array_key_exists('id', $defaults)) {
			$classes = $this->classDao->fetchAllExcept($defaults['id']);
		} else {
			$classes = $this->classDao->fetchAll();
		}
		foreach ($classes as $key => $value) {
			$parent->addOption($value, $value->id);
		}
		$form->addElement('submit', 'save', 'save');
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($class = null) {
		if ($class === null) {
			$class = new DDM_Class();
		}
		$class->c_name = $this->form->exportValue('name');
		$class->c_parent = $this->form->exportValue('parent');
		if ($this->form->exportValue('editable')) {
			$class->c_editable = true;
		} else {
			$class->c_editable = false;
		}
		return $class;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['editable'] = $this->form->getElementError('editable');
		$errors['parent'] = $this->form->getElementError('parent');
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $$this->object->id, 
				'name' => $this->object->c_name,
				'editable' => $this->object->c_editable,
				'parent' => $this->object->c_parent
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>