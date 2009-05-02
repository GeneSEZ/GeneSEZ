<?php
class Editor_TypeHandler extends Util_NotifierController {
	protected $typeDao; // = Doctrine::getTable('ddm_type')
	
	public function create() {
		$adapter = new Form_TypeAdapter();
		if ($adapter->isValid()) {
			$type = $adapter->object();
			$type->save();
			$this->notifier->add(new Msg_Message('type successfully created'));
			$this->redirect();
		}
		return new Core_BaseDto(array(
			'form' => $adapter->dto()
		));
	}
	public function edit($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Msg_Message('no id specified'));
			$this->redirect('list');
		}
		$type = Doctrine::getTable('ddm_type')->fetch($_REQUEST['id']);
		if ($type === false) {
			// message + redirect to list view
			$this->notifier->add(new Msg_Message('type with given id not found'));
			$this->redirect('list');
		}
		$adapter = new Form_TypeAdapter($type);
		if ($adapter->isValid()) {
			$type = $adapter->object($type);
			$type->save();
			$this->notifier->add(new Msg_Message('type successfully stored'));
			$this->redirect('list');
		}
		return new BaseDto(array(
			'form' => $adapter->dto(),
		));
	}
	public function delete($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Msg_Message('no id specified'));
			$this->redirect('list');
		}
		$type = $this->typeDao->fetch($_REQUEST['id']);
		if ($type === false) {
			$this->notifier->add(new Msg_Message('type with given id not found'));
			$this->redirect('list');
		}
		$type->delete();
		// message + redirect to list view
		$this->notifier->add(new Msg_Message('type successfully deleted'));
		$this->redirect('list');
	}
	public function show($id) {
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for types comming soon'));
		$this->redirect('list');
	}
	public function listing() {
		return new Core_BaseDto(array(
			'types' => $this->typeDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create')
		));
	}
}
?>