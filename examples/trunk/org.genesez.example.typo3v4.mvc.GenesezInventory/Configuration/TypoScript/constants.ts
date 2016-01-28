plugin.tx_gszinventory {
    persistence {
        # cat=plugin.tx_gszinventory//a; type=string; label=Default storage PID
        storagePid =
	}
    view {
        # cat=plugin.tx_gszinventory/file; type=string; label=Path to template roots (FE)
        templateRootPath = EXT:gsz_inventory/Resources/Private/Templates/
        # cat=plugin.tx_gszinventory/file; type=string; label=Path to template partials (FE)
        partialRootPath = EXT:gsz_inventory/Resources/Private/Partials/
        # cat=plugin.tx_gszinventory/file; type=string; label=Path to template layouts (FE)
        layoutRootPath = EXT:gsz_inventory/Resources/Private/Layouts/
    }
    // PROTECTED REGION ID(constants.txt.own.plugin.code.eee_1045467100313_135436_1) ENABLED START
    // TODO: put your further plugin code here
    // PROTECTED REGION END
}

// PROTECTED REGION ID(constants.txt.own.code.eee_1045467100313_135436_1) ENABLED START
// TODO: put your further code here
// PROTECTED REGION END
