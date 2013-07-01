package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462892357_208194_461) 
 */

import javax.enterprise.inject.Model;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Model
public class Credentials implements Serializable {
	
	private String username;
	
	private String password;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462892357_208194_461) ENABLED START */
	private static final long serialVersionUID = 1L;
	/* PROTECTED REGION END */
}
