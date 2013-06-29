package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462892357_208194_461) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Named;

/* PROTECTED REGION END */

/**
 */

@Model
public class Credentials implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String username;
	
	private String password;
	
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462892357_208194_461) ENABLED START */
	private static final long serialVersionUID = 1L;
	/* PROTECTED REGION END */

}
