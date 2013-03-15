package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_BKlvsIZoEeKi-fAVJTcXlg) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Parameter {
	
	private String name;
	
	private Object value;
	
	/**
	 * Initializing constructor for class '<em><b>Parameter</b></em>'.
	 * @param	name	{@link String.getName()}
	 * @param	value	{@link Object.getValue()}
	 */
	public Parameter(String name, Object value) {
		this.name = name;
		this.value = value;
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
	 * Returns the value of attribute '<em><b>value</b></em>'.
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * Sets the value of attribute '<em><b>value</b></em>'.
	 * @param	value	the value to set.
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._BKlvsIZoEeKi-fAVJTcXlg) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
