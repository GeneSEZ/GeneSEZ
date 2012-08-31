<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430895757_359389_420) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class Editor_AssociationHandler extends Util_NotifierController  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$associationDao
	 */
	protected $associationDao;
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_716900_439) ENABLED START */
		$this->associationAdapter->create();
		if ($this->associationAdapter->isValid()) {
			$association = $this->associationAdapter->object();
			$association->save();
			$this->notifier->add(new Msg_Message('association successfully stored'));
			$this->redirect('edit/' . $association->s_from, 'class');
		} else {
			foreach ($this->associationAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->associationAdapter->dto(),
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_562824_440) ENABLED START */
		$association = $this->associationDao->fetch($id);
		if ($association === false) {
			$this->notifier->add(new Msg_Message('no association with the given id found'));
			$this->redirect('list');
		}
		$this->associationAdapter->create($association);
		if ($this->associationAdapter->isValid()) {
			$association = $this->associationAdapter->object($association);
			$association->save();
			$this->notifier->add(new Msg_Message('association successfully stored'));
			$this->redirect('list');
		} else {
			foreach ($this->associationAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->associationAdapter->dto(), 
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_280209_441) ENABLED START */
		$association = $this->associationDao->fetch($id);
		if ($association === false) {
			$this->notifier->add(new Msg_Message('association with the given id not found'));
			$this->redirect('list');
		}
		$association->delete();
		$this->notifier->add(new Msg_Message('association successfully deleted'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
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
	 * @return	Mfw_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430902491_737014_443) ENABLED START */
		return new Mfw_DtoBase(array(
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
	
	public 	 function setAssociationDao($associationDao) {
		$this->associationDao = $associationDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_AssociationHandler::getAssociationAdapter() $associationAdapter}
	 * @param	mixed	$associationAdapter	the value to set
	 */
	
	public 	 function setAssociationAdapter($associationAdapter) {
		$this->associationAdapter = $associationAdapter;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430895757_359389_420) ENABLED START */
	// TODO: put your further code implementations for class 'AssociationHandler' here
	/* PROTECTED REGION END */
}
?>
