package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._12_5_6340215_1182161516984_21570_380) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class Owner implements AssociationClass {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 */
	private String name;
	/**
	 * @generated	attribute definition
	 */
	private ACLink associationClassLink = new ACLink();
	
	/**
	 * constructor which initializes all instance attributes
	 * @generated	initializing constructor for class '<em><b>Owner</b></em>'
	 * @param	name	{@link String.getName()}
	 * @param	associationClassLink	{@link ACLink.getAssociationClassLink()}
	 */
	public Owner(String name, ACLink associationClassLink) {
		this.name = name;
		this.associationClassLink = associationClassLink;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>associationClassLink</b></em>'
	 */
	public ACLink getAssociationClassLink() {
		return associationClassLink;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161516984_21570_380) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
