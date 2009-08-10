<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241433671335_950930_821) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Editor_DefaultController
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class Editor_ObjectHandler extends Editor_DefaultController  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$objectDao
	 */
	protected $objectDao;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$objectAdapter
	 */
	protected $objectAdapter;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_420232_843) ENABLED START */
		$this->objectAdapter->create($this->getClass());
		if ($this->objectAdapter->isValid()) {
			$object = $this->objectAdapter->object();
			$object->save();
			if (array_key_exists('association_from_id', $_REQUEST) && array_key_exists('association_name', $_REQUEST)) {
				$id = $_REQUEST['association_from_id'];
				$assoc = $_REQUEST['association_name'];
				if ($id !== null && $assoc !== null) {
					$from = $this->objectDao->fetch($id);
					$from->$assoc = $object;
					$from->save();
				}
			}
			$this->notifier->add(new Msg_Message('object created successfully'));
			$this->redirect('list');
		} else {
			foreach ($this->objectAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
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
	 * @return	Mfw_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_768508_844) ENABLED START */
		$entity = $this->objectDao->fetch($id);
		if ($entity === false) {
			$this->notifier->add(new Msg_Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('list');
		}
		$this->objectAdapter->create($this->getClass(), $entity);
		if ($this->objectAdapter->isValid()) {
			$object = $this->objectAdapter->object($entity);
			$object->save();
			$this->notifier->add(new Msg_Message('object saved successfully'));
			$this->redirect('list');
		} else {
			foreach ($this->objectAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
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
	 * @return	Mfw_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_757871_845) ENABLED START */
		$entity = $this->objectDao->fetch($id);
		if ($entity === false) {
			$this->notifier->add(new Msg_Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('list');
		}
		$entity->delete();
		$this->notifier->add(new Msg_Message('object successfully deleted'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_510778_846) ENABLED START */
		// comming soon :-)
//		$this->notifier->add(new Msg_Message('show view for objects comming soon'));
//		$this->redirect('list');
		$entity = $this->objectDao->fetch($id);
		if ($entity === false) {
			$this->notifier->add(new Msg_Message('object of class' . $this->getClass() . ' with given id not found'));
			$this->redirect('list');
		}
		$classes = $this->classDao->fetchSuperclasses($this->getClass());
		$selected = $this->getClass();
		if (array_key_exists('class', $_REQUEST)) {
			$show = $_REQUEST['class'];
			foreach ($classes as $class) {
				if ($class->c_name == $show) {
					$selected = $class->c_name;
					break;
				}
			}
		}
		return new Mfw_DtoBase(array(
			'object' => $entity,
			'class' => $selected,
			'classes' => $classes,
			'show' => $this->newLink('show'),
			'edit' => $this->newLink('edit'),
			'showAssociated' => $this->newLink()
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241433685616_601136_847) ENABLED START */
		return new Mfw_DtoBase(array(
			'class' => $this->getClass(),
			'classes' => $this->classDao->fetchSuperclasses($this->getClass()),
			'objects' => $this->objectDao->fetchAllByClass($this->getClass()),
//			'attributes' => $this->objectDao->fetchAllAttributes($this->getClass()),
//			'associations' => $this->objectDao->fetchOwnAssociations($this->getClass()),
			'show' => $this->newLink('show'),
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
	
	public 	 function setObjectDao($objectDao) {
		$this->objectDao = $objectDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_ObjectHandler::getObjectAdapter() $objectAdapter}
	 * @param	mixed	$objectAdapter	the value to set
	 */
	
	public 	 function setObjectAdapter($objectAdapter) {
		$this->objectAdapter = $objectAdapter;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241433671335_950930_821) ENABLED START */
	// TODO: put your further code implementations for class 'ObjectHandler' here
	/* PROTECTED REGION END */
}
?>
