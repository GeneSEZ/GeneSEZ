<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241433671335_950930_821) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Editor_DefaultController
 * @author	dreamer
 * @package	DDM
 */
class Editor_ObjectHandler extends Editor_DefaultController  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$objectDao
	 */
	protected $objectDao;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_420232_843) ENABLED START */
		$this->objectAdapter->create($this->getClass());
		if ($this->objectAdapter->isValid()) {
			$object = $this->objectAdapter->object();
			$object->save();
			$this->notifier->add(new Msg_Message('object created successfully'));
			$this->redirect('');
		}
		return new Core_BaseDto(array(
			'class' => $this->getClass(),
			'classes' => $this->classDao->fetchSuperclasses($this->getClass()),
//			'attributes' => $this->objectDao->fetchAllAttributes($this->getClass()),
//			'associations' => $this->objectDao->fetchOwnAssociations($this->getClass()),
			'form' => $this->objectAdapter->dto(),
			'list' => $this->newLink('list')
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_768508_844) ENABLED START */
		$entity = $this->objectDao->fetch($id);
		if ($entity === false) {
			$this->notifier->add(new Msg_Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('');
		}
		$this->objectAdapter->create($this->getClass(), $entity);
		if ($this->objectAdapter->isValid()) {
			$object = $this->objectAdapter->object($entity);
			$object->save();
			$this->notifier->add(new Msg_Message('object saved successfully'));
			$this->redirect('');
		}
		return new Core_BaseDto(array(
			'class' => $this->getClass(),
			'classes' => $this->classDao->fetchSuperclasses($this->getClass()),
//			'attributes' => $this->objectDao->fetchAllAttributes($this->getClass()),
//			'associations' => $this->objectDao->fetchOwnAssociations($this->getClass()),
			'form' => $this->objectAdapter->dto(),
			'list' => $this->newLink('list')
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_757871_845) ENABLED START */
		$entity = $this->objectDao->fetch($id);
		if ($entity === false) {
			$this->notifier->add(new Msg_Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('');
		}
		$entity->delete();
		$this->notifier->add(new Msg_Message('object successfully deleted'));
		$this->redirect('');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_510778_846) ENABLED START */
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for objects comming soon'));
		$this->redirect('');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_601136_847) ENABLED START */
		return new Core_BaseDto(array(
			'class' => $this->getClass(),
			'classes' => $this->classDao->fetchSuperclasses($this->getClass()),
			'objects' => $this->objectDao->fetchAllByClass($this->getClass()),
//			'attributes' => $this->objectDao->fetchAllAttributes($this->getClass()),
//			'associations' => $this->objectDao->fetchOwnAssociations($this->getClass()),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'showAssociated' => $this->newLink()
		));
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_ObjectHandler::getObjectDao() $objectDao}
	 * @param	mixed	$objectDao	the value to set
	 */
	public 	 function setObjectDao( $objectDao) {
		$this->objectDao = $objectDao;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241433671335_950930_821) ENABLED START */
	// TODO: put your further code implementations for class 'ObjectHandler' here
	protected $objectAdapter;
	public function setObjectAdapter($objectAdapter) {
		$this->objectAdapter = $objectAdapter;
	}
	/* PROTECTED REGION END */
}
?>
