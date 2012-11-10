package org.genesez.examples.java.jsf.addressbook.domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_b3f027f_1346926190140_487773_2241) 
 */

import java.util.Date;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author roman01
 */
public class Person extends Addressee {
	
	/** Stores associated objects of association MEMBERSHIP to Organisation */
	private java.util.Set<Organisation> membership = new java.util.HashSet<Organisation>();
	
	private String firstName;
	
	private String lastName;
	
	private Date birthdate;
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>lastName</b></em>'
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lastName</b></em>'
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>birthdate</b></em>'
	 */
	public Date getBirthdate() {
		return birthdate;
	}
	
	/**
	 * Sets the value of attribute '<em><b>birthdate</b></em>'
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * accessor for association to membership
	 */
	public java.util.Set<Organisation> getMembership() {
		return this.membership;
		
	}
	
	/**
	 * accessor for association to membership
	 */
	public void insertInMembership(Organisation membership) {
		if (this.membership.contains(membership)) {
			return;
		}
		this.membership.add(membership);
		if (!membership.getMembers().contains(this)) {
			membership.insertInMembers(this);
		}
	}
	
	/**
	 * accessor for association to membership
	 */
	public void removeFromMembership(Organisation membership) {
		if (!this.membership.contains(membership)) {
			return;
		}
		this.membership.remove(membership);
		if (membership.getMembers().contains(this)) {
			membership.removeFromMembers(this);
		}
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_b3f027f_1346926190140_487773_2241) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
