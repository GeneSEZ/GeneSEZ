<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240411825406_497558_455) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Mfw_Controller
 * @author	dreamer
 * @package	de.genesez.metaframework.util
 */
abstract class Util_NotifierController extends Mfw_Controller  {
	
	// -- attribute, constant + association declarations --------------------
	/**
	 * @generated	attribute definition
	 * @var		Msg_FlashNotifier	$notifier
	 */
	protected $notifier;
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	protected function noActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241765803687_477311_294) ENABLED START */
		$this->notifier->add(new Msg_Message('no action specified, redirecting to default action'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	protected function noIdSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241765803750_832752_295) ENABLED START */
		$this->notifier->add(new Msg_Message('no id specified'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @return	Mfw_Dto
	 */
	protected function unknownActionSpecified() {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1241765803750_878544_296) ENABLED START */
		$this->notifier->add(new Msg_Message('unknown action specified, redirecting to default action'));
		$this->redirect('list');
		/* PROTECTED REGION END */
	}
	

	
	// -- association + attribute accessors ---------------------------------
	/**
	 * @generated	setter method for the attribute {@link Util_NotifierController::getNotifier() $notifier}
	 * @param	Msg_FlashNotifier	$notifier	the value to set
	 */
	public 	 function setNotifier(Msg_FlashNotifier $notifier) {
		$this->notifier = $notifier;
	}
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1240411825406_497558_455) ENABLED START */
	// TODO: put your further code implementations for class 'Util_NotifierController' here
	/* PROTECTED REGION END */
}
?>
