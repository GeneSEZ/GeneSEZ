package association.simple;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_TkDxwJh5EeKA2py9a1_A4A) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public interface Hubable {
	
	/**
	 * Returns all linked objects of association '<em><b>bidiIfOneToMany</b></em>'.
	 */
	public java.util.Set<Relatable> getBidiIfOneToMany();
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bidiIfOneToMany</b></em>'.
	 * @param	bidiIfOneToMany	the object to associate.
	 */
	public void addBidiIfOneToMany(Relatable bidiIfOneToMany);
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>bidiIfOneToMany</b></em>'.
	 * @param	bidiIfOneToMany	the object to remove.
	 */
	public void removeBidiIfOneToMany(Relatable bidiIfOneToMany);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._TkDxwJh5EeKA2py9a1_A4A) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
