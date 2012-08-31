<?php
class Form_AssociationAdapter extends Form_BaseAdapter {
	protected $classDao;
	
	public function create($object = null, $action = null) {
		parent::create('associationForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:', array('size' => 80));
		$this->form->addRule('name', 'the name is required', 'required', null, 'client');
		$this->form->addElement('textarea', 'description', 'description:', array('cols' => 80, 'rows' => 2));
		// cardinalities
		$fromCard = $this->form->addElement('select', 'fromCardinality', 'from cardinality:');
		$toCard = $this->form->addElement('select', 'toCardinality', 'to cardinality:');
		$fromCard->addOption('0..1', '0..1');
		$fromCard->addOption('1', '1');
		$fromCard->addOption('N', 'N');
		$fromCard->addOption('1..N', '1..N');
		$toCard->addOption('0..1', '0..1');
		$toCard->addOption('1', '1');
		$toCard->addOption('N', 'N');
		$toCard->addOption('1..N', '1..N');
		// types
		$from = $this->form->addElement('select', 'from', 'from:');
		$to = $this->form->addElement('select', 'to', 'to:');
		$classes = $this->classDao->fetchAll();
		foreach ($classes as $key => $value) {
			$from->addOption($value->c_name, $value->id);
			$to->addOption($value->c_name, $value->id);
		}
		// finish form
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($association = null) {
		if ($association === null) {
			$association = new DDM_Association();
		}
		$from = $this->classDao->fetch($this->form->exportValue('from'));
		$to = $this->classDao->fetch($this->form->exportValue('to'));
		$name = $this->form->exportValue('name');
		$from->addAssociation(
			$name,
			$to,
			$this->form->exportValue('toCardinality'),
			$this->form->exportValue('fromCardinality'),
			$this->form->exportValue('description')
		);
		return $from->getAssociation($name);
	}
	
	public function errors() {
		$errors = array();
		$fields = array('name', 'description', 'fromCardinality', 'toCardinality', 'from', 'to');
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
				'name' => $this->object->s_name,
				'description' => $this->object->s_description,
				'from' => $this->object->s_from,
				'fromCardinality' => $this->object->s_from_cardinality,
				'to' => $this->object->s_to,
				'toCardinality' => $this->object->s_to_cardinality
			);
		}
		return array();
	}
	
	public function setClassDao($classDao) {
		$this->classDao = $classDao;
	}
}
?>