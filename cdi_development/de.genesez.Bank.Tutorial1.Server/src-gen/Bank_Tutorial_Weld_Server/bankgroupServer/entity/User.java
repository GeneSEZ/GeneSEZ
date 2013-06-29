package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462910495_371580_466) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/* PROTECTED REGION END */

/**
 */

@Entity
@Table(name = "tbl_User")
public class User implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Id
	private String username;
	
	private String password;
	
	private Date insertDate;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>User</b></em>'
	 */
	public User() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>username</b></em>'
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * documented here {@link getUsername()}
	 * @generated	setter method for the attribute '<em><b>username</b></em>'
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * getter for the attribute '<em><b>password</b></em>'
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * documented here {@link getPassword()}
	 * @generated	setter method for the attribute '<em><b>password</b></em>'
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * getter for the attribute '<em><b>insertDate</b></em>'
	 */
	public Date getInsertDate() {
		return insertDate;
	}
	
	/**
	 * documented here {@link getInsertDate()}
	 * @generated	setter method for the attribute '<em><b>insertDate</b></em>'
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462910495_371580_466) ENABLED START */
	// TODO: put your own implementation code here
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String userString = new String();
		userString = "User [";
		userString += "name :" + this.username;
		userString += ",password: " + this.password;
		userString += ",insertDate: " + this.insertDate.toString();
		userString += "]";
		return userString;
	}
	/* PROTECTED REGION END */

}
