<?php
class Form_AssociationAdapter extends BaseAdapter {
	protected $classDao;
	
	public function __construct($object = null, $action = null) {
		parent::__construct('associationForm', $object, $action);
		$this->classDao = Doctrine::getTable('ddm_class');
	}
	
	protected function fillForm() {
		$this->form->addElement('hidden', 'id');
		$this->form->addElement('text', 'name', 'name:');
		$this->form->addElement('text', 'description', 'description:');
		// cardinalities
		$leftCard = $this->form->addElement('select', 'fromCardinality', 'from cardinality:');
		$rightCard = $this->form->addElement('select', 'toCardinality', 'to cardinality:');
		$leftCard->addOption('0..1', '0..1');
		$leftCard->addOption('1', '1');
		$leftCard->addOption('*', '*');
		$leftCard->addOption('1..*', '1..*');
		$rightCard->addOption('0..1', '0..1');
		$rightCard->addOption('1', '1');
		$rightCard->addOption('*', '*');
		$rightCard->addOption('1..*', '1..*');
		// types
		$left = $this->form->addElement('select', 'from', 'from:');
		$right = $this->form->addElement('select', 'to', 'to:');
		$classes = $this->classDao->fetchAll();
		foreach ($classes as $key => $value) {
			$left->addOption($value, $value->id);
			$right->addOption($value, $value->id);
		}
		// finish form
		$this->form->addElement('submit', 'save', 'save');
		$this->customFormElements();
	}
	
	public function object($association = null) {
		if ($association === null) {
			$association = new DDM_Association();
		}
		$association->s_name = $this->form->exportValue('name');
		$association->s_description = $this->form->exportValue('description');
		// left cardinality
		$association->s_from_cardinality = $this->form->exportValue('fromCardinality');
		// right cardinality
		$association->s_to_cardinality = $this->form->exportValue('toCardinality');
		// left
		$leftId = $this->form->exportValue('from');
		//$left = $this->classDao->fetch($leftId);
		$association->s_from = $leftId;
		// right
		$rightId = $this->form->exportValue('to');
		//$right = $this->classDao->fetch($rightId);
		$association->s_to = $rightId;
		$association = $this->customObject($association);
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
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $this->object->id,
				'name' => $this->object->s_name,
				'description' => $this->object->s_description,
				'from' => $this->object->s_from,
				'fromCardinality' => $this->object->s_from_cardinality,
				'to' => $this->object->s_to,
				'toCardinality' => $this->object->s_to_cardinality
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>