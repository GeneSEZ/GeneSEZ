<?php
require_once 'Mfw/UrlResolver.php';
class UriResolverTestClass extends Mfw_UrlResolver {
	private $pathinfo;
	
	protected function pathInfo() {
		return $this->pathinfo;
	}
	
	public function setPathInfo($pathinfo) {
		$this->pathinfo = $pathinfo;
	}
}
?>