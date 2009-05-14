<?php
class Form_ObjectAdapter extends Form_BaseAdapter {
	protected $class;
	protected $classDao;
	protected $objectDao;
	protected $attributeDao;
	
	public function create($class, $object = null, $action = null) {
		$this->class = $class;
		parent::create( $class . 'Form', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$classes = $this->classDao->fetchSuperclasses($this->class);
		foreach ($classes as $class) {
			foreach ($class->attributes as $attrib) {
				$this->addAttribute($attrib, $class);
			}
			foreach ($class->associations as $assoc) {
				$this->addAssociation($assoc, $class);
			}
		}
		// TODO: i guess this should be replaced
		if (array_key_exists('association_from_id', $_REQUEST) && array_key_exists('association_name', $_REQUEST)) {
			$id = $this->form->addElement('hidden', 'association_from_id', $_REQUEST['association_from_id']);
			$assoc = $this->form->addElement('hidden', 'association_name', $_REQUEST['association_name']);
		}
//		$attributes = $this->objectDao->fetchAllAttributes($class);
//		foreach ($attributes as $attrib) {
//			$this->addAttribute($attrib);
//		}
//		$associations = $this->objectDao->fetchOwnAssociations($class);
//		foreach ($associations as $assoc) {
//			$this->addAssociation($assoc);
//		}
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($object = null) {
		$class = $this->classDao->fetchByName($this->class);
		if ($object === null) {
			$object = new DDM_Object();
			$object->class = $class;
		}
		foreach ($this->classDao->fetchSuperclasses($this->class) as $class) {
			foreach ($class->attributes as $attrib) {
				$this->addValue($object, $attrib, $this->getAttributePrefix($class));
			}
			foreach ($class->associations as $assoc) {
				$this->addLink($object, $assoc, $this->getAssociationPrefix($class));
			}
		}
//		$attributes = $this->objectDao->fetchAllAttributes($this->class);
//		foreach($attributes as $attrib) {
//			$this->addValue($object, $attrib);
//		}
//		$associations = $this->objectDao->fetchOwnAssociations($class);
//		foreach ($associations as $assoc) {
//			$this->addReference($object, $assoc);
//		}
		return $object;
	}
	
	public function errors() {
		$errors = array();
		foreach ($this->classDao->fetchSuperclasses($this->class) as $class) {
			foreach ($class->attributes as $attrib) {
				$formname = $this->getAttributePrefix($class) . $attrib->a_name;
				$error = $this->form->getElementError($formname);
				if ($error != '') {
					$errors[$formname] = $error;
				}
			}
		}
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults['id'] = $this->object->id;
			foreach ($this->classDao->fetchSuperclasses($this->class) as $class) {
				foreach ($class->attributes as $attrib) {
					$formname = $this->getAttributePrefix($class) . $attrib->a_name;
					$name = $attrib->a_name;
					$defaults[$formname] = $this->object->$name;
				}
				foreach ($class->associations as $assoc) {
					$formname = $this->getAssociationPrefix($class) . $assoc->s_name;
					$name = $assoc->s_name;
					if ($assoc->s_to_cardinality === '0..1' || $assoc->s_to_cardinality === '1') {
						$defaults[$formname] = $this->object->$name->id;
					} else {
						$values = array();
						$objects = $this->object->$name;
						if ($objects !== null) {
							foreach ($this->object->$name as $object) {
								$values[] = $object->id;
							}
						}
					}
				}
			}
			// attributes
//			$attributes = $this->objectDao->fetchAllAttributes($class);
//			foreach ($attributes as $attrib) {
//				$name = $attrib->a_name;
//				$defaults[$name] = $this->object->$name;
//			}
		}
		return $defaults;
	}
	
	/**
	 * Adds an attribute to the html form
	 * @param $attribute
	 * @param $prefix
	 * @return unknown_type
	 */
	protected function addAttribute(DDM_Attribute $attribute, DDM_Class $class) {
		$formname = $this->getAttributePrefix($class) . $attribute->a_name;
		switch ($attribute->type->t_basetype) {
			case 'BOOLEAN':
				$this->form->addElement('checkbox', $formname , $attribute->a_name . ':');
				break;
			case 'STRING':
				$this->form->addElement('text', $formname, $attribute->a_name . ':', array('size' => 80));
				break;
			case 'INTEGER':
				$this->form->addElement('text', $formname, $attribute->a_name . ':', array('size' => 80));
				$this->form->addRule($formname, 'value must be a number', 'numeric', null, 'client');
				break;
			default:
				$this->form->addElement('text', $formname, $attribute->a_name . ':', array('size' => 80));
				break;
		}
		$constraint = $attribute->type->t_constraint;
		if ($constraint != '') {
			if (preg_match('/^[a-zA-Z].*/', $constraint) == 1) {
				if (class_exists($constraint) && method_exists($constraint, 'validate')) {
//					$this->form->registerRule();
					$this->form->addRule($formname, 'invalid value', 'callback', array($constraint, 'validate'));
				}
			} else {
				$this->form->addRule($formname, 'invalid value', 'regex', $constraint, 'client');
			}
		}
	}
	
	/**
	 * Adds an association to the html form
	 * @param $association
	 * @param $prefix
	 * @return unknown_type
	 */
	protected function addAssociation(DDM_Association $association, DDM_Class $class) {
		$formname = $this->getAssociationPrefix($class) . $association->s_name;
		$assoc = $this->form->addElement('select', $formname, $association->s_name . ':');
		$entity;
		$cardinality;
		if ($association->from->c_name == $class->c_name) {
			$entity = $association->to->c_name;
			$cardinality = $association->s_to_cardinality;
		} else if ($association->to->c_name == $class->c_name) {
			$entity = $association->from->c_name;
			$cardinality = $association->s_from_cardinality;
		}
		// check multiplicity, multi-select
		if ($cardinality === 'N' || $cardinality === '1..N') {
			$assoc->setMultiple(true);
			$assoc->setSize(5);
		}
		// check multiplicity, only if optional
		if ($cardinality === '0..1' || $cardinality === 'N') {
			$assoc->addOption('', '');
		}
		$values = $this->objectDao->fetchAllByClass($entity);
		foreach ($values as $value) {
			$assoc->addOption($this->getReadableValue($value), $value->id);
		}
	}
	
	/**
	 * Adds an attribute value of the html form to the given object.
	 * @param $object
	 * @param $attribute
	 * @return unknown_type
	 */
	protected function addValue(DDM_Object $object, DDM_Attribute $attribute, $prefix) {
		$name = $attribute->a_name;
		$formname = $prefix . $attribute->a_name;
		$value;
		switch ($attribute->type->t_basetype) {
			case 'BOOLEAN':
				$value = $this->form->exportValue($formname);
				if ($value == '1') {
					$value = true;
				} else {
					$value = false;
				}
				break;
			case 'STRING':
				$value = $this->form->exportValue($formname);
				break;
			case 'INTEGER':
				$value = intval($this->form->exportValue($formname));
				break;
			default:
				break;
		}
		$constraint = $attribute->type->t_constraint;
		if ($constraint != '' && preg_match('/^[a-zA-Z].*/', $constraint) == 1) {
			if (class_exists($constraint) && method_exists($constraint, 'parse')) {
				try {
					$obj = call_user_func(array($constraint, 'parse'), $this->form->exportValue($formname));
					$value = strval($obj);
				} catch (ParseException $exception) {
					// should not happen: values are validated before object() is called
				}
			}
		}
		$object->$name = $value;
	}
	
	/**
	 * Adds a link of the html form to the given object.
	 * @param $object
	 * @param $association
	 * @param $prefix
	 * @return unknown_type
	 */
	protected function addLink(DDM_Object $object, DDM_Association $association, $prefix) {
		$name = $association->s_name;
		$formname = $prefix . $name;
		if (!$association->toOne()) {
			$ids = $this->form->exportValue($formname);
			foreach ($ids as $id) {
				$ref = $this->objectDao->fetch($id);
				$object->$name = $ref;
			}
		} else {
			$id = $this->form->exportValue($formname);
			// check if it's an optional reference
			if ($id === '') {
				return;
			}
			$ref = $this->objectDao->fetch($id);
			$object->$name = $ref;
		}
	}
	
	protected function getReadableValue($object) {
		$end = false;
		$value = '[' . $object->id . '] ';
		$class = $object->class;
		while (!$end) {
			if (!is_int($class->c_parent)) {
				$end = true;
			}
			if (count($class->attributes) > 0) {
				$name = $class->attributes[0]->a_name;
				$value .= $object->$name;
				$end = true;
			} else {
				$class = $class->parent;
			}
		}
		return $value;
	}
	
	protected function getAttributePrefix($class) {
		return $class->c_name . '_attrib_';
	}
	
	protected function getAssociationPrefix($class) {
		return $class->c_name . '_assoc_';
	}
	
	
	public function setClassDao($classDao) {
		$this->classDao = $classDao;
	}
	public function setObjectDao($objectDao) {
		$this->objectDao = $objectDao;
	}
	public function setAttributeDao($attributeDao) {
		$this->attributeDao = $attributeDao;
	}
}
?>