package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462981134_570566_486) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import Bank_Tutorial_Weld_Server.bankgroupServer.IEntityBase;

/* PROTECTED REGION END */

/**
 */

@Entity
@Table(name = "tbl_Bankgroup")
public class Bankgroup implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores associated objects of association BANKS to Bank */
	@OneToMany(cascade = {
		CascadeType.MERGE
	}, fetch = FetchType.EAGER, mappedBy = "bankgroup")
	private java.util.Set<Bank> banks = new java.util.HashSet<Bank>();
	
	/** stores the associated object of association ADDRESS to Address */
	@OneToOne(cascade = {})
	private Address address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>Bankgroup</b></em>'
	 */
	public Bankgroup() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>id</b></em>'
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * getter for the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * documented here {@link getName()}
	 * @generated	setter method for the attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter for the attribute '<em><b>version</b></em>'
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * documented here {@link getVersion()}
	 * @generated	setter method for the attribute '<em><b>version</b></em>'
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	/**
	 * accessor for association to banks
	 */
	public java.util.Set<Bank> getBanks() {
		return this.banks;
		
	}
	
	/**
	 * accessor for association to banks
	 */
	public void insertInBanks(Bank banks) {
		if (this.banks.contains(banks)) {
			return;
		}
		this.banks.add(banks);
		banks.setBankgroup(this);
	}
	
	/**
	 * accessor for association to banks
	 */
	public void removeFromBanks(Bank banks) {
		if (!this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
	}
	
	/**
	 * accessor for association to address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * accessor for association to address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
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
