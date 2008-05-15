package server;/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_590059_1207998915198_123982_658) ENABLED START *//* TODO put your imports here */import javax.persistence.FetchType;import javax.persistence.IdClass;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.Table;import java.io.Serializable;import javax.persistence.Id;import javax.persistence.OneToMany;import java.util.Random;import java.util.Iterator;/* PROTECTED REGION END *//** * @author X */@Entity(name = "")@Table(name = "Customer")@IdClass(CustomerPK.class)public class Customer implements Serializable {		// ////////////////////////////////////////////////////////////////////////	// generated variable, constant and association declarations	// ////////////////////////////////////////////////////////////////////////		@Id	private int customerNumber;		@Id	private String firstname;		private String sirname;		private String address;		@Id	private String postalCode;		private String city;	/**	 * variable for association to accounts	 */		@OneToMany(fetch = FetchType.EAGER, cascade = {		CascadeType.ALL	})	private java.util.List<Account> accounts = new java.util.ArrayList<Account>();		// ////////////////////////////////////////////////////////////////////////	// generated constructor implementations	// ////////////////////////////////////////////////////////////////////////		/**	 * @param  firstname  	 * @param  sirname  	 * @param  address  	 * @param  postalCode  	 * @param  city  	 */	public Customer(String firstname, String sirname, String address, String postalCode, String city) {		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208003925192_273415_1281) ENABLED START */		/* TODO put your own implementation code here */		this.firstname = firstname;		this.sirname = sirname;		this.postalCode = postalCode;		this.city = city;		this.address = address;		this.createCustomerNumber();		//this.onlineAccessAuthorisation = true;		/* PROTECTED REGION END */	}		/**	 */	public Customer() {		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208527747606_471350_795) ENABLED START */		/* TODO put your own implementation code here */		/* PROTECTED REGION END */	}		// ////////////////////////////////////////////////////////////////////////	// generated derived attribute method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated association method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated abstract method declaration	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated normal method implementations	// ////////////////////////////////////////////////////////////////////////		/**	 * @param  accountNumber  	 * @return  	 */		protected boolean existAccount(int accountNumber) {				boolean returnValue = false;		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208003945391_877977_1288) ENABLED START */		/* TODO put your own implementation code here */		Iterator<Account> it = accounts.iterator();		while (it.hasNext()) {			Account temp = it.next();			if (temp.getAccountNumber() == accountNumber) {				return true;			}		}		/* PROTECTED REGION END */		return returnValue;	}		/**	 * @param  other  	 * @return  	 */		public boolean equals(Object other) {				boolean returnValue = false;		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208003970407_796163_1292) ENABLED START */		/* TODO put your own implementation code here */		if (other instanceof Customer) {			Customer temp = (Customer) other;			if (this.sirname.equals(temp.getSirname()) && this.firstname.equals(temp.getFirstname())) {				return true;			}		}		/* PROTECTED REGION END */		return returnValue;	}		/**	 */		protected void printAccounts() {				/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208213007052_920060_483) ENABLED START */		/* TODO put your own implementation code here */		System.out.println(accounts.toString());		/* PROTECTED REGION END */	}		/**	 * @param  accountNumber  	 * @return  	 */		protected Account getAccount(int accountNumber) {				Account returnValue = null;		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208213952221_534951_499) ENABLED START */		/* TODO put your own implementation code here */		Iterator<Account> it = accounts.iterator();		while (it.hasNext()) {			Account temp = it.next();			if (temp.getAccountNumber() == accountNumber) {				return temp;			}		}		/* PROTECTED REGION END */		return returnValue;	}		/**	 * @param  account  	 * @return  	 */		protected boolean addAccount(Account account) {				boolean returnValue = false;		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208527940614_237061_798) ENABLED START */		/* TODO put your own implementation code here */		try {			if (this.accounts.add(account)) {				returnValue = true;			}		} catch (NullPointerException npe) {			npe.printStackTrace();			return false;		}		/* PROTECTED REGION END */		return returnValue;	}		/**	 * @param  accountNumber  	 * @return  	 */		protected boolean removeAccount(int accountNumber) {				boolean returnValue = false;		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208528023192_746081_810) ENABLED START */		/* TODO put your own implementation code here */		try {			Iterator<Account> it = accounts.iterator();			while (it.hasNext()) {				Account temp = it.next();				if (temp.getAccountNumber() == accountNumber) {					accounts.remove(temp);					returnValue = true;					break;				}			}		} catch (NullPointerException npe) {			npe.printStackTrace();			return false;		}		/* PROTECTED REGION END */		return returnValue;	}		/**	 */		private void createCustomerNumber() {				/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1208528087835_388335_814) ENABLED START */		/* TODO put your own implementation code here */		this.customerNumber = new Random().nextInt(99999999);		/* PROTECTED REGION END */	}		// ////////////////////////////////////////////////////////////////////////	// generated getter and setter method implementations	// ////////////////////////////////////////////////////////////////////////		public int getCustomerNumber() {		return customerNumber;	}		public String getFirstname() {		return firstname;	}		public void setFirstname(String _firstname) {		firstname = _firstname;	}		public String getSirname() {		return sirname;	}		public void setSirname(String _sirname) {		sirname = _sirname;	}		public String getAddress() {		return address;	}		public void setAddress(String _address) {		address = _address;	}		public String getPostalCode() {		return postalCode;	}		public void setPostalCode(String _postalCode) {		postalCode = _postalCode;	}		public String getCity() {		return city;	}		public void setCity(String _city) {		city = _city;	}		// ////////////////////////////////////////////////////////////////////////	// own implementations	// ////////////////////////////////////////////////////////////////////////		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_590059_1207998915198_123982_658) ENABLED START */	/* TODO put your own implementation code here */	/* PROTECTED REGION END */}