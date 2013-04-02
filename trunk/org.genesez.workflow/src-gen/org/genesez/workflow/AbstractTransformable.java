package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (__92oMJreEeKHbs5kPL3C6w) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class AbstractTransformable implements Transformable {
	
	private java.util.Set<Parameter> parameter = new java.util.LinkedHashSet<Parameter>();
	
	/**
	 * Returns the value of attribute '<em><b>parameter</b></em>'.
	 */
	public java.util.Set<Parameter> getParameter() {
		return parameter;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>parameter</b></em>'.
	 * @param	parameter	the value to add.
	 */
	public void addParameter(Parameter parameter) {
		this.parameter.add(parameter);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>parameter</b></em>'.
	 * @param	parameter	the value to remove.
	 */
	public void removeParameter(Parameter parameter) {
		this.parameter.remove(parameter);
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		return result;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation.__92oMJreEeKHbs5kPL3C6w) ENABLED START */
	/* PROTECTED REGION END */
}
