<?php
class Form_ObjectAdapter extends BaseAdapter {
	protected $class;
	protected $classDao;
	protected $objectDao;
	protected $attributeDao;
	
	public function __construct($class, $object = null, $action = null) {
		parent::__construct( $class . 'Form', $object, $action);
		$this->class = $class;
		$this->classDao = Doctrine::getTable('ddm_class');
		$this->objectDao = Doctrine::getTable('ddm_object');
		$this->attributeDao = Doctrine::getTable('ddm_attribute');
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$attributes = $this->objectDao->fetchAllAttributes($class);
		foreach ($attributes as $attrib) {
			$this->addAttribute($attrib);
		}
		$associations = $this->objectDao->fetchOwnAssociations($class);
		foreach ($associations as $assoc) {
			$this->addAssociation($assoc);
		}
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($object = null) {
		$class = $this->classDao->fetchByName($this->class);
		if ($object === null) {
			$object = new DDM_Object();
			$object->class = $class;
		}
		$attributes = $this->objectDao->fetchAllAttributes($this->class);
		foreach($attributes as $attrib) {
			$this->addValue($object, $attrib);
		}
		$associations = $this->objectDao->fetchOwnAssociations($class);
		foreach ($associations as $assoc) {
			$this->addReference($object, $assoc);
		}
		$object = $this->customObject();
		return $object;
	}
	
	public function errors() {
		
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== NULL) {
			$defaults['id'] = $this->object->id;
			// attributes
			$attributes = $this->objectDao->fetchAllAttributes($class);
			foreach ($attributes as $attrib) {
				$name = $attrib->a_name;
				$defaults[$name] = $this->object->$name;
			}
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
	
	protected function addAttribute(DDM_Attribute $attribute) {
		switch ($attribute->type->t_basetype) {
			case 'BOOLEAN':
				$this->form->addElement('checkbox', $attribute->a_name, $attribute->a_name . ':');
				break;
			case 'STRING': ;
			case 'INTEGER': ;
			default:
				$this->form->addElement('text', $attribute->a_name, $attribute->a_name . ':');
				break;
		}
	}
	
	protected function addAssociation(DDM_Association $association) {
		$assoc = $this->form->addElement('select', $association->s_name, $association->s_name . ':');
		$entity;
		$cardinality;
		if ($association->left->c_name === $this->class) {
			$entity = $association->right->c_name;
			$cardinality = $association->s_right_cardinality;
		} else if ($association->right->c_name === $this->class) {
			$entity = $association->left->c_name;
			$cardinality = $association->s_left_cardinality;
		}
		// check multiplicity, only if optional
		if ($cardinality === '0..1' || $cardinality === 'N') {
			$assoc->addOption('', '');
		}
		$values = $this->objectDao->fetchAllByClass($entity);
		foreach ($values as $value) {
			$assoc->addOption($value->id, $value->id);
		}
	}
	
	protected function addValue(DDM_Object $object, DDM_Attribute $attribute) {
		$name = $attribute->a_name;
		switch ($attribute->type->t_basetype) {
			case 'BOOLEAN':
				$value = $this->form->exportValue($name);
				if ($value) {
					$object->$name = true;
				} else {
					$object->$name = false;
				}
				break;
			case 'STRING': ;
			case 'INTEGER': ;
			default:
				$object->$name = $this->form->exportValue($name);
				break;
		}
	}
	
	protected function addLink(DDM_Object $object, DDM_Association $association) {
		$name = $association->s_name;
		$id = $this->form->exportValue($name);
		// check if it's an optional reference
		if ($id === '') {
			return;
		}
		$ref = $this->objectDao->fetch($id);
		$object->$name = $ref;
	}
}
?>