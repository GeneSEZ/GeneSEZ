<?php

require_once('DDM/BaseDDM_Association.php');

class DDM_Association extends BaseDDM_Association
{

	function __toString() {
		return 'Name: ' . $this->s_name;
	}

}

?>