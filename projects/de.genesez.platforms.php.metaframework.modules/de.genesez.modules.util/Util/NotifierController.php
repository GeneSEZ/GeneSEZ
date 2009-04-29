<?php
require_once 'Msg/FlashNotifier.php';
require_once 'Core/Controller.php';

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1240411825406_497558_455) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @see		Core_Controller
 * @author	dreamer
 * @package	Utilities
 */
abstract class Util_NotifierController extends Core_Controller  {
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 * @var		Msg_FlashNotifier	$notifier
	 */
	protected $notifier;






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
