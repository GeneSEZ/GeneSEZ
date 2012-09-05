package org.genesez.example.java.cdi.bank.server.action;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462892357_208194_461) 
 */

import java.io.Serializable;
import javax.enterprise.inject.Model;

/**
 */

@Model
public class Credentials implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String username;
	
	private String password;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>username</b></em>'
	 */
	public String getUsername() {
		return username;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>username</b></em>'
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Returns the value of attribute '<em><b>password</b></em>'
	 */
	public String getPassword() {
		return password;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>password</b></em>'
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462892357_208194_461) ENABLED START */
	private static final long serialVersionUID = 1L;
	/* PROTECTED REGION END */
	
}
