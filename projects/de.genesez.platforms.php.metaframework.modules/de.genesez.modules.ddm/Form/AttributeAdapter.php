<?php
class Form_AttributeAdapter extends Form_BaseAdapter {
	protected $typeDao;
	protected $classDao;
	
	public function create($object = null, $action = null) {
		parent::create('attributeForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:', array('size' => 80));
		$this->form->addRule('name', 'the name is required', 'required', null, 'client');
		$this->form->addElement('text', 'column', 'column:', array('size' => 80));
		$this->form->addElement('textarea', 'description', 'description:', array('cols' => 80, 'rows' => 2));
		// type
		$type = $this->form->addElement('select', 'type', 'type:');
		$types = $this->typeDao->fetchAll();
		foreach ($types as $key => $value) {
			$type->addOption($value->t_name, $value->id);
		}
		// class
		$class = $this->form->addElement('select', 'class', 'class:');
		$classes = $this->classDao->fetchAll();
		foreach ($classes as $key => $value) {
			$class->addOption($value->c_name, $value->id);
		}
		// finish form
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($attribute = null) {
		if ($attribute === null) {
			$attribute = new DDM_Attribute();
		}
		$attribute->a_name = $this->form->exportValue('name');
		$column = $this->form->exportValue('column');
		if ($column == '') {
			$attribute->a_column = $this->form->exportValue('name');
		} else {
			$attribute->a_column = $this->form->exportValue('column');
		}
		$attribute->a_description = $this->form->exportValue('description');
		// type
		$typeId = $this->form->exportValue('type');
//		$type = $this->typeDao->fetch($typeId);
		$attribute->a_type = $typeId;
		// class
		$classId = $this->form->exportValue('class');
//		$class = $this->classDao->fetch($classId);
		$attribute->a_class = $classId;
		return $attribute;
	}
	
	public function errors() {
		$errors = array();
		$fields = array('name', 'column', 'description', 'type', 'class');
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
				'name' => $this->object->a_name,
				'column' => $this->object->a_column,
				'description' => $this->object->a_description,
				'type' => $this->object->a_type,
				'class' => $this->object->a_class
			);
		}
		return array();
	}
	
	public function setClassDao($classDao) {
		$this->classDao = $classDao;
	}
	public function setTypeDao($typeDao) {
		$this->typeDao = $typeDao;
	}
}
?>