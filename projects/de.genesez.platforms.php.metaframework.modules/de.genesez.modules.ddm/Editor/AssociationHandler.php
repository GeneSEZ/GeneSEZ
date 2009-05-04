<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430895757_359389_420) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	DDM
 */
class Editor_AssociationHandler extends Util_NotifierController  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$associationDao
	 */
	protected $associationDao;




	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_716900_439) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_562824_440) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_280209_441) ENABLED START */
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
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Core_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_572499_442) ENABLED START */
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for associations comming soon'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Core_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_737014_443) ENABLED START */
		return new Core_BaseDto(array(
			'associations' => $this->associationDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'classEdit' => $this->newLink('edit', 'class')
		));
		/* PROTECTED REGION END */
	}


	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_AssociationHandler::getAssociationDao() $associationDao}
	 * @param	mixed	$associationDao	the value to set
	 */
	public 	 function setAssociationDao( $associationDao) {
		$this->associationDao = $associationDao;
	}


	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430895757_359389_420) ENABLED START */
	// TODO: put your further code implementations for class 'AssociationHandler' here
	/* PROTECTED REGION END */
}
?>
