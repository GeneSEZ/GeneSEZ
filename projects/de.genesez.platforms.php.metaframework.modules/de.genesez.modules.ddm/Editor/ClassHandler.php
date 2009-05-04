<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430480132_499562_330) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	DDM
 */
class Editor_ClassHandler extends Util_NotifierController  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$classDao
	 */
	protected $classDao;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_487550_349) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_2647_350) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_8676_351) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_451936_352) ENABLED START */
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for classes comming soon'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_850039_353) ENABLED START */
		return new Core_BaseDto(array(
			'classes' => $this->classDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create')
		));
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_ClassHandler::getClassDao() $classDao}
	 * @param	mixed	$classDao	the value to set
	 */
	public 	 function setClassDao( $classDao) {
		$this->classDao = $classDao;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430480132_499562_330) ENABLED START */
	// TODO: put your further code implementations for class 'ClassHandler' here
	/* PROTECTED REGION END */
}
?>
