<?php
class Form_AssociationAdapter extends Form_BaseAdapter {
	protected $classDao;
	
	public function create($object = null, $action = null) {
		parent::create('associationForm', $object, $action);
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$this->form->addElement('text', 'description', 'description:');
		// cardinalities
		$fromCard = $this->form->addElement('select', 'fromCardinality', 'from cardinality:');
		$toCard = $this->form->addElement('select', 'toCardinality', 'to cardinality:');
		$fromCard->addOption('0..1', '0..1');
		$fromCard->addOption('1', '1');
		$fromCard->addOption('*', '*');
		$fromCard->addOption('1..*', '1..*');
		$toCard->addOption('0..1', '0..1');
		$toCard->addOption('1', '1');
		$toCard->addOption('*', '*');
		$toCard->addOption('1..*', '1..*');
		// types
		$from = $this->form->addElement('select', 'from', 'from:');
		$to = $this->form->addElement('select', 'to', 'to:');
		$classes = $this->classDao->fetchAll();
		foreach ($classes as $key => $value) {
			$from->addOption($value, $value->id);
			$to->addOption($value, $value->id);
		}
		// finish form
		$this->form->addElement('submit', 'save', 'save');
	}
	
	public function object($association = null) {
		if ($association === null) {
			$association = new DDM_Association();
		}
		$association->s_name = $this->form->exportValue('name');
		$association->s_description = $this->form->exportValue('description');
		$association->s_from_cardinality = $this->form->exportValue('fromCardinality');
		$association->s_to_cardinality = $this->form->exportValue('toCardinality');
		$fromId = $this->form->exportValue('from');
		//$from = $this->classDao->fetch($fromId);
		$association->s_from = $fromId;
		$toId = $this->form->exportValue('to');
		//$to = $this->classDao->fetch($toId);
		$association->s_to = $toId;
		return $association;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['description'] = $this->form->getElementError('description');
		$errors['fromCardinality'] = $this->form->getElementError('fromCardinality');
		$errors['toCardinality'] = $this->form->getElementError('toCardinality');
		$errors['from'] = $this->form->getElementError('from');
		$errors['to'] = $this->form->getElementError('to');
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