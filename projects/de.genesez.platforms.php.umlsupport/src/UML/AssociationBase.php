<?php
abstract class UML_AssociationBase implements UML_Association {
	protected abstract function isSymmetric();
	protected abstract function link(&$associated);
	protected abstract function unlink(&$associated);
}
?>