<?php
class Editor_AttributeHandler extends Util_NotifierController {
	protected $attributeDao;
	
	public function create() {
		$adapter = new Form_AttributeAdapter();
		if ($adapter->isValid()) {
			$attribute = $adapter->object();
			$attribute->save();
			$this->notifier->add(new Message('attribute successfully stored'));
			$this->redirect('edit/' . $attribute->a_class, 'class');
		}
		return new Core_BaseDto(array(
			'form' => $adapter->dto(),
			'headline' => 'Create'
		));
	}
	public function edit($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('list');
		}
		$attribute = $this->attributeDao->fetch($_REQUEST['id']);
		if ($attribute === false) {
			$this->notifier->add(new Message('no attribute with the given id found'));
			$this->redirect('list');
		}
		$adapter = new Form_AttributeAdapter($attribute);
		if ($adapter->isValid()) {
			$attribute = $adapter->object($attribute);
			$attribute->save();
			$this->notifier->add(new Message('attribute successfully stored'));
			$this->redirect('list');
		}
		return new Core_BaseDto(array(
			'form' => $adapter->dto(), 
			'headline' => 'Edit'
		));
	}
	public function delete($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('list');
		}
		$attribute = $this->attributeDao->fetch($_REQUEST['id']);
		if ($attribute === false) {
			$this->notifier->add(new Message('attribute with the given id not found'));
			$this->redirect('list');
		}
		$attribute->delete();
		$this->notifier->add(new Message('attribute successfully deleted'));
		$this->redirect('list');
	}
	public function show($id) {
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for attributes comming soon'));
		$this->redirect('list');
	}
	public function listing() {
		return new Core_BaseDto(array(
			'attributes' => $this->attributeDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'editType' => $this->newLink('edit', 'type'),
			'editClass' => $this->newLink('edit', 'class')
		));
	}
}
?>