<?php
/**
 * @author	dreamer
 * @package	Adapter
 */


/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237058774562_708044_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 * @package	Adapter
 */
class Adapter_SeasarPhpBuilder   {
	
	
	
	
	// -- method implementations --------------------------------------------
	/**
	 * @generated	method stub for implementation
	 * @param	array	$components	
	 * @return	S2Container
	 */
	public static function newContainer($components = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058843921_766739_300) ENABLED START */
		$container = new S2ContainerImpl();
		foreach ($components as $component) {
			$container->register($component);
		}
		return $container;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$class	
	 * @param	string	$name	
	 * @param	array	$arguments	
	 * @param	array	$properties	
	 * @return	S2Container_ComponentDef
	 */
	public static function newComponent($class = '', $name = '', $arguments = array(), $properties = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058871750_353203_305) ENABLED START */
		$component = new S2Container_ComponentDefImpl($class, $name);
		foreach ($arguments as $arg) {
			$component->addArgDef($arg);
		}
		foreach ($properties as $property) {
			$component->addPropertyDef($property);
		}
		return $component;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$value	
	 * @return	S2Container_ArgDef
	 */
	public static function newArgument($value = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058878859_43574_308) ENABLED START */
		$argument = new S2Container_ArgDefImpl($value);
		return $argument;
		/* PROTECTED REGION END */
	}
	/**
	 * @generated	method stub for implementation
	 * @param	string	$name	
	 * @param	string	$value	
	 * @return	S2Container_PropertyDef
	 */
	public static function newProperty($name = null, $value = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058882687_664177_311) ENABLED START */
		$property = new S2Container_PropertyDefImpl($name, $value);
		return $property;
		/* PROTECTED REGION END */
	}
	
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237058774562_708044_281) ENABLED START */
	// TODO: put your further code implementations for class 'Adapter_SeasarPhpBuilder' here
	/* PROTECTED REGION END */
}
?>
