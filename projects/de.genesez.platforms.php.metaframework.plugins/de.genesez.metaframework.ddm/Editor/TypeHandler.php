<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430197741_12901_263) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class Editor_TypeHandler extends Util_NotifierController  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$typeDao
	 */
	protected $typeDao;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$typeAdapter
	 */
	protected $typeAdapter;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430235319_200085_285) ENABLED START */
		$this->typeAdapter->create();
		if ($this->typeAdapter->isValid()) {
			$type = $this->typeAdapter->object();
			$type->save();
			$this->notifier->add(new Msg_Message('type successfully created'));
			$this->redirect('list');
		} else {
			foreach ($this->typeAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->typeAdapter->dto()
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430268054_596774_289) ENABLED START */
		$type = $this->typeDao->fetch($id);
		if ($type === false) {
			// message + redirect to list view
			$this->notifier->add(new Msg_Message('type with given id not found', Msg_Message::ERROR));
			$this->redirect('list');
		}
		$this->typeAdapter->create($type);
		if ($this->typeAdapter->isValid()) {
			$type = $this->typeAdapter->object($type);
			$type->save();
			$this->notifier->add(new Msg_Message('type successfully stored'));
			$this->redirect('list');
		} else {
			foreach ($this->typeAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->typeAdapter->dto(),
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430278772_879323_293) ENABLED START */
		$type = $this->typeDao->fetch($id);
		if ($type === false) {
			$this->notifier->add(new Msg_Message('type with given id not found', Msg_Message::ERROR));
			$this->redirect('list');
		}
		$type->delete();
		// message + redirect to list view
		$this->notifier->add(new Msg_Message('type successfully deleted'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430288663_397254_297) ENABLED START */
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for types comming soon'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430298413_462039_301) ENABLED START */
		return new Mfw_DtoBase(array(
			'types' => $this->typeDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create')
		));
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_TypeHandler::getTypeDao() $typeDao}
	 * @param	mixed	$typeDao	the value to set
	 */
	
	public 	 function setTypeDao($typeDao) {
		$this->typeDao = $typeDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_TypeHandler::getTypeAdapter() $typeAdapter}
	 * @param	mixed	$typeAdapter	the value to set
	 */
	
	public 	 function setTypeAdapter($typeAdapter) {
		$this->typeAdapter = $typeAdapter;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430197741_12901_263) ENABLED START */
	// TODO: put your further code implementations for class 'TypeHandler' here
	/* PROTECTED REGION END */
}
?>
