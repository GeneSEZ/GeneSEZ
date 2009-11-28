package de.genesez.Usermanagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@Table(name="tbl_User")
@Name("user")
@Scope(ScopeType.SESSION)
public class User implements Serializable{
	
	@Id
	private String username;
	private String password;
	private String firstname;
	private String sirname;
	
	public User(){
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSirname() {
		return sirname;
	}
	
	public void setSirname(String sirname) {
		this.sirname = sirname;
	}
	
	
}
