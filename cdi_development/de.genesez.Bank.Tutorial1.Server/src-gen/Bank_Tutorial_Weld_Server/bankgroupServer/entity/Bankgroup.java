package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462981134_570566_486) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Bankgroup")
public class Bankgroup implements EntityBase, Serializable {
	
	/** Stores all linked objects of association '<em><b>banks</b></em>' */
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "bankgroup")
	private java.util.Set<Bank> banks = new java.util.HashSet<Bank>();
	
	/** Stores the linked object of association '<em><b>address</b></em>' */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bankgroup")
	private Address address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Bankgroup</b></em>'.
	 */
	
	public Bankgroup() {
	}
	
	/**
	 * Returns all linked objects of association '<em><b>banks</b></em>'.
	 */
	
	public java.util.Set<Bank> getBanks() {
		return banks;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>banks</b></em>'.
	 * @param	banks	the object to associate.
	 */
	
	public void addBanks(Bank banks) {
		if (banks == null || this.banks.contains(banks)) {
			return;
		}
		this.banks.add(banks);
		banks.setBankgroup(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>banks</b></em>'.
	 * @param	banks	the object to remove.
	 */
	
	public void removeBanks(Bank banks) {
		if (banks == null || !this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
		banks.setBankgroup(null);
	}
	
	/**
	 * Returns the linked object of association '<em><b>address</b></em>'.
	 */
	
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>address</b></em>'.
	 * @param	address	the object to associate.
	 */
	
	public void setAddress(Address address) {
		if (this.address == address) {
			return;
		}
		Address former = this.address;
		this.address = address;
		if (former != null) {
			former.setBankgroup(null);
		}
		if (address != null) {
			address.setBankgroup(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public long getId() {
		return id;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462981134_570566_486) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String bankgroup = "[";
		bankgroup += "Id: " + getId();
		bankgroup += " Name: " + getName();
		bankgroup += " Banks: [";
		
		if (getBanks() != null)
			for (Bank bank : getBanks()) {
				bankgroup += bank.getName() + ",";
			}
		bankgroup += " ]";
		bankgroup += " ]";
		return bankgroup;
	}
	
	/* PROTECTED REGION END */
}
