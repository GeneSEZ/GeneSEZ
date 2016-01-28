<?php

return array(
    'ctrl' => array(
        'title' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_tca.xlf:domain_model_product',
        'label' => 'name',
        'iconfile' => 'EXT:gsz_inventory/Resources/Public/Backend/Icons/tx_gszinventory_domain_model_product.svg',
        'tstamp' => 'tstamp',
        'crdate' => 'crdate',
        'cruser_id' => 'cruser_id',
        'delete' => 'deleted',
        'origUid' => 't3_origuid',
        'searchFields' => 'name, description, quantity',
        'dividers2tabs' => true,
        /* PROTECTED REGION ID(tca.php.own.ctrl.section.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
        // TODO: put your further 'ctrl' section code here
        /* PROTECTED REGION END */
    ),
    'interface' => array(
        'showRecordFieldList' => 'name, description, quantity',
        /* PROTECTED REGION ID(tca.php.own.interface.section.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
        // TODO: put your further 'interface' section code here
        /* PROTECTED REGION END */
    ),
    'columns' => array(
        'name' => array(
            'exclude' => false,
            'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_tca.xlf:domain_model_product.name',
            'config' => array(
                'type' => 'input',
                'size' => 30,
                'default' => '',
                'eval' => 'trim',
                /* PROTECTED REGION ID(tca.php.own.columns.section.column.config.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363700126_91538_2293) ENABLED START */
                // TODO: put your further column config code here
                'eval' => 'required,trim',
                /* PROTECTED REGION END */
            ),
            /* PROTECTED REGION ID(tca.php.own.columns.section.column.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363700126_91538_2293) ENABLED START */
            // TODO: put your further column code here
            /* PROTECTED REGION END */
        ),
        'description' => array(
            'exclude' => false,
            'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_tca.xlf:domain_model_product.description',
            'config' => array(
                'type' => 'text',
                'cols' => 40,
                'rows' => 15,
                'default' => '',
                'eval' => 'trim',
                /* PROTECTED REGION ID(tca.php.own.columns.section.column.config.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363708261_140463_2300) ENABLED START */
                // TODO: put your further column config code here
                /* PROTECTED REGION END */
            ),
            /* PROTECTED REGION ID(tca.php.own.columns.section.column.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363708261_140463_2300) ENABLED START */
            // TODO: put your further column code here
            /* PROTECTED REGION END */
        ),
        'quantity' => array(
            'exclude' => false,
            'label' => 'LLL:EXT:gsz_inventory/Resources/Private/Language/locallang_tca.xlf:domain_model_product.quantity',
            'config' => array(
                'type' => 'input',
                'size' => 30,
                'default' => 0,
                'eval' => 'int',
                /* PROTECTED REGION ID(tca.php.own.columns.section.column.config.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363722856_936956_2307) ENABLED START */
                // TODO: put your further column config code here
                /* PROTECTED REGION END */
            ),
            /* PROTECTED REGION ID(tca.php.own.columns.section.column.code._17_0_1_8a7027a_1306344238376_116675_2466._17_0_2_8a7027a_1314363722856_936956_2307) ENABLED START */
            // TODO: put your further column code here
            /* PROTECTED REGION END */
        ),
        /* PROTECTED REGION ID(tca.php.own.columns.section.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
        // TODO: put your further 'columns' section code here
        /* PROTECTED REGION END */
    ),
    'types' => array(
        '0' => array('showitem' => 'name, description, quantity'),
        /* PROTECTED REGION ID(tca.php.own.types.section.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
        // TODO: put your further 'types' section code here
        /* PROTECTED REGION END */
    ),
    'palettes' => array(
        '1' => array('showitem' => ''),
        /* PROTECTED REGION ID(tca.php.own.palettes.section.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
        // TODO: put your further 'palettes' section code here
        /* PROTECTED REGION END */
    ),
    /* PROTECTED REGION ID(tca.php.own.code._17_0_1_8a7027a_1306344238376_116675_2466) ENABLED START */
    // TODO: put your further code here
    /* PROTECTED REGION END */
);
