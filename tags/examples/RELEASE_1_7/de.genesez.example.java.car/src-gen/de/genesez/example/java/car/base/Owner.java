package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._12_5_6340215_1182161516984_21570_380) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

public class Owner implements AssociationClass {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String name;
	
	private ACLink associationClassLink = new ACLink();
	
	/**
	 * initializing constructor for class '<em><b>Owner</b></em>'
	 * @param	name	{@link String.getName()}
	 * @param	associationClassLink	{@link ACLink.getAssociationClassLink()}
	 */
	public Owner(String name, ACLink associationClassLink) {
		this.name = name;
		this.associationClassLink = associationClassLink;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>associationClassLink</b></em>'
	 */
	public ACLink getAssociationClassLink() {
		return associationClassLink;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161516984_21570_380) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
