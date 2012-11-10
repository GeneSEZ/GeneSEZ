package org.genesez.examples.java.jsf.addressbook.domain;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_b3f027f_1346926367781_356200_2273) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author roman01
 */
public class Organisation extends Addressee {
	
	/** Stores associated objects of association MEMBERS to Person */
	private java.util.Set<Person> members = new java.util.HashSet<Person>();
	
	/** Stores the associated object of association PARENTORGANISATION to Organisation */
	private Organisation parentOrganisation;
	
	/** Stores associated objects of association SUBSIDIARIES to Organisation */
	private java.util.Set<Organisation> subsidiaries = new java.util.HashSet<Organisation>();
	
	private String name;
	
	private boolean nonprofit;
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>nonprofit</b></em>'
	 */
	public boolean getNonprofit() {
		return nonprofit;
	}
	
	/**
	 * Sets the value of attribute '<em><b>nonprofit</b></em>'
	 */
	public void setNonprofit(boolean nonprofit) {
		this.nonprofit = nonprofit;
	}
	
	/**
	 * accessor for association to members
	 */
	public java.util.Set<Person> getMembers() {
		return this.members;
		
	}
	
	/**
	 * accessor for association to members
	 */
	public void insertInMembers(Person members) {
		if (this.members.contains(members)) {
			return;
		}
		this.members.add(members);
		if (!members.getMembership().contains(this)) {
			members.insertInMembership(this);
		}
	}
	
	/**
	 * accessor for association to members
	 */
	public void removeFromMembers(Person members) {
		if (!this.members.contains(members)) {
			return;
		}
		this.members.remove(members);
		if (members.getMembership().contains(this)) {
			members.removeFromMembership(this);
		}
	}
	
	/**
	 * accessor for association to parentOrganisation
	 */
	public Organisation getParentOrganisation() {
		return parentOrganisation;
	}
	
	/**
	 * accessor for association to parentOrganisation
	 */
	public void setParentOrganisation(Organisation parentOrganisation) {
		this.parentOrganisation = parentOrganisation;
	}
	
	/**
	 * accessor for association to subsidiaries
	 */
	public java.util.Set<Organisation> getSubsidiaries() {
		return this.subsidiaries;
		
	}
	
	/**
	 * accessor for association to subsidiaries
	 */
	public void insertInSubsidiaries(Organisation subsidiaries) {
		if (this.subsidiaries.contains(subsidiaries)) {
			return;
		}
		this.subsidiaries.add(subsidiaries);
		subsidiaries.setParentOrganisation(this);
	}
	
	/**
	 * accessor for association to subsidiaries
	 */
	public void removeFromSubsidiaries(Organisation subsidiaries) {
		if (!this.subsidiaries.contains(subsidiaries)) {
			return;
		}
		this.subsidiaries.remove(subsidiaries);
		subsidiaries.setParentOrganisation(null);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_b3f027f_1346926367781_356200_2273) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
