package de.genesez.platforms.java.umlsupport.associations;

/**
 * Describes an object responsible to read and write the referenced object of to one associations
 * @param <T>	the type of the to one association
 * 
 * @author dreamer
 */
public interface Accessor<To> {
	
	/**
	 * retrieves the value of the to one association
	 * @return	the referenced object
	 */
	public To get();
	
	/**
	 * stores the value of the to one association
	 * @param referenced	the referenced object to set
	 */
	public void set(To referenced);
}
