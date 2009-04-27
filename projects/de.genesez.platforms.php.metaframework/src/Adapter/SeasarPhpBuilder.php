<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1237058774562_708044_281) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Supports the creation of the dependency injection container using a fluent 
 * API according the builder pattern.
 * @author	dreamer
 * @package	Metaframework
 */
class Adapter_SeasarPhpBuilder   {




	// -- method implementations --------------------------------------------
	
	/**
	 * creates a new dependency injection container
	 * @param	array	$components	array of type 'S2Container_ComponentDef', default value is 'array()'
	 * @return	S2Container
	 */
	public static function newContainer($components = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058843921_766739_300) ENABLED START */
		S2Container_ChildComponentDefBindingUtil::init();
		$container = new S2ContainerImpl();
		foreach ($components as $component) {
			$container->register($component);
		}
		S2Container_ChildComponentDefBindingUtil::bind($container);
		return $container;
		/* PROTECTED REGION END */
	}

	/**
	 * creates a new component
	 * @param	string	$class	default value is ''''
	 * @param	string	$name	default value is ''''
	 * @param	array	$arguments	array of type 'S2Container_ArgDef', default value is 'array()'
	 * @param	array	$properties	array of type 'S2Container_PropertyDef', default value is 'array()'
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
	 * creates a <b>constructor argument</b> (parameter) for a component for 
	 * constructor injection.<br><br>Note: to reference to other components, pass 
	 * theier name as a String. To specify a normal String value, enclose the 
	 * value in quotes, i.e. a value like '<i>\'value\'</i>'.
	 * @param	string	$value	default value is 'null'
	 * @return	S2Container_ArgDef
	 */
	public static function newArgument($value = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058878859_43574_308) ENABLED START */
		$argument = new S2Container_ArgDefImpl($value);
		S2Container_ChildComponentDefBindingUtil::put($value, $argument);
		return $argument;
		/* PROTECTED REGION END */
	}

	/**
	 * creates a new property for a component for <b>setter injection</b>.
	 * <br>
	 * 
	 * Note: to reference to other components as value, pass theier name as a String. 
	 * To specify a normal String value, enclose the value in quotes, i.e. like '<i>\'value\'</i>'.
	 * @param	string	$name	default value is 'null'
	 * @param	string	$value	default value is 'null'
	 * @return	S2Container_PropertyDef
	 */
	public static function newProperty($name = null, $value = null) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1237058882687_664177_311) ENABLED START */
		$property = new S2Container_PropertyDefImpl($name, $value);
		S2Container_ChildComponentDefBindingUtil::put($value, $property);
		return $property;
		/* PROTECTED REGION END */
	}




	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1237058774562_708044_281) ENABLED START */
	// TODO: put your further code implementations for class 'Adapter_SeasarPhpBuilder' here
	public static function finishContainer($container) {
		S2Container_ChildComponentDefBindingUtil::bind($container);
	}
	/* PROTECTED REGION END */
}
?>
