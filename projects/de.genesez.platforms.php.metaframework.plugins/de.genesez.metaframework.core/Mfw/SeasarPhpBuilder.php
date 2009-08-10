<?php

/* PROTECTED REGION ID(php.own.imports._16_0_b6f02e1_1243537883500_527170_325) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Supports the creation of the dependency injection container using a fluent 
 * API according the builder pattern.
 * @author	dreamer
 * @package	de.genesez.metaframework.core
 */
class Mfw_SeasarPhpBuilder   {
	
	
	
	
	// -- method implementations --------------------------------------------
	
	/**
	 * creates a new dependency injection container
	 * @param	array	$components	array of type 'S2Container_ComponentDef', default value is 'array()'
	 * @return	S2Container
	 */
	public static function newContainer(array $components = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_391164_328) ENABLED START */
		$container = new S2ContainerImpl();
		foreach ($components as $component) {
			$container->register($component);
		}
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
	public static function newComponent($class = '', $name = '', array $arguments = array(), array $properties = array()) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_740807_329) ENABLED START */
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_703608_330) ENABLED START */
		$argument = new S2Container_ArgDefImpl();
		self::setValue($argument, $value);
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
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_861555_331) ENABLED START */
		$property = new S2Container_PropertyDefImpl($name);
		self::setValue($property, $value);
		return $property;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	S2Container	$container	
	 */
	public static function finishContainer(S2Container $container) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_511456_332) ENABLED START */
		S2Container_ChildComponentDefBindingUtil::bind($container);
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	S2Container_ArgDef	$argDef	
	 * @param	string	$value	
	 */
	protected static function setValue(S2Container_ArgDef $argDef, $value) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_40613_333) ENABLED START */
		if (is_object($value)) {
			$argDef->setValue($value);
		} elseif (self::isValue($value)) {
			$argDef->setValue(self::injectionValue($value));
		} else {
			$argDef->setExpression($value);
			S2Container_ChildComponentDefBindingUtil::put($value, $argDef);
		}
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$value	
	 * @return	boolean
	 */
	protected static function isValue($value) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_211799_334) ENABLED START */
		return preg_match('/^(\'|\")(.*)(\'|\")$/', $value) == 1;
		/* PROTECTED REGION END */
	}

	/**
	 * @generated	method stub for implementation
	 * @param	string	$value	
	 * @return	string
	 */
	protected static function injectionValue($value) {
		/* PROTECTED REGION ID(php.implementation._16_0_b6f02e1_1243537883500_812210_335) ENABLED START */
		$value = trim($value);
		$rep = preg_replace('/^(\'|\")(.*)(\'|\")$/', '$2', $value);
		if ($rep == $value) {
			return null;
		}
		return $rep;
		/* PROTECTED REGION END */
	}
	

	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._16_0_b6f02e1_1243537883500_527170_325) ENABLED START */
	// TODO: put your further code implementations for class 'Mfw_SeasarPhpBuilder' here
	/* PROTECTED REGION END */
}
?>
