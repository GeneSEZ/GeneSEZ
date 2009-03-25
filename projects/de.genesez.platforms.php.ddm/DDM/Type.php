<?php

require_once('DDM/BaseDDM_Type.php');

class DDM_Type extends BaseDDM_Type
{

	public function __toString() {
		return $this->t_name;
	}

}

?>