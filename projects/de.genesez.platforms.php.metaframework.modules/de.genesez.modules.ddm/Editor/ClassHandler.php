<?php
class Editor_ClassHandler extends Util_NotifierController {
	protected $classDao;
	
	public function create() {
		$adapter = new Form_ClassAdapter();
		if ($adapter->isValid()) {
			$class = $adapter->object();
			$class->save();
			$this->notifier->add(new Message('class successfully created'));
			$this->redirect($this->newLink('edit/' . $class->id));
		}
		$this->view->content = new Core_BaseDto(array(
			'form' => $adapter->dto()
		));
	}
	public function edit($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('list');
		}
		$class = $this->classDao->fetch($_REQUEST['id']);
		if ($class === false) {
			$this->notifier->add(new Message('class with given id not found'));
			$this->redirect('list');
		}
		$adapter = new Form_ClassAdapter($class);
		if ($adapter->isValid()) {
			$class = $adapter->object($class);
			$class->save();
			$this->notifier->add(new Message('class successfully stored'));
			$this->redirect('list');
		}
		$attributeAdapter = new Form_AttributeAdapter(null, $this->newLink('create', 'attribute'));
		$associationAdapter = new Form_AssociationAdapter(null, $this->newLink('create', 'association'));
		return new Core_BaseDto(array(
			'form' => $adapter->dto(),
			'class' => $class,
			'editAction' => $this->newLink('edit'),
			'editTypeAction' => $this->newLink('edit', 'type'),
			'attributeForm' => $attributeAdapter->dto(),
			'removeAttributeAction' => $this->newLink('delete', 'attribute'),
			'editAttributeAction' => $this->newLink('edit', 'attribute'),
			'associationForm' => $associationAdapter->dto(),
			'editAssociationAction' => $this->newLink('edit', 'association'),
			'removeAssociationAction' => $this->newLink('delete', 'association')
		));
	}
	
	public function delete($id) {
		if (!array_key_exists('id', $_REQUEST)) {
			$this->notifier->add(new Message('no id specified'));
			$this->redirect('list');
		}
		$class = $this->classDao->fetch($_REQUEST['id']);
		if ($class === false) {
			$this->notifier->add(new Message('class with given id not found'));
			$this->redirect('ist');
		}
		$class->delete();
		// message + redirect to list view
		$this->notifier->add(new Message('class successfully deleted'));
		$this->redirect('list');
	}
	
	public function show($id) {
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for classes comming soon'));
		$this->redirect('list');
	}
	
	public function listing() {
		return new Core_BaseDto(array(
			'classes' => $this->classDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create')
		));
	}
}
?>