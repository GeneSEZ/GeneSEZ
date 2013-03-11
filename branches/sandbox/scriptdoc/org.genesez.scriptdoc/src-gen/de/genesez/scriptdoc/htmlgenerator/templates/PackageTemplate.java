package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;

import de.genesez.scriptdoc.parsing.ScriptPackage;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337511678687_918292_1880) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class PackageTemplate extends WildCardTemplate {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>PackageTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public PackageTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337511794566_548076_1938) ENABLED START */
		super(templateName, type);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void make() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337511906902_900101_1943) ENABLED START */
		for (ScriptPackage pack : table.getPackages()) {
			create(pack.getName().replace("::", "."), PACKFOLDER, new PackageTemplate(this.templateName, contentType), createWildCards(pack, contentType));
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337511678687_918292_1880) ENABLED START */
	public final String PACKFOLDER = "packages";
	/* PROTECTED REGION END */

}
