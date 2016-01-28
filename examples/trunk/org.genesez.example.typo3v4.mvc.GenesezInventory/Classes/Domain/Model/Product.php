<?php
namespace GeneSEZ\GszInventory\Domain\Model;

/* PROTECTED REGION ID(php.class.own.use.imports._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
/* PROTECTED REGION END */

/***************************************************************
 *  Copyright notice
 *
 *  (c) 2013 - 2016 Nico Herbig, Jochen Rau
 *  All rights reserved
 *
 *  This script is part of the TYPO3 project. The TYPO3 project is
 *  free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  The GNU General Public License can be found at
 *  http://www.gnu.org/copyleft/gpl.html.
 *  A copy is found in the textfile GPL.txt and important notices to the license
 *  from the author is found in LICENSE.txt distributed with these scripts.
 *
 *  This script is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  This copyright notice MUST APPEAR in all copies of the script!
 ***************************************************************/

/**
 * @version $Id$
 * @copyright Copyright belongs to the respective authors
 * @license http://www.gnu.org/licenses/gpl.html GNU General Public License, version 3 or later
 */
class Product extends \TYPO3\CMS\Extbase\DomainObject\AbstractEntity
{

    /**
     * @var string
     */
    protected $name = '';

    /**
     * @var string
     */
    protected $description = '';

    /**
     * @var int
     */
    protected $quantity = 0;

    /**
     * @param string $name
     * @param string $description
     * @param int $quantity
     */
    public function __construct($name = '', $description = '', $quantity = 0)
    {
        /* PROTECTED REGION ID(php.constructor.own.code._17_0_2_8a7027a_1314363787787_15072_2350) ENABLED START */
        $this->setName($name);
        $this->setDescription($description);
        $this->setQuantity($quantity);
        /* PROTECTED REGION END */
    }

    /**
     * Get accessor for name.
     *
     * @return string
     */
    public function getName()
    {
        /* PROTECTED REGION ID(php.attribute.get.own.code._17_0_2_8a7027a_1314363700126_91538_2293) START */
        return $this->name;
        /* PROTECTED REGION END */
    }

    /**
     * Set accessor for name.
     *
     * @param string $name
     * @return void
     */
    public function setName($name)
    {
        /* PROTECTED REGION ID(php.attribute.set.own.code._17_0_2_8a7027a_1314363700126_91538_2293) START */
        $this->name = $name;
        /* PROTECTED REGION END */
    }

    /**
     * Get accessor for description.
     *
     * @return string
     */
    public function getDescription()
    {
        /* PROTECTED REGION ID(php.attribute.get.own.code._17_0_2_8a7027a_1314363708261_140463_2300) START */
        return $this->description;
        /* PROTECTED REGION END */
    }

    /**
     * Set accessor for description.
     *
     * @param string $description
     * @return void
     */
    public function setDescription($description = null)
    {
        /* PROTECTED REGION ID(php.attribute.set.own.code._17_0_2_8a7027a_1314363708261_140463_2300) START */
        $this->description = $description;
        /* PROTECTED REGION END */
    }

    /**
     * Get accessor for quantity.
     *
     * @return int
     */
    public function getQuantity()
    {
        /* PROTECTED REGION ID(php.attribute.get.own.code._17_0_2_8a7027a_1314363722856_936956_2307) START */
        return $this->quantity;
        /* PROTECTED REGION END */
    }

    /**
     * Set accessor for quantity.
     *
     * @param int $quantity
     * @return void
     */
    public function setQuantity($quantity = null)
    {
        /* PROTECTED REGION ID(php.attribute.set.own.code._17_0_2_8a7027a_1314363722856_936956_2307) START */
        $this->quantity = $quantity;
        /* PROTECTED REGION END */
    }

    /* PROTECTED REGION ID(php.class.own.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
    // TODO: put your further code here
    /* PROTECTED REGION END */

}
