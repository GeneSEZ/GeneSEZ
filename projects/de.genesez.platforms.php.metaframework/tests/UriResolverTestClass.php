<?php
require_once 'Core/UrlResolver.php';
class UriResolverTestClass extends Core_UrlResolver {
	private $pathinfo;
	
	protected function pathInfo() {
		return $this->pathinfo;
	}
	
	public function setPathInfo($pathinfo) {
		$this->pathinfo = $pathinfo;
	}
}
?>