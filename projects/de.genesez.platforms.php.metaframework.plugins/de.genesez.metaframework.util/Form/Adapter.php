<?php
interface Form_Adapter {
	public function create();
	public function isValid();
	public function dto();
	public function errors();
	public function object();
}
?>