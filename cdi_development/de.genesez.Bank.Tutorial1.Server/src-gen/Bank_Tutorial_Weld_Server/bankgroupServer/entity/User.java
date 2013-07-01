package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462910495_371580_466) 
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_User")
public class User implements Serializable {
	
	@Id
	private String username;
	
	private String password;
	
	private Date insertDate;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>User</b></em>'.
	 */
	
	public User() {
	}
	
	/**
	 * Returns the value of attribute '<em><b>username</b></em>'.
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the value of attribute '<em><b>username</b></em>'.
	 * @param	username	the value to set.
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Returns the value of attribute '<em><b>password</b></em>'.
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the value of attribute '<em><b>password</b></em>'.
	 * @param	password	the value to set.
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Returns the value of attribute '<em><b>insertDate</b></em>'.
	 */
	
	public Date getInsertDate() {
		return new Date(insertDate.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>insertDate</b></em>'.
	 * @param	insertDate	the value to set.
	 */
	
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
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
