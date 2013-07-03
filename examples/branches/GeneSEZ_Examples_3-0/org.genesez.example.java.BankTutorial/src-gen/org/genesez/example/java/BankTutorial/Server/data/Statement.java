package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068974750_25486_1380) 
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * A statement logs all operations of an account.
 */
@Entity
@Table(name = "tbl_Statement")
public class Statement implements Serializable {
	
	private Date date;
	
	private String content;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Statement</b></em>'.
	 */
	
	public Statement() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@PrePersist
	public void initiateDate() {
		/* PROTECTED REGION ID(java.implementation._16_0_129203bc_1271070380343_498815_274) ENABLED START */
		// TODO: implementation of method 'Statement.initiateDate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>date</b></em>'.
	 */
	
	public Date getDate() {
		return new Date(date.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>date</b></em>'.
	 * @param	date	the value to set.
	 */
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Returns the value of attribute '<em><b>content</b></em>'.
	 */
	
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the value of attribute '<em><b>content</b></em>'.
	 * @param	content	the value to set.
	 */
	
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068974750_25486_1380) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
