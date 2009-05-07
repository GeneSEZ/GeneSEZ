<?php
class Form_AttributeAdapter extends BaseAdapter {
	protected $typeDao;
	protected $classDao;
	
	public function __construct($object = null, $action = null) {
		parent::__construct('attributeForm', $object, $action);
		$this->typeDao = Doctrine::getTable('ddm_type');
		$this->classDao = Doctrine::getTable('ddm_class');
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$this->form->addElement('text', 'column', 'column:');
		$this->form->addElement('text', 'description', 'description:');
		// type
		$type = $this->form->addElement('select', 'type', 'type:');
		$types = $this->typeDao->fetchAll();
		foreach ($types as $key => $value) {
			$type->addOption($value, $value->id);
		}
		// class
		$class = $this->form->addElement('select', 'class', 'class:');
		$classes = $this->classDao->fetchAll();
		foreach ($classes as $key => $value) {
			$class->addOption($value, $value->id);
		}
		// finish form
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($type = null) {
		if ($attribute === null) {
			$attribute = new DDM_Attribute();
		}
		$attribute->a_name = $this->form->exportValue('name');
		$attribute->a_name = $this->form->exportValue('column');
		$attribute->a_name = $this->form->exportValue('description');
		// type
		$typeId = $this->form->exportValue('type');
		$type = $this->typeDao->fetch($typeId);
		$attribute->type = $type;
		// class
		$classId = $this->form->exportValue('class');
		$class = $this->classDao->fetch($classId);
		$attribute->class = $class;
		$attribute = $this->customObject($attribute);
		return $attribute;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['column'] = $this->form->getElementError('column');
		$errors['description'] = $this->form->getElementError('description');
		$errors['type'] = $this->form->getElementError('type');
		$errors['class'] = $this->form->getElementError('class');
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $this->object->id,
				'name' => $this->object->a_name,
				'column' => $this->object->a_column,
				'description' => $this->object->a_description,
				'type' => $this->object->a_type,
				'class' => $this->object->a_class
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>