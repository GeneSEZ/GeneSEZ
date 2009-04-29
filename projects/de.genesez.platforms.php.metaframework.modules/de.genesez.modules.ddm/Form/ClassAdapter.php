<?php
class Form_ClassAdapter extends Form_BaseAdapter {
	
	public function object($class = null) {
		if ($class === NULL) {
			$class = new DDM_Class();
		}
		$class->c_name = $form->exportValue('name');
		if ($form->exportValue('editable')) {
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
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function createForm($class = null) {
		$defaults = $this->defaults($class);
		$this->form = new HTML_QuickForm('classForm');
		$this->form->setDefaults($defaults);
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$editable = $form->addElement('checkbox', 'editable', 'editable:');
		$parent = $form->addElement('select', 'parent', 'parent:');
		$parent->addOption('', '');
		$classes;
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
	
	protected function defaults($class = null) {
		$defaults = array();
		if ($class !== NULL) {
			$defaults = array(
				'id' => $class->id, 
				'name' => $class->c_name,
				'editable' => $class->c_editable,
				'parent' => $class->c_parent
			);
		}
		$defaults = $this->customDefaults($defaults, $class);
		return $defaults;
	}
}
?>