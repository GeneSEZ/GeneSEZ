<?php

// TODO: Implement Tests
class DDM_ClassTable extends Doctrine_Table
{
    public function findOneByName($name)
    {
    	return $this->findOneByC_Name($name);
    }

}

?>