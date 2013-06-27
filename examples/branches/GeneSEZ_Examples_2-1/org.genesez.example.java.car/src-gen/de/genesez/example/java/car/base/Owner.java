package de.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_12_5_6340215_1182161516984_21570_380) 
 */

import org.genesez.platform.java.umlsupport.associations.ACLink;
import org.genesez.platform.java.umlsupport.associations.*;
import org.genesez.platform.java.umlsupport.associations.AssociationClass;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */
public class Owner implements AssociationClass {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String name;
	
	private ACLink associationClassLink = new ACLink();
	
	/**
	 * Initializing constructor for class '<em><b>Owner</b></em>'.
	 * @param	name	{@link String.getName()}
	 * @param	associationClassLink	{@link ACLink.getAssociationClassLink()}
	 */
	public Owner(String name, ACLink associationClassLink) {
		this.name = name;
		this.associationClassLink = associationClassLink;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>associationClassLink</b></em>'
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
