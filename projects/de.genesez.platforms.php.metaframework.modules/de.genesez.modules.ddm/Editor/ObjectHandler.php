<?php
class Editor_ObjectHandler extends Editor_DefaultController {
	protected $objectDao;
	
	public function create() {
		$adapter = new Form_ObjectAdapter($this->getClass());
		if ($adapter->isValid()) {
			$object = $adapter->object();
			$object->save();
			$this->notifier->add(new Message('object created successfully'));
			$this->redirect('');
		}
		return new Core_BaseDto(array(
			'class' => $this->entity,
			'attributes' => $this->objectDao->fetchAllAttributes($this->entity),
			'associations' => $this->objectDao->fetchOwnAssociations($this->entity),
			'form' => $adapter->dto(),
			'list' => $this->newLink('list')
		));
	}
	public function edit($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('');
		}
		$entity = $this->objectDao->fetch($_REQUEST['id']);
		if ($entity === false) {
			$this->notifier->add(new Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('');
		}
		$adapter = new Form_ObjectAdapter($this->getClass(), $entity);
		if ($adapter->isValid()) {
			$object = $adapter->object($entity);
			$object->save();
			$this->notifier->add(new Message('object saved successfully'));
			$this->redirect('');
		}
		return new Core_BaseDto(array(
			'class' => $this->entity,
			'attributes' => $this->objectDao->fetchAllAttributes($this->entity),
			'associations' => $this->objectDao->fetchOwnAssociations($this->entity),
			'form' => $adapter->dto(),
			'list' => $this->newLink('list')
		));
	}
	public function delete($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('');
		}
		$entity = $this->objectDao->fetch($_REQUEST['id']);
		if ($entity === false) {
			$this->notifier->add(new Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('');
		}
		$entity->delete();
		$this->notifier->add(new Message('object successfully deleted'));
		$this->redirect('');
	}
	public function show($id) {
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for objects comming soon'));
		$this->redirect('');
	}
	public function listing() {
		return new Core_BaseDto(array(
			'class' => $this->getClass(),
			'objects' => $this->objectDao->fetchAllByClass($this->getClass()),
			'attributes' => $this->objectDao->fetchAllAttributes($this->getClass()),
			'associations' => $this->objectDao->fetchOwnAssociations($this->getClass()),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'showAssociated' => $this->newLink()
		));
	}
}
?>