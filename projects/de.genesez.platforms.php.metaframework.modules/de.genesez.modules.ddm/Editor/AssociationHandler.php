<?php
class Editor_AssociationHandler extends Util_NotifierController {
	protected $associationDao;
	
	public function create() {
		$adapter = new Form_AssociationAdapter();
		if ($adapter->isValid()) {
			$association = $adapter->object();
			$association->save();
			$this->notifier->add(new Message('association successfully stored'));
			$this->redirect('edit/' . $association->s_left, 'class');
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
		$association = $this->associationDao->fetch($_REQUEST['id']);
		if ($association === false) {
			$this->notifier->add(new Message('no association with the given id found'));
			$this->redirect('list');
		}
		$adapter = new Form_AssociationAdapter($association);
		if ($adapter->isValid()) {
			$association = $adapter->object($association);
			$association->save();
			$this->notifier->add(new Message('association successfully stored'));
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
		$association = $this->associationDao->fetch($_REQUEST['id']);
		if ($association === false) {
			$this->notifier->add(new Message('association with the given id not found'));
			$this->redirect('list');
		}
		$association->delete();
		$this->notifier->add(new Message('association successfully deleted'));
		$this->redirect('list');
	}
	public function show($id) {
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for associations comming soon'));
		$this->redirect('list');
	}
	public function listing() {
		return new Core_BaseDto(array(
			'associations' => $this->associationDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'classEdit' => $this->newLink('edit', 'class')
		));
	}
}
?>