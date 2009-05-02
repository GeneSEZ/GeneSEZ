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
		// cardinalities
		$leftCard = $this->form->addElement('select', 'leftCardinality', 'left cardinality:');
		$rightCard = $this->form->addElement('select', 'rightCardinality', 'right cardinality:');
		$leftCard->addOption('0..1', '0..1');
		$leftCard->addOption('1', '1');
		$leftCard->addOption('*', '*');
		$leftCard->addOption('1..*', '1..*');
		$rightCard->addOption('0..1', '0..1');
		$rightCard->addOption('1', '1');
		$rightCard->addOption('*', '*');
		$rightCard->addOption('1..*', '1..*');
		// types
		$left = $this->form->addElement('select', 'left', 'left:');
		$right = $this->form->addElement('select', 'right', 'right:');
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
		// left cardinality
		$association->s_left_cardinality = $this->form->exportValue('leftCardinality');
		// right cardinality
		$association->s_right_cardinality = $this->form->exportValue('rightCardinality');
		// left
		$leftId = $fthis->orm->exportValue('left');
		//$left = $this->classDao->fetch($leftId);
		$association->s_left = $leftId;
		// right
		$rightId = $this->form->exportValue('right');
		//$right = $this->classDao->fetch($rightId);
		$association->s_right = $rightId;
		$association = $this->customObject($association);
		return $association;
	}
	
	public function errors() {
		$errors = array();
		$errors['name'] = $this->form->getElementError('name');
		$errors['leftCardinality'] = $this->form->getElementError('leftCardinality');
		$errors['rightCardinality'] = $this->form->getElementError('rightCardinality');
		$errors['left'] = $this->form->getElementError('left');
		$errors['right'] = $this->form->getElementError('right');
		$errors = $this->customErrors($errors);
		return $errors;
	}
	
	protected function defaults() {
		$defaults = array();
		if ($this->object !== null) {
			$defaults = array(
				'id' => $this->object->id,
				'name' => $this->object->s_name,
				'left' => $this->object->s_left,
				'leftCardinality' => $this->object->s_left_cardinality,
				'right' => $this->object->s_right,
				'rightCardinality' => $this->object->s_right_cardinality
			);
		}
		$defaults = $this->customDefaults($defaults);
		return $defaults;
	}
}
?>