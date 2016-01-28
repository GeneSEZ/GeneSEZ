plugin.tx_gszinventory {
    persistence {
        storagePid = {$plugin.tx_gszinventory.persistence.storagePid}
    }
    view {
        templateRootPaths {
            10 = EXT:gsz_inventory/Resources/Private/Templates/
            20 = {$plugin.tx_gszinventory.view.templateRootPath}
        }
        partialRootPaths {
            10 = EXT:gsz_inventory/Resources/Private/Partials/
            20 = {$plugin.tx_gszinventory.view.partialRootPath}
        }
        layoutRootPaths {
            10 = EXT:gsz_inventory/Resources/Private/Layouts/
            20 = {$plugin.tx_gszinventory.view.layoutRootPath}
        }
    }
    // PROTECTED REGION ID(setup.txt.own.plugin.code.eee_1045467100313_135436_1) ENABLED START
    // TODO: put your further plugin code here
    // PROTECTED REGION END
}

// PROTECTED REGION ID(setup.txt.own.code.eee_1045467100313_135436_1) ENABLED START
// TODO: put your further code here
// PROTECTED REGION END
