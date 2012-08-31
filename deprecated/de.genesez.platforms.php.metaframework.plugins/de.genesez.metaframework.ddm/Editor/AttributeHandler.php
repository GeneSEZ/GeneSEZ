<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1241430670929_72136_374) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Util_NotifierController
 * @author	dreamer
 * @package	de.genesez.metaframework.ddm
 */
class Editor_AttributeHandler extends Util_NotifierController  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		mixed	$attributeDao
	 */
	protected $attributeDao;
	/**
	 * @generated	attribute definition
	 * @var		mixed	$attributeAdapter
	 */
	protected $attributeAdapter;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function create() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430826226_496216_393) ENABLED START */
		$this->attributeAdapter->create();
		if ($this->attributeAdapter->isValid()) {
			$attribute = $this->attributeAdapter->object();
			$attribute->save();
			$this->notifier->add(new Msg_Message('attribute successfully stored'));
			$this->redirect('edit/' . $attribute->a_class, 'class');
		} else {
			foreach ($this->attributeAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->attributeAdapter->dto(),
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function edit($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430826226_526148_394) ENABLED START */
		$attribute = $this->attributeDao->fetch($id);
		if ($attribute === false) {
			$this->notifier->add(new Msg_Message('no attribute with the given id found'));
			$this->redirect('list');
		}
		$this->attributeAdapter->create($attribute);
		if ($this->attributeAdapter->isValid()) {
			$attribute = $this->attributeAdapter->object($attribute);
			$attribute->save();
			$this->notifier->add(new Msg_Message('attribute successfully stored'));
			$this->redirect('list');
		} else {
			foreach ($this->attributeAdapter->errors() as $error) {
				$this->notifier->add(new Msg_Message($error, Msg_Message::ERROR), 0);
			}
		}
		return new Mfw_DtoBase(array(
			'form' => $this->attributeAdapter->dto(), 
		));
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function delete($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430826226_45703_395) ENABLED START */
		$attribute = $this->attributeDao->fetch($id);
		if ($attribute === false) {
			$this->notifier->add(new Msg_Message('attribute with the given id not found'));
			$this->redirect('list');
		}
		$attribute->delete();
		$this->notifier->add(new Msg_Message('attribute successfully deleted'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	int	$id	
	 * @return	Mfw_Dto
	 */
	public function show($id) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430826241_736916_396) ENABLED START */
		// comming soon :-)
		$this->notifier->add(new Msg_Message('show view for attributes comming soon'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	public function listing() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241430826241_870334_397) ENABLED START */
		return new Mfw_DtoBase(array(
			'attributes' => $this->attributeDao->fetchAll(),
			'edit' => $this->newLink('edit'),
			'delete' => $this->newLink('delete'),
			'create' => $this->newLink('create'),
			'editType' => $this->newLink('edit', 'type'),
			'editClass' => $this->newLink('edit', 'class')
		));
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Editor_AttributeHandler::getAttributeDao() $attributeDao}
	 * @param	mixed	$attributeDao	the value to set
	 */
	
	public 	 function setAttributeDao($attributeDao) {
		$this->attributeDao = $attributeDao;
	}
	/**
	 * @generated	setter method for the attribute {@link Editor_AttributeHandler::getAttributeAdapter() $attributeAdapter}
	 * @param	mixed	$attributeAdapter	the value to set
	 */
	
	public 	 function setAttributeAdapter($attributeAdapter) {
		$this->attributeAdapter = $attributeAdapter;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1241430670929_72136_374) ENABLED START */
	// TODO: put your further code implementations for class 'AttributeHandler' here
	/* PROTECTED REGION END */
}
?>
