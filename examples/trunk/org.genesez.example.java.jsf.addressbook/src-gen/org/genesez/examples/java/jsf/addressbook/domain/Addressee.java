package org.genesez.examples.java.jsf.addressbook.domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_b3f027f_1346925140937_90675_2017) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author roman01
 */
public abstract class Addressee {
	
	/** Stores associated objects of association CONTACTS to Contact */
	private java.util.Set<Contact> contacts = new java.util.HashSet<Contact>();
	
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
	
	/**
	 * accessor for association to contacts
	 */
	public java.util.Set<Contact> getContacts() {
		return this.contacts;
		
	}
	
	/**
	 * accessor for association to contacts
	 */
	public void insertInContacts(Contact contacts) {
		if (this.contacts.contains(contacts)) {
			return;
		}
		this.contacts.add(contacts);
	}
	
	/**
	 * accessor for association to contacts
	 */
	public void removeFromContacts(Contact contacts) {
		if (!this.contacts.contains(contacts)) {
			return;
		}
		this.contacts.remove(contacts);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_b3f027f_1346925140937_90675_2017) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
