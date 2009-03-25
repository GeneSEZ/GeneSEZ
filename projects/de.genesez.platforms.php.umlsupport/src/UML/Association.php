<?php
interface UML_Association {
	public function insert(&$associated);
	public function remove(&$associated);
	public function get();
	public function getAll();
	// public function iterator();
}
?>