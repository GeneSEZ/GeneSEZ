package association.simple;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_V0KzMJh5EeKA2py9a1_A4A) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public interface Relatable {
	
	/**
	 * Returns the linked object of association '<em><b>bidiIfManyToOne</b></em>'.
	 */
	public Hubable getBidiIfManyToOne();
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiIfManyToOne</b></em>'.
	 * @param	bidiIfManyToOne	the object to associate.
	 */
	public void setBidiIfManyToOne(Hubable bidiIfManyToOne);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._V0KzMJh5EeKA2py9a1_A4A) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
