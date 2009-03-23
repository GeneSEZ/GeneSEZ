package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class Engine implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.CAR, new OneAssociation<Engine, Car>(this, Car.Associations.ENGINE));
	}
	/**
	 * @generated	attribute definition
	 */
	private byte ps;
	/**
	 * @generated	attribute definition
	 */
	private String name;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>ps</b></em>'
	 */
	public byte getPs() {
		return ps;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * generic accessor for association objects used by the association handling framework
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>car</b></em>' to {@link Car}
	 */
	@SuppressWarnings("unchecked")
	public Association<Engine, Car> car() {
		return (Association<Engine, Car>) association.get(Associations.CAR);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
