<?php
echo "hi world :-)";

require_once 'base/Owner.php';

$owner = new Owner();
//$car = new Car();

class Test {
	abstract function doSomething() {
		$var = "";
		return $var;
	}
}
?>
