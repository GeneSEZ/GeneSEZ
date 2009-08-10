<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430480132_499562_330) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class Editor_ClassHandler extends Util_NotifierController  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$classDao
	 */
	protected $classDao;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$classAdapter
	 */
	protected $classAdapter;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$attributeAdapter
	 */
	protected $attributeAdapter;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$associationAdapter
	 */
	protected $associationAdapter;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_487550_349) ENABLED START */
		$this->classAdapter->create();
		if ($this->classAdapter->isValid()) {
			$class = $this->classAdapter->object();
			$class->save();
			$this->notifier->add(new Msg_Message('class successfully created'));
			$this->redirect($this->newLink('edit/' . $class->id));
		} else {
			foreach ($this->classAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->classAdapter->dto()
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_2647_350) ENABLED START */
		$class = $this->classDao->fetch($id);
		if ($class === false) {
			$this->notifier->add(new Msg_Message('class with given id not found'));
			$this->redirect('list');
		}
		$this->classAdapter->create($class);
		if ($this->classAdapter->isValid()) {
			$class = $this->classAdapter->object($class);
			$class->save();
			$this->notifier->add(new Msg_Message('class successfully stored'));
			$this->redirect('list');
		} else {
			foreach ($this->classAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		$this->attributeAdapter->create(null, $this->newLink('create', 'attribute'));
		$this->associationAdapter->create(null, $this->newLink('create', 'association'));
		return new Mfw_DtoBase(array(
			'form' => $this->classAdapter->dto(),
			'class' => $class,
			'editAction' => $this->newLink('edit'),
			'editTypeAction' => $this->newLink('edit', 'type'),
			'attributeForm' => $this->attributeAdapter->dto(),
			'removeAttributeAction' => $this->newLink('delete', 'attribute'),
			'editAttributeAction' => $this->newLink('edit', 'attribute'),
			'associationForm' => $this->associationAdapter->dto(),
			'editAssociationAction' => $this->newLink('edit', 'association'),
			'removeAssociationAction' => $this->newLink('delete', 'association')
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_8676_351) ENABLED START */
		$class = $this->classDao->fetch($id);
		if ($class === false) {
			$this->notifier->add(new Msg_Message('class with given id not found'));
			$this->redirect('ist');
		}
		$class->delete();
		// Msg_Message + redirect to list view
		$this->notifier->add(new Msg_Message('class successfully deleted'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
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
	 * @return	Mfw_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430582663_850039_353) ENABLED START */
		return new Mfw_DtoBase(array(
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
	
	public 	 function setClassDao($classDao) {
		$this->classDao = $classDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_ClassHandler::getClassAdapter() $classAdapter}
	 * @param	mixed	$classAdapter	the value to set
	 */
	
	public 	 function setClassAdapter($classAdapter) {
		$this->classAdapter = $classAdapter;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_ClassHandler::getAttributeAdapter() $attributeAdapter}
	 * @param	mixed	$attributeAdapter	the value to set
	 */
	
	public 	 function setAttributeAdapter($attributeAdapter) {
		$this->attributeAdapter = $attributeAdapter;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_ClassHandler::getAssociationAdapter() $associationAdapter}
	 * @param	mixed	$associationAdapter	the value to set
	 */
	
	public 	 function setAssociationAdapter($associationAdapter) {
		$this->associationAdapter = $associationAdapter;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430480132_499562_330) ENABLED START */
	// TODO: put your further code implementations for class 'ClassHandler' here
	/* PROTECTED REGION END */
}
?>
