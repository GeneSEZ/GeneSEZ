package org.genesez.examples.java.jsf.addressbook.domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_b3f027f_1346922810093_192884_1922) 
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author roman01
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_b3f027f_1346922810093_192884_1922) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
