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
					$defaults[$formname] = $this->object->$name;
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
			case 'STRING': ;
			case 'INTEGER': ;
			default:
				$this->form->addElement('text', $formname, $attribute->a_name . ':', array('size' => 80));
				break;
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
		switch ($attribute->type->t_basetype) {
			case 'BOOLEAN':
				$value = $this->form->exportValue($formname);
				if ($value == '1') {
					$object->$name = true;
				} else {
					$object->$name = false;
				}
				break;
			case 'STRING': ;
			case 'INTEGER': ;
			default:
				$object->$name = $this->form->exportValue($formname);
				break;
		}
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
		$id = $this->form->exportValue($formname);
		// check if it's an optional reference
		if ($id === '') {
			return;
		}
		$ref = $this->objectDao->fetch($id);
		$object->$name = $ref;
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